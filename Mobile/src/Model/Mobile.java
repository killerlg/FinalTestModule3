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
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Double getPrice() {
        return price;
    }
    public int getAmount() {
        return amount;
    }
    public String getProducer() {
        return producer;
    }

}
