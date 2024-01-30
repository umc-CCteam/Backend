package backend.CC.service;

import backend.CC.converter.AuthConverter;
import backend.CC.domain.Member;
import backend.CC.repository.AuthRepository;
import backend.CC.web.dto.AuthRequestDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//GET을 제외한 나머지 요청에 대한 비즈니스 로직
@RequiredArgsConstructor
@Service
public class AuthCommandServiceImpl implements AuthCommandService {
    private final AuthRepository authRepository;

//    로그인 함수 (Member를 만드는 작업을 converter에서)


    @Override
    @Transactional
    public Member joinAuth(AuthRequestDTO.JoinDto request){
        Member newAuth = AuthConverter.toAuth(request);
        return authRepository.save(newAuth);
    }

    public boolean loginAuth(AuthRequestDTO.LoginDto request) {
        Member member = authRepository.findMemberByEmailAnAndPassWord(request.getEmail(), request.getPassword());
        // 회원이 존재하지 않으면 예외를 발생시킨다.
        if (member == null) { //존재하지 않는 회원입니다
            return false;
        }


        // 회원이 존재하면 password가 일치하는지 확인한다.
        return true;
    }
}
