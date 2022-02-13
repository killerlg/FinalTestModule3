package Function;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
    public ArrayList<String> readFile() {
        String result;
        ArrayList<String> listResult = new ArrayList<>();
        try {
            Scanner fr = new Scanner(new File("data/mobile.csv"));
            while (fr.hasNext()) {
                result = fr.nextLine();
                listResult.add(result);
            }
            fr.close();
        } catch (Exception e) {
            System.out.println("Co loi xay ra");
        }
        return listResult;
    }
}
