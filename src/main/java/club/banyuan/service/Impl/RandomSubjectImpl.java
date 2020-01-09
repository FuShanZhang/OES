package club.banyuan.service.Impl;

import club.banyuan.dao.IQuestionDao;
import club.banyuan.dao.QuestionDaoImpl;
import club.banyuan.pojo.Question;
import club.banyuan.service.RandomSubject;

import java.util.*;

public class RandomSubjectImpl implements RandomSubject {
    @Override
    public List randomSubjectMethod(String subjectName,Integer qType) {

        IQuestionDao question = new QuestionDaoImpl();
        //传入
        List list = question.selectSubject(subjectName, qType);
        //随你打乱集合中的顺序
        Collections.shuffle(list);
        return list;
    }

    public List getTenQuestions(String subjectName , Integer qType , Integer number) {
        List list = randomSubjectMethod(subjectName,qType);
        ArrayList<Question> arrayList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            arrayList.add((Question) list.get(i));
        }
        return arrayList;
    }
}