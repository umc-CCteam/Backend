package backend.CC.service;

import backend.CC.domain.Member;
import backend.CC.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    @Override
    public Member findById(Long memberId) {
        Member member =  memberRepository.findById(memberId).get();
        return member;
    }

}
