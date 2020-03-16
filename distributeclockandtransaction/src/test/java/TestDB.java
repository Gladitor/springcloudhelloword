import com.jiay.distributeclock.Application;
import com.jiay.distributeclock.bean.User;
import com.jiay.distributeclock.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestDB {
    @Autowired
    private UserService userService;

    @Test
    public void test(){
        User user = new User();
        user.setName("jiay");
        user.setAge(20);
        try {
            userService.addUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
