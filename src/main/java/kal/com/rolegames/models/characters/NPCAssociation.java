package kal.com.rolegames.models.characters;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "npc_associations")
//lombok annotations
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@ToString(includeFieldNames = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class NPCAssociation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "association_id")
    @EqualsAndHashCode.Include
    private Long associationId;

    @ManyToOne
    @JoinColumn(name = "other_npc_id", nullable = false)
    private NonPlayerCharacter otherNpc;

    @Basic(optional = false)
    private String relationship;

    private Integer relationshipStrength; // 0-10 scale, negative for antagonistic

    @Version
    @Setter(AccessLevel.NONE)
    private Long version;

    // Method to check if this is a positive relationship
    // Should return true if relationshipStrength is positive
    public boolean isPositiveRelationship() {
        // TODO: Return true if relationshipStrength is not null and greater than 0
        return false; // Default return for compilation
    }

    // Method to check if this is a negative relationship
    // Should return true if relationshipStrength is negative
    public boolean isNegativeRelationship() {
        // TODO: Return true if relationshipStrength is not null and less than 0
        return false; // Default return for compilation
    }

    // Method to check if this is a neutral relationship
    // Should return true if relationshipStrength is null or zero
    public boolean isNeutralRelationship() {
        // TODO: Return true if relationshipStrength is null or equal to 0
        return false; // Default return for compilation
    }

    // Method to get a formatted description of the relationship
    // Should build a string with the relationship details including strength description
    public String getRelationshipDescription() {
        // TODO: Build a StringBuilder starting with "Relationship with [otherNpc.getName()]: "
        // TODO: Add the relationship description
        // TODO: Add strength descriptor based on relationshipStrength value if not null
        // TODO: Return the complete string
        return null; // Default return for compilation
    }
}