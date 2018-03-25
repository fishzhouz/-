package xmu.yunzhieducation.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.yunzhieducation.entity.*;
import xmu.yunzhieducation.mapper.*;
import xmu.yunzhieducation.service.CourseService;
import xmu.yunzhieducation.vo.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private PeriodMapper periodMapper;
    @Autowired
    private DateMapper dateMapper;
    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private SchoolMapper schoolMapper;
    @Autowired
    private TrainingMapper trainingMapper;

    @Override
   public List<CourseAndTeacherVo> getOwnCourse(BigInteger user_id)
    {
       List<CourseAndTeacherVo> courseAndTeacherVos=new ArrayList<CourseAndTeacherVo>();
       List<Class_student> class_students=courseMapper.selectClassstudentByStudentID(user_id);
       for(Class_student c:class_students)
            {
                CourseAndTeacherVo courseAndTeacherVo=new CourseAndTeacherVo();
                courseAndTeacherVo.setClass_id(c.getClass_id());
                BigInteger course_id=courseMapper.selectCourseIDByClassID(c.getClass_id()).getCourse_id();
                Course course=courseMapper.selectCourseinfoByCourseID(course_id);
                courseAndTeacherVo.setCourse_id(course_id);
                courseAndTeacherVo.setCourse_name(course.getName());
                courseAndTeacherVo.setPicture(course.getPicture());
                courseAndTeacherVo.setTeacher_name(loginMapper.selectUserByuserID(course.getTeacher_id()).getName());
                if(c.getGrade()==null)  {
                    courseAndTeacherVo.setIs_end(false);
                    courseAndTeacherVo.setReplay("进行中");
                }
                else{
                    courseAndTeacherVo.setIs_end(true);
                    courseAndTeacherVo.setReplay("已结束  "+c.getGrade()+"分");
                }
                courseAndTeacherVos.add(courseAndTeacherVo);
            }
            return courseAndTeacherVos;
    }

    @Override
    public List<CourseVo> getTeacherCourse(BigInteger user_id)
    {
        List<CourseVo> courseVos=new ArrayList<CourseVo>();
        List<Course> courses=courseMapper.selectCourseByTeacherID(user_id);
        String name=loginMapper.selectUserByuserID(user_id).getName();
        for(Course c:courses){
            CourseVo courseVo=new CourseVo();
            courseVo.setCourse_id(c.getId());
            courseVo.setCourse_name(c.getName());
            courseVo.setPicture(c.getPicture());
            courseVo.setTeacher_name(name);
            courseVos.add(courseVo);
        }
        return courseVos;
    }
    @Override
    public CourseInfoVo getCourseInfo(BigInteger user_id,BigInteger course_id)
    {
        CourseInfoVo courseInfoVo=new CourseInfoVo();
        List<Class1> class1s=courseMapper.selectClassByCourseID(course_id);
        Integer sum=0;
        for(Class1 c:class1s){
            sum+=c.getStudent_num();
        }
        courseInfoVo.setNum(sum);
        courseInfoVo.setCourse(courseMapper.selectCourseinfoByCourseID(course_id));
        List<Class_student> class_students=courseMapper.selectClassstudentByStudentID(user_id);
        boolean temp=false;
        for(Class_student c:class_students)
        {
            for(Class1 class1:class1s)
            {
                if(class1.getId()==c.getClass_id())
                {
                    temp=true;
                    break;
                }
            }
        }
        courseInfoVo.setIs_choose(temp);
        return courseInfoVo;
    }

    @Override
    public boolean chooseCourse(BigInteger user_id,BigInteger class_id)
    {
        Class_student class_student=new Class_student();
        class_student.setClass_id(class_id);
        class_student.setStudent_id(user_id);
        courseMapper.chooseCourseByStudentID(class_student);
        //选完课之后班级人数加一
        courseMapper.updateClass(class_id);
        return true;
    }

    @Override
    public List<PeriodInfoVo> getOwnPeriod(BigInteger class_id, BigInteger user_id)
    {
        List<PeriodInfoVo> periodInfoVos =new ArrayList<PeriodInfoVo>();
        List<Period> periods=periodMapper.selectPeriodByClassID(class_id);
        Integer index=1;
        for(Period p:periods)
        {
            PeriodInfoVo periodInfoVo =new PeriodInfoVo();
            periodInfoVo.setPeriod_id(p.getId());
            periodInfoVo.setContent("第"+index+"课时  "+p.getKnowledge_point());
            index+=1;
            Student_period s=dateMapper.listStudentPeriodByPeriodIdAndStudentId(p.getId(),user_id);
            if(s==null){
                periodInfoVo.setIs_click(false);
            }
            else{
                periodInfoVo.setIs_click(true);
            }
            periodInfoVos.add(periodInfoVo);
        }
        return periodInfoVos;
    }

    @Override
    public List<TaskIdAndContentVo> getOwnTask(BigInteger class_id)
    {
        List<TaskIdAndContentVo> taskIdAndContentVos =new ArrayList<>();
        List<Period> periods=periodMapper.selectPeriodByClassID(class_id);
        Integer index=1;
        for(Period p:periods){
            List<Task> tasks=taskMapper.selectTaskByperiodID(p.getId());
            for(Task t:tasks){
                TaskIdAndContentVo taskIdAndContentVo =new TaskIdAndContentVo();
                taskIdAndContentVo.setTask_id(t.getId());
                taskIdAndContentVo.setContent("任务"+index+"  "+t.getName());
                index+=1;
                taskIdAndContentVos.add(taskIdAndContentVo);
            }
        }
        return taskIdAndContentVos;
    }

    @Override
    public List<WrongQuestionVo> getOwnWrongQuestion(BigInteger user_id,BigInteger course_id)
    {
        List<WrongQuestionVo> wrongQuestionVos=new ArrayList<>();
        List<Student_question> student_questions=taskMapper.selectStudentquestionBycourseID(user_id,course_id);
        Integer index=1;
        for(Student_question s:student_questions) {
            WrongQuestionVo wrongQuestionVo = new WrongQuestionVo();
            wrongQuestionVo.setWrong_answer(s.getOwn_answer());
            Question question = taskMapper.selectQuestionByquestionID(s.getQuestion_id());
            wrongQuestionVo.setHeading(index + ". " + question.getHeading());
            wrongQuestionVo.setA(question.getA());
            wrongQuestionVo.setB(question.getB());
            wrongQuestionVo.setC(question.getC());
            wrongQuestionVo.setD(question.getD());
            wrongQuestionVo.setAnswer(question.getAnswer());
            index+=1;
            wrongQuestionVos.add(wrongQuestionVo);
        }
        return wrongQuestionVos;
    }

    @Override
    public List<TopicVo> getCircleTopic(BigInteger belonging_id,Integer type)
    {
        List<TopicVo> topicVos=new ArrayList<>();
        List<Topic> topics=commentMapper.selectTopicBybelongingID(belonging_id, type);
        BigInteger index=new BigInteger("1");
        for(Topic t:topics){
            TopicVo topicVo=new TopicVo();
            topicVo.setNo(index);
            index=index.add(new BigInteger("1"));
            topicVo.setHeading(t.getHeading());
            topicVo.setContent(t.getContent());
            topicVo.setTime(t.getTime());
            List<Comment> comments=commentMapper.selectCommentBytopicID(t.getId());
            topicVo.setComment_num(new BigInteger((comments.size()+"")));
            topicVos.add(topicVo);
        }
        return topicVos;
    }

    @Override
    public List<Class1> getClass(BigInteger course_id,Integer type)
    {
        List<Class1> class1s=courseMapper.selectClassByCourseID(course_id);
        if(type==0)
        {
            return class1s;
        }
        else if(type==1)
        {
            List<Class1> class1List=new ArrayList<>();
            Date now=new Date();
            System.out.println(now);
            for(Class1 c:class1s){
                if((c.getStart_time().compareTo(now))<0&&(c.getEnd_time().compareTo(now))>0){
                    class1List.add(c);
                }
            }
            return class1List;
        }
        return null;
    }

    @Override
    public boolean insertClass(Class1 class1)
    {
        schoolMapper.insertClass(class1);
        return true;
    }

    @Override
    public List<StudentGradeVo> getStudent(BigInteger class_id)
    {
        List<StudentGradeVo> studentGradeVos=new ArrayList<>();
        List<Class_student> class_students=dateMapper.listClassStudentByClassId(class_id);
        for(Class_student c:class_students){
            StudentGradeVo studentGradeVo=new StudentGradeVo();
            studentGradeVo.setStudent_id(c.getStudent_id());
            studentGradeVo.setGrade(c.getGrade());
            studentGradeVo.setName(loginMapper.selectUserByuserID(c.getStudent_id()).getName());
            studentGradeVos.add(studentGradeVo);
        }
        return studentGradeVos;
    }

    @Override
    public boolean insertCourse(Course course)
    {
        courseMapper.creatCourse(course);
        return true;
    }

    @Override
    public boolean GradeStudent(BigInteger student_id,BigInteger class_id,Integer grade)
    {
        Class_student c=new Class_student();
        c.setClass_id(class_id);
        c.setStudent_id(student_id);
        c.setGrade(grade);
        courseMapper.updateClassStudentGradeByID(c);
        return true;
    }

    @Override
    public boolean dropCourse(BigInteger class_id,BigInteger user_id)
    {
        BigInteger course_id=courseMapper.selectCourseIDByClassID(class_id).getCourse_id();
        //删个人档案
        dateMapper.deleteAbilityFileByCourseIdAndStudentId(course_id,user_id);
        //删class_student表，班级表里人数减一、
        courseMapper.dropCourseByClassID(class_id,user_id);
        courseMapper.updateMinClass(class_id);
        //删4个表
        List<Period> periods=periodMapper.selectPeriodByClassID(class_id);
        for(Period p:periods){
            List<Task> tasks=taskMapper.selectTaskByperiodID(p.getId());
            for(Task t:tasks){
                List<Question> questions=taskMapper.selectQuestionBytaskID(t.getId());
                for(Question q:questions){
                            taskMapper.deleteStudentquestionByID(q.getId(),user_id);
                }
                taskMapper.deleteStudenttaskByID(t.getId(),user_id);
            }
            periodMapper.deleteStudentPeriodByStudentIDPeriodID(user_id,p.getId());
        }
        List<Trainging> traingings=trainingMapper.listTrainingByCourseId(course_id);
        for(Trainging t:traingings){
            trainingMapper.deleteStudentTrainingById(t.getId(),user_id);
            trainingMapper.updateMinTraining(t.getId());
        }
        return true;
    }

    @Override
    public boolean deleteCourse(BigInteger course_id)
    {
        List<Class1> class1s=courseMapper.selectClassByCourseID(course_id);
        for(Class1 c:class1s){
            List<Class_student> class_students=dateMapper.listClassStudentByClassId(c.getId());
            for(Class_student class_student:class_students){
                dropCourse(c.getId(),class_student.getStudent_id());
            }
        }
        for(Class1 c:class1s){
            List<Period> periods=periodMapper.selectPeriodByClassID(c.getId());
            for(Period p:periods){
                List<Task> tasks=taskMapper.selectTaskByperiodID(p.getId());
                for(Task t:tasks){
                    List<Question> questions=taskMapper.selectQuestionBytaskID(t.getId());
                    for(Question q:questions){
                        taskMapper.deleteQuestionByquestionID(q.getId());
                    }
                    taskMapper.deleteTaskBytaskID(t.getId());
                }
                periodMapper.deletePeriodByPeriodID(p.getId());
            }
            schoolMapper.deleteClass(c.getId());
        }
        List<Topic> topics=commentMapper.selectTopicBybelongingID(course_id,1);
        for(Topic t:topics){
            loginMapper.deleteMessageBytopicID(t.getId());
            List<Comment> comments=commentMapper.selectCommentBytopicID(t.getId());
            for(Comment c:comments){
                commentMapper.deleteCommentByID(c.getId());
            }
            commentMapper.deleteTopicByID(t.getId());
        }
        List<Trainging> traingings=trainingMapper.listTrainingByCourseId(course_id);
        for(Trainging t:traingings){
            List<Topic> topicList=commentMapper.selectTopicBybelongingID(t.getId(),2);
            for(Topic topic:topicList){
                loginMapper.deleteMessageBytopicID(topic.getId());
                List<Comment> comments=commentMapper.selectCommentBytopicID(topic.getId());
                for(Comment c:comments){
                    commentMapper.deleteCommentByID(c.getId());
                }
                commentMapper.deleteTopicByID(topic.getId());
            }
            trainingMapper.deleteTrainingById(t.getId());
        }
        schoolMapper.deleteSchoolInfoByCourseId(course_id);
        courseMapper.deleteCourseByCourseID(course_id);
        return true;
    }
}
