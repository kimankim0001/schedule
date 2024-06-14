package com.sparta.schedule.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "comment")
public class Comment extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String username;

    @Column(nullable = false, length = 200)
    @NotBlank(message = "공백이거나 null 인 것은 불가능합니다.")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    public Comment(String username, String comment, Schedule schedule) {
        this.username = username;
        this.comment = comment;
        this.schedule = schedule;
    }

    public void updateComment(String comment) {
        this.comment = comment;
    }


}
