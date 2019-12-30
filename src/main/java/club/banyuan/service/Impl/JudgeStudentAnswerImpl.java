
package club.banyuan.service.Impl;

import club.banyuan.dao.AdminDaoImpl;
import club.banyuan.dao.IAdminDao;
import club.banyuan.pojo.Question;
import club.banyuan.service.JudgeStudentAnswer;



/**
 * /功能：判断传过来的题号是否存在,判断学生答案是否正确。
 *  方法：idExist（），判断题号是否在数据库中存在，CompareAnswer（）判断该题答案是否与数据中相同
 * @author 翁
 */



public class JudgeStudentAnswerImpl implements JudgeStudentAnswer {


    @Override
    public boolean CompareAnswer(Question question, int option) {
        return question.getOpt() == option;
    }
}

