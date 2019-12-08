package com.stan.controller;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.stan.entity.User;
import com.stan.entity.base.ResultEntity;
import com.stan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Stan
 * Date: 2019/12/1 17:06
 * Content:
 */


@RestController
@RequestMapping("res")
public class RestControllers {


    @Value("${fastdfspath}")
    private String fastdfspath;


    @Autowired
    private FastFileStorageClient fileStorageClient;

    @Autowired
    private IUserService userService;

    /**
     * 用户图片上传
     *
     * @param file
     * @param uid  : 用户id
     * @return
     */
    @RequestMapping("uploadFile")
    public ResultEntity upload(MultipartFile file, Integer uid) {
        //文件名称
        String filename = file.getOriginalFilename();
        System.out.println(file);
        //获取文件名称后缀
        String fileExName = filename.substring(filename.lastIndexOf(".") + 1);
        try {

            //上传  storePath:存储路径
            StorePath storePath = fileStorageClient.uploadImageAndCrtThumbImage(file.getInputStream(), file.getSize(), fileExName, null);
            //相对路径
            String fullPath = storePath.getFullPath();

            //获取大图和小图的路径
            String maxHead = fastdfspath + fullPath;
            String minHead = fastdfspath + fullPath.replaceAll("." + fileExName, "_100x100." + fileExName);

            //修改用户表头像
            if (uid != null) {
                User user = userService.selectById(uid);
                user.setMaxHead(maxHead);
                user.setMinHead(minHead);
                //更新数据库
                userService.update(user);
            }
            Map<String, String> map = new HashMap<>();
            map.put("maxHead", maxHead);
            map.put("minHead", minHead);

            return ResultEntity.success(map);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultEntity.error("上传异常，请稍后");
        }
    }
}
