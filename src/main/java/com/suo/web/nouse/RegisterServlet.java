package com.suo.web.nouse;

import com.suo.mapper.UserMapper;
import com.suo.pojo.User;
import com.suo.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User user;

        //2. 调用myBatis
        //2.1 创建sqlSessionFactory对象
        /*String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);*/

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        //2.2 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //2.3 获取Mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        user = mapper.selectByName(name);

        System.out.println(user);
        if(user != null) {
            request.setAttribute("errorMsg","用户名已存在");
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);

        }
        else {
            user = new User();
            user.setName(name);
            user.setPassword(password);
            user.setEmail(email);
            //2.4 调用方法
            mapper.add(user);

            sqlSession.commit();

            request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);
        }
        //System.out.println(user);



        //2.5 释放资源
        sqlSession.close();


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
