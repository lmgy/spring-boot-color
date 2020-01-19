package com.lmgy.color.service.impl;

import com.lmgy.color.service.IImageService;
import com.lmgy.color.utils.ImageUtil;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lmgy
 * @date 2019/12/31
 */
@Service
@CacheConfig(cacheNames = {"photoCache"})
public class ImageServiceImpl implements IImageService {

    @Override
    public void generatePhoto(String color, int width, int height, HttpServletResponse resp) {
        if (isImageAvailable(color, width, height)) {
            try {
                ImageUtil.gen(color, width, height, resp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isImageAvailable(String color, int width, int height) {
        return width > 0 && height > 0 && color.length() >= 6;
    }

}
