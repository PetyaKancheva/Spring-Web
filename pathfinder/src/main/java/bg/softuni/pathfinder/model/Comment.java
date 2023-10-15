package bg.softuni.pathfinder.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name= "comments")
public class Comment extends BaseEntity {
    @Column(nullable = false)
    private Boolean approved;
    @Column (nullable = false)
    private LocalDateTime created;
    @Column(name = "text_content",nullable = false,columnDefinition="TEXT")
    private String textContent;
    @ManyToOne()
    private User author;
    @ManyToOne()
    private Route route;
    public Comment(){

    }

    public Boolean getApproved() {
        return approved;
    }

    public Comment setApproved(Boolean approved) {
        this.approved = approved;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public Comment setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public String getTextContent() {
        return textContent;
    }

    public Comment setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Comment setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Route getRoute() {
        return route;
    }

    public Comment setRoute(Route route) {
        this.route = route;
        return this;
    }
}
