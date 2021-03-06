import com.yummy.MainClass;
import com.yummy.controller.MemberController;
import com.yummy.module.MemberModule;
import com.yummy.service.memberservice.MemberInfoService;
import com.yummy.service.memberservice.MemberLoginService;
import com.yummy.util.message.servicemessage.LoginMessage;
import com.yummy.util.message.servicemessage.ModifyMessage;
import com.yummy.util.message.servicemessage.SignupMessage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainClass.class)
public class MemberTest {

    @Autowired
    private MemberLoginService memberLoginService;

    @Autowired
    private MemberInfoService memberInfoService;

    @Autowired
    private MemberController memberController;

    private String email="test";
    private String password="12345";

    public MemberTest(){
    }

    @Test
    public void test(){
        memberController.memberSignUp(null);
    }

    @Test
    public void testInfoModify(){
        String phone="123456789";
        String name="zhangsan";
        String newPassword="123";
        memberLoginService.signUp(email,password);
        MemberModule memberModule=memberInfoService.getMemberInfo(email);
        memberModule.setPhone(phone);
        memberModule.setName(name);
        memberModule.setPassword(newPassword);
        // modifyMemberInfo
        ModifyMessage modifyMessage=memberInfoService.modifyMemberInfo(memberModule);
        Assert.assertEquals(ModifyMessage.MODIFY_SUCCESS,modifyMessage);
        // checkModify
        LoginMessage loginMessage=memberLoginService.login(email,password);
        Assert.assertEquals(LoginMessage.WRONG_PASSWD,loginMessage);
        LoginMessage loginMessage1=memberLoginService.login(email,newPassword);
        Assert.assertEquals(LoginMessage.SUCCESS,loginMessage1);
        ModifyMessage modifyMessage1=memberInfoService.deleteMember(email);
        Assert.assertEquals(ModifyMessage.MODIFY_SUCCESS,modifyMessage1);
    }

    @Test
    public void testLoginService(){
        memberLoginService.signUp(email,password);
        SignupMessage signupMessage=memberLoginService.signUp(email,password);
        Assert.assertEquals(SignupMessage.DUPLICATED_USER,signupMessage);
        LoginMessage loginMessage=memberLoginService.login(email,password);
        Assert.assertEquals(LoginMessage.SUCCESS,loginMessage);
        ModifyMessage modifyMessage1=memberInfoService.deleteMember(email);
        Assert.assertEquals(ModifyMessage.MODIFY_SUCCESS,modifyMessage1);
        LoginMessage loginMessage1=memberLoginService.login(email,password);
        Assert.assertEquals(LoginMessage.NO_USER,loginMessage1);
    }


}
