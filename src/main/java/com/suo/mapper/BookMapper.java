package com.suo.mapper;

import com.suo.pojo.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper {

    /**
     * 添加图书
     * @param book
     */
    @ResultMap("BookResultMap")
    @Insert("insert into t_book values (null,#{name},#{price},#{author},#{sales},#{stock},#{imgPath});")
    void add(Book book);

    /**
     * 删除图书
     * @param id
     */
    @Delete("delete from t_book where id = #{id}")
    void deleteById(int id);

    /**
     * 修改图书
     * @param book
     */
    @Update("update t_book set name = #{name},price = #{price},author = #{author},sales = #{sales},stock = #{stock},img_path = #{imgPath} where id = #{id}")
    void updateById(Book book);

    /**
     * 查询全部图书
     * @return
     */
    @ResultMap("BookResultMap")
    @Select("select * from t_book")
    List<Book> selectAll();

    /**
     * 查询图书根据id
     * @param id
     * @return
     */
    @ResultMap("BookResultMap")
    @Select("select * from t_book where id = #{id}")
    Book selectById(int id);

    /**
     * 返回记录总数
     * @return
     */
@Select("select  count(1) from t_book ")
    int selectCount();

    /**
     *
     * @param pageNo(当前页号)
     * @param pageSize（每页显示得条数）
     * @return
     */
    @ResultMap("BookResultMap")
 @Select("select * from t_book limit (#{pageNo},#{pageSize})")
    List<Book> selectPage(@Param("pageNo") int pageNo,@Param("pageSize") int pageSize);


    @ResultMap("BookResultMap")
    @Select("select  * from t_book where price between #{min} and #{max} limit #{pageNo},#{pageSize}")
    List<Book> selectByPrice(@Param("max") int max,@Param("min") int min,@Param("pageNo") int pageNo,@Param("pageSize") int pageSize);


    @Select("select count(1) from t_book where price between #{min} and #{max}")
    int selectCountByPrice(@Param("max") int max,@Param("min") int min);
}
