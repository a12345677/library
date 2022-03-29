package com.suo.web.nouse;

import com.suo.mapper.BookMapper;
import com.suo.pojo.Book;
import com.suo.util.SqlSessionFactoryUtils;
import com.suo.util.WebUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BookAddServlet", value = "/BookAddServlet")
public class BookAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        Book book = WebUtils.copyParamToBean(request.getParameterMap(),new Book());
//        String id = request.getParameter("id");
//        String name = request.getParameter("name");
//        String author = request.getParameter("author");
//        String price = request.getParameter("price");
//        String sales = request.getParameter("sales");
//        String stock = request.getParameter("stock");
//
//
//        Book book = new Book();
//        book.setId(Integer.parseInt(id));
//        book.setName(name);
//        book.setAuthor(author);
//        book.setPrice(Double.parseDouble(price));
//        book.setSales(Integer.parseInt(sales));
//        book.setStock(Integer.parseInt(stock));



        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        mapper.add(book);

        sqlSession.commit();

        sqlSession.close();

        request.getRequestDispatcher("/BookShowServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
