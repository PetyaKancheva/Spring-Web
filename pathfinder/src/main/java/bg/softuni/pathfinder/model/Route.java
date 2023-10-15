package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.model.enums.UserLevels;
import jakarta.persistence.*;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity {
    @Column
    private String description;
    @Column(name = "gpx_coordinates", columnDefinition = "TEXT")
    private String gpxCoordinates;
    @Enumerated(EnumType.STRING)
    private UserLevels level;
    @Column(nullable=false,unique= true)
    private String name;

    @ManyToOne
    private User author;
    @Column(columnDefinition = "TEXT")
    private String videoURL;
    public Route(){

    }

    public String getDescription() {
        return description;
    }

    public Route setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public Route setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public UserLevels getLevel() {
        return level;
    }

    public Route setLevel(UserLevels level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public Route setName(String name) {
        this.name = name;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Route setAuthor(User author) {
        this.author = author;
        return this;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public Route setVideoURL(String videoURL) {
        this.videoURL = videoURL;
        return this;
    }
}
