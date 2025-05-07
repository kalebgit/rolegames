package kal.com.rolegames.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "death_save_trackers")
//lombok annotations
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@ToString(includeFieldNames = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DeathSaveTracker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "death_save_id")
    @EqualsAndHashCode.Include
    private Long deathSaveId;

    @OneToOne(mappedBy = "deathSaves")
    private PlayerCharacter character;

    @Basic(optional = false)
    private Integer successes;

    @Basic(optional = false)
    private Integer failures;

    @Version
    @Setter(AccessLevel.NONE)
    private Long version;

    // Initialize with zero successes and failures
    @PrePersist
    protected void prePersist() {
        if (successes == null) {
            successes = 0;
        }
        if (failures == null) {
            failures = 0;
        }
    }

    // Method to record a successful death saving throw
    // Should increment successes and check if character is now stable (3 successes)
    public void addSuccess() {
        // TODO: Increment successes
        // TODO: If successes reach 3 or more, the character is now stable
        // TODO: If character is not null, update their state to stable
    }

    // Method to record a failed death saving throw
    // Should increment failures and check if character is now dead (3 failures)
    public void addFailure() {
        // TODO: Increment failures
        // TODO: If failures reach 3 or more, the character is now dead
        // TODO: If character is not null, update their state to dead
    }

    // Method to reset death saving throws
    // Should set both successes and failures to 0
    public void reset() {
        // TODO: Set successes to 0
        // TODO: Set failures to 0
    }

    // Method to check if the character is stable
    // Should return true if successes is 3 or more
    public boolean isStable() {
        // TODO: Return true if successes is 3 or more
        return false; // Default return for compilation
    }

    // Method to check if the character is dead
    // Should return true if failures is 3 or more
    public boolean isDead() {
        // TODO: Return true if failures is 3 or more
        return false; // Default return for compilation
    }

    // Method to check if the character is still in the process of making death saves
    // Should return true if the character is neither stable nor dead
    public boolean isUnstable() {
        // TODO: Return true if the character is neither stable nor dead
        return false; // Default return for compilation
    }
}