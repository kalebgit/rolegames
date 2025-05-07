package kal.com.rolegames.models;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
//lombok annotations
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@ToString(includeFieldNames = true)
@EqualsAndHashCode
public class Range {

    private Integer normal;

    private Integer maximum;

    // Method to get a formatted display string for the range
    // Should return a string in the format "normal/maximum ft." or just "normal ft." or "Melee"
    public String getDisplayRange() {
        // TODO: If both normal and maximum are not null, return normal + "/" + maximum + " ft."
        // TODO: Else if normal is not null, return normal + " ft."
        // TODO: Else return "Melee"
        return null; // Default return for compilation
    }

    // Method to check if this is a ranged weapon/attack
    // Should return true if the normal range is greater than 5 feet
    public boolean isRanged() {
        // TODO: Return true if normal is not null and normal > 5
        return false; // Default return for compilation
    }

    // Method to check if this is a melee weapon/attack
    // Should return true if the normal range is null or less than or equal to 5 feet
    public boolean isMelee() {
        // TODO: Return true if normal is null or normal <= 5
        return false; // Default return for compilation
    }
}