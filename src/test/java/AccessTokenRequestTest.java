import me.abnerlee.wechatAPItest.AccessTokenRequest;
import org.junit.Test;
import org.junit.Assert;

/**
 * Created by Administrator on 14-11-23.
 */
public class AccessTokenRequestTest {
    @Test
    public void testGetAccessToken(){
        String accessToken = AccessTokenRequest.getAccessToken();
        Assert.assertTrue(accessToken != null);
    }
}
