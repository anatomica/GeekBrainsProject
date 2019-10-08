package Theme4;

public class Dog extends Animal {
    Dog() {
        this.DistanceRun = 500;
        this.DistanceJump = 3;
        this.DistanceSwim = -1;
    }
    Dog(int _DistanceRun, double _DistanceJump, int _DistanceSwim) {
        this.DistanceRun = _DistanceRun;
        this.DistanceJump = _DistanceJump;
        this.DistanceSwim = _DistanceSwim;
    }
}