package club.banyuan.service;

import club.banyuan.pojo.Question;

public interface JudgeStudentAnswer {
    boolean CompareAnswer(Question question, int option); //考生答案和正确答案对比
   // boolean idExist(int id); //判断题号是否存在

}
