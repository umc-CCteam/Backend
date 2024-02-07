package backend.CC.domain;

import backend.CC.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Video extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    @ManyToOne
    @JoinColumn(name = "creator_pr_id")
    private CreatorPR creatorPR;

    public Video(String url) {
        this.url = url;
    }

    public void setCreatorPR(CreatorPR creatorPR) {
        this.creatorPR = creatorPR;
    }
}
