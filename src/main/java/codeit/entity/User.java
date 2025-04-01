package codeit.entity;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class User {

    private final String id;
    private String nickname;
    private final String email;
    private final String password;
    private final Long createdAt;

    public User(String id, String email, String password, String nickname) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.createdAt = System.currentTimeMillis();
        this.id = id;
    }
}
