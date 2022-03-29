package com.suo.web;

import com.suo.mapper.BookMapper;
import com.suo.pojo.Book;
import com.suo.pojo.Page;
import com.suo.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ClientServlet", value = "/ClientServlet")
public class ClientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int pageNo = request.getParameter("pageNo") != null ? Integer.parseInt(request.getParameter("pageNo")) : 1;

        int pageSize = request.getParameter("pageSize") != null ? Integer.parseInt(request.getParameter("pageSize")) : Page.PAGE_SIZE;

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        int pageTotalCount = mapper.selectCount();

        int pageTotal = (pageTotalCount + pageSize - 1) / pageSize;

        List<Book> books = mapper.selectPage((pageNo-1)*pageSize, pageSize);

        Page<Book> page = new Page<>();

        page.setPageNo(pageNo);

        page.setPageSize(pageSize);

        page.setPageTotalCount(pageTotalCount);

        page.setPageTotal(pageTotal);

        page.setItems(books);

        request.setAttribute("page",page);

        request.getRequestDispatcher("/pages/client/client_index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
