package club.banyuan.pojo;


/**
 * 选项答案(A,B,C,D) 对应 (1000,100,10,1)
 * 选项类型(单,多)  对应（Integer 就是 0 和 1）看
 */

public class Question {

    private Integer id;
    private String name;
    private Integer opt;
    private String subject;
    private String questionText;
    private Integer type;

    public Question() {
    }

    public Question(Integer id, String name, Integer opt, String subject, String questionText, Integer type) {
        this.id = id;
        this.name = name;
        this.opt = opt;
        this.subject = subject;
        this.questionText = questionText;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOpt() {
        return opt;
    }

    public void setOpt(Integer opt) {
        this.opt = opt;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", opt='" + opt + '\'' +
                ", subject='" + subject + '\'' +
                ", questionText='" + questionText + '\'' +
                ", type=" + type +
                '}';
    }
}
