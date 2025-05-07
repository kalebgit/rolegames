package kal.com.rolegames.models.combat;

import jakarta.persistence.*;
import kal.com.rolegames.models.effects.Effect;
import kal.com.rolegames.models.sessions.Encounter;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "combat_states")
//lombok annotations
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@ToString(includeFieldNames = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CombatState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "combat_state_id")
    @EqualsAndHashCode.Include
    private Long combatStateId;

    @OneToOne(mappedBy = "combatState")
    private Encounter encounter;

    @Basic(optional = false)
    private Integer currentRound;

    @OneToMany(mappedBy = "combatState", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("initiativeRoll DESC")
    private List<Initiative> initiativeOrder = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "combat_state_id")
    private Set<Effect> activeEffects = new HashSet<>();

    @Basic(optional = false)
    private Boolean isActive;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startTime;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endTime;

    @OneToMany(mappedBy = "combat", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("timestamp ASC")
    private List<CombatAction> actionHistory = new ArrayList<>();

    @Version
    @Setter(AccessLevel.NONE)
    private Long version;

    // Method to add a participant to combat with their initiative roll
    // Should create a new Initiative object, initialize its values, and add it to the initiative order
    public void addParticipant(Character character, int initiativeRoll) {
        // TODO: Create a new Initiative object
        // TODO: Set its combatState to this
        // TODO: Set its character to the parameter
        // TODO: Set its initiativeRoll to the parameter
        // TODO: Set currentTurn, hasActed, and other action counters to initial values
        // TODO: Add to initiativeOrder
        // TODO: Sort initiativeOrder by initiativeRoll descending
    }

    // Method to start combat
    // Should set isActive to true, record start time, set round to 1, and set the first character's turn
    public void startCombat() {
        // TODO: Set isActive to true
        // TODO: Set startTime to current time
        // TODO: Set currentRound to 1
        // TODO: If initiativeOrder is not empty, set the first character's currentTurn to true
    }

    // Method to end combat
    // Should set isActive to false, record end time, and clear all current turns
    public void endCombat() {
        // TODO: Set isActive to false
        // TODO: Set endTime to current time
        // TODO: Iterate through initiativeOrder and set all currentTurn flags to false
    }

    // Method to proceed to the next turn in initiative order
    // Should end current turn, move to next character, and potentially start a new round
    public void nextTurn() {
        // TODO: Find the index of the current turn character
        // TODO: End that character's turn (set currentTurn to false, hasActed to true)
        // TODO: Calculate the next index (with wrap-around)
        // TODO: If next index is 0, start a new round (increment currentRound, reset all action counters)
        // TODO: Start the next character's turn (set currentTurn to true)
    }

    // Method to get the participant whose turn it currently is
    // Should return the Initiative object that has currentTurn set to true
    public Initiative getCurrentTurnParticipant() {
        // TODO: Iterate through initiativeOrder to find the entry with currentTurn = true
        // TODO: Return that Initiative object, or null if none found
        return null; // Default return for compilation
    }

    // Method to add an action to the combat history
    // Should add the action to the history and set the action's combat to this
    public void addAction(CombatAction action) {
        // TODO: Add action to actionHistory
        // TODO: Set action's combat to this CombatState
    }
}