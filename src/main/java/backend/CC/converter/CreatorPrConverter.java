package backend.CC.converter;

import backend.CC.domain.CreatorPR;
import backend.CC.domain.Member;
import backend.CC.domain.Video;
import backend.CC.web.dto.PrRequestDTO;
import backend.CC.web.dto.PrResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CreatorPrConverter {

    public static PrResponseDTO.creatorPRDTO toCreatorPrDetail(CreatorPR creatorPR) {
        Member member = creatorPR.getMember();
        List<String> videoUrlList = creatorPR.getVideoList().stream()
                .map(Video::getUrl).collect(Collectors.toList());

        return PrResponseDTO.creatorPRDTO.builder()
                .creatorPrId(creatorPR.getId())
                .nickname(member.getNickname())
                .comment(member.getProfile().getComment())
                .category1(creatorPR.getCategory().getCategory1())
                .category2(creatorPR.getCategory().getCategory2())
                .email(member.getEmail())
                .youtube(creatorPR.getYoutube())
                .insta(creatorPR.getInsta())
                .tictok(creatorPR.getTictok())
                .photo(creatorPR.getPhoto())
                .content(creatorPR.getContent())
                .url(videoUrlList)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static List<PrResponseDTO.creatorPRListDTO> toCreatePrList(List<CreatorPR> creatorPRList) {
        return creatorPRList.stream()
                .map(CreatorPrConverter::mapToDTO)
                .collect(Collectors.toList());
    }

    private static PrResponseDTO.creatorPRListDTO mapToDTO(CreatorPR creatorPR) {
        return PrResponseDTO.creatorPRListDTO.builder()
                .memberId(creatorPR.getMember().getId())
                .nickname(creatorPR.getMember().getNickname())
                .comment(creatorPR.getMember().getProfile().getComment())
                .youtube(creatorPR.getYoutube())
                .insta(creatorPR.getInsta())
                .tictok(creatorPR.getTictok())
                .photo(creatorPR.getPhoto())
                .category1(creatorPR.getCategory().getCategory1())
                .category2(creatorPR.getCategory().getCategory2())
                .build();
    }

    public static PrResponseDTO.creatorPrFormDTO toCreatePrForm(Member member) {
        return PrResponseDTO.creatorPrFormDTO.builder()
                .nickname(member.getNickname())
                .comment(member.getProfile().getComment())
                .email(member.getEmail())
                .build();
    }

    public static CreatorPR toCreatePr(PrRequestDTO.createCreatorPrDTO request) {
        return CreatorPR.builder()
                .content(request.getContent())
                .photo(request.getPhoto())
                .youtube(request.getYoutube())
                .insta(request.getInsta())
                .tictok(request.getTictok())
                .build();
    }

}