package net.liam.soybeanmod.event;

public class Global {
    // private static int tickCounter = 0;


    // onItemUseFinish fires twice so this accounts for it
    private static int cancelDouble = 0;
    private static int cancelItemFinishDouble = 0;

    // public void Tick() {
    //     tickCounter++;
    // }

    public void addDouble() {
        cancelDouble++;
    }

    public void addItemFinishDouble() {
        cancelItemFinishDouble++;
    }

    // public int getTick() {
    //     return tickCounter;
    // }

    public int getDouble() {
        return cancelDouble;
    }

    // public void resetTick() {
    //     tickCounter = 0;
    // }

    // public boolean Minute() {
    //     if ( (tickCounter / 4800) > 0 ) {
    //         tickCounter = 0;
    //         return true;
    //     }
    //     return false;
    // }

    // public boolean Fifteen() {
    //     if ( (tickCounter / 1200) > 0 ) {
    //         tickCounter = 0;
    //         return true;
    //     }
    //     return false;
    // }

    public boolean isDouble() {
        if ((cancelDouble%2) == 0) {
            cancelDouble = 0;
            return true;
        }
        return false;
    }

    public boolean isFinishDouble() {
        if ((cancelItemFinishDouble%2) == 0) {
            cancelItemFinishDouble = 0;
            return true;
        }
        return false;
    }

    
}
