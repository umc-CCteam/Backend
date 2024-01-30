package backend.CC.service;

import backend.CC.domain.CreatorPR;
import backend.CC.web.dto.PrRequestDTO;

import java.util.List;

public interface CreatorPrService {

    public CreatorPR findById(Long creatorPrId);

    public List<CreatorPR> findAll();

    public CreatorPR createPr(Long memberId, PrRequestDTO.createCreatorPrDTO request);
}
