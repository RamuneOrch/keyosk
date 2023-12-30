package sparta.java_project.keyosk;

public class Menu {
    String name, detail;
    int price, count;
    public Menu(String name, int price, String detail, int count){
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.count = count;
    }

    public void incCount(){
        this.count++;
    }

    public int getCount() {
        return count;
    }

    public String getDetail() {
        return detail;
    }

    public int getPrice() {
        return price*count;
    }

    public String getName() {
        return name;
    }
}
