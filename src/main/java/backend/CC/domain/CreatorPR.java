package backend.CC.domain;

import backend.CC.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CreatorPR extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Image image;

    private Integer youtube;
    private Integer insta;
    private Integer tictok;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "creatorPR", cascade = CascadeType.ALL)
    private List<Video> videoList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setVideoList(List<Video> videoList) {
        this.videoList = videoList;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
