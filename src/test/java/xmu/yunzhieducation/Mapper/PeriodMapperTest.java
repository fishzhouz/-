package xmu.yunzhieducation.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xmu.yunzhieducation.entity.Period;
import xmu.yunzhieducation.entity.Student_period;
import xmu.yunzhieducation.mapper.PeriodMapper;

import java.math.BigInteger;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeriodMapperTest {
    @Autowired
    private PeriodMapper periodMapper;

    @Test
    public void testCreatePeriod()
    {
        Period p=new Period();
        p.setClass_id(new BigInteger("1"));
        p.setKnowledge_point("RNN");
        periodMapper.createPeriod(p);
    }

    @Test
    public void testDeletePeriodByPeriodID()
    {
        periodMapper.deletePeriodByPeriodID(new BigInteger("5"));
    }

    @Test
    public void testUpdatePeriodByPeriodID()
    {
        Period p=new Period();
        p.setId(new BigInteger("6"));
        p.setClass_id(new BigInteger("1"));
        p.setKnowledge_point("RNN");
        p.setPpt("../1.pptx");
        p.setVideo("../1.mp4");
        periodMapper.updatePeriodByPeriodID(p);
    }

    @Test
    public void testSelectPeriodByClassID()
    {
        List<Period> periods=periodMapper.selectPeriodByClassID(new BigInteger("1"));
        for(Period p:periods){
            System.out.println(p);
        }
    }

    @Test
    public void testUpdateStudentPeriodisclick()
    {
        periodMapper.updateStudentPeriodisclick(new BigInteger("4"),new BigInteger("1"));
    }

    @Test
    public void testInsertStudentPeriod()
    {
        Student_period s=new Student_period();
        s.setStudent_id(new BigInteger("5"));
        s.setPeriod_id(new BigInteger("1"));
        s.setIs_click(0);
        periodMapper.insertStudentPeriod(s);
    }

    @Test
    public void testDeleteStudentPeriodByStudentIDPeriodID()
    {
        periodMapper.deleteStudentPeriodByStudentIDPeriodID(new BigInteger("5"),new BigInteger("1"));
    }

    @Test
    public void testSelectPeriodByPeriodID()
    {
        Period period=periodMapper.selectPeriodByPeriodID(new BigInteger("1"));
        System.out.println(period);
    }
}
