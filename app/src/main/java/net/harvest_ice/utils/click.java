
package net.harvest_ice.utils;

public class click {
    float count = 0;

    public click()
    {
        this.count = 0;
    }

    public void wasClicked()
    {
        this.count++;
    }

    @Override
    public String toString()
    {
        return String.valueOf(count);
    }
}
