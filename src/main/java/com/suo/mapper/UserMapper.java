package com.suo.mapper;

import com.suo.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    /**
     * 根据账户密码查询用户信息
     * @param name
     * @param password
     * @return
     */
    @Select("select *from t_user where name =#{name} and password=#{password}")
    User    select(@Param("name") String name ,@Param("password") String password);
    @Select("select * from t_user where name = #{name}")
    User    selectByName(String name) ;
    @Insert("insert  into  t_user values (null,#{name},#{password},#{emails})")
    void add(User user);
}
