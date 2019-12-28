package club.banyuan.util;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author zhangfushan
 */
@SuppressWarnings("All")
public class SocketConn {

    private  InetAddress localHostAddress;

    public InetAddress getLocalHostAddr() throws UnknownHostException {
        localHostAddress = InetAddress.getLocalHost();
        return localHostAddress;
    }

    @Test
    public void MyTest() throws UnknownHostException {
        SocketConn socketConn = new SocketConn();
        System.out.println(socketConn.getLocalHostAddr());
    }
}
