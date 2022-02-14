package Service;

import Function.*;

import java.util.ArrayList;

public class MobileServiceImpl implements iMobileService{
    public int nextIndex;

    public MobileServiceImpl() {
        readNextIndex();
    }

    @Override
    public void addMobile() {
        AddMobileFunction addMobile = new AddMobileFunction();
        addMobile.addMobile(nextIndex);
        nextIndex++;
    }

    @Override
    public void deleteMobile() {
        try {
            DeleteMobileFunction deleteMobileFunction = new DeleteMobileFunction();
            deleteMobileFunction.delete();
        } catch (NotFoundProductException e) {
            System.out.println("Du lieu trong file trong");
        }
    }

    @Override
    public void displayFile() {
        DisplayAllMobileFunction displayAllMobileFunction = new DisplayAllMobileFunction();
        displayAllMobileFunction.displayAllMobile();
    }

    @Override
    public void search() {
        try {
            SearchMobileFunction searchMobileFunction = new SearchMobileFunction();
            searchMobileFunction.search();
        } catch (NotFoundProductException e) {
            System.out.println("Du lieu khong hop le");
        }
    }

    @Override
    public void readNextIndex() {
        DisplayAllMobileFunction displayAllMobileFunction = new DisplayAllMobileFunction();
        ArrayList<String> listResult = displayAllMobileFunction.readFile();
        if (!listResult.isEmpty()) {
            String result = listResult.get(listResult.size() - 1);
            this.nextIndex = Integer.parseInt(result.substring(0, result.indexOf(","))) + 1;
        } else {
            this.nextIndex = 1;
        }
    }
}
