package site.wattsnwc.java8.lambda.classes;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 这里需要写注释
 */
@Getter
@Setter
@Builder
public class Article {
    private final String title;
    private final String author;
    private final List<String> tags;
}
