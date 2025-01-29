package  net.harvest_ice;
import net.harvest_ice.utils.*;



public class Main {
    public static void main(String[] args) {
        System.out.println("Start Game!");
    
        Click variClick = new Click();
        Display userDisplay = new Display(variClick);
        

        System.out.println(variClick); 
        boolean loop = true;
        while(loop)
        {
            variClick.tick();
            //variClick.displayIfMoneyChange();
            userDisplay.update(variClick);
        }
    }
}
