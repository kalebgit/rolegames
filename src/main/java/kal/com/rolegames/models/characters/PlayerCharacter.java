package kal.com.rolegames.models.characters;

import jakarta.persistence.*;
import kal.com.rolegames.models.items.Item;
import kal.com.rolegames.models.sessions.Campaign;
import kal.com.rolegames.models.sessions.Session;
import kal.com.rolegames.models.spells.Spell;
import kal.com.rolegames.models.spells.SpellSlot;
import kal.com.rolegames.models.users.Player;
import kal.com.rolegames.models.util.CharacterClassType;
import kal.com.rolegames.models.util.EquipSlot;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "player_character_id")
//lombok annotations
@SuperBuilder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString(callSuper = true)
public class PlayerCharacter extends GameCharacter {

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private CharacterClassType characterClass;

    private String subclass;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Item> inventory = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "character_equipped_items",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "equip_slot")
    private Map<EquipSlot, Item> equippedItems = new HashMap<>();

    @ManyToMany
    @JoinTable(
            name = "character_spells",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "spell_id")
    )
    private Set<Spell> spells = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "character_features",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id")
    )
    private Set<Feature> features = new HashSet<>();

    private String backstory;

    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private Campaign currentCampaign;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "death_save_id")
    private DeathSaveTracker deathSaves;

    @ManyToMany(mappedBy = "attendingPlayers")
    private Set<Session> sessions = new HashSet<>();

    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SpellSlot> spellSlots = new HashSet<>();

    public void addItemToInventory(Item item) {
        // TODO: Set item's owner to this character
        item.setOwner(this);
        // TODO: Add item to inventory set
        inventory.add(item);
    }

    // Method to remove an item from the character's inventory
    // Should check if item exists in inventory, set its owner to null, and remove from inventory
    public void removeItemFromInventory(Item item) {
        // TODO: Check if inventory contains the item
        // TODO: If it does, set item's owner to null and remove from inventory
        if(inventory.contains(item)){
            inventory.remove(item);
        }
    }

    // Method to equip an item in a specific slot
    // Should handle unequipping any current item in that slot
    // Should also ensure the item is in the character's inventory
    public void equipItem(Item item, EquipSlot slot) {
        // TODO: Check if there's already an item in that slot and unequip it
        // TODO: Check if item is in inventory, if not add it
        // TODO: Add item to equipped items map with the slot as key
        // desequipar el item de ese slot
        if(equippedItems.get(slot) != null){
           equippedItems.remove(slot);
        }

        // equipar item
        if(!inventory.contains(item)) {
            addItemToInventory(item);
        }
        equippedItems.put(slot, item);
    }

    // Method to unequip an item from a specific slot
    // Should simply remove the item from the equipped items map
    public void unequipItem(EquipSlot slot) {
        equippedItems.remove(slot);
    }

}