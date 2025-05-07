package kal.com.rolegames.models.users;

import jakarta.persistence.*;
import kal.com.rolegames.models.characters.PlayerCharacter;
import kal.com.rolegames.models.users.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name="player_id")
//lombok annotations
@SuperBuilder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString(callSuper = true)
public class Player extends User {

    @OneToMany(mappedBy = "player", cascade = {CascadeType.ALL}, fetch=FetchType.LAZY, orphanRemoval=true)
    @Setter(AccessLevel.NONE)
    private Set<PlayerCharacter> characters = new HashSet<>();

    @Basic(optional = false)
    @Setter(AccessLevel.NONE)
    private int experience = 0;

    // Method to add a character to this player's list of characters
    // Should set the character's player to this player and add to characters set
    public void addCharacter(PlayerCharacter character) {
        // TODO: Set character's player to this player
        // TODO: Add character to characters set
    }

    // Method to remove a character from this player's list
    // Should remove character from set and set its player to null
    public void removeCharacter(PlayerCharacter character) {
        // TODO: Remove character from characters set
        // TODO: Set character's player to null
    }

    // Method to add experience to this player
    // Should add the specified amount to the player's experience
    public void addExperience(int amount) {
        // TODO: Add amount to experience
    }

    // Method to get the player's level based on experience
    // Should calculate the level based on D&D's experience progression
    public int getLevel() {
        // TODO: Implement level calculation based on experience
        // A simple formula could be level = experience / 1000 + 1 (or similar)
        return 0; // Default return for compilation
    }
}