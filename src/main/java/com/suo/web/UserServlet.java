package com.suo.web;

import com.alibaba.fastjson.JSON;
import com.google.code.kaptcha.servlet.KaptchaServlet;
import com.suo.mapper.UserMapper;
import com.suo.pojo.User;
import com.suo.util.SqlSessionFactoryUtils;
import com.suo.util.WebUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends BaseServlet {

    /**
     * 登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.select(username, password);
        if(user!=null){
            //登录成功
            //判断是否标记记住我
            if("1".equals(remember)){
                Cookie c_username = new Cookie("username",username);
                Cookie c_password = new Cookie("password",password);
               //设置cookie的最大存活时间
                c_username.setMaxAge(60*60*24*7);
                c_password.setMaxAge(60*60*24*7);
                response.addCookie(c_username);
                response.addCookie(c_password);

            }
                request.setAttribute("username",username);
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }
        else{
            //登陆失败
            request.setAttribute("username",username);
            request.setAttribute("msg","账号或密码错误！");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }

    }

    /**
     * 注册
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String kaptcha_session_key = (String)request.getSession().getAttribute("KAPTCHA_SESSION_KEY");
        request.getSession().removeAttribute("KAPTCHA_SESSION_KEY");


        String name = request.getParameter("username");
        String code = request.getParameter("code");


        User user;


        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        //2.2 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //2.3 获取Mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        user = mapper.selectByName(name);

        if(kaptcha_session_key.equalsIgnoreCase(code)) {

            if(user != null) {
                request.setAttribute("errorMsg","用户名已存在");
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);

            }
            else {

                user = WebUtils.copyParamToBean(request.getParameterMap(),new User());
                user.setName(name);
                //2.4 调用方法
                mapper.add(user);

                sqlSession.commit();

                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);
            }
        }
        else {
            request.setAttribute("errorMsg","验证码错误");
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
        }



        //2.5 释放资源
        sqlSession.close();

    }

    /**
     * 注销
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.getSession().invalidate();

        request.getSession().setAttribute("username",null);

        response.sendRedirect(request.getContextPath());
    }

    protected void ajaxExistsUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println(1);
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        //2.2 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //2.3 获取Mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.selectByName(username);

        sqlSession.close();

        if (user != null) {
            System.out.println(2);
            response.getWriter().write("true");
        }
        else {
            response.getWriter().write("false");
        }

    }

}
