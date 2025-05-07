package kal.com.rolegames.models.skills;

import jakarta.persistence.*;
import lombok.*;
import util.AbilityType;
import util.ProficiencyLevel;
import util.SkillType;

@Entity
@Table(name = "skills")
//lombok annotations
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@ToString(includeFieldNames = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    @EqualsAndHashCode.Include
    private Long skillId;

    @ManyToOne
    @JoinColumn(name = "character_id", nullable = false)
    private Character character;

    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private SkillType skillType;

    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private ProficiencyLevel proficiencyLevel;

    private Integer bonusModifier;

    @Version
    @Setter(AccessLevel.NONE)
    private Long version;

    // Method to get the ability type associated with this skill
    // Should return the ability type from the SkillType enum
    public AbilityType getAssociatedAbility() {
        // TODO: Return the associated ability from skillType
        return null; // Default return for compilation
    }

    // Method to calculate the total skill modifier
    // Should consider ability modifier, proficiency bonus based on proficiency level, and any bonus modifiers
    public int getSkillModifier() {
        // TODO: Start with ability modifier from character
        // TODO: Add proficiency bonus based on proficiency level (none, proficient, expertise)
        // TODO: Add any additional modifiers
        // TODO: Return the total
        return 0; // Default return for compilation
    }

    // Method to calculate the passive score for this skill
    // Should be 10 + the skill modifier
    public int getPassiveScore() {
        // TODO: Return 10 + the skill modifier
        return 0; // Default return for compilation
    }

    // Method to check if the character has proficiency in this skill
    // Should return true if proficiency level is not NONE
    public boolean hasProficiency() {
        // TODO: Return true if proficiencyLevel is not NONE
        return false; // Default return for compilation
    }

    // Method to check if the character has expertise in this skill
    // Should return true if proficiency level is EXPERTISE
    public boolean hasExpertise() {
        // TODO: Return true if proficiencyLevel is EXPERTISE
        return false; // Default return for compilation
    }
}