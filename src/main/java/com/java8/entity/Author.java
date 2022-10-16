package com.java8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;

/**
 * @ClassName Author
 * @Description TODO
 * @Author bill
 * @Date 2022/9/24 22:45
 * @Version 1.0
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author implements Comparable<Author> {

    private Long id;

    private String name;

    private Integer age;

    private String intro;

    private List<Book> books;

    @Override
    public int compareTo(Author o) {
        return this.getAge() - o.getAge();
    }
}
