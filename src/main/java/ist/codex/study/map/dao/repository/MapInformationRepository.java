package ist.codex.study.map.dao.repository;

import ist.codex.study.map.dao.model.MapInformation;
import ist.codex.study.map.internal.dto.MapInformationDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MapInformationRepository extends JpaRepository<MapInformation, Long> {
    Optional<MapInformation> findByLatitudeAndLongitudeAndRadius(double latitude, double longitude, int radius);
}
