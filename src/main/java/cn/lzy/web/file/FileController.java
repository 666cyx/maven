package cn.lzy.web.file;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * @author 陈远翔
 * @date 2023/9/19 9:43
 */

//上传
@Controller
public class FileController {
    @GetMapping("/toUpload")  //http://localhost:8090/toUpload
    public String toUpload(){
        return "upload";
    }
    @PostMapping("/uploadFile")
    public String uploadFile(MultipartFile[] fileUpload, Model model){

        boolean statue = true;
        String message = null;

        for (MultipartFile file : fileUpload) {

            String fileName = file.getOriginalFilename();

            fileName = UUID.randomUUID() + "_" + fileName;

            String dirPath = "D:/springfile/";
            File filePath = new File(dirPath);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            try {
                file.transferTo(new File(dirPath + fileName));
            } catch (Exception e) {
                statue = false;
                message = e.getMessage() + "";

                model.addAttribute("uploadStatus","上传失败: "+e.getMessage());
            }
        }
        if (statue) {
            model.addAttribute("uploadStatus","上传成功!");
        } else {
            model.addAttribute("uploadStatus","上传失败!" +message);
        }
        return "upload";
    }
//下载
    @GetMapping("/toDownload")
    public String toDownload(){
        return "download";
    }
    @GetMapping("/download")
    public ResponseEntity<byte[]> fileDownload(HttpServletRequest request,String filename)throws Exception{
        String dirPath= "D:/springfile/";
        File file=new File(dirPath + File.separator + filename);
        HttpHeaders headers=new HttpHeaders();
        filename=getFilename(request,filename);
        headers.setContentDispositionFormData("attachment",filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        try{
            return new ResponseEntity<>(FileUtils.readFileToByteArray(file),headers,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<byte[]>(e.getMessage().getBytes(), HttpStatus.EXPECTATION_FAILED);
        }
    }

private  String getFilename(HttpServletRequest request,String filename)
    throws Exception{
        String[] IEBrowserKeywORDS={"MSIE","Trident","Edge"};
        String userAgent=request.getHeader("User-Agent");
        for (String KeyWord : IEBrowserKeywORDS){
            if (userAgent.contains(KeyWord)){
                return URLEncoder.encode(filename,"UTF-8").replace("+","");
            }
        }
        return new String(filename.getBytes("Utf-8"),"ISO-8859-1");
}

}
