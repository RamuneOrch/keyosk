package sparta.java_project.keyosk;

public class Menu {
    String name, detail;
    int price;
    public Menu(String name, int price, String detail){
        this.name = name;
        this.price = price;
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
