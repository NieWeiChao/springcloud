package site.wattsnwc.java8.lambda.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {


    public static void main(String[] args) {
        //1.使用Collection中的方法和Arrays
        String[] strArr = new String[]{"a", "b", "c"};
        List<String> list = Arrays.asList(strArr);
        Stream<String> stream = list.stream();
        Stream<String> stream1 = Arrays.stream(strArr);

        //2. 使用Stream中提供的静态方法
        Stream<String> stream2 = Stream.of(strArr);
        Stream<Double> stream3 = Stream.generate(Math::random);
        Stream<Object> stream4 = Stream.empty();
        Stream.iterate(1, i -> i++);
        //合并
        Stream.concat(Stream.of(1, 2, 3), Stream.of(4, 5, 6)).
                forEach(System.out::println);
        //去重
        Stream<String> streamDistinct = Stream.of("a", "a", "b", "c");
        streamDistinct.distinct().forEach(System.out::println);
        //限制返回流元素
        Stream<String> streamLimit = Stream.of("a", "a", "b", "c");
        streamLimit.limit(2).forEach(System.out::println);
        //跳过元素
        Stream<String> streamSkip = Stream.of("a", "a", "b", "c");
        streamSkip.skip(2).forEach(System.out::println);

        //peek
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
        //sort
        Stream<Integer> streamSort = Stream.of(3, 2, 1);
        streamSort.sorted(Integer::compareTo).forEach(System.out::println);

        //match
        Stream<Integer> streamAllmatch = Stream.of(3, 2, 1);
        boolean allMatch = streamAllmatch.allMatch(integer -> integer >= 3);
        System.out.println(allMatch);
    }
}