package kal.com.rolegames.models.sessions;

import jakarta.persistence.*;
import kal.com.rolegames.models.users.Player;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sessions")
//lombok annotations
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@ToString(includeFieldNames = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    @EqualsAndHashCode.Include
    private Long sessionId;

    @ManyToOne
    @JoinColumn(name = "campaign_id", nullable = false)
    private Campaign campaign;

    @Basic(optional = false)
    private Integer sessionNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Basic(optional = false)
    private LocalDateTime date;

    private Integer duration; // in minutes

    @ManyToMany
    @JoinTable(
            name = "session_players",
            joinColumns = @JoinColumn(name = "session_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private Set<Player> attendingPlayers = new HashSet<>();

    @Lob
    private String summary;

    @Lob
    @Column(name = "dm_notes")
    private String dmNotes;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Encounter> encountersCompleted = new HashSet<>();

    @Lob
    @Column(name = "next_session_objectives")
    private String nextSessionObjectives;

    @Version
    @Setter(AccessLevel.NONE)
    private Long version;

    public void addAttendingPlayer(Player player) {
        attendingPlayers.add(player);
    }

    public void removeAttendingPlayer(Player player) {
        attendingPlayers.remove(player);
    }

    public void addEncounter(Encounter encounter) {
        encountersCompleted.add(encounter);
        encounter.setSession(this);
    }

    public void removeEncounter(Encounter encounter) {
        encountersCompleted.remove(encounter);
        encounter.setSession(null);
    }
}