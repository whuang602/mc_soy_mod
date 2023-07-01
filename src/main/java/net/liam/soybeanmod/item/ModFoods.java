package net.liam.soybeanmod.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties SOYBEAN = (new FoodProperties.Builder()).nutrition(2).saturationMod(.5F).build();
    public static final FoodProperties SOY_SAUCE = (new FoodProperties.Builder()).nutrition(1).saturationMod(.1F).build();
}
