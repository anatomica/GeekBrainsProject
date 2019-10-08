package Theme4;

class Cat extends Animal {
    Cat() {
        this.DistanceRun = 200;
        this.DistanceJump = 2;
        this.DistanceSwim = -1;
        this.FoodEat = 3;
    }
    Cat(int _DistanceRun, double _DistanceJump, int _DistanceSwim, int _FoodEat, boolean _Satiety, String _Name) {
        this.DistanceRun = _DistanceRun;
        this.DistanceJump = _DistanceJump;
        this.DistanceSwim = _DistanceSwim;
        this.FoodEat = _FoodEat;
        this.Satiety = _Satiety;
        this.Name = _Name;
    }
}