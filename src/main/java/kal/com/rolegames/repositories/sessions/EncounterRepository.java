package kal.com.rolegames.repositories.sessions;

import kal.com.rolegames.models.sessions.Encounter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EncounterRepository extends JpaRepository<Encounter, Long> {
}
