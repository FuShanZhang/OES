package club.banyuan.service.Impl;

import club.banyuan.dao.IQuestionDao;
import club.banyuan.dao.QuestionDaoImpl;
import club.banyuan.pojo.Question;
import club.banyuan.service.RandomSubject;

import java.util.*;

public class RandomSubjectImpl implements RandomSubject {
    @Override
    public List randomSubjectMethod(String subjectName) {

        IQuestionDao question = new QuestionDaoImpl();
        //传入
        List list = question.selectSubject(subjectName);
        //随你打乱集合中的顺序
        Collections.shuffle(list);
        return list;
    }

    public List getTenQuestions(String subjectName) {
        List list = randomSubjectMethod(subjectName);
        ArrayList<Question> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add((Question) list.get(i));
        }
        return arrayList;
    }
}