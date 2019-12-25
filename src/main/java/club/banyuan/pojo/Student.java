package club.banyuan.pojo;

import lombok.Data;
import java.util.Map;

@Data
public class Student {

    private Integer id;
    private String name;
    private String username;
    private String password;
    private Map<String,Double> score;
}
