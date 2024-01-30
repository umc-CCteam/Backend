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
                .category(creatorPR.getCategory().getName())
                .email(member.getEmail())
                .googleAuth(member.isGoogleAuth())
                .instaAuth(member.isInstaAuth())
                .photo(creatorPR.getPhoto())
                .content(creatorPR.getContent())
                .url(videoUrlList)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static List<PrResponseDTO.creatorPRListDTO> toCreatePrList(List<CreatorPR> creatorPRList) {
        return creatorPRList.stream()
                .map(creatorPR ->
                        PrResponseDTO.creatorPRListDTO.builder()
                                .memberId(creatorPR.getMember().getId())
                                .nickname(creatorPR.getMember().getNickname())
                                .comment(creatorPR.getMember().getProfile().getComment())
                                .googleAuth(creatorPR.getMember().isGoogleAuth())
                                .instaAuth(creatorPR.getMember().isInstaAuth())
                                .photo(creatorPR.getPhoto())
                                .category(creatorPR.getCategory().getName())
                                .build()
                ).collect(Collectors.toList());
    }

    public static PrResponseDTO.creatorPrFormDTO toCreatePrForm(Member member) {
        return PrResponseDTO.creatorPrFormDTO.builder()
                .nickname(member.getNickname())
                .comment(member.getProfile().getComment())
                .email(member.getEmail())
                .googleAuth(member.isGoogleAuth())
                .instaAuth(member.isInstaAuth())
                .build();
    }

    public static CreatorPR toCreatePr(PrRequestDTO.createCreatorPrDTO request) {
        return CreatorPR.builder()
                .content(request.getContent())
                .photo(request.getPhoto())
                .build();
    }

}
