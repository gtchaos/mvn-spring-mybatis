package cn.springmvc.dao;

import cn.springmvc.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
/**
 * Created by baidu on 16/7/12.
 * 接口加注解的形式,可以不用单独定义mapper.xml,但是需要在mybatis-config.xml里面声明mapper元素
 */
public interface UserDAO {
    @Insert("insert into t_user (name, age, state, nickname) values(#{name}, #{age}, #{age}, #{nickname})")
    public int insertUser(User user);

    @Update("update t_user set name=#{name}, age=#{age} where id=#{id}")
    public void updateUser(User user);

    @Select("select * from t_user where id=#{id}")
    public User findById(int id);

    @Delete("delete from t_user where id=#{id}")
    public void deleteUser(int id);
}
