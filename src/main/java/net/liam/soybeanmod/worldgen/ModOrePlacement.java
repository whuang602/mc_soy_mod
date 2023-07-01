package net.liam.soybeanmod.worldgen;

import java.util.List;

import net.minecraft.world.level.levelgen.placement.*;

public class ModOrePlacement {
     public static List<PlacementModifier> orePlacement(PlacementModifier x, PlacementModifier y) {
        return List.of(x, InSquarePlacement.spread(), y, BiomeFilter.biome());
     }
     public static List<PlacementModifier> commonOrePlacement(int x, PlacementModifier y) {
        return orePlacement(CountPlacement.of(x), y);
     }
     public static List<PlacementModifier> rareOrePlacement(int x, PlacementModifier y) {
        return orePlacement(RarityFilter.onAverageOnceEvery(x), y);
     }
}
