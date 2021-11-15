import lombok.Data;

import java.io.*;

/**
 * 测试jdk反序列化对象，增加或删除字段后会不会报错
 * 在一次面试中面试官提到使用jdk序列化的弊端，在我回答完之后，他补充了该观点。
 * 我表示怀疑，实测只要不修改serialVersionUID，增删对象的字段，反序列化都不会报错
 *
 * @author sunmengyuan
 * @date 2021-11-15
 */
public class JdkSerializable {
    @Data
    static class Person implements Serializable {
        private static final long serialVersionUID = 1L;
        private int id;
        private String name;
        private int age;
        private String address;
        private String address2;

        @Override
        public String toString() {
            return "id = " + this.id + ", name = " + this.name + ", age = " + this.age + ", address = " + this.address;
        }
    }

    private static void serialize() throws IOException {
        Person p = new Person();
        p.setId(1);
        p.setName("zhangsan");
        p.setAge(16);
//        p.setAddress("xxxx");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\person.txt"));
        //2.使用ObjectOutputStream对象中的方法writeObject,把对象写入到文件中
        oos.writeObject(p);
        //3.释放资源
        oos.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 删除一个字段后反序列化
        ObjectInputStream oos = new ObjectInputStream(new FileInputStream("D:\\person.txt"));
        Person p = (Person) oos.readObject();
        System.out.println(p.toString());
    }
}
