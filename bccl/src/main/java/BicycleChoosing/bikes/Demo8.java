package BicycleChoosing.bikes;

import BicycleChoosing.Bicycle;

public class Demo8 extends Bicycle {
    private int HodVilki;


    public Demo8(String brand, int tyreHP, String frame, long price, int hod) {
        super(brand, tyreHP, frame, price);
        HodVilki = hod;
    }

    // цена в Японских Юанях
    @Override
    public double getPrice(){
        return price*0062f/100f;
    }
}
