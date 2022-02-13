package Function;

import Model.GenuineMobile;
import Model.HandCarriedMobile;
import Model.Mobile;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AddMobileFunction {
    public Mobile addMobile(int id) {
        boolean check = true;
        Mobile mobile = null;
        do {
            String selection = "";
            System.out.println("Chon loai dien thoai: ");
            System.out.println("1. Hang chinh hang");
            System.out.println("2. Hang xach tay");
            selection = input("selection");
            String name = input("name");
            String price = input("price");
            String amount = input("amount");
            String producer = input("producer");


            if (selection.equals("1")) {
                String type = "Hang chinh hang";
                String insuranceTime = input("insurance time");
                String insuranceLimit = input("insurance limit");

                ArrayList<String> errors = validateOffical(name, price, amount, producer, insuranceTime, insuranceLimit);
                if (errors.size() != 0) {
                    mobile = new GenuineMobile(id, type, name, Double.parseDouble(price), Integer.parseInt(amount),
                            producer, Integer.parseInt(insuranceTime), insuranceLimit);
                } else {
                    check = false;
                    for (String error : errors) {
                        System.out.println(error);
                    }
                }
            } else if (selection.equals("2")) {
                String type = "Hang xach tay";
                String nationHandcarried = input("nation hand carried from");
                String status = input("status");
                ArrayList<String> errors = validateHandCarried(name, price, amount, producer, nationHandcarried, status);
                if (errors.size() != 0) {
                    mobile = new HandCarriedMobile(id, type, name, Double.parseDouble(price), Integer.parseInt(amount),
                            producer, nationHandcarried, status);
                } else {
                    check = false;
                    for (String error : errors) {
                        System.out.println(error);
                    }
                }
            } else {
                check = false;
                System.out.println("Mobile Type is Invalid!");
            }

        } while (!check);
        writeMobileToFile(mobile);
        return mobile;
    }

    public void writeMobileToFile(Mobile mobile) {
        try {
            File file = new File("data/mobile.csv");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(mobile.toString() + "\n");
            //Closing BufferedWriter Stream
            bw.close();
        } catch (IOException ioe) {
            System.out.println("Exception occurred:");
            ioe.printStackTrace();
        }
    }

    public ArrayList<String> validateOffical(
            String name, String price, String amount, String producer,
            String insuranceTime, String insuranceLimit
    ) {
        ArrayList<String> errors = new ArrayList<>();
        errors.addAll(validateGeneral(name, price, amount, producer));
        // Validate insuranceTime
        try {
            if (Integer.parseInt(insuranceTime) >= 730 || Integer.parseInt(insuranceTime) < 0) {
                errors.add("Insurance Time is Invalid!");
            }
        } catch (Exception e) {
            errors.add("Insurance Time is Invalid!");
        }
        // Validate Insurance Limit
        if (!(insuranceLimit.equalsIgnoreCase("Toan quoc") || !insuranceLimit.equalsIgnoreCase("Quoc te"))) {
            errors.add("Insurance Limit is Invalid!");
        }

        return errors;
    }

    public ArrayList<String> validateHandCarried(
            String name, String price, String amount, String producer,
            String nationHandcarried, String status
    ) {
        ArrayList<String> errors = new ArrayList<>();
        errors.addAll(validateGeneral(name, price, amount, producer));
        // Validate nation handcarrired
        if (nationHandcarried.equalsIgnoreCase("Viet Nam")) {
            errors.add("Nation Hand Carried From is Invalid!");
        }
        // Validate status
        if (!(status.equalsIgnoreCase("Chua sua chua") || !status.equalsIgnoreCase("Da sua chua"))) {
            errors.add("Status is Invalid!");
        }
        return errors;
    }

    public ArrayList<String> validateGeneral(
            String name, String price, String amount, String producer
    ) {
        ArrayList<String> errors = new ArrayList<>();
        // Validate name
        if (name.equals("")) {
            errors.add("Name is Invalid!");
        }
        // Validate price
        try {
            if (Double.parseDouble(price) < 0) {
                errors.add("Price is Invalid!");
            }
        } catch (Exception e) {
            errors.add("Price is Invalid!");
        }
        // Validate Amount
        try {
            if (Integer.parseInt(amount) < 0) {
                errors.add("Amount is Invalid!");
            }
        } catch (Exception e) {
            errors.add("Amount is Invalid!");
        }
        // Validate producer
        if (producer.equals("")) {
            errors.add("Producer is Invalid!");
        }
        return errors;
    }

    public String input(String attribute) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input " + attribute + " :");
        String result = scanner.nextLine();
        return result;
    }

}
