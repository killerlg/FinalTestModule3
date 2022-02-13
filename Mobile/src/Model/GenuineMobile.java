package Model;

public class GenuineMobile extends Mobile{
    private int insuranceTime;
    private String insuranceLimit;

    public GenuineMobile() {
    }

    public GenuineMobile(int id, String type, String name, Double price, int amount, String producer, int insuranceTime, String insuranceLimit) {
        super(id, type, name, price, amount, producer);
        this.insuranceTime = insuranceTime;
        this.insuranceLimit = insuranceLimit;
    }

    @Override
    public String toString() {
        return this.getId()+","
                + this.getType() + ","
                + this.getName() + ","
                + String.format("%,.0f",this.getPrice()).replace(",",".") + ","
                + this.getAmount() + ","
                + this.getProducer() + ","
                + this.insuranceTime + ","
                + this.insuranceLimit;
    }
}
