package kal.com.rolegames.models.effects;

import jakarta.persistence.*;
import kal.com.rolegames.models.util.AbilityType;
import kal.com.rolegames.models.util.EffectType;
import lombok.*;

@Entity
@Table(name = "item_effects")
//lombok annotations
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@ToString(includeFieldNames = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemEffect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_effect_id")
    @EqualsAndHashCode.Include
    private Long itemEffectId;

    @Basic(optional = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private EffectType effectType;

    @Lob
    private String description;

    @Enumerated(EnumType.STRING)
    private AbilityType affectedAbility;

    private Integer bonusValue;

    private String damageDice;

    private Integer chargesPerDay;

    private Integer currentCharges;

    @Version
    @Setter(AccessLevel.NONE)
    private Long version;

    // Method to check if this effect is currently active
    // Should return true if there is no charge limit or if charges are available
    public boolean isActive() {
        // TODO: Return true if chargesPerDay is null or currentCharges < chargesPerDay
        return false; // Default return for compilation
    }

    // Method to mark a charge as used
    // Should increment currentCharges if the effect is active and has charges
    public void useCharge() {
        // TODO: Check if chargesPerDay is not null and currentCharges < chargesPerDay
        // TODO: If so, increment currentCharges
    }

    // Method to reset the charges used
    // Should set currentCharges back to 0
    public void resetCharges() {
        // TODO: Set currentCharges to 0
    }

    // Method to get a formatted description of the effect
    // Should build a string with the effect details including any ability bonuses and charges
    public String getEffectDescription() {
        // TODO: Start with effect name
        // TODO: If bonusValue is not null, add details about the affected ability and bonus
        // TODO: If damageDice is not null, add details about the damage bonus
        // TODO: If chargesPerDay is not null, add details about remaining charges
        // TODO: Return the complete string
        return null; // Default return for compilation
    }
}