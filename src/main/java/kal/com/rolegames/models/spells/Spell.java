package kal.com.rolegames.models;

import jakarta.persistence.*;
import lombok.*;
import util.AbilityType;
import util.DamageType;
import util.SpellComponent;
import util.SpellSchool;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "spells")
//lombok annotations
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@ToString(includeFieldNames = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Spell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spell_id")
    @EqualsAndHashCode.Include
    private Long spellId;

    @Basic(optional = false)
    private String name;

    @Basic(optional = false)
    private Integer level;

    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private SpellSchool school;

    @Basic(optional = false)
    private String castingTime;

    @Basic(optional = false)
    private String range;

    @ElementCollection
    @CollectionTable(name = "spell_components",
            joinColumns = @JoinColumn(name = "spell_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "component")
    private Set<SpellComponent> components = new HashSet<>();

    @Basic(optional = false)
    private String duration;

    @Lob
    @Basic(optional = false)
    private String description;

    @Lob
    private String higherLevelEffects;

    @Enumerated(EnumType.STRING)
    private DamageType damageType;

    private String damageDice;

    @Enumerated(EnumType.STRING)
    private AbilityType savingThrow;

    @Basic(optional = false)
    private Boolean ritual;

    @Basic(optional = false)
    private Boolean concentration;

    private String materialComponents;

    @ManyToMany(mappedBy = "spells")
    private Set<PlayerCharacter> characters = new HashSet<>();

    @Version
    @Setter(AccessLevel.NONE)
    private Long version;

    // Method to check if this spell is a cantrip
    // Should return true if level is 0
    public boolean isCantrip() {
        // TODO: Return true if level is 0
        return false; // Default return for compilation
    }

    // Method to check if this spell requires concentration
    // Should return the value of the concentration field
    public boolean requiresConcentration() {
        // TODO: Return concentration
        return false; // Default return for compilation
    }

    // Method to check if this spell can be cast as a ritual
    // Should return the value of the ritual field
    public boolean canCastAsRitual() {
        // TODO: Return ritual
        return false; // Default return for compilation
    }

    // Method to check if this spell requires a saving throw
    // Should return true if savingThrow is not null
    public boolean requiresSavingThrow() {
        // TODO: Return true if savingThrow is not null
        return false; // Default return for compilation
    }

    // Method to check if this spell deals damage
    // Should return true if both damageType and damageDice are not null
    public boolean dealsDamage() {
        // TODO: Return true if both damageType and damageDice are not null
        return false; // Default return for compilation
    }

    // Method to get a formatted full description of the spell
    // Should build a string with all the spell's details in a readable format
    public String getFullDescription() {
        // TODO: Build a StringBuilder with the spell's details
        // TODO: Include name, level, school
        // TODO: Include casting time, range, components
        // TODO: Include duration (with concentration if applicable)
        // TODO: Include description
        // TODO: Include higher level effects if any
        // TODO: Return the complete string
        return null; // Default return for compilation
    }
}