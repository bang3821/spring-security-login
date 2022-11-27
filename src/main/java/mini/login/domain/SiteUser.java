package mini.login.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class SiteUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)   //이메일은 중복되면 안된다. 중복되면 오류
    private String email;

    private String password;

    @Column
    private String nickname;
}
