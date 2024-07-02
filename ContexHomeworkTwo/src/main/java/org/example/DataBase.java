package org.example;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class DataBase {
    private List<String> story;

    void add(String number, int sum) {
        StringBuilder stringBuilder = new StringBuilder("перевод ");
        stringBuilder.append(sum);
        stringBuilder.append(" на номер ");
        stringBuilder.append(number);
        story.add(String.valueOf(stringBuilder));
    }
}
