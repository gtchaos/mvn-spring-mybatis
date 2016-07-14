package cn.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import cn.springmvc.model.User;
import cn.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by baidu on 16/7/14.
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping("/{id}")
    public ModelAndView view(@PathVariable("id") int id, HttpServletRequest request) {
        User gmm = new User();
        gmm.setId(id);
        gmm.setName("gaomiaomiao");
        gmm.setAge(29);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", gmm);
        mv.setViewName("user/view");
        return mv;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Map insert() {
        User gmm = new User();
        gmm.setName("allen kao");
        gmm.setState(2);
        gmm.setAge(29);
        gmm.setNickname("michael");
        int a = service.insertUser(gmm);
        Map map = new HashMap();
        map.put("key", a);
        return map;

    }
}