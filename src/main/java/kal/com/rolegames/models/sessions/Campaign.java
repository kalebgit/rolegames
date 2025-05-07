package kal.com.rolegames.models.sessions;

import jakarta.persistence.*;
import kal.com.rolegames.models.characters.NonPlayerCharacter;
import kal.com.rolegames.models.characters.PlayerCharacter;
import kal.com.rolegames.models.users.DungeonMaster;
import kal.com.rolegames.models.users.Player;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "campaigns")
//lombok annotations
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@ToString(includeFieldNames = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "campaign_id")
    @EqualsAndHashCode.Include
    private Long campaignId;

    @Basic(optional = false)
    private String name;

    @Lob
    private String description;

    @ManyToOne
    @JoinColumn(name = "dm_id", nullable = false)
    private DungeonMaster dungeonMaster;

    @ManyToMany
    @JoinTable(
            name = "campaign_players",
            joinColumns = @JoinColumn(name = "campaign_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private Set<Player> players = new HashSet<>();

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Session> sessions = new HashSet<>();

    @Temporal(TemporalType.DATE)
    private LocalDate startDate;

    @Temporal(TemporalType.DATE)
    private LocalDate endDate;

    private Boolean isActive;

    @Lob
    private String globalNotes;

    @ManyToMany
    @JoinTable(
            name = "campaign_important_npcs",
            joinColumns = @JoinColumn(name = "campaign_id"),
            inverseJoinColumns = @JoinColumn(name = "npc_id")
    )
    private Set<NonPlayerCharacter> importantNPCs = new HashSet<>();

    @OneToMany(mappedBy = "currentCampaign")
    private Set<PlayerCharacter> activeCharacters = new HashSet<>();

    @Version
    @Setter(AccessLevel.NONE)
    private Long version;

    // Method to add a player to this campaign
    // Should add the Player to the players set
    public void addPlayer(Player player) {
        // TODO: Add player to players set
    }

    // Method to remove a player from this campaign
    // Should remove the Player from the players set
    public void removePlayer(Player player) {
        // TODO: Remove player from players set
    }

    // Method to add a session to this campaign
    // Should add the Session to the sessions set and set the session's campaign to this campaign
    public void addSession(Session session) {
        // TODO: Add session to sessions set
        // TODO: Set session's campaign to this campaign
    }

    // Method to remove a session from this campaign
    // Should remove the Session from the sessions set and set the session's campaign to null
    public void removeSession(Session session) {
        // TODO: Remove session from sessions set
        // TODO: Set session's campaign to null
    }

    // Method to add an NPC to the list of important NPCs for this campaign
    // Should add the NonPlayerCharacter to the importantNPCs set
    public void addImportantNPC(NonPlayerCharacter npc) {
        // TODO: Add npc to importantNPCs set
    }

    // Method to remove an NPC from the list of important NPCs for this campaign
    // Should remove the NonPlayerCharacter from the importantNPCs set
    public void removeImportantNPC(NonPlayerCharacter npc) {
        // TODO: Remove npc from importantNPCs set
    }
}