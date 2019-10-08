package Theme4;

abstract class Animal {
    int DistanceRun;
    double DistanceJump;
    int DistanceSwim;
    int FoodEat;
    boolean Satiety;
    String Name;


    boolean run(int value) {
        return DistanceRun >= value;
    }
    boolean jump(double value) {
        return DistanceJump >= value;
    }
    boolean swim(int value) {
        return DistanceSwim >= value;
    }

    int getDistanceRun() {
        return DistanceRun;
    }
    double getDistanceJump() {
        return DistanceJump;
    }
    int getDistanceSwim() {
        return DistanceSwim;
    }
    int getFoodEat() { return FoodEat;
    }
}