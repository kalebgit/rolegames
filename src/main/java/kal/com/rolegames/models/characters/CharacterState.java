package kal.com.rolegames.models.characters;

import jakarta.persistence.*;
import lombok.*;
import util.StateType;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "character_states")
//lombok annotations
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@ToString(includeFieldNames = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CharacterState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    @EqualsAndHashCode.Include
    private Long stateId;

    @Basic(optional = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private StateType stateType;

    @Lob
    private String description;

    @OneToMany(mappedBy = "currentState")
    private Set<Character> characters = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "state_id")
    private Set<Effect> effects = new HashSet<>();

    @Version
    @Setter(AccessLevel.NONE)
    private Long version;

    // Method to add an effect to this state
    // Should add the Effect to the effects set
    public void addEffect(Effect effect) {
        // TODO: Add effect to effects set
    }

    // Method to remove an effect from this state
    // Should remove the Effect from the effects set
    public void removeEffect(Effect effect) {
        // TODO: Remove effect from effects set
    }

    // Method to check if this state disables a character
    // Should return true if the state type is one that prevents actions
    public boolean isDisabled() {
        // TODO: Return true if stateType is UNCONSCIOUS, PARALYZED, PETRIFIED, or INCAPACITATED
        return false; // Default return for compilation
    }

    // Method to check if a character in this state can take actions
    // Should return true if the character is not disabled
    public boolean canTakeActions() {
        // TODO: Return the opposite of isDisabled()
        return false; // Default return for compilation
    }

    // Method to check if this is a negative state
    // Should return true if the state type is anything other than NORMAL or INSPIRED
    public boolean isNegativeState() {
        // TODO: Return true if stateType is not NORMAL and not INSPIRED
        return false; // Default return for compilation
    }
}