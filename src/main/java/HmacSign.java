import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author sunmengyuan
 * @date 2021-09-28
 * 使用HmacSHA1算法生成签名
 */
public class HmacSign {
    /**
     * @param content 请求的参数内容
     * @param secret  签名secret
     * @return
     */
    private static String getHmacSign(String content, String secret) {
        byte[] result = null;
        try {
            SecretKeySpec signinKey = new SecretKeySpec(secret.getBytes(), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signinKey);
            byte[] rawHmac;
            rawHmac = mac.doFinal(content.getBytes(StandardCharsets.UTF_8));
            result = Base64.getEncoder().encode(rawHmac);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null != result) {
            return new String(result);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(getHmacSign("{}", "638328d345a04f4f9aa8af6b0c79f536"));
    }
}
