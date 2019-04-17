package LOL;

import java.io.Serializable;

/**
 * @outhor liusiyu
 * @create 2019-04-15-15:59
 */
public class Product implements Serializable {
    private  String  name;
    private  int price;
    private   int  amout;
    private  String level;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmout() {
        return amout;
    }

    public void setAmout(int amout) {
        this.amout = amout;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", amout=" + amout +
                ", level='" + level + '\'' +
                '}';
    }
}
