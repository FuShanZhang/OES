package club.banyuan.util;


import java.util.Vector;

final class ConnManager {


    private ConnManager(){}

    static ConnManager getConnManager(){
        return  ConnHolder.CONN_MANAGER;
    }

    private static class ConnHolder{
        private final static ConnManager CONN_MANAGER = new ConnManager();
    }

    private Vector<ClientConn> vector = new Vector<ClientConn>();

    void addClient(ClientConn cc){
        vector.add(cc);
    }

}
