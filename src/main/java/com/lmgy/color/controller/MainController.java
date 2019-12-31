package com.lmgy.color.controller;

import com.lmgy.color.utils.ImageUtil;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lmgy
 * @date 2019/12/29
 */
@Api(value = "生成图片", protocols = "http")
@RestController
@RequestMapping(value = "/v1")
public class MainController {

    @GetMapping(value = "/{color}/{width}/{height}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void getColor(@PathVariable String color, @PathVariable int width, @PathVariable int height, HttpServletResponse response) {
        try {
            ImageUtil.gen(color, width, height, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
