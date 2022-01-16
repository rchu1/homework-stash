package edu.cscc;

public class car {
    private static
    String make;
    int yearMake;
    int speed;


    car(String make, int yearMake) {
        this.speed = speed;
        this.yearMake = yearMake;
        this.make = make;
    }

    public static String getMake() {
        return make;
    }

    public void setMake(String make) {

    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {

    }

    public int getYearMake() {
        return yearMake;
    }

    public void setYearMake(int yearMake) {

    }
    public int accelerate()
    {
        speed =speed + 5;
        return speed;
    }
    public int brake()
    {
        speed =speed - 5;
        return speed;
    }
}