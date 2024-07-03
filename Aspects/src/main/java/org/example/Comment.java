package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Scope("prototype")
@Component
@NoArgsConstructor
public class Comment {

    private String text;
    private String author;

    public String getText() {
        return text;
    }

    @NotEmpty
    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    @NotEmpty
    public void setAuthor(String author) {
        this.author = author;
    }

}