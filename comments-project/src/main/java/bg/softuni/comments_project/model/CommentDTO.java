package bg.softuni.comments_project.model;

public record CommentDTO(
        Long id,
        String user_name,
        String title,
        String body) {
}
