package backend.CC.service;

import backend.CC.converter.CreatorPrConverter;
import backend.CC.converter.VideoConverter;
import backend.CC.domain.*;
import backend.CC.repository.CategoryRepository;
import backend.CC.repository.CreatorPrRepository;
import backend.CC.repository.VideoRepository;
import backend.CC.web.dto.PrRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CreatorPrServiceImpl implements CreatorPrService {

    private final CreatorPrRepository creatorPrRepository;
    private final MemberServiceImpl memberService;
    private final CategoryRepository categoryRepository;

    @Override
    public CreatorPR findById(Long creatorPrId) {
        CreatorPR creatorPR = creatorPrRepository.findById(creatorPrId).get();
        return creatorPR;
    }

    @Override
    public List<CreatorPR> findAll() {
        List<CreatorPR> creatorPRList = creatorPrRepository.findAll();
        return creatorPRList;
    }

    @Override
    @Transactional
    public CreatorPR createPr(Long memberId, PrRequestDTO.createCreatorPrDTO request, Image image) {
        Member member = memberService.findById(memberId);
        CreatorPR newPr = CreatorPrConverter.toCreatePr(request);

        Category category = categoryRepository.findByCategory1AndCategory2(request.getCategory1(), request.getCategory2());
        List<Video> videoList = VideoConverter.toVideoList(request.getVideo());

        newPr.setCategory(category);
        newPr.setVideoList(videoList);
        newPr.setMember(member);
        newPr.setImage(image);

        for(Video video : videoList) {
            video.setCreatorPR(newPr);
        }
        creatorPrRepository.save(newPr);
        return newPr;
    }
}
