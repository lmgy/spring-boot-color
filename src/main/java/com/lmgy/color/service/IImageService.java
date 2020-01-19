package com.lmgy.color.service;

import javax.servlet.http.HttpServletResponse;

/**
 * @author lmgy
 * @date 2019/12/31
 */
public interface IImageService {

    /**生成纯色图片
     * @param color 颜色-十六进制
     * @param width 图片宽度
     * @param height 图片高度
     * @param resp HttpServletResponse
     */
    void generatePhoto(String color, int width, int height, HttpServletResponse resp);

}
