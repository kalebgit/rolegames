package kal.com.rolegames.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "spell_slots")
//lombok annotations
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@ToString(includeFieldNames = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SpellSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spell_slot_id")
    @EqualsAndHashCode.Include
    private Long spellSlotId;

    @ManyToOne
    @JoinColumn(name = "character_id", nullable = false)
    private Character character;

    @Basic(optional = false)
    private Integer level;

    @Basic(optional = false)
    private Integer totalSlots;

    @Basic(optional = false)
    private Integer usedSlots;

    @Version
    @Setter(AccessLevel.NONE)
    private Long version;

    // Method to calculate the number of available slots
    // Should return the difference between totalSlots and usedSlots
    public int getAvailableSlots() {
        // TODO: Return totalSlots minus usedSlots
        return 0; // Default return for compilation
    }

    // Method to check if there are any slots available
    // Should return true if the number of available slots is greater than 0
    public boolean hasAvailableSlot() {
        // TODO: Return true if getAvailableSlots() > 0
        return false; // Default return for compilation
    }

    // Method to mark a slot as used
    // Should increment usedSlots if there are slots available
    public void useSlot() {
        // TODO: Check if hasAvailableSlot() is true
        // TODO: If so, increment usedSlots
    }

    // Method to restore a used slot
    // Should decrement usedSlots if there are any used slots
    public void restoreSlot() {
        // TODO: Check if usedSlots > 0
        // TODO: If so, decrement usedSlots
    }

    // Method to restore all used slots
    // Should set usedSlots to 0
    public void restoreAllSlots() {
        // TODO: Set usedSlots to 0
    }
}