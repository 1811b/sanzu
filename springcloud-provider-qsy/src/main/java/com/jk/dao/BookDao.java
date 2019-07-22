package com.jk.dao;

import com.jk.model.Book;
import com.jk.model.BookImgs;
import com.jk.model.DianZiBook;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookDao {
    @Select("select count(*) FROM t_book")
    int findBookTotal(Book book);

    @Select("select t.productId,t.proNumber,t.proTitle,t.proContext,t.shuPing,t.sumCount,t.cover,t.cuStatus,t.cuXiaoId,t.reStatus,shangStatus,t.tuiStatus,tt.typeName as typeName\n" +
            "        from t_book t\n" +
            "               left join t_type tt on t.typeId = tt.typeId" +
            "                     limit #{start},#{rows}")
    List<Book> findBookPage(int start, Integer rows, Book book);

    @Delete("delete from t_book where productId=#{productId}")
    Boolean delBook(Integer productId);

    @Insert("insert into t_book (proNumber,proTitle,proContext,shuPing,sumCount,cover,cuStatus,cuXiaoId,reStatus,shangStatus,tuiStatus,typeId) values (#{proNumber},#{proTitle},#{proContext},#{shuPing},#{sumCount},#{cover},#{cuStatus},#{cuXiaoId},#{reStatus},#{shangStatus},#{tuiStatus},#{typeId})")
    void saveBook(Book book);


    @Update("update  t_book  set  shangStatus = 2 where productId=#{productId}")
    void xiaJia(Integer productId,Integer shangStatus);

    @Update("update  t_book  set  shangStatus = 1 where productId=#{productId}")
    void shangJia(Integer productId,Integer shangStatus);



    @Select("select count(*) FROM t_bookimgs")
    int findTotal(BookImgs bookImgs);

    @Select("select imgId,proNo,imgs from t_bookimgs  limit #{start},#{rows}")
    List<BookImgs> findPage(int start, Integer rows, BookImgs bookImgs);

    @Delete("delete from t_bookimgs where imgId=#{imgId}")
    Boolean delImg(Integer imgId);

    @Insert("insert into t_bookimgs(proNo,imgs) values(#{proNo},#{imgs})")
    void saveImg(BookImgs bookImgs);

    @Select("select count(*) FROM t_dianzibook")
    int queryTotal(DianZiBook dianZiBook);

    @Select("select t.productId,t.proNumber,t.proTitle,t.proContext,t.bookPrice,t.cover,t.shangTime,t.createTime,t.shangStatus,tt.typeName as typeName\n" +
            "               from t_dianzibook t\n" +
            "                        left join t_type tt on t.typeId = tt.typeId\n" +
            "                           limit #{start},#{rows}")
    List<DianZiBook> queryPage(int start, Integer rows, DianZiBook dianZiBook);

    @Delete("delete from t_dianzibook where productId=#{productId}")
    Boolean delQueryBook(Integer productId);

    @Insert("insert into t_dianzibook (proNumber,proTitle,proContext,bookPrice,shangTime,cover,createTime,shangStatus,typeId) values (#{proNumber},#{proTitle},#{proContext},#{bookPrice},#{shangTime},#{cover},#{createTime},#{shangStatus},#{typeId})")
    void saveQuery(DianZiBook dianZiBook);

    @Update("update  t_dianzibook  set  shangStatus = 2 where productId=#{productId}")
    void xia(Integer productId);

    @Update("update  t_dianzibook  set  shangStatus = 1 where productId=#{productId}")
    void shang(Integer productId);

    @Update("update  t_book  set  cuStatus = 2 where productId=#{productId}")
    void cuXiao(Integer productId, Integer cuStatus);

    @Update("update  t_book  set  cuStatus = 1 where productId=#{productId}")
    void buCu(Integer productId, Integer cuStatus);

    @Update("update  t_book  set  reStatus = 2 where productId=#{productId}")
    void remai(Integer productId, Integer reStatus);

    @Update("update  t_book  set  cuStatus = 1 where productId=#{productId}")
    void bure(Integer productId, Integer reStatus);

    @Update("update  t_book  set  tuiStatus = 2 where productId=#{productId}")
    void tuijian(Integer productId, Integer tuiStatus);

    @Update("update  t_book  set  tuiStatus = 1 where productId=#{productId}")
    void butui(Integer productId, Integer tuiStatus);
}
