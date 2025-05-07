package kal.com.rolegames.models.effects;

import jakarta.persistence.*;
import kal.com.rolegames.models.characters.GameCharacter;
import kal.com.rolegames.models.spells.Spell;
import kal.com.rolegames.models.util.EffectType;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "effects")
//lombok annotations
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@ToString(includeFieldNames = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Effect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "effect_id")
    @EqualsAndHashCode.Include
    private Long effectId;

    @Basic(optional = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private EffectType effectType;

    @Lob
    private String description;

    @ManyToOne
    @JoinColumn(name = "source_id")
    private GameCharacter source;

    @ManyToOne
    @JoinColumn(name = "target_id")
    private GameCharacter target;

    @ManyToOne
    @JoinColumn(name = "spell_id")
    private Spell spell;

    @Basic(optional = false)
    private Integer duration; // in rounds, -1 for until dispelled

    @Basic(optional = false)
    private Boolean isActive;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startTime;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endTime;

    @Version
    @Setter(AccessLevel.NONE)
    private Long version;

    // Method to activate this effect
    // Should set isActive to true and record the start time
    public void activate() {
        // TODO: Set isActive to true
        // TODO: Set startTime to current time
    }

    // Method to deactivate this effect
    // Should set isActive to false and record the end time
    public void deactivate() {
        // TODO: Set isActive to false
        // TODO: Set endTime to current time
    }

    // Method to check if this effect is permanent
    // Should return true if duration is negative
    public boolean isPermanent() {
        // TODO: Return true if duration is less than 0
        return false; // Default return for compilation
    }

    // Method to check if this effect is temporary
    // Should return true if the effect is not permanent
    public boolean isTemporary() {
        // TODO: Return the opposite of isPermanent()
        return false; // Default return for compilation
    }

    // Method to check if this effect comes from a spell
    // Should return true if the spell field is not null
    public boolean isFromSpell() {
        // TODO: Return true if spell is not null
        return false; // Default return for compilation
    }

    // Method to get the name of the source of this effect
    // Should return the spell name if from a spell, character name if from a character, or "Unknown"
    public String getSourceName() {
        // TODO: If isFromSpell() is true, return spell.getName()
        // TODO: Else if source is not null, return source.getName()
        // TODO: Else return "Unknown"
        return null; // Default return for compilation
    }
}