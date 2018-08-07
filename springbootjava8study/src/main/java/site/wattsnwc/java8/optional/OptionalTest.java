package site.wattsnwc.java8.optional;

import java.util.Optional;


public class OptionalTest {

    /**
     * Optional.empty():通过静态工厂方法Optional.empty，创建一个空的Optional对象；
     * Optional of(T value):如果value为null的话，立即抛出NullPointerException；
     * Optional ofNullable(T value)：使用静态工厂方法Optional.ofNullable，你可以创建一个允许null值的Optional对象。
     * @param user
     * @return
     */
    private String getUserName(User user) {
        Optional<Object> optional = Optional.empty();
        Optional<Object> optional1 = Optional.ofNullable(null);
        Optional<String> optional2 = Optional.of(null);
        Optional<User> userOptional = Optional.ofNullable(user);
        return userOptional.map(User::getUserName).orElse(null);
    }

    class User {
        private String userName;

        public User(String userName) {
            this.userName = userName;
        }

        public String getUserName() {
            return userName;
        }
    }
}