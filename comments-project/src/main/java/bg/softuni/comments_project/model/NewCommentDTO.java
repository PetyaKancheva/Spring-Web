package bg.softuni.comments_project.model;

public record NewCommentDTO(
        String user_name,
        String title,
        String body
) {
}
