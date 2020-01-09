package club.banyuan.service;

import club.banyuan.pojo.Question;

import java.util.List;

public interface RandomSubject {
    List<Question> randomSubjectMethod(String subjectName , Integer qType );

    List getTenQuestions(String subjectName,Integer qType ,Integer number);
}
