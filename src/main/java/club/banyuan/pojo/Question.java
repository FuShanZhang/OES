package club.banyuan.pojo;





public class Question {

    private Integer id;
    private String name;
    private Integer opt;//选项答案(A,B,C,D)对应(1000,100,10,1)
    private String subject;//题目所属的科目类型
    private String questionText;//题目内容，包括题干和选项
    private Integer questionType;//选项类型：0代表单选，1代表多选

    public Question() {
    }

    public Question(Integer id, String name, Integer opt, String subject, String questionText, Integer questionType) {
        this.id = id;
        this.name = name;
        this.opt = opt;
        this.subject = subject;
        this.questionText = questionText;
        this.questionType = questionType;
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

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", opt=" + opt +
                ", subject='" + subject + '\'' +
                ", questionText='" + questionText + '\'' +
                ", questionType=" + questionType +
                '}';
    }
}
