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
    public static final RegistryObject<Item> SOY_SAUCE = ITEMS.register("soy_sauce", () -> new Item(new Item.Properties().food(ModFoods.SOY_SAUCE)));
    public static final RegistryObject<Item> TOFU = ITEMS.register("tofu", () -> new Item(new Item.Properties().food(ModFoods.TOFU)));
    public static final RegistryObject<Item> EDAMAME = ITEMS.register("edamame", () -> new Item(new Item.Properties().food(ModFoods.EDAMAME)));
    public static final RegistryObject<Item> GYPSUM = ITEMS.register("gypsum", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SOYBUNCH = ITEMS.register("soybunch", () -> new Item(new Item.Properties().food(ModFoods.SOYBUNCH)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

