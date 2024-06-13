package christmas;

import java.util.HashMap;
import java.util.Map;

import static christmas.Badge.*;
import static christmas.Day.getDayName;

public class Order {
    private final int getGiftPrice = 120000;
    private final int day1 = 1;
    private final int day25 = 25;
    private final int day7 = 7;
    private final int year = 2023;
    private final int giftPrice = 25000;
    private final int limitEventPrice = 10000;
    Menu menu = new Menu();

    public int sumPrice(Map<String, Integer> order) {
        int sumPrice = 0;
        for (String key : order.keySet()) {
            sumPrice += menu.findPrice(key);
        }
        return sumPrice;
    }

    public boolean getGift(int sumPrice) {
        if (sumPrice >= getGiftPrice) {
            return true;
        }
        return false;
    }

    public String getBadge(int discountPrice) {
        if (STAR.getLower() <= discountPrice && discountPrice < STAR.getUpper()) {
            return "별";
        } else if (Tree.getLower() <= discountPrice && discountPrice < Tree.getUpper()) {
            return "트리";
        } else if (SANTA.getLower() <= discountPrice) {
            return "산타";
        }
        return "없음";
    }

    public Map<String, Integer> eventXMas(int orderDay) {
        Map<String, Integer> result = new HashMap<>();
        int discountPrice = 1000; // default discount price
        if (day1 <= orderDay && orderDay <= day25) {
            discountPrice += (orderDay - 1) * 100;

            result.put("크리스마스 디데이 할인", discountPrice);
        }
        return result;
    }

    public Map<String, Integer> eventWeekday(int orderDay, Map<String, Integer> order) {
        Map<String, Integer> result = new HashMap<>();
        Day day = getDayName(orderDay % day7); // 요일
        int discountPrice = 0;
        if (!(day == Day.FRI || day == Day.SAT)) {
            for (String key : order.keySet()) {
                if (menu.isDessert(key)) {
                    discountPrice += year;
                }
            }
        }
        if (discountPrice != 0) {
            result.put("평일 할인", discountPrice);
        }
        return result;
    }

    public Map<String, Integer> eventWeekend(int orderDay, Map<String, Integer> order) {
        Map<String, Integer> result = new HashMap<>();
        Day day = getDayName(orderDay % day7); // 요일
        int discountPrice = 0;
        if (day == Day.FRI || day == Day.SAT) {
            // 주말 할인
            for (String key : order.keySet()) {
                if (menu.isMain(key)) {
                    discountPrice += year;
                }
            }
        }
        if (discountPrice != 0) {
            result.put("주말 할인", discountPrice);
        }
        return result;
    }

    public Map<String, Integer> eventGift(boolean isGift) {
        Map<String, Integer> result = new HashMap<>();
        if (isGift) {
            result.put("증정 이벤트", giftPrice);
        }
        return result;
    }


    public Map<String, Integer> getBenefit(int orderDay, int sumPrice, Map<String, Integer> order, boolean isGift) {
        // 혜택 내역, 혜택 금액 반환
        Map<String, Integer> benefit = new HashMap<>();
        int sumDiscountPrice = 0;

        if (sumPrice >= limitEventPrice) { // 이벤트 적용
            benefit.putAll(eventXMas(orderDay));
            benefit.putAll(eventWeekday(orderDay, order));
            benefit.putAll(eventWeekend(orderDay, order));
            benefit.putAll(eventGift(isGift));
            benefit.putAll(eventStar(orderDay));
        }
        return benefit;
    }

    private Map<String, Integer> eventStar(int orderDay) {
        Map<String, Integer> result = new HashMap<>();
        int discountPrice = 0;
        int[] eventStarDay = {3, 10, 17, 24, 25, 31};
        for (int i = 0; i < eventStarDay.length; i++) {
            if (orderDay == eventStarDay[i]) {
                discountPrice = 1000; // default discount price
                result.put("특별 할인", discountPrice);
                break;
            }
        }
        return result;
    }


    public int sumBenefitPrice(Map<String, Integer> benefit) {
        int price = 0;
        for (String key : benefit.keySet()) {
            price += benefit.get(key);
        }
        return price;
    }
}
