package backend.CC.domain;

import backend.CC.domain.common.BaseEntity;
import backend.CC.domain.dto.ProfileRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Profile extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "profile_id")
    private Long id;

    private String nickname;
    private String platform;
    private String comment;

    public Profile(String nickname, String platform, String comment) {
        this.nickname = nickname;
        this.platform = platform;
        this.comment = comment;
    }

    public void update(ProfileRequest.RegisterDto updateDto) {
        this.nickname = updateDto.getName();
        this.comment = updateDto.getComment();
        this.platform = updateDto.getPlatform();

    }
//    @OneToOne(mappedBy="profile")
//    private User user;
}
