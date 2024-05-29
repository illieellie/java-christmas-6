package christmas;

import java.util.Map;
import java.util.Objects;

public class Order {
    Menu menu = new Menu();

    public String[] sumPrice(Map<String, Integer> order) {
        int sumPrice = 0;
        String[] result = new String[2];

        for(String key : order.keySet()){
            sumPrice += menu.findPrice(key);
        }
        result[0] = String.valueOf(sumPrice);
        result[1] = addComma(sumPrice);

        return result;
    }

    private String addComma(int sumPrice) {
        // 뒤에서 4번째 자리에 콤마
        String result = String.valueOf(sumPrice);
        int  indexTail = result.length();
        for(int i = indexTail-3;i>0; i-=3){
         // i자리에 컴마를 찍으면 됨
            String headString = result.substring(0,i); // 머리
            String tailString = result.substring(i,indexTail); // 꼬리
            // 사이에 컴마를 넣어야함
            result=headString+','+tailString;
            indexTail+=1;
        }
        return result;
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
//    public String[] getBenefit(int orderDay, Map<String,Integer> order, boolean isGift) {
//        // 혜택 내역, 혜택 금액 반환
//        String[] result = new String[2];
//        StringBuilder s = new StringBuilder();
//        int sumDiscountPrice = 0;
//
//        Day day = getDay(orderDay%7); // 요일
//
//        if(1<=orderDay&&orderDay<=25) { // 크리스마스 디데이 할인
//            int discountPrice = 1000;
//            discountPrice+=orderDay-1;
//            sumDiscountPrice+=discountPrice;
//            s.append("크리스마스 디데이 할인:"+discountPrice+"\n");
//        }
//
//        if(day==Day.FRI||day==Day.SAT){
//            int discountPrice = 0;
//            // 주말 할인
//            for(String key : order.keySet()){
//                if(menu.isMain(key)){
//                   discountPrice+= 2023;
//                }
//            }
//            sumDiscountPrice+=discountPrice;
//            s.append("주말 할인:"+discountPrice+"\n");
//
//        }
//        if(!(day==Day.FRI||day==Day.SAT)){
//           // 평일 할인
//            int discountPrice = 0;
//            for(String key : order.keySet()){
//                if(menu.isDessert(key)){
//                    discountPrice+= 2023;
//                }
//            }
//            sumDiscountPrice+=discountPrice;
//            s.append("평일 할인:"+discountPrice+"\n");
//        }
//
//        // 증정 이벤트 빠짐
//        // 총 혜택 금액
//
//        result[0] = String.valueOf(sumDiscountPrice);
//        result[1] = String.valueOf(s);
//
//        return result;
//    }




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
}
