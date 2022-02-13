package Model;

public abstract class Mobile {
    private int id;
    private String type;
    private String name;
    private Double price;
    private int amount;
    private String producer;

    public Mobile() {
    }

    public Mobile(int id, String type, String name, Double price, int amount, String producer) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.producer = producer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
