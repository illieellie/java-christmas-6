package christmas;

import java.util.Map;
import java.util.Objects;

public class Order {


    public int sumPrice(Map<String, Integer> order) {
        int sumPrice = 0;
        Menu menu = new Menu();
        for(String key : order.keySet()){
            sumPrice += menu.findPrice(key);
        }
        return sumPrice;
    }

//    public String getGift(int sumPrice) {
//    }

//    public String getBadge(int discountPrice) {
//    }
//
//
//    public String[] getBenefit(int day) {
//    }
}
