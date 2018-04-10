package xmu.yunzhieducation.view;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value="/student")
public class StudentController {
    @RequestMapping(value="/classj")
    public String classj() { return "student/classj"; }

    @RequestMapping(value="/index")
    public String index() { return "student/index"; }
    @RequestMapping(value="/task")
    public String task() { return "student/task"; }

    @RequestMapping(value="/alumniCircle")
    public String alumniCircle() { return "student/alumniCircle"; }

    @RequestMapping(value="/circleComment")
    public String circleComment() { return "student/circleComment"; }

    @RequestMapping(value="/circleToComment")
    public String circleToComment() { return "student/circleToComment"; }

    @RequestMapping(value="/circleToPut")
    public String circleToPut() { return "student/circleToPut"; }

    @RequestMapping(value="/classContent")
    public String classContent() { return "student/classContent"; }

    @RequestMapping(value="/classContentTrue")
    public String classContentTrue() { return "student/classContentTrue"; }

    @RequestMapping(value="/classDetails")
    public String classDetails() { return "student/classDetails"; }

    @RequestMapping(value="/finishTraining")
    public String finishTraining() { return "student/finishTraining"; }

    @RequestMapping(value="/information")
    public String information() { return "student/information"; }

    @RequestMapping(value="/login")
    public String login() { return "student/login"; }

    @RequestMapping(value="/message")
    public String message() { return "student/message"; }

    @RequestMapping(value="/myStudy")
    public String myStudy() { return "student/myStudy"; }

    @RequestMapping(value="/mytraining")
    public String mytraining() { return "student/mytraining"; }

    @RequestMapping(value="/schoolIndex")
    public String schoolIndex() { return "student/schoolIndex"; }

    @RequestMapping(value="/teacher")
    public String teacher() { return "student/teacher"; }
}
