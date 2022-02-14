package Function;

import Service.MobileServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int nextIndex = 0;

    public static void main(String[] args) throws NotFoundProductException {
        MobileServiceImpl mobileService = new MobileServiceImpl();
        boolean check = false;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chuc nang: ");
            System.out.println("1. Them file");
            System.out.println("2. Xoa file");
            System.out.println("3. Xem file");
            System.out.println("4. Tim Kiem");
            System.out.println("0. Thoat");
            System.out.println("Chon chuc nang: ");
            String selection = scanner.nextLine();
            switch (selection) {
                case "1":
                    mobileService.addMobile();
                    break;
                case "2":
                    mobileService.deleteMobile();
                    mobileService.displayFile();
                    break;
                case "3":
                    mobileService.displayFile();
                    break;
                case "4":
                    mobileService.search();
                    break;
                case "0":
                    System.exit(0);
                    break;
            }

            if (selection.equals("0")) {
                check = true;
            }
        } while (!check);
    }

}
