package kal.com.rolegames.models.sessions;

import jakarta.persistence.*;
import kal.com.rolegames.models.characters.GameCharacter;
import kal.com.rolegames.models.combat.CombatState;
import kal.com.rolegames.models.rewards.Reward;
import kal.com.rolegames.models.util.DifficultyLevel;
import kal.com.rolegames.models.util.EncounterType;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "encounters")
//lombok annotations
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@ToString(includeFieldNames = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Encounter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "encounter_id")
    @EqualsAndHashCode.Include
    private Long encounterId;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @Basic(optional = false)
    private String name;

    @Lob
    private String description;

    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private EncounterType encounterType;

    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private DifficultyLevel difficulty;

    @ManyToMany
    @JoinTable(
            name = "encounter_participants",
            joinColumns = @JoinColumn(name = "encounter_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id")
    )
    private Set<GameCharacter> participants = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "encounter_id")
    private Set<Reward> rewards = new HashSet<>();

    @Basic(optional = false)
    private Boolean isCompleted;

    @Lob
    private String notes;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "combat_state_id")
    private CombatState combatState;

    @Version
    @Setter(AccessLevel.NONE)
    private Long version;

    // Method to add a character as a participant in this encounter
    // Should add the GameCharacter to the participants set
    public void addParticipant(GameCharacter character) {
        // TODO: Add character to participants set
    }

    // Method to remove a character from the participants in this encounter
    // Should remove the GameCharacter from the participants set
    public void removeParticipant(GameCharacter character) {
        // TODO: Remove character from participants set
    }

    // Method to add a reward to this encounter
    // Should add the Reward to the rewards set
    public void addReward(Reward reward) {
        // TODO: Add reward to rewards set
    }

    // Method to remove a reward from this encounter
    // Should remove the Reward from the rewards set
    public void removeReward(Reward reward) {
        // TODO: Remove reward from rewards set
    }

    // Method to initiate combat for this encounter
    // Should create a new CombatState if this is a combat encounter and no combat state exists yet
    public void startCombat() {
        // TODO: Check if this is a combat encounter and combatState is null
        // TODO: If so, create a new CombatState, set its encounter to this, initialize round to 1, and set active to true
        // TODO: Set this encounter's combatState to the new CombatState
    }

    // Method to end combat for this encounter
    // Should set the combat state's isActive to false if a combat state exists
    public void endCombat() {
        // TODO: Check if combatState is not null
        // TODO: If so, set its isActive to false
    }
}