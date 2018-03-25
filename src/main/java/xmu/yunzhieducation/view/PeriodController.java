package xmu.yunzhieducation.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xmu.yunzhieducation.entity.Period;
import xmu.yunzhieducation.service.PeriodService;

import java.math.BigInteger;
import java.util.List;

@RestController
public class PeriodController {

    @Autowired
    private PeriodService periodService;

    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/period/{period_id}",method = RequestMethod.GET)
    @ResponseBody
    public Period getPeriod(@PathVariable("period_id") BigInteger period_id){
        return periodService.getPeriod(period_id);
    }




    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/period/{period_id}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deletePeriod(@PathVariable("period_id")BigInteger period_id){
        periodService.deletePeriod(period_id);
    }






    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/period/{period_id}",method = RequestMethod.PUT)
    @ResponseBody
    public void updatePeriod(@PathVariable("period_id")BigInteger period_id,@RequestBody Period period){
        period.setId(period_id);
        periodService.updatePeriod(period);
    }





    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value = "/period/{class_id}",method = RequestMethod.POST)
    @ResponseBody
    public void postPeriod(@PathVariable("class_id")BigInteger class_id,@RequestBody Period period){
        period.setClass_id(class_id);
        periodService.postPeriod(period);
    }




    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/period/class/{class_id}",method = RequestMethod.GET)
    @ResponseBody
    public List<Period> getPeriodByClassID(@PathVariable("class_id")BigInteger class_id){
        return periodService.getPeriodByClassID(class_id);
    }






    @JsonIgnoreProperties
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/period/{period_id}/click",method = RequestMethod.POST)
    @ResponseBody
    public void insertStdentPeriod(@PathVariable("period_id")BigInteger period_id,@RequestParam(value = "user_id") BigInteger student_id){
        periodService.insertStdentPeriod(student_id,period_id);
    }
}
