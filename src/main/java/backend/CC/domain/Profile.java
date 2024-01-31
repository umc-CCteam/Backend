package backend.CC.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Profile {

    @Id @GeneratedValue
    @Column(name = "profile_id")
    private Long id;

    private String email;
    private String nickname;
    private String platform;
    private String comment;

//    @OneToOne(mappedBy="profile")
//    private User user;


}
