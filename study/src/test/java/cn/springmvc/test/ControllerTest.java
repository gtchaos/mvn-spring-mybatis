package cn.springmvc.test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.ResultMatcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;
import  org.springframework.util.Assert;
/**
 * Created by baidu on 16/7/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:conf/spring-mvc.xml"})
//当然 你可以声明一个事务管理 每个单元测试都进行事务回滚 无论成功与否
public class ControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void testLogin() throws Exception {
        mockMvc.perform((get("/login").param("userName", "admin").param("passWord", "1"))).andExpect(status().isOk())
                .andDo(print());
    }
    @Test
    public void testView() throws Exception {
        MvcResult result = mockMvc.perform(get("/user/1"))
                .andExpect(model().attributeExists("user")) //验证存储模型数据
                .andExpect(view().name("user/view")) //验证viewName
                .andExpect(forwardedUrl("/WEB-INF/jsp/user/view.jsp"))//验证视图渲染时forward到的jsp
                .andExpect(status().isOk())//验证状态码是否为200
                .andDo(print()) //添加一个结果处理器，表示要对结果做点什么事情, 比如此处输出MvcResult到控制台
                .andReturn(); //表示执行完成后返回相应的结果
        Assert.notNull(result.getModelAndView().getModel().get("user"));
    }
    /*@Test
    //有些单元测试你不希望回滚
    @Rollback(false)
  public void testInsert() throws Exception {
      mockMvc.perform((post("/insertTest"))).andExpect(status().isOk())
              .andDo(print());
  } */
}
