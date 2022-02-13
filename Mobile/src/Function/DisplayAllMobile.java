package Function;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DisplayAllMobile extends ReadFile{
    public void displayAllMobile() {
        ArrayList<String> listResult = readFile();
        for (int i=0; i< listResult.size();i++) {
            System.out.println(listResult.get(i));
        }
    }


}
