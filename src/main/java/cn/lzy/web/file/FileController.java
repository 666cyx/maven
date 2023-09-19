package cn.lzy.web.file;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @author 陈远翔
 * @date 2023/9/19 9:43
 */


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
}
