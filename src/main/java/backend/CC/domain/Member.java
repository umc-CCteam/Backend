package backend.CC.domain;

import backend.CC.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String passWord;

    private String email;
    private String nickname;

    private boolean googleAuth;
    private boolean instaAuth;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<CreatorPR> creatorPRList = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private Profile profile;

}
