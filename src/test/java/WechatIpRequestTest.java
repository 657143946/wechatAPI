import me.abnerlee.wechatAPI.WechatIpRequest;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 14-11-23.
 */
public class WechatIpRequestTest {
    @Test
    public void testGetWechatIpList(){
        List<String> ips = WechatIpRequest.getWechatIpList();
        System.out.println(ips);
        Assert.assertTrue(ips != null);

    }
}
