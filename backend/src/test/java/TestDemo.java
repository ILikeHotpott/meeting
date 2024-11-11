import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;
import self.live.LiveApplication;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

@SpringBootTest(classes = LiveApplication.class)
@RunWith(SpringRunner.class)
public class TestDemo {
    @Test
    public void test() throws Exception {
        String plaintext = "xiaomaomi-xj";
        String md5Str = DigestUtils.md5DigestAsHex(plaintext.getBytes(StandardCharsets.UTF_8));
        System.out.println(md5Str.toUpperCase(Locale.CHINA));
    }
}
