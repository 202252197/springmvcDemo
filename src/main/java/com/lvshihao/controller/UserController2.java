package com.lvshihao.controller;

import com.lvshihao.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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
//这种方式实现比较简单,只需要标注一个Controller即可,不需要实现什么接口
@Controller
public class UserController2 {

    @RequestMapping("/index")//只需要在这里给定访问路径即可
    public String index(Model model){
        //设置视图中的数据
        model.addAttribute("name","吕世昊");
        return "index";
    }
    @RequestMapping("/index2")
    public String index2(Model model){
        List<User> list=new ArrayList<>();
        list.add(new User(1,"吕世昊","16"));
        list.add(new User(2,"张莹","15"));
        model.addAttribute("list",list);
        return "index2";
    }
    //转发可以转发到其他页面上如user,也可以转发到其他控制器上如forward:/user
    //重定向可以重定向到页面上如redirect:/jsp/redirect.jsp,但是设置的model值是参数而不是属性,还可以转发到其他控制器上如redirect:/user
    @RequestMapping("/forward")
    public String forward(Model model){
        model.addAttribute("name","吕世昊6666");
        return "forward";
    }
    @RequestMapping("/forward2")
    public String forward2(Model model){
        model.addAttribute("name","吕世昊");
        return "forward:/forward";
    }
    @RequestMapping("/redirect")
    public String redirect(Model model){
        model.addAttribute("name","吕世昊");
        return "redirect:forward";
    }
    @RequestMapping("/redirect2")
    public String redirect2(Model model){
        model.addAttribute("name","吕世昊");
        return "redirect:/jsp/redirect.jsp";
    }
    /*RequestMapping中的
     value写的是路径,是一个数组的形式,可以匹配多个路径
     path是value的别名,所有二者任选其一,他们的作用是一样的
     method 设置请求的类型
     params 设置请求的时候必须要给的参数,还可以指定参数的值
     headers 能够影响浏览器的行为
     consumers 消费者,媒体类型,可以限定必须为application/json;charset=UTF-8
     produces 产生的影响的类型
     */

    @RequestMapping(value = "/index3",params = {"age=44","name"})
    public String index3(){
        return "index3";
    }
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String tesr(){
        System.out.println("你好");
        return "index";
    }
    /*关于请求路径问题
    springmvc支持ant风格
    ? 任意的字符,斜杠例外
    * 0到n,任意个字符都可以不能含斜杠
    ** 支持任意层路径 /m3/**这样才可以提现出来 /m3**这个其实和上面是一样的效果所有不行
     */
    /*@GetMapping,@PostMapping.......
        GetMapping 限定了只支持get请求
        PostMapping 限定了只支持post请求
     */
    /*对于非get post请求的支持
        对于非get post请求的支持,需要有额外的内容添加,要在web.xml增加一个过滤器来额外处理,还需要在form表单中设置一个隐藏域
     */
    @DeleteMapping("/delete")
    public void delete(){
        System.out.println("delete请求");
    }
    /*关于静态资源访问的问题
        由于我们的servlet设置了URL匹配方式为/所以,他将静态资源也当作一个后台请求
        比如http://localhost:8080/user/index.css
        它尝试去匹配一个user/index.css的Controller里面的RequestMapping的组合,因为没有,所以404
        解决方式很多,最简单的,是让springmvc单独处理,将这些交给容器的默认的servlet处理,就不让DispatcherServlet来处理了
        解决方式1
            默认的servlet处理器      <mvc:annotation-driven />    <mvc:default-servlet-handler/>
        解决方式2
            通过映射关系描述,---对编写规则
             <mvc:resources mapping="/static/css/*" location="static/css/"/>
        解决方式3
            自行在web.xml定义映射规则
     */
    /*@PathVariable  restful风格*/
    @RequestMapping("/add/{id}/{name}/{shop}")
    public void addshop(@PathVariable("id") int id,@PathVariable("name")String name,@PathVariable("shop")String shop){
        System.out.println("卡卡卡");
        Optional.of(id+"=="+name+"=="+shop).ifPresent(System.out::println);
    }
}
