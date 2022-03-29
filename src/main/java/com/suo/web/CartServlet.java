package com.suo.web;

import com.alibaba.fastjson.JSON;
import com.suo.mapper.BookMapper;
import com.suo.pojo.Book;
import com.suo.pojo.Cart;
import com.suo.pojo.CartItem;
import com.suo.pojo.User;
import com.suo.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


public class CartServlet extends BaseServlet {
    SqlSessionFactory  sqlSessionFactory  =   SqlSessionFactoryUtils.getSqlSessionFactory() ;

    /**
     * 将商品添加到购物车
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected  void add(HttpServletRequest request ,HttpServletResponse response ) throws ServletException,IOException{
         /*获取需要添加这本书的id*/
        String id = request.getParameter("id");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        /*如果不调用bookMapper的方法的话 将无法给cartItem赋值*/
        Book book = mapper.selectById(Integer.parseInt(id));
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,new BigDecimal(book.getPrice()),new BigDecimal(book.getPrice()));
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        /*没有该正在登录的用户的购物车的话*/
          if(cart==null){
              cart =  new Cart();
              cart.addItem(cartItem);
          }
          else {
              /*有购物车就直接把书添加进去*/
            cart.addItem(cartItem);
          }
          sqlSession.close();

        /* Referer请求头，可以请求发起时，把浏览器地址栏中的地址发给服务器
        *   即  回到发出请求的那个页面   并把最后一个商品名显示到页面上*/
         response.sendRedirect( request.getHeader("Referer"));
    }
    /**将商品从购物车中删除*/
    public  void delete(HttpServletRequest request ,HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.deleteItem(Integer.parseInt(id));
        response.sendRedirect(request.getHeader("Referer"));
    }
    /**将商品从购物车清空*/
    public  void clear(HttpServletRequest request , HttpServletResponse response  ) throws IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.clear();
        response.sendRedirect(request.getHeader("Referer"));

    }
    /**将商品的数量在购物车内更新*/
    public  void  update(HttpServletRequest request ,HttpServletResponse response ) throws IOException {
        String id = request.getParameter("id");
        String count = request.getParameter("count");
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.updateCount(Integer.parseInt(id),Integer.parseInt(count));
        response.sendRedirect(request.getHeader("Referer"));
    }


}
