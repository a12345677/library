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
import java.util.List;

@WebServlet(name = "BookShowServlet", value = "/BookShowServlet")
public class BookShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        List<Book> books = mapper.selectAll();

        request.setAttribute("books",books);

        sqlSession.close();


        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
