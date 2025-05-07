package kal.com.rolegames.models.items;

import jakarta.persistence.*;
import kal.com.rolegames.models.util.WeaponProperty;
import kal.com.rolegames.models.util.WeaponType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "weapon_id")
//lombok annotations
@SuperBuilder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString(callSuper = true)
public class Weapon extends Item {

    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private WeaponType weaponType;

    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private kal.com.rolegames.util.DamageType damageType;

    @Basic(optional = false)
    private String damageDice;

    private Integer damageBonus;

    @ElementCollection
    @CollectionTable(name = "weapon_properties",
            joinColumns = @JoinColumn(name = "weapon_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "property")
    private Set<WeaponProperty> properties = new HashSet<>();

    @Embedded
    private Range range;

    private Boolean isMagical;

    private Integer attackBonus;

    // Method to add a property to this weapon
    // Should add the WeaponProperty to the properties set
    public void addProperty(WeaponProperty property) {
        // TODO: Add property to the properties set
    }

    // Method to remove a property from this weapon
    // Should remove the WeaponProperty from the properties set
    public void removeProperty(WeaponProperty property) {
        // TODO: Remove property from the properties set
    }

    // Method to calculate the total attack bonus for a character using this weapon
    // Should consider weapon's attack bonus, ability modifiers based on weapon type, and proficiency if applicable
    public Integer getTotalAttackBonus(Character wielder, Boolean isProficient) {
        // TODO: Calculate base total from attackBonus (if not null)
        // TODO: Add ability modifier (STR or DEX based on weapon type and properties)
        // TODO: Add proficiency bonus if character is proficient
        // TODO: Return the total bonus
        return 0; // Default return for compilation
    }

    // Method to calculate the total damage formula for this weapon when used by a character
    // Should return a string in the format "XdY+Z" where X is number of dice, Y is die type, and Z is bonus
    public String getTotalDamage(Character wielder) {
        // TODO: Determine the appropriate ability modifier to use (STR or DEX)
        // TODO: Calculate the total bonus from damageBonus and ability modifier
        // TODO: Return the damage formula as a string (e.g., "1d8+3")
        return null; // Default return for compilation
    }

    // Helper method to check if this weapon has a specific property
    // Should return true if the property is in the properties set, false otherwise
    private boolean hasProperty(WeaponProperty property) {
        // TODO: Check if properties contains the specified property
        return false; // Default return for compilation
    }

    // Helper method to determine if this is a ranged weapon
    // Should return true if the weapon has a range greater than 5 feet
    private boolean isRanged() {
        // TODO: Check if range is not null and normal range is greater than 5
        return false; // Default return for compilation
    }
}