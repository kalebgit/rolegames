package kal.com.rolegames.models.characters;

import jakarta.persistence.*;
import kal.com.rolegames.models.util.BehaviorTrait;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "npc_behaviors")
//lombok annotations
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@ToString(includeFieldNames = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class NPCBehavior {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "behavior_id")
    @EqualsAndHashCode.Include
    private Long behaviorId;

    @Lob
    private String personalityDescription;

    @ElementCollection
    @CollectionTable(name = "npc_behavior_traits",
            joinColumns = @JoinColumn(name = "behavior_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "trait")
    private Set<BehaviorTrait> traits = new HashSet<>();

    private Integer aggressiveness; // 0-10 scale

    private Integer friendliness; // 0-10 scale

    private Integer honesty; // 0-10 scale

    @OneToOne(mappedBy = "behavior")
    private NonPlayerCharacter npc;

    @Version
    @Setter(AccessLevel.NONE)
    private Long version;

    // Method to add a trait to this NPC's behavior
    // Should add the BehaviorTrait to the traits set
    public void addTrait(BehaviorTrait trait) {
        // TODO: Add trait to traits set
    }

    // Method to remove a trait from this NPC's behavior
    // Should remove the BehaviorTrait from the traits set
    public void removeTrait(BehaviorTrait trait) {
        // TODO: Remove trait from traits set
    }

    // Method to check if this NPC has a specific trait
    // Should return true if the trait is in the traits set
    public boolean hasTrait(BehaviorTrait trait) {
        // TODO: Return true if traits contains the specified trait
        return false; // Default return for compilation
    }

    // Method to check if the NPC is likely to attack
    // Should return true if aggressiveness is high (above 7)
    public boolean isLikelyToAttack() {
        // TODO: Return true if aggressiveness is not null and greater than 7
        return false; // Default return for compilation
    }

    // Method to check if the NPC is likely to help others
    // Should return true if friendliness is high (above 7)
    public boolean isLikelyToHelp() {
        // TODO: Return true if friendliness is not null and greater than 7
        return false; // Default return for compilation
    }

    // Method to check if the NPC is likely to lie
    // Should return true if honesty is low (below 3)
    public boolean isLikelyToLie() {
        // TODO: Return true if honesty is not null and less than 3
        return false; // Default return for compilation
    }
}