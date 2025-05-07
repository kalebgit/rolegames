package kal.com.rolegames.models;

import jakarta.persistence.*;
import lombok.*;
import util.AbilityType;

@Entity
@Table(name = "saving_throws")
//lombok annotations
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@ToString(includeFieldNames = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SavingThrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "saving_throw_id")
    @EqualsAndHashCode.Include
    private Long savingThrowId;

    @ManyToOne
    @JoinColumn(name = "character_id", nullable = false)
    private Character character;

    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private AbilityType abilityType;

    @Basic(optional = false)
    private Boolean isProficient;

    private Boolean advantage;

    private Boolean disadvantage;

    private Integer bonusModifier;

    @Version
    @Setter(AccessLevel.NONE)
    private Long version;

    // Method to calculate the total saving throw modifier
    // Should consider ability modifier, proficiency bonus if proficient, and any bonus modifiers
    public int getSavingThrowModifier() {
        // TODO: Start with ability modifier from character
        // TODO: Add proficiency bonus if isProficient is true
        // TODO: Add bonusModifier if not null
        // TODO: Return the total
        return 0; // Default return for compilation
    }

    // Method to check if this saving throw has advantage
    // Should return true if advantage is not null and true
    public boolean hasAdvantage() {
        // TODO: Return true if advantage is not null and true
        return false; // Default return for compilation
    }

    // Method to check if this saving throw has disadvantage
    // Should return true if disadvantage is not null and true
    public boolean hasDisadvantage() {
        // TODO: Return true if disadvantage is not null and true
        return false; // Default return for compilation
    }
}