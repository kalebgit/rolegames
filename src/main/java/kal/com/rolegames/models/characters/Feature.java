package kal.com.rolegames.models.characters;

import jakarta.persistence.*;
import kal.com.rolegames.models.util.FeatureType;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "features")
//lombok annotations
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@ToString(includeFieldNames = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feature_id")
    @EqualsAndHashCode.Include
    private Long featureId;

    @Basic(optional = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private FeatureType featureType;

    @Lob
    private String description;

    @Basic(optional = false)
    private Integer levelRequired;

    private Integer usesPerDay;

    private Integer currentUses;

    @ManyToMany(mappedBy = "features")
    private Set<PlayerCharacter> characters = new HashSet<>();

    @Version
    @Setter(AccessLevel.NONE)
    private Long version;

    // Method to check if the feature is available for use
    // Should return true if there are no uses per day limit or if current uses is less than the limit
    public boolean isAvailable() {
        // TODO: Return true if usesPerDay is null or currentUses < usesPerDay
        return false; // Default return for compilation
    }

    // Method to mark that the feature has been used
    // Should increment currentUses if the feature is available and has a usage limit
    public void useFeature() {
        // TODO: Check if usesPerDay is not null and currentUses < usesPerDay
        // TODO: If so, increment currentUses
    }

    // Method to reset the feature's uses
    // Should set currentUses back to 0
    public void resetUses() {
        // TODO: Set currentUses to 0
    }

    // Method to get a formatted full description of the feature
    // Should build a string with all the feature's details in a readable format
    public String getFullDescription() {
        // TODO: Build a StringBuilder with the feature's details
        // TODO: Include name and feature type
        // TODO: Include level required
        // TODO: Include uses per day if applicable
        // TODO: Include description
        // TODO: Return the complete string
        return null; // Default return for compilation
    }
}