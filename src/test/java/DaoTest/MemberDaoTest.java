package DaoTest;
/*
 * author: SJZ
 * date: 2019/2/20
 */

import com.yummy.MainClass;
import com.yummy.dao.MemberDao;
import com.yummy.pojo.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainClass.class)
public class MemberDaoTest {
    @Autowired
    private MemberDao memberDao;

    @Test
    public void test(){
        Member member =new Member();
        member.setEmail("734609160@qq.com");
        int id=memberDao.insertMember(member);

    }

}
