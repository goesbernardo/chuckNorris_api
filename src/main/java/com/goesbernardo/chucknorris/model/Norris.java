package com.goesbernardo.chucknorris.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TB_NORRIS")
public class Norris {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime created_at;

    private String iconUrl;

    private Long idResponse;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

    private String url;

    private String value;
}
