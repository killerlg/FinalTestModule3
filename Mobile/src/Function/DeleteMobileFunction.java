package Function;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DeleteMobileFunction extends ReadFileFunction {
    public void delete() throws NotFoundProductException {
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        ArrayList<String> listResult = readFile();
        if (listResult.isEmpty()) {
            check = true;
        }
        int indexToDelete = 0;
        do {
            System.out.println("Nhap vao id can xoa: ");
            String id = scanner.nextLine();
            for (int i=0; i<listResult.size();i++) {
                int index = listResult.get(i).indexOf(",");
                String id2 = listResult.get(i).substring(0,index);
                if (id.equals(id2)) {
                    indexToDelete = i;
                    check = true;
                    break;
                }
            }
        } while (!check);



        if (check && (!listResult.isEmpty())) {
                System.out.println("Xac nhan xoa: (Input Yes to Delete)");
                String confirm = scanner.next();
                if (confirm.equalsIgnoreCase("Yes")) {
                    listResult.remove(indexToDelete);
                    System.out.println("Da xoa san pham theo yeu cau");
                } else {
                    System.out.println("Huy xoa");
                }
        } else {
            throw new NotFoundProductException();
        }


        try{
            File file =new File("data/mobile.csv");
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i=0; i<listResult.size();i++) {
                bw.write(listResult.get(i)+"\n");
            }

            bw.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }


}
