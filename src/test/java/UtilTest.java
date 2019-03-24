import com.yummy.MainClass;
import com.yummy.util.EmailSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainClass.class)
public class UtilTest {

    @Autowired
    private EmailSender emailSender;

    public UtilTest(){
    }
    @Test
    public void testEmailSender(){
        emailSender.sendEmail("734609160@qq.com","this is a test!");
    }
}
