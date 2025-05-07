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

    // Method to add a player to the list of attending players for this session
    // Should add the Player to the attendingPlayers set
    public void addAttendingPlayer(Player player) {
        // TODO: Add player to attendingPlayers set
    }

    // Method to remove a player from the list of attending players for this session
    // Should remove the Player from the attendingPlayers set
    public void removeAttendingPlayer(Player player) {
        // TODO: Remove player from attendingPlayers set
    }

    // Method to add an encounter to this session
    // Should add the Encounter to the encountersCompleted set and set the encounter's session to this session
    public void addEncounter(Encounter encounter) {
        // TODO: Add encounter to encountersCompleted set
        // TODO: Set encounter's session to this session
    }

    // Method to remove an encounter from this session
    // Should remove the Encounter from the encountersCompleted set and set the encounter's session to null
    public void removeEncounter(Encounter encounter) {
        // TODO: Remove encounter from encountersCompleted set
        // TODO: Set encounter's session to null
    }
}