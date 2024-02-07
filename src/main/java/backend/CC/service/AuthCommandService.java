package backend.CC.service;

import backend.CC.domain.Member;
import backend.CC.web.dto.AuthRequestDTO;

// 서비스를 만들 경우 인터페이스를 먼저 두고 이를 구제화한다.
public interface AuthCommandService {
    Member joinAuth(AuthRequestDTO.JoinDto request);
    boolean loginAuth(AuthRequestDTO.LoginDto request);
}
