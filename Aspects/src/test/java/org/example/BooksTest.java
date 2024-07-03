package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class BooksTest {

    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    private Books books = context.getBean(Books.class);
    @Test
    public void addCommentInListBooksOk() {
        Comment comment = context.getBean(Comment.class);
        comment.setAuthor("Стив Жопс");
        comment.setText("Шёл Иван по лесу за выпивкой");
        List<Comment> list = new ArrayList<>();
        list.add(comment);
        books.addCommentInListBooks(comment);
        Assert.assertEquals(list, books.getList());
    }

    @Test
    public void setListOk() {
        Comment comment = context.getBean(Comment.class);
        comment.setAuthor("Стив Майнкрафт");
        comment.setText("Хероблин блин, съел все блины");
        List<Comment> list = new ArrayList<>();
        list.add(comment);
        books.setList(list);
        Assert.assertEquals(list, books.getList());
    }
    @Test(expected =  CustomException.class)
    public void addCommentInListBooksException() {
        books.addCommentInListBooks(null);
    }

    @Test(expected =  CustomException.class)
    public void setListException() {
        List<Comment> list = new ArrayList<>();
        books.setList(list);
    }

}