package net.liam.soybeanmod.craving;

import net.minecraft.nbt.CompoundTag;

public class PlayerCraving {
    private int craving = 1;
    private final int MIN_CRAVING = 0;
    private final int MAX_CRAVING = 10;

    public void resetCraving() {
        this.craving = 1;
    }

    public int getCraving() {
        return craving;
    }

    public void addCraving(int val) {
        this.craving = Math.min(craving+val, MAX_CRAVING);
    }

    public void subCraving(int val) {
        this.craving = Math.max(craving-val, MIN_CRAVING);
    }

    public void copyFrom(PlayerCraving source) {
        this.craving = source.craving;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("craving", craving);
    }

    public void loadNBTData(CompoundTag nbt) {
        craving = nbt.getInt("craving");
    }
}