package Function;

import Model.GenuineMobile;
import Model.HandCarriedMobile;
import Model.Mobile;

import java.io.*;
import java.util.Scanner;

public class AddMobile {
    public Mobile addMobile(int id) {
        Scanner scanner = new Scanner(System.in);
        String selection = "";
        boolean check = false;
        do {

            System.out.println("Chon loai dien thoai: ");
            System.out.println("1. Hang chinh hang");
            System.out.println("2. Hang xach tay");
            selection = scanner.nextLine();
            if (selection.equals("1") || selection.equals("2")) {
                check = true;
            }
        } while (!check);
        Mobile mobile = null;
        if (selection.equals("1")) {
            mobile = new GenuineMobile(id,inputName(), inputPrice(), inputAmount(), inputProducer(), inputInsuranceTime(), inputInsuranceLimit());
        } else {
            mobile = new HandCarriedMobile(id,inputName(),inputPrice(),inputAmount(),inputProducer(),inputNationHandcarried(),inputStatus());
        }

        try{
            File file =new File("data/mobile.csv");
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(mobile.toString()+"\n");
            //Closing BufferedWriter Stream
            bw.close();
            System.out.println("Data successfully appended at the end of file");
        }catch(IOException ioe){
            System.out.println("Exception occurred:");
            ioe.printStackTrace();
        }

         return mobile;
    };


    public String inputName() {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        do {
            System.out.print("Nhap ten dien thoai: ");
                name = scanner.nextLine();}
        while (name.equals(""));
        return name;
    }

    public Double inputPrice() {
        Scanner scanner = new Scanner(System.in);
        Double price = 0.0d;
        boolean check = false;
        do {
            System.out.print("Nhap gia dien thoai: ");
            String priceString = scanner.nextLine();

            try {
                price = Double.parseDouble(priceString);
                if (price > 0) {
                    check = true;
                } else {
                    check= false;
                }
            } catch(Exception e) {
                System.out.println("So lieu nhao vao khong hop le");
            }
        } while (!check);
        return price;
    }

    public int inputAmount() {
        Scanner scanner = new Scanner(System.in);
        int amount = 0;
        boolean check = false;
        do {
            System.out.print("Nhap so luong dien thoai: ");
            String priceString = scanner.nextLine();

            try {
                amount = Integer.parseInt(priceString);
                if (amount > 0) {
                    check = true;
                } else {
                    check= false;
                }
            } catch(Exception e) {
                System.out.println("So lieu nhao vao khong hop le");
            }
        } while (!check);
        return amount;
    }

    public String inputProducer() {
        Scanner scanner = new Scanner(System.in);
        String producerName = "";
        do {
            System.out.print("Nhap ten nha san xuat: ");
            producerName = scanner.nextLine();}
        while (producerName.equals(""));
        return producerName;
    }

    public int inputInsuranceTime() {
        Scanner scanner = new Scanner(System.in);
        int insuranceTime = 0;
        boolean check = false;
        do {
            System.out.print("Nhap thoi gian bao hanh: ");
            String priceString = scanner.nextLine();

            try {
                insuranceTime = Integer.parseInt(priceString);
                if (insuranceTime > 0 && insuranceTime<=730) {
                    check = true;
                } else {
                    check= false;
                }
            } catch(Exception e) {
                System.out.println("So lieu nhao vao khong hop le");
            }
        } while (!check);
        return insuranceTime;
    }

    public String inputInsuranceLimit() {
        Scanner scanner = new Scanner(System.in);
        String insuranceLimit = "";
        boolean check = false;
        do {
            System.out.print("Nhap pham vi bao hanh: ");
            insuranceLimit = scanner.nextLine();
            if (insuranceLimit.equalsIgnoreCase("Toan Quoc")
            || insuranceLimit.equalsIgnoreCase("Quoc Te")) {
                check = true;
            }
        }
        while (!check);
        return insuranceLimit;
    }

    public String inputNationHandcarried() {
        Scanner scanner = new Scanner(System.in);
        String nationHandcarried = "";
        boolean check = false;
        do {
            System.out.print("Nhap quoc gia xach tay: ");
            nationHandcarried = scanner.nextLine();
            if (!nationHandcarried.equalsIgnoreCase("Viet Nam")) {
                check = true;
            }
        }
        while (!check);
        return nationHandcarried;
    }

    public String inputStatus() {
        Scanner scanner = new Scanner(System.in);
        String status = "";
        boolean check = false;
        do {
            System.out.print("Nhap trang thai: ");
            status = scanner.nextLine();
            if (status.equalsIgnoreCase("Da sua chua")
                    || status.equalsIgnoreCase("Chua sua chua")) {
                check = true;
            }
        }
        while (!check);
        return status;
    }

}
