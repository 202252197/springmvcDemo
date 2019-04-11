package com.lvshihao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

/**
 * 功能描述
 *
 * @author 吕世昊
 * @date 2019-4-7$
 * @describe 想成为世界最厉害的程序员
 * @email 202252197@qq.com
 * @signature 我的梦想---兰博基尼{奋斗}
 */
@Controller
@SessionAttributes("msg")//用在类上,它会自动将模型填充到会话里面去
public class UserController3 {
    @RequestMapping("/date")
    @ResponseBody
    public String getdate(){
        return new Date().toString();
    }
    @ModelAttribute //就是在Controller里面的任意一个处理具体的方法之前都会执行
    public void msg(Model model){
        model.addAttribute("msg","吕世昊最帅");
    }
    @RequestMapping("/ceshimsg")
    @ResponseBody
    public String test(Model model){
        Optional.of(model.containsAttribute("msg")).ifPresent(System.out::println);
        return "ok";
    }
    @RequestMapping("/ceshimsg2")
    @ResponseBody
    public String test2(@ModelAttribute("msg") String msg){
        Optional.of(msg).ifPresent(System.out::println);
        return "ok";
    }
    //测试SessionAttributes
    @RequestMapping("/ceshisession")
    public String testSession(){
        return "redirect:/jsp/Testsession.jsp";
    }
    //测试SessionAttribute
    @RequestMapping("/session")
    public String testSession3(){
        return "redirect:stestsession";
    }
    @RequestMapping("/stestsession")
    public void testSession2(@SessionAttribute("msg") String msg){
        Optional.of(msg).ifPresent(System.out::println);
    }
    //测试Cookieid
    @RequestMapping("testCookie")
    public void getCookie(@CookieValue("JSESSIONID") String jsessionid){
        Optional.of(jsessionid).ifPresent(System.out::println);
    }
}
