package kal.com.rolegames.models.users;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import util.AbilityType;
import util.AlignmentType;
import util.RaceType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "characters")
//lombok annotations
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@SuperBuilder
@ToString(includeFieldNames = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    @EqualsAndHashCode.Include
    private Long characterId;

    @Basic(optional = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private RaceType race;

    @Basic(optional = false)
    private Integer level;

    @Basic(optional = false)
    private Integer experiencePoints;

    @ElementCollection
    @CollectionTable(name = "character_abilities",
            joinColumns = @JoinColumn(name = "character_id"))
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "ability_type")
    @Column(name = "score")
    private Map<AbilityType, Integer> abilities = new HashMap<>();

    @Basic(optional = false)
    private Integer hitPoints;

    @Basic(optional = false)
    private Integer maxHitPoints;

    @Basic(optional = false)
    private Integer armorClass;

    @Basic(optional = false)
    private Integer proficiencyBonus;

    @Basic(optional = false)
    private Integer speed;

    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private AlignmentType alignment;

    private String background;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "character_traits",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "trait_id")
    )
    private Set<Trait> traits = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "current_state_id")
    private CharacterState currentState;

    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Skill> skills = new HashSet<>();

    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SavingThrow> savingThrows = new HashSet<>();

    @ManyToMany(mappedBy = "participants")
    private Set<Encounter> encounters = new HashSet<>();

    @Version
    @Setter(AccessLevel.NONE)
    private Long version;

    // Method to calculate ability modifier based on ability score
    // Should implement the D&D formula: (score - 10) / 2, rounded down
    public int getAbilityModifier(AbilityType abilityType) {
        // TODO: Retrieve ability score from abilities map
        // TODO: Return the calculated modifier using the (score - 10) / 2 formula
        return 0; // Default return for compilation
    }
}