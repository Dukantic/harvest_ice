
package net.harvest_ice.utils;
import java.time.*;



public class Click {
    static private final float LAMBDA_TIME_BREAK = 1.2F;
    static private final float LAMBDA_MONEY_BREAK = 1.1F;

    private double money = 0;
    private double lastMoney = 0;
    private float moneyPerBreak = 1;
    private long timeBreak;
    LocalTime nextBreak ;

    public Click()
    {
        this.money = 0;
        this.lastMoney = 0;
        this.timeBreak = (long) 1e9; 
        this.moneyPerBreak = 1;
        this.nextBreak = LocalTime.now().plusNanos(this.timeBreak);
    }

    public double getMoney()
    {
        return this.money;
    }

    private void breakIce()
    {
        while (LocalTime.now().isAfter(this.nextBreak))
        {

            this.nextBreak = this.nextBreak.plusNanos(this.timeBreak);
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

    private boolean isPurchasable(float price)
    {
        if (price <= this.money)
        {
            this.money -= price;
            return true;
        }
        return false;
    }

    public boolean purchaseMoreTime(float price)
    {
        if (this.isPurchasable(price))
        {
            long dif = this.timeBreak;
            this.timeBreak *= LAMBDA_TIME_BREAK;
            this.moneyPerBreak *= LAMBDA_MONEY_BREAK;
            dif = this.timeBreak - dif ;
            this.nextBreak = this.nextBreak.plusNanos(dif);
            return true;
        }
        return false;
    }

    public boolean purchaseLessTime(float price)
    {
        if (this.timeBreak >= 1e7 && this.isPurchasable(price))
        {
            long dif = this.timeBreak;
            this.timeBreak /= LAMBDA_TIME_BREAK;
            dif -= timeBreak;
            this.nextBreak = this.nextBreak.plusNanos(-dif);
            return true;
        }
        return false;
    }

    public boolean purchaseLessPrice(float price)
    {
        if (this.isPurchasable(price))
        {
             
            return true;
        }
        return false;
    }


    @Override
    public String toString()
    {
        return String.format("%.2f", this.money) + "¤" ;
    }
}
