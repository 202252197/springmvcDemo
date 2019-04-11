package com.lvshihao.controller;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 功能描述
 *
 * @author 吕世昊
 * @date 2019-4-7$
 * @describe 想成为世界最厉害的程序员
 * @email 202252197@qq.com
 * @signature 我的梦想---兰博基尼{奋斗}
 */
//实现一个Controller接口的方式
//同时还需要将这个类在mvc.xml中进行配置bean和映射路径,所以这种比较麻烦
public class UserController implements Controller {
    /*控制器的解释
        是一种比较传统的实现一个接口方式完成的,Controller
        如果一个接口只有一个方法那么这个接口就是函数式接口
     */
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("name","吕世昊");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
