package sparta.java_project.keyosk.menuMessage;

public class MenuMessage extends MainMessage {
    public MenuMessage(){
        super();
        System.out.println("[ Songs Cafe ]");
        System.out.println("1. Coffee   | 커피");
        System.out.println("2. Drink    | 음료");
        System.out.println("3. Dessert  | 디저트");
        System.out.println();
        System.out.println("[ 메뉴 주문 ]");
        System.out.println("4.주문   | 장바구니를 확인 후 주문합니다");
        System.out.println("5.취소   | 진행중인 주문을 취소합니다.");
    }
}
