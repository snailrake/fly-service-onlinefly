package ru.onlinefly.fly_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @Column(name = "login", length = 256, nullable = false)
    private String id;

    @Column(name = "name", length = 256, nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "team_id")
    private Team team;

    @Column(name = "password", length = 80, nullable = false)
    private String password;

    @Column(name = "role", length = 16, nullable = false)
    private String role;

    @Column(name = "mail", length = 256, nullable = false)
    private String mail;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<FlyResult> results;

    public User(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.password = user.getPassword();
        this.role = user.getRole();
        this.mail = user.getMail();
        this.team = user.getTeam();
        this.results = user.getResults();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getUsername() {
        return getId();
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
        return true;
    }
}
