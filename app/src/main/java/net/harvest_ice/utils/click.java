
package net.harvest_ice.utils;
import java.time.*;

public class click {
    private float money = 0;
    private float lastMoney = 0;
    private float moneyPerBreak = 5;
    private long timeBreak;
    LocalTime nextBreak ;

    public click()
    {
        this.money = 0;
        this.lastMoney = 0;
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
        }
    }

    public void tick()
    {
        
        this.breakIce();
    }

    public void displayIfMoneyChange()
    {
        if (this.lastMoney != this.money)
        {
            System.out.println(this);
            this.lastMoney = this.money;
        }
    }

    @Override
    public String toString()
    {
        return String.valueOf(this.money) + "¤";
    }
}
