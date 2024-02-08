package backend.CC.domain;

import backend.CC.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category1;

    private String category2;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<CreatorPR> creatorPRList = new ArrayList<>();

}
