package club.banyuan.controller;

public class checkQuestion {

    public static boolean checkTitle(String title) {
        if (title.getBytes().length < 3000) {
            return true;
        } else {
            return false;
        }
    }
}
