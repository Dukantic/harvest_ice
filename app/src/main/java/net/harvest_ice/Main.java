package  net.harvest_ice;

import net.harvest_ice.utils.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start Game!");
        click variClick = new click();
        System.out.println(variClick); 
        boolean loop = true;
        while(loop)
        {
            variClick.tick();
            variClick.displayIfMoneyChange();
            if(variClick.getMoney() >= 20)
            {
                loop = false;
            }
        }
    }
}
