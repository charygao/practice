package com.quantum.boot.redis.domain;



import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements Serializable {

    private static final long serialVersionUId = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;


}