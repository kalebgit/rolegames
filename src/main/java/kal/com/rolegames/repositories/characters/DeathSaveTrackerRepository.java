package kal.com.rolegames.repositories.characters;

import kal.com.rolegames.models.characters.DeathSaveTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DeathSaveTrackerRepository extends JpaRepository<Long, DeathSaveTracker> {


    @Modifying(clearAutomatically = true)
    @Query("UPDATE DeathSaveTracker d SET d.successes = d.successes + 1 WHERE d.deathSaveId = :id")
    void incrementSuccesses(@Param("id") Long id);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE DeathSaveTracker d SET d.failures = d.failures + 1 WHERE d.deathSaveId = :id")
    void incrementFailures(@Param("id") Long id);

    @Query("SELECT d.successes FROM DeathSaveTracker d WHERE d.deathSaveId = :id")
    Integer findSuccessesValueById(@Param("id") Long id);

    @Query("SELECT d.failures FROM DeathSaveTracker d WHERE d.deathSaveId = :id")
    Integer findFailuresValueById(@Param("id") Long id);

    @Query("SELECT d.character FROM DeathSaveTracker d WHERE d.deathSaveId = :id")
    Long findCharacterValueById(@Param("id") Long id);
}
