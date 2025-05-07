package kal.com.rolegames.models.rewards;

import jakarta.persistence.*;
import kal.com.rolegames.models.items.Item;
import kal.com.rolegames.models.util.RewardType;
import lombok.*;

@Entity
@Table(name = "rewards")
//lombok annotations
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@ToString(includeFieldNames = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reward_id")
    @EqualsAndHashCode.Include
    private Long rewardId;

    @Basic(optional = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private RewardType rewardType;

    private Integer experienceAmount;

    private Integer goldAmount;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item itemReward;

    @Basic(optional = false)
    private Boolean claimed;

    @Version
    @Setter(AccessLevel.NONE)
    private Long version;

    // Method to check if this is an experience reward
    // Should return true if rewardType is EXPERIENCE
    public boolean isExperienceReward() {
        // TODO: Return true if rewardType is EXPERIENCE
        return false; // Default return for compilation
    }

    // Method to check if this is a gold reward
    // Should return true if rewardType is GOLD
    public boolean isGoldReward() {
        // TODO: Return true if rewardType is GOLD
        return false; // Default return for compilation
    }

    // Method to check if this is an item reward
    // Should return true if rewardType is ITEM
    public boolean isItemReward() {
        // TODO: Return true if rewardType is ITEM
        return false; // Default return for compilation
    }

    // Method to mark this reward as claimed
    // Should set claimed to true
    public void claim() {
        // TODO: Set claimed to true
    }

    // Method to get a formatted description of the reward
    // Should build a string with the reward details including type, amount, and claimed status
    public String getRewardDescription() {
        // TODO: Start with reward name followed by colon
        // TODO: Add details based on reward type (experience, gold, or item)
        // TODO: Add claimed status
        // TODO: Return the complete string
        return null; // Default return for compilation
    }
}