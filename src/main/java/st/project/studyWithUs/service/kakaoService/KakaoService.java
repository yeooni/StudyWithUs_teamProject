package st.project.studyWithUs.service.kakaoService;

import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public interface KakaoService {


    void kakaoLogout(String access_Token);
    String getKaKaoAccessToken(String code);
    HashMap<String, Object> getUserInfo (String access_Token);
}
