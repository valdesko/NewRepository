package BicycleChoosing;

import BicycleChoosing.bikes.Chucker;
import BicycleChoosing.bikes.Demo8;

public class Main {
    public static void main(String[] args){
        Bicycle first = new Bicycle("GT", 1000,"Hardtale",100);
        first.drive(87);
        System.out.println("Покрышек осталось на:" + first.getTyreHP());

        Bicycle second = new Bicycle();
        second.setTyreHP(200);
        second.drive(1000);

        Chucker chuck = new Chucker("GT", 1000, "Hardtale", 15000, 27);
        Demo8 dem = new Demo8("Specialized", 300, "Downhill", 2500000, 220);

        chuck.drive(3000);
        dem.drive(10);

        Bicycle[] bikes = new Bicycle[4];
        bikes[0] = first;
        bikes[1] = second;
        bikes[2] = chuck;
        bikes[3] = dem;
        double totalPrice = 0;
        for (int i=0; i<bikes.length;i++)
            totalPrice += bikes[i].getPrice();

        System.out.println("За все:" + totalPrice);


    }
}
