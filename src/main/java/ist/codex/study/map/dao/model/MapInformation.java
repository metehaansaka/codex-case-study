package ist.codex.study.map.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class MapInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "longitude")
    private double longitude;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "radius")
    private int radius;

    @OneToMany(mappedBy = "mapInformation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Result> results;
}
