package net.liam.jojomod.event;

public class Global {
    private static int tickCounter = 0;

    public void Tick() {
        tickCounter = tickCounter + 1;
    }

    public int getTick() {
        return tickCounter;
    }

    public boolean Minute() {
        if ( (tickCounter / 4800) > 0 ) {
            tickCounter = 0;
            return true;
        }
        return false;
    }

    
}
