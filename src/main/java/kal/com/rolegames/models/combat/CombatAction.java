package kal.com.rolegames.models;

import jakarta.persistence.*;
import lombok.*;
import util.ActionType;

import java.time.LocalDateTime;

@Entity
@Table(name = "combat_actions")
//lombok annotations
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@ToString(includeFieldNames = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CombatAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "action_id")
    @EqualsAndHashCode.Include
    private Long actionId;

    @ManyToOne
    @JoinColumn(name = "combat_state_id")
    private CombatState combat;

    @ManyToOne
    @JoinColumn(name = "character_id", nullable = false)
    private Character character;

    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private ActionType actionType;

    @ManyToOne
    @JoinColumn(name = "target_id")
    private Character target;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "spell_id")
    private Spell spell;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "result_id")
    private ActionResult result;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime timestamp;

    @PrePersist
    protected void prePersist() {
        this.timestamp = LocalDateTime.now();
    }

    // Method to set the result of this action
    // Should create a new ActionResult with the provided parameters and set it as this action's result
    public void setResult(boolean success, int damageDealt, String description) {
        // TODO: Create a new ActionResult
        // TODO: Set its success, damageDealt, and description properties
        // TODO: Set this action's result to the new ActionResult
    }

    // Method to generate a descriptive string for this action
    // Should build a string describing the action, who performed it, what was used, and the result
    public String getActionDescription() {
        // TODO: Build a StringBuilder with character name and action type
        // TODO: Add target information if there is a target
        // TODO: Add item information if there is an item
        // TODO: Add spell information if there is a spell
        // TODO: Add result information if there is a result
        // TODO: Return the complete string
        return null; // Default return for compilation
    }
}