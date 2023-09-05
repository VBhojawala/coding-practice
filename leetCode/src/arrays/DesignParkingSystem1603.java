package arrays;

public class DesignParkingSystem1603 {

    int[] p;
    public DesignParkingSystem1603(int big, int medium, int small) {
        p = new int[] {0, big, medium, small};
    }

    public boolean addCar(int carType) {
        if (p[carType] > 0){
            p[carType]--;
            return true;
        }
        return false;

    }
}
