package com.suo.web.nouse;

import com.suo.mapper.BookMapper;
import com.suo.pojo.Book;
import com.suo.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BookSelectById", value = "/BookSelectById")
public class BookSelectById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        Book book = mapper.selectById(Integer.parseInt(id));

        request.setAttribute("book",book);

        sqlSession.close();

        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
