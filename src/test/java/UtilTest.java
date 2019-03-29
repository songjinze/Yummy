import com.yummy.MainClass;
import com.yummy.util.CheckCodeCreator;
import com.yummy.util.MyOwnDate;
import com.yummy.util.EmailSender;
import org.junit.Assert;
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
    @Autowired
    private MyOwnDate myOwnDate;
    @Autowired
    private CheckCodeCreator checkCodeCreator;

    public UtilTest(){
    }
    @Test
    public void testEmailSender(){
        emailSender.sendEmail("734609160@qq.com","this is a test!");
    }

    @Test
    public void testDate(){
        String now= myOwnDate.getDate();
        System.out.println(now);
        String []nowSep=now.split("-");
        String tomorrow=nowSep[0]+"-"+nowSep[1]+"-"+(Integer.parseInt(nowSep[2])+1);
        String yesterday=nowSep[0]+"-"+nowSep[1]+"-"+(Integer.parseInt(nowSep[2])-1);
        Assert.assertEquals(-1, myOwnDate.compareTo(now,tomorrow));
        Assert.assertEquals(1, myOwnDate.compareTo(now,yesterday));
        Assert.assertEquals(0, myOwnDate.compareTo(now,now));
    }

    @Test
    public void testCheckCode(){
        for(int i=0;i<100;i++){
            String checkCode=checkCodeCreator.createCheckCode();
            System.out.println(checkCode);
        }
    }
}
