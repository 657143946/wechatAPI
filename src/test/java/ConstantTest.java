import me.abnerlee.wechatAPI.Constant;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 14-11-22.
 */
public class ConstantTest {

    @Test
    public void testConstantRead(){
        Assert.assertTrue(Constant.TOKEN != null);
        Assert.assertTrue(Constant.APPID != null);
        Assert.assertTrue(Constant.APPSECRET != null);
    }

}
