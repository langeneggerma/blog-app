package ch.langenegger;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Blog {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String content;

    public Blog(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Blog() {

    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
