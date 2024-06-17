package com.sparta.schedule.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    @Length(min = 4, max = 10)
    @Column(unique = true, nullable = false)
    @NotBlank(message = "유저네임을 입력해주세요")
    private String username;
    @Length(min = 8, max = 15)
    @Column(nullable = false)
    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;
    private String authority;

    public void setUserInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
