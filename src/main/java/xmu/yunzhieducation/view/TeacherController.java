package xmu.yunzhieducation.view;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/teacher")
public class TeacherController {
    @RequestMapping(value="/classj")
    public String classj() { return "teacher/classj"; }

    @RequestMapping(value="/classContent")
    public String classContent() { return "teacher/classContent"; }

    @RequestMapping(value="/newClass")
    public String newClass() { return "teacher/newClass"; }

    @RequestMapping(value="/newLesson")
    public String newLesson() { return "teacher/newLesson"; }

    @RequestMapping(value="/newlittleLesson")
    public String newlittleLesson() { return "teacher/newlittleLesson"; }

    @RequestMapping(value="/point")
    public String point() { return "teacher/point"; }

    @RequestMapping(value="/stage")
    public String stage() { return "teacher/stage"; }

    @RequestMapping(value="/upClass")
    public String upClass() { return "teacher/upClass"; }
}
