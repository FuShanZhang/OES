package club.banyuan.service;

public interface JudgeStudentAnswer {
    boolean CompareAnswer(int id, int option); //考生答案和正确答案对比
    boolean idExist(int id); //判断题号是否存在
}
