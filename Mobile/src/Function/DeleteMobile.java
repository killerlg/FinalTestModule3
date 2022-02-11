package Function;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DeleteMobile {
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
            System.out.println("Data successfully appended at the end of file");
        }catch(IOException ioe){
            System.out.println("Exception occurred:");
            ioe.printStackTrace();
        }
    }

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
