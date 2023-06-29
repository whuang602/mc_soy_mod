package net.liam.jojomod.thirst;

import net.minecraft.nbt.CompoundTag;

public class PlayerThirst {
    private int thirst = 10;
    private final int MIN_THIRST = 0;
    private final int MAX_THIRST = 10;

    public void resetThirst() {
        this.thirst = 10;
    }

    public int getThirst() {
        return thirst;
    }

    public void addThirst(int val) {
        this.thirst = Math.min(thirst+val, MAX_THIRST);
    }

    public void subThirst(int val) {
        this.thirst = Math.max(thirst-val, MIN_THIRST);
    }

    public void copyFrom(PlayerThirst source) {
        this.thirst = source.thirst;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("thirst", thirst);
    }

    public void loadNBTData(CompoundTag nbt) {
        thirst = nbt.getInt("thirst");
    }
}