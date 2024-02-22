package ist.codex.study.map.dao.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="address")
    private String address;
    @Column(name="placeId")
    private String placeId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "geometry_id", referencedColumnName = "id")
    private Geometry geometry;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "map_information_id", nullable = false, referencedColumnName = "id")
    private MapInformation mapInformation;
}
