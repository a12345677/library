package com.suo.web;

import com.suo.mapper.BookMapper;
import com.suo.pojo.Book;
import com.suo.pojo.Page;
import com.suo.util.SqlSessionFactoryUtils;
import com.suo.util.WebUtils;
import org.apache.commons.collections.FactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet", value = "/BookServlet")
public class BookServlet extends BaseServlet{
    /**
     * 查询所有
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        List<Book> books = mapper.selectAll();

        request.setAttribute("books",books);

        sqlSession.close();

        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }

    /**
     * 通过id进行查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void selectById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        Book book = mapper.selectById(Integer.parseInt(id));

        request.setAttribute("book",book);

        sqlSession.close();

        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request,response);
    }

    /**
     * 添加书籍
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Book book = WebUtils.copyParamToBean(request.getParameterMap(),new Book());

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        mapper.add(book);

        sqlSession.commit();

        sqlSession.close();

        response.sendRedirect("/project/BookServlet?action=page");

        //request.getRequestDispatcher("/BookServlet?action=selectAll").forward(request,response);
    }

    /**
     * 根据id删除书籍
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        mapper.deleteById(Integer.parseInt(id));

        sqlSession.commit();

        sqlSession.close();

        response.sendRedirect("/project/BookServlet?action=page");

        //request.getRequestDispatcher("/BookServlet?action=selectAll").forward(request,response);
    }

    /**
     * 修改书籍信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Book book = WebUtils.copyParamToBean(request.getParameterMap(),new Book());

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        mapper.updateById(book);

        sqlSession.commit();

        sqlSession.close();

        response.sendRedirect("/project/BookServlet?action=page");

        //request.getRequestDispatcher("/BookServlet?action=selectAll").forward(request,response);
    }

    /**
     * 分页
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlSessionFactory  sqlSessionFactory  =   SqlSessionFactoryUtils.getSqlSessionFactory() ;
     int pageNo = request.getParameter("pageNo")!=null ? Integer.parseInt(request.getParameter("pageNo")):1;
     int pageSize = request.getParameter("pageSize")!=null?Integer.parseInt(request.getParameter("pageSize")):Page.PAGE_SIZE ;
     Page<Book> page =  new Page<>();
     page.setPageNo(pageNo);
     page.setPageSize(pageSize);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        int count = mapper.selectCount();
        page.setPageTotalCount(count);
        int totalPage = (count + pageSize - 1) / pageSize;
        page.setPageTotal(totalPage);
        List<Book> books = mapper.selectPage((pageNo - 1) * pageSize, pageSize);
        page.setItems(books);
        request.setAttribute("page",page);
        request.getRequestDispatcher("/pages/client/client_index.jsp").forward(request,response);

    }
 /**找到所输入得最大值和最小值之间得*/
    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = request.getParameter("pageNo") != null ? Integer.parseInt(request.getParameter("pageNo")) : 1;

        int pageSize = request.getParameter("pageSize") != null ? Integer.parseInt(request.getParameter("pageSize")) : Page.PAGE_SIZE;

        int max;

        int min;

        if("".equals(request.getParameter("max")) || request.getParameter("max") == null) {
            max = Integer.MAX_VALUE;
        }
        else {
            max = Integer.parseInt(request.getParameter("max"));
        }

        if("".equals(request.getParameter("min")) || request.getParameter("min") == null) {
            min = -1;
        }
        else {
            min = Integer.parseInt(request.getParameter("min"));
        }

        System.out.println(max);

        System.out.println(min);

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        List<Book> books = mapper.selectByPrice(max,min,(pageNo-1)*pageSize, pageSize);

        int pageTotalCount = mapper.selectCountByPrice(max,min);

        int pageTotal = (pageTotalCount + pageSize - 1) / pageSize;

        Page<Book> page = new Page<>();

        page.setPageNo(pageNo);

        page.setPageSize(pageSize);

        page.setPageTotalCount(pageTotalCount);

        page.setPageTotal(pageTotal);

        page.setItems(books);

        request.setAttribute("page",page);

        request.setAttribute("min",min);

        request.setAttribute("max",max);

        request.getRequestDispatcher("/pages/client/client_index.jsp").forward(request,response);
    }
}
