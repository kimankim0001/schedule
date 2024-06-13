package com.sparta.schedule.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "schedule")
@NoArgsConstructor
public class Schedule extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String username;

    @Column(nullable = false, length = 100)
    @NotBlank
    private String password;

    @Column(nullable = false, length = 200)
    @NotBlank
    private String title;

    @Column(nullable = false, length = 500)
    private String description;

    public Schedule(String username, String password, String title, String description) {
        this.username = username;
        this.password = password;
        this.title = title;
        this.description = description;
    }

    public void updateSchedule(String username, String title, String description){
        if (username != null && !username.isBlank()){
            this.username = username;
        }
        if (title != null && !title.isBlank()){
            this.title = title;
        }
        if (description != null && !description.isBlank()){
            this.description = description;
        }
    }



}
