package Function;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchMobile extends ReadFile{
    public void search() throws NotFoundProductException {
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        ArrayList<String> listResult = readFile();
            System.out.println("Nhap vao id can tim: ");
            String id = scanner.nextLine();
            for (int i=0; i<listResult.size();i++) {
                int index = listResult.get(i).indexOf(",");
                index = listResult.get(i).indexOf(",",index+1);
                if (listResult.get(i).substring(0,index).indexOf(id) != -1) {
                    System.out.println(listResult.get(i));
                    check = true;
                }
            }
            if (!check) {
                System.out.println("Khong tim duoc san pham!");
            }

    }

}
