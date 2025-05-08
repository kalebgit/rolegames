package kal.com.rolegames.models.users;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.NaturalId;
import util.UserType;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="users")
//lombok annotations
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@SuperBuilder
@ToString(includeFieldNames = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;

    @NaturalId
    @Basic(optional=false)
    private String username;

    @Basic(optional=false)
    private String password;

    @NaturalId
    @Column(unique=true)
    @Basic(optional=false)
    private String email;


    @Enumerated(EnumType.STRING)
    @Basic(optional=false)
    @Column(name="user_type")
    private UserType userType;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false, name="created_at")
    @Basic(optional=false)
    @Setter(AccessLevel.NONE)
    private LocalDateTime createdAt;

    @Version
    @Setter(AccessLevel.NONE)
    private Long version;

    // sistema basado en roles, esto es composite
    // TODO todavia no estamos seguros de agregar esta parte de roles
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private Set<Role> roles = new HashSet<>();
//
//    public void addRole(Role role){
//        roles.add(role);
//    }

    @PrePersist
    protected void prePersist(){
        this.createdAt = LocalDateTime.now();
    }
}
