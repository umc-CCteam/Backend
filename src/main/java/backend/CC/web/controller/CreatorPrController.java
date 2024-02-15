package backend.CC.web.controller;

import backend.CC.apiResponse.ApiResponse;
import backend.CC.converter.CreatorPrConverter;
import backend.CC.domain.CreatorPR;
import backend.CC.domain.Image;
import backend.CC.domain.Member;
import backend.CC.service.CreatorPrServiceImpl;
import backend.CC.service.ImageService;
import backend.CC.service.MemberServiceImpl;
import backend.CC.web.dto.PrRequestDTO;
import backend.CC.web.dto.PrResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/creator-pr")
public class CreatorPrController {

    private final CreatorPrServiceImpl creatorPrService;
    private final MemberServiceImpl memberService;
    private final ImageService imageService;

    /**
     * creatorPR 전체 조회 페이지
     */
    @GetMapping
    public ApiResponse<List<PrResponseDTO.creatorPRListDTO>> getCreatorPRList() {
        List<CreatorPR> creatorPRList = creatorPrService.findAll();
        return ApiResponse.onSuccess(CreatorPrConverter.toCreatePrList(creatorPRList));
    }

    /**
     * creatorPR 상세 조회
     */
    @GetMapping("/{creator-pr-id}")
    public ApiResponse<PrResponseDTO.creatorPRDTO> getCreatorPR(
            @PathVariable("creator-pr-id") Long creatorPrId
    ) {
        CreatorPR creatorPR = creatorPrService.findById(creatorPrId);
        return ApiResponse.onSuccess(CreatorPrConverter.toCreatorPrDetail(creatorPR));
    }

    /**
     * CreatorPR 작성(Get)
     */
    @GetMapping("/new/{memberId}")
    public ApiResponse<PrResponseDTO.creatorPrFormDTO> getCreatorPRForm(
            @PathVariable("memberId") Long memberId
    ) {
        Member member = memberService.findById(memberId);
        return ApiResponse.onSuccess(CreatorPrConverter.toCreatePrForm(member));
    }

    /**
     * CreatorPR 작성(Post)
     */
    @PostMapping("/new/{memberId}")
    public ApiResponse<PrResponseDTO.creatorPRDTO> createCreatorPR(
            @RequestPart(value = "image") MultipartFile image,
            @PathVariable("memberId") Long memberId,
            @RequestPart(value = "request") PrRequestDTO.createCreatorPrDTO request

    ) throws IOException {
        Image prImage = imageService.createfile(image);
        imageService.saveImage(prImage);
        CreatorPR creatorPR = creatorPrService.createPr(memberId, request, prImage);
        return ApiResponse.onSuccess(CreatorPrConverter.toCreatorPrDetail(creatorPR));
    }
}
