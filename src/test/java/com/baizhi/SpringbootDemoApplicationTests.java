package com.baizhi;

import com.baizhi.dao.BookDao;
import com.baizhi.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemoApplicationTests {
    @Autowired
    private BookDao bookDao;
    @Test
    public void select() {
        List<Book> books = bookDao.selectAll();
        for (Book book : books) {
            System.out.println(book);
        }
    }
    @Test
    public void insert() {
        Book book=new Book();
        book.setName("哈哈哈");
        //所有字段都会添加一遍
        bookDao.insert(book);
    }
    @Test
    public void insertSelective() {
        Book book=new Book();
        book.setName("奇葩说");
        //只会添加id和name两个字段
        bookDao.insertSelective(book);
    }
    @Test
    public void update(){
        Book book=new Book();
        book.setId(2);
        book.setName("啦啦啦");
        //会把所有字段都修改
        bookDao.updateByPrimaryKey(book);
    }
    @Test
    public void updateSelective(){
        Book book=new Book();
        book.setId(4);
        book.setName("猪八戒");
        //只会修改id为4的name列
        bookDao.updateByPrimaryKeySelective(book);
    }
}
