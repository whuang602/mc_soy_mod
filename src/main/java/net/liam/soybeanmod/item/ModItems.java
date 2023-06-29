package net.liam.soybeanmod.item;


import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.liam.soybeanmod.SoybeanMod;
import net.minecraft.world.item.Item;



public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SoybeanMod.MOD_ID);

    public static final RegistryObject<Item> SOYBEAN = ITEMS.register("soybean", () -> new Item(new Item.Properties().food(ModFoods.SOYBEAN)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
