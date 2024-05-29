package christmas;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Order {
    Menu menu = new Menu();

    public int sumPrice(Map<String, Integer> order) {
        int sumPrice = 0;
        for(String key : order.keySet()){
            sumPrice += menu.findPrice(key);
        }
        return sumPrice;
    }

    public boolean getGift(int sumPrice) {
        if(sumPrice>=120000){
            return true;
        }
        return false;
    }

//    public String getBadge(int discountPrice) {
//    }
//
//


    public Map<String,Integer> eventXMas(int orderDay){
        Map<String,Integer> result = new HashMap<>(); // *해쉬맵 생성을 안 하고 바로 넘기고 싶음
        int discountPrice = 0;
        if(1<=orderDay&&orderDay<=25){
            discountPrice+=1000+orderDay-1;
        }
        if(discountPrice!=0) {
            result.put("크리스마스 디데이 할인", discountPrice);
        }
        return result;
    }

    public Map<String,Integer> eventWeekday(int orderDay,Map<String,Integer> order){
        Map<String,Integer> result = new HashMap<>();
        Day day = getDay(orderDay%7); // 요일
        int discountPrice = 0;
        if(!(day==Day.FRI||day==Day.SAT)){
            for(String key : order.keySet()){
                if(menu.isDessert(key)){
                    discountPrice+= 2023;
                }
            }
        }
        if(discountPrice!=0){
            result.put("평일 할인",discountPrice);
        }
        return result;
    }

    public Map<String,Integer> eventWeekend(int orderDay,Map<String,Integer> order){
        Map<String,Integer> result = new HashMap<>();
        Day day = getDay(orderDay%7); // 요일
        int discountPrice = 0;
        if(day==Day.FRI||day==Day.SAT){
            // 주말 할인
            for(String key : order.keySet()){
                if(menu.isMain(key)){
                    discountPrice+= 2023;
                }
            }
        }
        if(discountPrice!=0) {
            result.put("주말 할인", discountPrice);
        }
        return result;
    }

    public Map<String,Integer> eventGift(boolean isGift) {
        Map<String, Integer> result = new HashMap<>();
        if(isGift){
            result.put("증정 이벤트",25000);
        }
        return result;
    }


    public Map<String,Integer> getBenefit(int orderDay, Map<String,Integer> order, boolean isGift) {
        // 혜택 내역, 혜택 금액 반환
        Map<String,Integer> benefit = new HashMap<>();
        
        int sumDiscountPrice = 0;

        // 만약 널을 넣으려고 하면 어떻게 되는건지 테스트
        benefit.putAll(eventXMas(orderDay));
        benefit.putAll(eventWeekday(orderDay,order));
        benefit.putAll(eventWeekend(orderDay,order));
        benefit.putAll(eventGift(isGift));


        return benefit;
    }



    public Day getDay(int day){
       Day today= Day.FRI; // 나머지 0
       if (day==1) {
            today = Day.SAT;
        }else if (day==2) {
            today = Day.SAT;
        }else if (day==3) {
            today = Day.SAT;
        }else if (day==4) {
            today = Day.SAT;
        }else if (day==5) {
            today = Day.SAT;
        }else if (day==6) {
            today = Day.SAT;
        }
        return today;
    }

    public int sumBenefitPrice(Map<String, Integer> benefit) {
        int price = 0;
        for(String key : benefit.keySet()){
         price+=benefit.get(key);
        }
        return price;
    }
}
