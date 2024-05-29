package christmas;

import java.util.Map;
import java.util.Objects;

public class OutputView {
    // 유틸성 클래스
    private OutputView(){
    }

    public static void printComment1() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n" +
                "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
    }

    public static void printComment2(){
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)\n");
    }

    public static void printErrorMessageDay() {
        System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    public static void printErrorMessageMenu() {
        System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    public static void printOrder(Map<String, Integer> order) {
        System.out.println("<주문 메뉴>");
       for(String key : order.keySet()){
           System.out.println(key + " " + order.get(key) + "개");
       }
        System.out.println("");
    }

    public static void printPrice(int sumPrice) {
        System.out.println("<할인 전 총주문 금액>\n"+addComma(sumPrice)+"원\n");
    }

    public static String addComma(int sumPrice) {
        // 뒤에서 4번째 자리에 콤마
        String result = String.valueOf(sumPrice);
        int  indexTail = result.length();
        for(int i = indexTail-3;i>0; i-=3){
            // i자리에 컴마를 찍으면 됨
            String headString = result.substring(0,i); // 머리
            String tailString = result.substring(i,indexTail); // 꼬리
            // 사이에 컴마
            result=headString+','+tailString;
            indexTail+=1;
        }
        return result;
    }

    public static void printGift(boolean gift) {
        String result = "없음";
        if(gift==true){
            result = "샴페인 1개";
        }
        System.out.println("<증정 메뉴>\n" + result+"\n");
    }

    public static void printResultPrice(int i) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(addComma(i)+"원\n");
    }

    public static void printBadge(String badge) {
        System.out.println("<12월 이벤트 배지>\n"+badge+"\n");
    }

    public static void printBenefit(Map<String,Integer> benefit) {
        System.out.println("<혜택 내역>");
        if(benefit.size()==0){
            System.out.println("없음");
        } else if (benefit.size()!=0) {
            for(String key : benefit.keySet()){
                System.out.println(key + ": -"+addComma(benefit.get(key))+"원");
            }
        }

        System.out.println("");
    }

    public static void printBenefitPrice(int sumBenefitPrice) {
        System.out.println("<총혜택 금액>");
        if(sumBenefitPrice!=0) {
            System.out.print("-");
        }
        System.out.println(addComma(sumBenefitPrice)+"원\n");
    }




}
