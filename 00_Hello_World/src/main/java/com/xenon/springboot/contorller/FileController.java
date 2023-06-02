package com.xenon.springboot.contorller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/file")
public class FileController
{
    // 传输文件需要设置enctype=form-data，让文件以二进制流形式传输
    // 默认的x-www-form-urlencoded只会将文件的路径传输过去
    @PostMapping("/upload")
    // 文件统一使用MultipartFile
    public ArrayList<String> fileUpload(String username, MultipartFile photo, HttpServletRequest request) throws IOException
    {
        ArrayList<String> strings = new ArrayList<>();

        strings.add("用户昵称：" + username);
        // 用户昵称：user

        strings.add("\n文件原始名称为：" + photo.getOriginalFilename());
        // 文件原始名称为：wallhaven-gp8pdq.jpg

        strings.add("\n获取文件类型：" + photo.getContentType());
        // 获取文件类型：image/jpeg

        strings.add("\n获取项目路径：" + System.getProperty("user.dir"));
        // 获取项目路径：G:\\IDEA_Projects\\Maven\\Spring_Series\\SpringBoot

        // 动态获取Web服务器地址，定位到需要保存的路径，方便在不同的设备上部署
        strings.add("\n将要把该文件保存到的路径为：" + request.getServletContext().getRealPath("/upload/"));
        // 将要把该文件保存到的路径为：C:\\Users\\Xenon\\AppData\\Local\\Temp\\tomcat-docbase.8080.974044404585903746\\upload\\

        saveFile(photo, request.getServletContext().getRealPath("/upload/"));

        return strings;
    }

    public void saveFile(MultipartFile file, String path) throws IOException
    {
        // 如果存储目录文件夹不存在则创建
        File dir = new File(path);
        if (!dir.exists())
        {
            dir.mkdir();
        }

        // 使用MultipartFile下的方法将文件存储到特定路径，需要指明文件的名字
        file.transferTo(new File(path + file.getOriginalFilename()));
    }
}
