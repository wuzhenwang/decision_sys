package edu.sxu.decision_sys.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * @author wzw
 * @version 1.0
 * @description 用户
 * @date 2020/5/1 16:19
 */
public class User implements UserDetails {
    private String userId;
    private String realName;
    private String username;
    private String password;
    private String phone;
    private String address;
    private String email;
    private String imgPath;
    private Boolean enabled;
    private List<Role> roles;

    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
    public String getUserId() {
        return userId;
    }
    public String getAddress() {
        return address;
    }
    public String getImgPath() {
        return imgPath;
    }
    public List<Role> getRoles() {
        if (Objects.equals(roles, null))
            roles = new ArrayList<>();
        return roles;
    }
    public String getRealName() {
        return realName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
    }
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>(roles.size());
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
