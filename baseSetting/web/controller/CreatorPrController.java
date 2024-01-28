package backend.CC.web.controller;

import backend.CC.apiResponse.ApiResponse;
import backend.CC.service.CreatorPrServiceImpl;
import backend.CC.web.dto.PrResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/creator-pr")
public class CreatorPrController {

    private final CreatorPrServiceImpl creatorPrService;

    /**
     * creatorPR 전체 조회 페이지
     */
    @GetMapping
    public ApiResponse<List<PrResponseDTO.creatorPRDTO>> getCreatorPR() {

        return null;
    }


    /**
     * creatorPR 상세 조회
     */

    /**
     * CreatorPR 작성(Get)
     */

    /**
     * CreatorPR 작성(Post)
     */
}
