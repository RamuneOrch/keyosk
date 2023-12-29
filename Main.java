package sparta.java_project.keyosk;

import sparta.java_project.keyosk.menu.Coffee;
import sparta.java_project.keyosk.menu.Dessert;
import sparta.java_project.keyosk.menu.Drink;

import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // 커피
        ArrayList<Menu> coffList = new ArrayList<>();
        coffList.add(new Menu("아메리카노",1800, "물이랑 커피 섞은거"));
        coffList.add(new Menu("카푸치노", 4000, "에스프레소를 섞은거"));
        coffList.add(new Menu("카페 라떼", 3500, "커피랑 우유 섞은거"));
        coffList.add(new Menu("초코 라떼", 3500, "초코랑 커피랑 우유 석은거"));
        coffList.add(new Menu("바닐라 라떼", 3500, "바나나랑 우유랑 커피 섞은거"));

        // 드링크
        ArrayList<Menu> drinkList = new ArrayList<>();
        drinkList.add(new Menu("레몬 에이드", 3800, "레몬이 들어감"));
        drinkList.add(new Menu("자몽 에이드", 4300, "자몽이 들어감"));
        drinkList.add(new Menu("블루 레몬 에이드", 4000, "블루 레몬이 들어감"));
        drinkList.add(new Menu("유자 에이드", 4200, "유자가 들어감"));
        drinkList.add(new Menu("딸기 에이드", 4100, "딸기가 들어감"));

        // 디저트
        ArrayList<Menu> dessertList = new ArrayList<>();
        dessertList.add(new Menu("딸기케이크", 3500, "딸기가 들어감"));
        dessertList.add(new Menu("티라미수", 7500, "티라미수임"));
        dessertList.add(new Menu("초코 파운드", 6500, "초코가 들어감"));
        dessertList.add(new Menu("마카롱", 3500, "마카롱임"));
        dessertList.add(new Menu("버터와플", 8500, "버터랑 와플"));

        // 장바구니
        ArrayList<Menu> bascket = new ArrayList<>();

        int waitingNumber = 0;
        while(true){
            int total = 0;
            MenuMessage mM = new MenuMessage();
            String menuCheck = sc.nextLine();
            switch (menuCheck){
                case("1") :
                    new MainMessage();
                    for(int i = 0; i < coffList.size(); i++){
                        System.out.println(i + 1 + ". " + coffList.get(i).getName()+" | 가격 : " + coffList.get(i).getName()+ " | " + coffList.get(i).getDetail());
                    }
                    String menuDetailCheck1 = sc.nextLine();
                    if(!menuDetailCheck1.isEmpty()){
                        bascket.add(coffList.get(Integer.parseInt(menuDetailCheck1)-1));
                    }
                    break;
                case("2"):
                    new MainMessage();
                    for(int i = 0; i < drinkList.size(); i++){
                        System.out.println(i + 1 + ". " + drinkList.get(i).getName()+" | 가격 : " + drinkList.get(i).getName()+ " | " + drinkList.get(i).getDetail());
                    }
                    String menuDetailCheck2 = sc.nextLine();
                    if(!menuDetailCheck2.isEmpty()){
                        bascket.add(coffList.get(Integer.parseInt(menuDetailCheck2)-1));
                    }
                    break;
                case("3"):
                    new MainMessage();
                    for(int i = 0; i < dessertList.size(); i++){
                        System.out.println(i + 1 + ". " + dessertList.get(i).getName()+" | 가격 : " + dessertList.get(i).getName()+ " | " + dessertList.get(i).getDetail());
                    }
                    String menuDetailCheck3 = sc.nextLine();
                    if(!menuDetailCheck3.isEmpty()){
                        bascket.add(coffList.get(Integer.parseInt(menuDetailCheck3)-1));
                    }
                    break;
                case("4"):
                    new Bascket();
                    for (Menu menu : bascket) {
                        System.out.println(menu.getName() + " | 가격 | " + menu.getPrice() + " | " + menu.getDetail());
                    }
                    System.out.println();
                    System.out.println("[ Total ]");
                    for (Menu menu : bascket){
                        total+=menu.getPrice();
                    }
                    System.out.println("총 가격 : " + total);
                    System.out.println("1. 주문          2. 메뉴판");
                    if(sc.next().equals("1")){
                        System.out.println("주문이 완료되었습니다!");
                        System.out.println();
                        waitingNumber++;
                        System.out.println("대기번호는 [ " + waitingNumber + " ] 번 입니다.");
                        System.out.println("3초후 메뉴판으로 돌아갑니다.");
                        bascket.clear();
                        try{
                            Thread.sleep(3000);
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    break;
                case("5"):
                    new CancelMessage();
                    String cancelCheck = sc.next();
                    if(cancelCheck.equals("1")){
                        break;
                    }
                    break;
                default:
                    break;

            }

        }
    }
}
