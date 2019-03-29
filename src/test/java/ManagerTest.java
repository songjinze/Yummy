import com.yummy.MainClass;
import com.yummy.service.managerservice.ManagerLoginService;
import com.yummy.util.message.servicemessage.LoginMessage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainClass.class)
@Transactional
public class ManagerTest {

    @Autowired
    private ManagerLoginService managerLoginService;

    private String managerName="zhangsan";
    private String managerPassword="12345";

    @Test
    public void testManagerLogin(){
        managerLoginService.setManager(managerName,managerPassword);
        LoginMessage loginMessage=managerLoginService.login(managerName,managerPassword);
        LoginMessage loginMessage1=managerLoginService.login(managerPassword,managerName);
        LoginMessage loginMessage2=managerLoginService.login(managerName,"123");
        Assert.assertEquals(LoginMessage.NO_USER,loginMessage1);
        Assert.assertEquals(LoginMessage.SUCCESS,loginMessage);
        Assert.assertEquals(LoginMessage.WRONG_PASSWD,loginMessage2);
    }
}
