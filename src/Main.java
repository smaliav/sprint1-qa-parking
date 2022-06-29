import java.util.Scanner;

public class Main {

    /*
    - Поставить автомобиль на парковку
    - Забрать автомобиль с парковки
    - Посмотреть состояние парковочных мест на этаже
    - Посмотреть цену за парковку
    - Изменить цену за парковку
    - Выход
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingSystem parkingSystem = new ParkingSystem();

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                // Поставить автомобиль на парковку
                System.out.print("Введите этаж: ");
                int floor = scanner.nextInt();
                System.out.print("Введите место: ");
                int spot = scanner.nextInt();
                System.out.print("Введите название автомобиля: ");
                String name = scanner.next();

                boolean isSuccess = parkingSystem.parkCar(floor, spot, name);
                if (isSuccess) {
                    System.out.println("Автомобиль успешно припаркован!");
                } else {
                    System.out.println("Место уже занято!");
                }
            } else if (command == 2) {
                // Забрать автомобиль с парковки
                System.out.print("Введите этаж: ");
                int floor = scanner.nextInt();
                System.out.print("Введите место: ");
                int spot = scanner.nextInt();
                System.out.print("Введите кол-во ваших денег: ");
                double money = scanner.nextDouble();

                boolean isSuccess = parkingSystem.getCar(floor, spot, money);
                if (isSuccess) {
                    System.out.println("Автомобиль успешно забрали!");
                } else {
                    System.out.println("Не удалось забрать автомобиль! Проверьте, что вы выбрали верное место и вам хватает денег.");
                }
            } else if (command == 3) {
                // Посмотреть состояние парковочных мест на этаже
                System.out.print("Введите этаж: ");
                int floor = scanner.nextInt();
                parkingSystem.printFloorInfo(floor);
            } else if (command == 4) {
                // Посмотреть цену за парковку
                System.out.println("Цена за парковку: " + parkingSystem.price);
            } else if (command == 5) {
                // Изменить цену за парковку
                System.out.print("Введите новую цену: ");
                double price = scanner.nextDouble();
                parkingSystem.changePrice(price);
                System.out.println("Цена за парковку была успешно изменена!");
            } else if (command == 0) {
                // Выход
                return;
            } else {
                System.out.println("Такой команды нет!");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Система управления парковкой. Выбирете действие:");
        System.out.println("1. Поставить автомобиль на парковку");
        System.out.println("2. Забрать автомобиль с парковки");
        System.out.println("3. Посмотреть состояние парковочных мест на этаже");
        System.out.println("4. Посмотреть цену за парковку");
        System.out.println("5. Изменить цену за парковку");
        System.out.println("0. Выход");
    }

}
