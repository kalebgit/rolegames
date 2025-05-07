package kal.com.rolegames.models.items;

import jakarta.persistence.*;
import kal.com.rolegames.models.util.ArmorType;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@PrimaryKeyJoinColumn(name = "armor_id")
//lombok annotations
@SuperBuilder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString(callSuper = true)
public class Armor extends Item {

    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private ArmorType armorType;

    @Basic(optional = false)
    private Integer baseArmorClass;

    private Integer strengthRequirement;

    private Boolean stealthDisadvantage;

    private Integer magicalBonus;

    // Method to calculate the total AC provided by this armor for a specific character
    // Should consider armor type, base AC, DEX modifier based on armor type, and magical bonus
    public Integer calculateArmorClass(Character wearer) {
        // TODO: Start with base AC
        // TODO: Add DEX modifier based on armor type (full for light, max +2 for medium, none for heavy)
        // TODO: Add magical bonus if present
        // TODO: Return the total AC
        return 0; // Default return for compilation
    }

    // Method to check if a character meets the requirements to wear this armor
    // Should check if character's strength meets the strength requirement (if any)
    public boolean canBeWornBy(Character character) {
        // TODO: Check if there is a strength requirement
        // TODO: If so, check if the character's strength meets the requirement
        // TODO: Return the result
        return false; // Default return for compilation
    }
}