package mini.login.Service;

import lombok.RequiredArgsConstructor;
import mini.login.domain.SiteUser;
import mini.login.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor         // 생성자를 만들어줌.
public class UserService {

    private final UserRepository userRepository;

    public SiteUser signUp(String email, String password, String nickname) {
        SiteUser siteUser = new SiteUser();   // 새로운 빈 껌데기의 user 객체를 만듬.
        siteUser.setEmail(email);     //받아온 email,nickname 을 빈 껍데기 객체에 저장
        siteUser.setNickname(nickname);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); //암호화를 시키는 객체를 만듬 (비밀번호)
        siteUser.setPassword(passwordEncoder.encode(password)); //encode=암호화를 시킴
        this.userRepository.save(siteUser);
        return siteUser;

    }
}
