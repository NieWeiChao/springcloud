package site.wattsnwc.java8.lambda;

import java.util.Arrays;


/**
 * Consumer 即消费者，用于接收单个值，
 * BiConsumer 则是接收两个值，
 * Function 用于变换对象，
 * Predicate 用于判断
 */
public class Java8Tester {
   public static void main(String args[]){
      Java8Tester tester = new Java8Tester();

      // 类型声明
      MathOperation addition = (int a, int b) -> a + b;

      // 不用类型声明
      MathOperation subtraction = (a, b) -> a - b;

      // 大括号中的返回语句
      MathOperation multiplication = (int a, int b) -> { return a * b; };

      // 没有大括号及返回语句
      MathOperation division = (int a, int b) -> a / b;

      System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
      System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
      System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
      System.out.println("10 / 5 = " + tester.operate(10, 5, division));

      // 不用括号
      GreetingService greetService1 = message ->
      System.out.println("Hello " + message);

      // 用括号
      GreetingService greetService2 = (message) ->
      System.out.println("Hello " + message);

      greetService1.sayMessage("Runoob");
      greetService2.sayMessage("Google");
      int adder = 5;
      Arrays.asList(1, 2, 3, 4, 5).forEach(e -> System.out.println(e + adder));
   }

   interface MathOperation {
      int operation(int a, int b);
   }

   interface GreetingService {
      void sayMessage(String message);
   }

   private int operate(int a, int b, MathOperation mathOperation){
      return mathOperation.operation(a, b);
   }
}