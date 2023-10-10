package ch.langenegger.blog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // Lombok's annotation to generate all the getters, setters, equals, hash, and toString methods, based on the fields
@Entity // JPA annotation to make this object ready for storage in a JPA-based data store
@NoArgsConstructor
@AllArgsConstructor
public class Blog {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 5, message = "Titel braucht min. 5 Zeichen.")
    private String title;
    @NotBlank
    private String content;

    public Blog(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
