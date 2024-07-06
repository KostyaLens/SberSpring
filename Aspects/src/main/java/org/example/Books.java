package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Books {

    private List<Comment> list = new ArrayList<>();
    @NotEmpty
    public void addCommentInListBooks(Comment comment){
        list.add(comment);
    }

    @NotEmpty
    public void setList(List<Comment> list) {
        deleteAllTexts();
        this.list.addAll(list);
    }

    public List<Comment> getList(){
        return this.list;
    }
    public void deleteAllTexts(){
        this.list.clear();
    }
}
