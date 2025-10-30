package com.ebim.esupplier.security;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "\"Users\"", schema = "public")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class User implements UserDetails {
    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "UserName")
    private String username;

    @Column(name = "NormalizedUserName", unique = true)
    private String normalizedUserName;

    @Column(name = "Email")
    private String email;

    @Column(name = "NormalizedEmail")
    private String normalizedEmail;

    @Column(name = "EmailConfirmed", nullable = false)
    @Builder.Default
    private boolean emailConfirmed = false;

    @Column(name = "PasswordHash")
    private String password;

    @Column(name = "SecurityStamp")
    private String securityStamp;

    @Column(name = "ConcurrencyStamp")
    private String concurrencyStamp;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "PhoneNumberConfirmed", nullable = false)
    @Builder.Default
    private boolean phoneNumberConfirmed = false;

    @Column(name = "TwoFactorEnabled", nullable = false)
    @Builder.Default
    private boolean twoFactorEnabled = false;

    @Column(name = "LockoutEnd")
    private Instant lockoutEnd;

    @Column(name = "LockoutEnabled", nullable = false)
    @Builder.Default
    private boolean lockoutEnabled = false;

    @Column(name = "AccessFailedCount", nullable = false)
    @Builder.Default
    private int accessFailedCount = 0;

    @Column(name = "TaxId", unique = true)
    private String taxId;

    @Column(name = "IsActive", nullable = false)
    @Builder.Default
    private boolean enabled = true;

    @Column(name = "CreatedAt", nullable = false)
    @Builder.Default
    private Instant createdAt = Instant.now();

    @Column(name = "LastModifiedAt")
    private Instant lastModifiedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Builder.Default
    private Set<UserRole> userRoles = new HashSet<>();

    @PreUpdate
    public void onUpdate() {
        this.lastModifiedAt = Instant.now();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userRoles.stream()
                .map(UserRole::getRole)
                .map(Role::getName)
                .map(name -> new SimpleGrantedAuthority(name))
                .collect(Collectors.toSet());
    }
    @Override public String getPassword() { return password; }
    @Override public String getUsername() { return username; }
    @Override public boolean isEnabled() { return enabled; }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return lockoutEnd == null || lockoutEnd.isBefore(Instant.now()); }
    @Override public boolean isCredentialsNonExpired() { return true; }
}