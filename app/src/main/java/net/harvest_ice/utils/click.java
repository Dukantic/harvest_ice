
package net.harvest_ice.utils;

public class click {
    private float money = 0;
    private float count = 0;
    private float timeBreak = 1;
    private float moneyPerBreak = 5;

    public click()
    {
        this.money = 0;
        this.count = 0;
        this.timeBreak = 1;
        this.moneyPerBreak = 5;
    }

    public void tick()
    {
        this.count+= 2;

        if (this.count >= this.timeBreak)
        {
            this.count -= this.timeBreak;
            this.money += moneyPerBreak;
        }
    }

    @Override
    public String toString()
    {
        return String.valueOf(this.money);
    }
}
