package BicycleChoosing;

import org.w3c.dom.ls.LSOutput;

public class Bicycle {
    String brand;
    private int tyreHP;
    String frame;
    protected double price;


    Bicycle(){
        tyreHP = 200;
    }

    public Bicycle(String brand, int tyreHP, String frame, double price){
        this.brand = brand;
        this.tyreHP = tyreHP;
        this.frame = frame;
        this.price = price;
    }


    public void drive(int distance){
        if (tyreHP > 500) {
            if (distance < tyreHP) {
                tyreHP = tyreHP - distance;
            }
            else {
                System.out.println("Столько на этих покрышках не проехать");
            }
        }
        else {
            System.out.println("Покрышки нужно заменить!");
        }
    }

    public int getTyreHP(){
        return tyreHP;
    }

    public void setTyreHP(int meters){
        tyreHP = meters;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double amount){
        price = amount;
    }



}
