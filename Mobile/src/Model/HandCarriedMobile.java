package Model;

public class HandCarriedMobile extends Mobile{
    private String nationHandcarried;
    private String status;

    public HandCarriedMobile() {
    }

    public HandCarriedMobile(int id, String name, Double price, int amount, String producer, String nationHandcarried, String status) {
        super(id, name, price, amount, producer);
        this.nationHandcarried = nationHandcarried;
        this.status = status;
    }

    public String getNationHandcarried() {
        return nationHandcarried;
    }

    public void setNationHandcarried(String nationHandcarried) {
        this.nationHandcarried = nationHandcarried;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.getId()+","
                + this.getName() + ","
                + String.format("%,.0f",this.getPrice()).replace(",",".") + ","
                + this.getAmount() + ","
                + this.getProducer() + ","
                + this.nationHandcarried + ","
                + this.status;
    }
}
