import com.yummy.MainClass;
import com.yummy.dao.PayDao;
import com.yummy.entity.Pay;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = MainClass.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PayInsertion {
    @Autowired
    private PayDao payDao;

    @Test
    public void insertPayAccount(){
        Pay pay=new Pay();
        pay.setName("lisi");
        pay.setPassword("321");
        pay.setAccountBalance(100000);
        payDao.save(pay);
    }
}
