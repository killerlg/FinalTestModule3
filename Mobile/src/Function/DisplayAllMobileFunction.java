package Function;

import java.util.ArrayList;

public class DisplayAllMobileFunction extends ReadFileFunction {
    public void displayAllMobile() {
        ArrayList<String> listResult = readFile();
        for (int i=0; i< listResult.size();i++) {
            System.out.println(listResult.get(i));
        }
    }

}
