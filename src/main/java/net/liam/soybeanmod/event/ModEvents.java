package net.liam.soybeanmod.event;

import net.liam.soybeanmod.SoybeanMod;
import net.liam.soybeanmod.craving.PlayerCraving;
import net.liam.soybeanmod.craving.PlayerCravingProvider;
import net.liam.soybeanmod.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.commands.DamageCommand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SoybeanMod.MOD_ID)
public class ModEvents {

    private static Global time = new Global();


    @SubscribeEvent
    public static void onAttachCapabilitiesPLayer(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof Player) {
            if (!event.getObject().getCapability(PlayerCravingProvider.PLAYER_CRAVING).isPresent()) {
                event.addCapability(new ResourceLocation(SoybeanMod.MOD_ID, "properties"), new PlayerCravingProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            event.getOriginal().getCapability(PlayerCravingProvider.PLAYER_CRAVING).ifPresent(oldStore -> {
                event.getOriginal().getCapability(PlayerCravingProvider.PLAYER_CRAVING).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(PlayerCraving.class);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.side == LogicalSide.SERVER) {
            time.addDouble();
            event.player.getCapability(PlayerCravingProvider.PLAYER_CRAVING).ifPresent(craving -> {
                if (!time.isDouble()) {
                    if ( craving.getCraving() > 0 && (event.player.tickCount % 1200) == 0) {
                        craving.subCraving(1);
                        if (craving.getCraving() > 0)
                        {
                            event.player.sendSystemMessage(Component.literal("Soy Craving: " + craving.getCraving()));
                        }
                        else {
                            event.player.sendSystemMessage(Component.literal("You really need soy..."));
                        }
                    }
                    else if (craving.getCraving() == 0 && (event.player.tickCount % 300) == 0) {
                        event.player.sendSystemMessage(Component.literal("Ouchies"));
                        event.player.setHealth(event.player.getHealth()-2);
                    }
                }
            });


        }
    }

    @SubscribeEvent
    public static void onItemUseFinish(LivingEntityUseItemEvent.Finish event) {
        time.addItemFinishDouble();
        if(event.getEntity() instanceof Player && !time.isFinishDouble()) {
            if (event.getItem().getItem() == ModItems.SOYBEAN.get()) {
                event.getEntity().getCapability(PlayerCravingProvider.PLAYER_CRAVING).ifPresent( craving -> {
                    craving.addCraving(1);
                    event.getEntity().sendSystemMessage(Component.literal("Soy Craving: " + craving.getCraving())); });
            }
        }
    }

}
