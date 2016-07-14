package cn.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    HttpServletRequest request; //这里可以获取到request

    @RequestMapping("index")
    public String index(){
        System.out.println(111);
        return "index";
    }
    /**
     * 登录入口
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request,HttpServletResponse response){
        String account = request.getParameter("userName");
        String password = request.getParameter("passWord");
        if (account.equals("admin") && password.equals("1")){
            return "index";
        }else{
            return "index";
        }
    }

}
