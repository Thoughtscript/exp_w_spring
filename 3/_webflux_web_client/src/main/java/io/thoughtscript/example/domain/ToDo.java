package io.thoughtscript.example.domain;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ToDo {
    private int userId;
    private int id;
    private String title;
    private boolean completed;
}
