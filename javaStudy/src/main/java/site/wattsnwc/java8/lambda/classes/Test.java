package site.wattsnwc.java8.lambda.classes;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 这里需要写注释
 */
public class Test {
    public static List<Article> articles = Arrays.asList(
            Article.builder().author("watts").tags(Arrays.asList("Java","IT")).build(),
            Article.builder().author("watts1").tags(Arrays.asList("Python","IT1")).build(),
            Article.builder().author("watts2").tags(Arrays.asList("PHP","It2")).build(),
            Article.builder().author("watts2").tags(Arrays.asList("Java","It3")).build()
    );
    public static void main(String[] args) {
        //早到第一篇包含java的文章
        Article fArticle =  articles.stream()
                .filter(article -> article.getTags().contains("Java"))
                .findFirst().orElse(Article.builder().build());
        System.out.println(fArticle.getTags());
        //获取所有包含java的文章
        List<Article> fArticles = articles.stream()
                .filter(article -> article.getTags().contains("Java"))
                .collect(Collectors.toList());
        fArticles.stream().map(Article::getTags).forEach(System.out::println);
        //根据作者分组
        Map<String, List<Article>> groupByAuthor = articles.stream()
                .collect(Collectors.groupingBy(Article::getAuthor));
        groupByAuthor.forEach((s, articles1) -> System.out.println(s+":"+articles1.size()));
        //返回所有标签
        articles.stream().flatMap(article -> article.getTags().stream())
                .collect(Collectors.toSet()).forEach(System.out::println);
    }
}
