package club.banyuan.pojo;

import lombok.Data;

@Data
public class Question {

    private Integer id;
    private String name;
    private String opt;
    private String subject;
    private String questionText;

}
