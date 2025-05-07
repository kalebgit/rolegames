package kal.com.rolegames.models.combat;

import jakarta.persistence.*;
import kal.com.rolegames.models.characters.GameCharacter;
import lombok.*;

@Entity
@Table(name = "initiatives")
//lombok annotations
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@ToString(includeFieldNames = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Initiative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "initiative_id")
    @EqualsAndHashCode.Include
    private Long initiativeId;

    @ManyToOne
    @JoinColumn(name = "combat_state_id", nullable = false)
    private CombatState combatState;

    @ManyToOne
    @JoinColumn(name = "character_id", nullable = false)
    private GameCharacter character;

    @Basic(optional = false)
    private Integer initiativeRoll;

    @Basic(optional = false)
    private Boolean currentTurn;

    @Basic(optional = false)
    private Boolean hasActed;

    @Basic(optional = false)
    private Integer bonusActionsUsed;

    @Basic(optional = false)
    private Integer reactionsUsed;

    @Basic(optional = false)
    private Integer movementUsed;

    @Version
    @Setter(AccessLevel.NONE)
    private Long version;

    // Method to check if the character can take an action
    // Should return true if the character has not acted yet
    public boolean canTakeAction() {
        // TODO: Return the opposite of hasActed
        return false; // Default return for compilation
    }

    // Method to check if the character can take a bonus action
    // Should return true if the character has not used all their bonus actions
    public boolean canTakeBonusAction() {
        // TODO: Return true if bonusActionsUsed is less than 1
        return false; // Default return for compilation
    }

    // Method to check if the character can take a reaction
    // Should return true if the character has not used all their reactions
    public boolean canTakeReaction() {
        // TODO: Return true if reactionsUsed is less than 1
        return false; // Default return for compilation
    }

    // Method to mark that the character has used their action
    // Should set hasActed to true
    public void useAction() {
        // TODO: Set hasActed to true
    }

    // Method to mark that the character has used a bonus action
    // Should increment bonusActionsUsed
    public void useBonusAction() {
        // TODO: Increment bonusActionsUsed
    }

    // Method to mark that the character has used a reaction
    // Should increment reactionsUsed
    public void useReaction() {
        // TODO: Increment reactionsUsed
    }

    // Method to track movement used
    // Should add the specified distance to movementUsed
    public void useMovement(int distance) {
        // TODO: Add distance to movementUsed
    }
}