package xmu.yunzhieducation.view;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


/**
 * @author zelei.fan
 *
 */
@RestController
public class UploadFileController{


    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value = "/uploadFileAction", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFileAction(HttpServletRequest request, @RequestParam("uploadFile") MultipartFile file) {
        try {
            String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
            System.out.println(uploadDir);
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            String filename = file.getOriginalFilename();

            File serverFile = new File(uploadDir + filename);
            file.transferTo(serverFile);
            return uploadDir+filename;
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }



    }



    //文件下载相关代码
    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    @ResponseBody
    public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
        String fileName = "task、period、data.txt";// 设置文件名，根据业务需要替换成要下载的文件名
        if (fileName != null) {
            //设置文件路径
            String realPath = "C:\\Users\\Administrator\\Desktop\\";
            File file = new File(realPath , fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }





}
