package kal.com.rolegames.services.characters;

import jakarta.transaction.Transactional;
import kal.com.rolegames.models.characters.GameCharacter;
import kal.com.rolegames.repositories.characters.DeathSaveTrackerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

//lombok
@AllArgsConstructor(onConstructor=@__({@Autowired}))
public class DeathSaveTrackerService {

    private final DeathSaveTrackerRepository deathSaveTrackerRepository;

    @Transactional
    public void addSuccess() {
    }

    // Method to record a failed death saving throw
    // Should increment failures and check if character is now dead (3 failures)
    public void addFailure() {
        // TODO: Increment failures
        // TODO: If failures reach 3 or more, the character is now dead
        // TODO: If character is not null, update their state to dead
    }
}
