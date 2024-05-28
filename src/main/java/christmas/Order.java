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

    public String getGift(int sumPrice) {
        if(sumPrice>=120000){
            return "샴페인 1개";
        }
        return "없음";
    }

//    public String getBadge(int discountPrice) {
//    }
//
//
//    public String[] getBenefit(int day) {
//        // 혜택 내역, 혜택 금액 반환
//        //
//    }
}
