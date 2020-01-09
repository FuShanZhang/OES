package club.banyuan.util;

import java.io.IOException;
import java.net.Socket;

public class Test {

    @org.junit.Test
    public void Test01(){
        new ServiceConn().start();
    }

    @org.junit.Test
    public void Test02() throws IOException {
        ClientConn clientConn = new ClientConn(new Socket("192.168.10.59",8469));
    }

}
