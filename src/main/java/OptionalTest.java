import lombok.Data;

import java.util.Optional;

/**
 * @author sunmengyuan
 * @date 2021-08-24
 * 测试Optional 类的常见用法
 */
public class OptionalTest {
    @Data
    static class User {
        private String name;
        private int age;
        private Address address;
    }

    @Data
    static class Address {
        private String province;
        private String city;
        private String district;
    }

    public static void main(String[] args) {
        User user = new User();
        // 不会报空指针
        System.out.println(Optional.ofNullable(user.getAddress()).orElse(new Address()).getCity());
        // 会报空指针
//        System.out.println(user.getAddress().getCity());
    }
}
