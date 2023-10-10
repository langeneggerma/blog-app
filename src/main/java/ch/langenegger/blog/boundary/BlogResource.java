package ch.langenegger.blog.boundary;

import ch.langenegger.blog.control.BlogService;
import ch.langenegger.blog.entity.Blog;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;


import java.util.List;

@Path("/blog")
@ApplicationScoped
public class BlogResource {

    @Inject
    BlogService blogService;


    @GET
    public List<Blog> getBlogs(@QueryParam("search") String search){
        if(search != null && !search.isBlank()){
            return blogService.findBlogs(search);
        }
        return blogService.getBlogs();
    }

    @GET
    @Path("/{id}")
    public Blog getBlog(Long id){
        return blogService.getBlog(id);
    }

    @POST
    public void addBlog(Blog blog){
        blogService.addBlog(blog);
    }

    @DELETE
    @Path("/{id}")
    public void deleteBlog(@PathParam("id") Long id){
        var blog =  blogService.getBlog(id);
        blogService.deleteBlog(blog);
    }
}
