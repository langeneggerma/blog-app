package ch.langenegger.blog.control;

import java.util.List;

import ch.langenegger.blog.entity.Blog;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.jboss.logging.Logger;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

@Dependent
public class BlogService {
    @Inject
    BlogRepository blogRepository;

    @Inject
    Logger logger;

    public List<Blog> getBlogs() {
        var blogs = blogRepository.listAll();
        logger.info("Returning " + blogs.size() + " blogs");
        return blogs;
    }

    public List<Blog> findBlogs(String searchString) {
        var blogs = blogRepository.find("title like ?1 or content like ?1", "%" + searchString + "%");
        logger.info("Returning " + blogs.count() + " blogs");
        return blogs.list();
    }

    public Blog getBlog(Long id) {
        var blog = blogRepository.findById(id);
        if (blog == null) {
            logger.info("Blog with id " + id + " not found");
            throw new NotFoundException();
        }
        logger.info("Returning blog " + blog.getTitle());
        return blog;
    }

    @Transactional
    public void addBlog(Blog blog) {
        logger.info("Adding blog " + blog.getTitle());
        blogRepository.persist(blog);
    }

    @Transactional
    public void deleteBlog(Blog blog) {
        logger.info("Deleting blog " + blog.getTitle());
        blogRepository.delete(blog);
    }

}
