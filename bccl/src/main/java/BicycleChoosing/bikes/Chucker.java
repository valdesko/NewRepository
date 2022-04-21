package BicycleChoosing.bikes;

import BicycleChoosing.Bicycle;

public class Chucker extends Bicycle {
    private int kolvoSkorostey;


    public Chucker(String brand, int tyreHP, String frame, long price, int skorosti) {
        super(brand, tyreHP, frame, price);
        kolvoSkorostey = skorosti;
    }

    // цена в Канадских долларах
    @Override
    public double getPrice(){
        return price*6391/100f;
    }
}
