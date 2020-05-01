package edu.sxu.decision_sys.service;

import edu.sxu.decision_sys.entity.Role;
import edu.sxu.decision_sys.entity.User;
import edu.sxu.decision_sys.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author wzw
 * @version 1.0
 * @description userService
 * @date 2020/5/1 19:46
 */
@Service("userService")
public class UserService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 通过id查询
     * @param id
     * @return
     */
    public User queryById(String id) {
        return userMapper.queryById(id);
    }

    /**
     * 通过username 查询
     * @param username
     * @return
     */
    public User queryByUsername(String username) {
        return userMapper.queryByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.queryByUsername(username);
        if (Objects.equals(user, null)) {
            throw new UsernameNotFoundException(String.format("User with username=%s was not found", username));
        }
        Role role = new Role();
        role.setName("ROLE_admin");
        role.setNameZh("管理员");
        role.setRoleId("1");
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        return user;
    }
}
