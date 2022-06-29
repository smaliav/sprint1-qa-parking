public class ParkingSystem {

    ParkingFloor[] floors;
    double price;

    ParkingSystem() {
        floors = new ParkingFloor[3];
        for (int i = 0; i < 3; i++) {
            floors[i] = new ParkingFloor();
        }
        price = 180;
    }

    boolean parkCar(int floor, int spot, String name) {
        String carName = floors[floor].spots[spot];
        boolean isVacant = carName.isEmpty();
        if (isVacant) {
            floors[floor].spots[spot] = name;
            return true;
        } else {
            return false;
        }
    }

    boolean getCar(int floor, int spot, double money) {
        if (money < price) {
            return false;
        }

        String carName = floors[floor].spots[spot];

        if (carName.isEmpty()) {
            return false;
        } else {
            floors[floor].spots[spot] = "";
            return true;
        }
    }

    void printFloorInfo(int floor) {
        String[] spots = floors[floor].spots;
        for (int i = 0; i < spots.length; i++) {
            System.out.println(i + ". " + spots[i]);
        }
        System.out.println("Максимальное кол-во подряд занятых мест: " + calcMaxStreak(floor));
    }

    void changePrice(double newPrice) {
        price = newPrice;
    }

    int calcMaxStreak(int floor) {
        String[] spots = floors[floor].spots;

        int maxStreak = 0;
        int curStreak = 0;

        for (int i = 0; i < spots.length; i++) {
            if (spots[i].isEmpty()) {
                curStreak = 0;
            } else {
                curStreak++;
            }

            if (curStreak > maxStreak) {
                maxStreak = curStreak;
            }
        }

        return maxStreak;
    }

    class ParkingFloor {

        String[] spots;

        ParkingFloor() {
            spots = new String[10];
            for (int i = 0; i < 10; i++) {
                spots[i] = "";
            }
        }

    }

}
