package Model;

public class GenuineMobile extends Mobile{
    private int insuranceTime;
    private String insuranceLimit;

    public GenuineMobile() {
    }

    public GenuineMobile(int id, String name, Double price, int amount, String producer, int insuranceTime, String insuranceLimit) {
        super(id, name, price, amount, producer);
        this.insuranceTime = insuranceTime;
        this.insuranceLimit = insuranceLimit;
    }

    public int getInsuranceTime() {
        return insuranceTime;
    }

    public void setInsuranceTime(int insuranceTime) {
        this.insuranceTime = insuranceTime;
    }

    public String getInsuranceLimit() {
        return insuranceLimit;
    }

    public void setInsuranceLimit(String insuranceLimit) {
        this.insuranceLimit = insuranceLimit;
    }

    @Override
    public String toString() {
        return this.getId()+","
                + this.getName() + ","
                + String.format("%,.0f",this.getPrice()).replace(",",".") + ","
                + this.getAmount() + ","
                + this.getProducer() + ","
                + this.insuranceTime + ","
                + this.insuranceLimit;
    }
}
