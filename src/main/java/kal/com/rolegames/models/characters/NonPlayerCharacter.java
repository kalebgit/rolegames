package kal.com.rolegames.models.characters;

import jakarta.persistence.*;
import kal.com.rolegames.models.items.Item;
import kal.com.rolegames.models.sessions.Campaign;
import kal.com.rolegames.models.users.User;
import kal.com.rolegames.models.util.NPCType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "npc_id")
//lombok annotations
@SuperBuilder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString(callSuper = true)
public class NonPlayerCharacter extends GameCharacter {

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private NPCType npcType;

    private Float challengeRating;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "npc_id")
    private Set<DialogueOption> dialogue = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "behavior_id")
    private NPCBehavior behavior;

    private String motivation;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "npc_id")
    private Set<NPCAssociation> associations = new HashSet<>();

    private Boolean isHostile;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Item> inventory = new HashSet<>();

    @ManyToMany(mappedBy = "importantNPCs")
    private Set<Campaign> campaigns = new HashSet<>();

    // Method to add a dialogue option to this NPC
    // Should add the DialogueOption to the dialogue set
    public void addDialogueOption(DialogueOption option) {
        // TODO: Add option to dialogue set
    }

    // Method to create an association between this NPC and another NPC
    // Should create a new NPCAssociation object and add it to associations
    public void addAssociation(NonPlayerCharacter otherNpc, String relationship) {
        // TODO: Create a new NPCAssociation with otherNpc and relationship
        // TODO: Add it to the associations set
    }

    // Method to add an item to the NPC's inventory
    // Should set the item's owner to this NPC and add to inventory set
    public void addItemToInventory(Item item) {
        // TODO: Set item's owner to this NPC
        // TODO: Add item to inventory set
    }

    // Method to remove an item from the NPC's inventory
    // Should check if item exists in inventory, set its owner to null, and remove from inventory
    public void removeItemFromInventory(Item item) {
        // TODO: Check if inventory contains the item
        // TODO: If it does, set item's owner to null and remove from inventory
    }
}