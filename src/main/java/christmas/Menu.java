package christmas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {

    private static List<String> allMenu = new ArrayList<>();
    private static Map<String,Integer> starter = new HashMap<>();
    private static Map<String,Integer> main = new HashMap<>();
    private static Map<String,Integer> dessert = new HashMap<>();
    private static Map<String,Integer> drink = new HashMap<>();

    public Menu(){
        starter.put("양송이수프",6000);
        starter.put("타파스",5500);
        starter.put("시저샐러드",8000);

        main.put("티본스테이크",55000);
        main.put("바비큐립",54000);
        main.put("해산물파스타",35000);
        main.put("크리스마스파스타",25000);

        dessert.put("초코케이크",15000);
        dessert.put("아이스크림",5000);

        drink.put("제로콜라",3000);
        drink.put("레드와인",60000);
        drink.put("샴페인",25000);

        allMenu.addAll(starter.keySet().stream().toList());
        allMenu.addAll(main.keySet().stream().toList());
        allMenu.addAll(dessert.keySet().stream().toList());
        allMenu.addAll(drink.keySet().stream().toList());
    }

    public boolean findMenu(String menuName){
        if(allMenu.contains(menuName)==true)return true;

        return false;
    }

    public int findPrice(String menuName){
        int price = 0;
        if(starter.containsKey(menuName)){
            price = starter.get(menuName);
        } else if (main.containsKey(menuName)) {
            price = main.get(menuName);
        } else if (dessert.containsKey(menuName)) {
            price = dessert.get(menuName);
        } else if (drink.containsKey(menuName)) {
            price = drink.get(menuName);
        }
        return price;
    }

    public int orderOnlyDrink(String menuName){
        // 음료가 아니면 +1을 반환
        if(drink.containsKey(menuName)){
            return 0;
        }
        return 1;
    }
    public  boolean isMain(String menuName){
        if(main.containsKey(menuName)){
            return true;
        }
        return false;
    }
    public  boolean isDessert(String menuName){
        if(dessert.containsKey(menuName)){
            return true;
        }
        return false;
    }
    public  boolean isDrink(String menuName){
        if(drink.containsKey(menuName)){
            return true;
        }
        return false;
    }


}
