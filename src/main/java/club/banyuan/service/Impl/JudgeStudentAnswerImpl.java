/*
package club.banyuan.service.Impl;

import club.banyuan.dao.AdminDaoImpl;
import club.banyuan.dao.IAdminDao;
import club.banyuan.service.JudgeStudentAnswer;
*/
/*功能：判断传过来的题号是否存在,判断学生答案是否正确。
  方法：idExist（），判断题号是否在数据库中存在，CompareAnswer（）判断该题答案是否与数据中相同
*@翁
* *//*



public class JudgeStudentAnswerImpl implements JudgeStudentAnswer {
    IAdminDao iadminDao;
    //判断题号是否存在，如果存在返回true，否则返回false
    public boolean idExist(int id) {
        iadminDao=new AdminDaoImpl();
        if(iadminDao.idExist(id)){
            return true;
        }else {
            return false;
        }

    }

    public boolean CompareAnswer(int id,int option) {
        iadminDao=new AdminDaoImpl();
        //判断题号是否存在
        if(idExist(id)){
            //如果存在，判断数据中该题的答案和否与传过来的答案相同
            if(getAnswerById(id)==option){
                //如果相同，返回true，负责返回false
                return true;
            }else {
                return false;
            }

        }else {
            return false;
        }

    }


}
*/
