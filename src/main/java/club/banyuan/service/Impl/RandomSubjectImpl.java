package club.banyuan.service.Impl;

import club.banyuan.dao.IQuestionDao;
import club.banyuan.dao.QuestionDaoImpl;
import club.banyuan.pojo.Question;
import club.banyuan.service.RandomSubject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RandomSubjectImpl implements RandomSubject {
    @Override
    public List<Question> randomSubjectMethod(String subjectName) {
        IQuestionDao question=new QuestionDaoImpl();
        //传入
        List list=question.selectSubject(subjectName);
        //随你打乱集合中的顺序
        Collections.shuffle(list);
        return list;
    }
}
