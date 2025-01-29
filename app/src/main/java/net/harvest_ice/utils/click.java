
package net.harvest_ice.utils;
import java.time.*;

public class click {
    private float money = 0;
    private long timeBreak;
    private float moneyPerBreak = 5;
    LocalTime nextBreak ;

    public click()
    {
        this.money = 0;
        this.timeBreak = 1;
        this.moneyPerBreak = 5;
        this.nextBreak = LocalTime.now().plusSeconds(timeBreak);
    }

    public float getMoney()
    {
        return this.money;
    }

    private void breakIce()
    {
        if (LocalTime.now().isAfter(this.nextBreak))
        {
            this.nextBreak = LocalTime.now().plusSeconds(this.timeBreak);
            this.money += moneyPerBreak;
            System.out.println(this);
        }
    }

    public void tick()
    {
        
        this.breakIce();
    }

    @Override
    public String toString()
    {
        return String.valueOf(this.money) + "¤";
    }
}
