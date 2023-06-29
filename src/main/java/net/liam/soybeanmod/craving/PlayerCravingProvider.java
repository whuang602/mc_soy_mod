package net.liam.soybeanmod.craving;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

public class PlayerCravingProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

    public static Capability<PlayerCraving> PLAYER_CRAVING = CapabilityManager.get(new CapabilityToken<PlayerCraving>() {});

    private PlayerCraving craving = null;
    private final LazyOptional<PlayerCraving> optional = LazyOptional.of(this::createPlayerCraving);

    private PlayerCraving createPlayerCraving() {
        if (this.craving == null) {
            this.craving = new PlayerCraving();
        }
        return this.craving;
    }


    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == PLAYER_CRAVING)
            return optional.cast();
        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerCraving().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerCraving().loadNBTData(nbt);
    }
    
}
