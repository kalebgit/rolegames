package kal.com.rolegames.models.users;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import kal.com.rolegames.models.characters.NonPlayerCharacter;
import kal.com.rolegames.models.items.Item;
import kal.com.rolegames.models.sessions.Campaign;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "dm_id")
//lombok annotations
@SuperBuilder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString(callSuper = true)
public class DungeonMaster extends User {

    @OneToMany(mappedBy = "dungeonMaster", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Campaign> campaigns = new HashSet<>();

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<NonPlayerCharacter> createdNpcs = new HashSet<>();

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Item> createdItems = new HashSet<>();

    private String dmStyle;

    private Float rating;

    // Method to add a campaign to this DM's list of campaigns
    // Should set this DM as the campaign's dungeonMaster and add to campaigns set
    public void addCampaign(Campaign campaign) {
        // TODO: Add campaign to campaigns set
        // TODO: Set campaign's dungeonMaster to this DM
    }

    // Method to remove a campaign from this DM's list
    // Should remove campaign from set and set its dungeonMaster to null
    public void removeCampaign(Campaign campaign) {
        // TODO: Remove campaign from campaigns set
        // TODO: Set campaign's dungeonMaster to null
    }

    // Method to create an NPC associated with this DM
    // Should add NPC to createdNpcs set and set NPC's creator to this DM
    public void createNpc(NonPlayerCharacter npc) {
        // TODO: Add npc to createdNpcs set
        // TODO: Set npc's creator to this DM
    }

    // Method to create an item associated with this DM
    // Should add item to createdItems set and set item's creator to this DM
    public void createItem(Item item) {
        // TODO: Add item to createdItems set
        // TODO: Set item's creator to this DM
    }
}