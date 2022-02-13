package Function;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int nextIndex = 0;

    public static void main(String[] args) throws NotFoundProductException {
//        Read next index
        readNextIndex();
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
                    addMobile();
                    break;
                case "2":
                    deleteMobile();
                    displayFile();
                    break;
                case "3":
                    displayFile();
                    break;
                case "4":
                    search();
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


    public static void addMobile() {
        AddMobile addMobile = new AddMobile();
        addMobile.addMobile(nextIndex);
        nextIndex++;
    }

    public static void deleteMobile() throws NotFoundProductException {
        try {
            DeleteMobile deleteMobile = new DeleteMobile();
            deleteMobile.delete();
        } catch (NotFoundProductException e) {
            System.out.println("Du lieu trong file trong");
        }

    }

    public static void readNextIndex() {
        DisplayAllMobile displayAllMobile = new DisplayAllMobile();
        ArrayList<String> listResult = displayAllMobile.readFile();
        if (!listResult.isEmpty()) {
            String result = listResult.get(listResult.size() - 1);
            nextIndex = Integer.parseInt(result.substring(0, result.indexOf(",")));
        } else {
            nextIndex = 1;
        }
    }

    public static void displayFile() {
        DisplayAllMobile displayAllMobile = new DisplayAllMobile();
        displayAllMobile.displayAllMobile();
    }

    public static void search() {
        try {
            SearchMobile searchMobile = new SearchMobile();
            searchMobile.search();
        } catch (NotFoundProductException e) {
            System.out.println("Du lieu khong hop le");
        }
    }
}
