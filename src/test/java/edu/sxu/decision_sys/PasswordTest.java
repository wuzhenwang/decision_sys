package edu.sxu.decision_sys;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author wzw
 * @version 1.0
 * @description 密码测试
 * @date 2020/5/1 22:01
 */
public class PasswordTest {
    @Test
    public void passwordTest() {
        String p = new BCryptPasswordEncoder().encode("123456");
        System.out.println(p);
    }
}
