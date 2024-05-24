package com.study.Ex14ReadDB.entity;

import com.study.Ex14ReadDB.dto.MemberJoinDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name="MEMBER")
@Getter
//@Setter : 자체 setter메소드를 사용한다.
@AllArgsConstructor
@NoArgsConstructor//@ModelAttibue @RequestBody 매핑시 필요!
@Builder
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userId;
    @Column(name = "user_pw")
    private String userPw;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_role")
    private String userRole;
    @Column(name = "join_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinDate;

    public MemberJoinDto toSaveDto(){
        return MemberJoinDto.builder()
                .id(id)
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .userRole(userRole)
                .joinDate(joinDate)
                .build();
    }
}
