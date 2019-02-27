package DaoTest;
/*
 * author: SJZ
 * date: 2019/2/25
 */

import com.yummy.MainClass;
import com.yummy.dao.RestaurantDao;
import com.yummy.entity.Restaurant;
import com.yummy.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainClass.class)

public class RestaurantDaoTest {
    @Autowired
    RestaurantDao restaurantDao;
    @Test
    public void testRestaurantDao(){
        Restaurant restaurant=new Restaurant();
        Address address=new Address();
        address.setAddress("this is my home");
        restaurant.setAddress(address);
        restaurant.setIdCode("aaaaaaa");
        restaurantDao.insertRestaurant(restaurant);
        Restaurant restaurant1=restaurantDao.getRestaurantByIdCode("aaaaaaa");
        assertTrue(restaurant1.getAddress().getAddress().equals("this is my home"));
    }
}
