package api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entities.Book;
import entities.City;
import interfaces.DbMapper;

@RestController
public class MapperController 
{
    private final AtomicLong counter = new AtomicLong();
    private DbMapper mapper;

    @Autowired
    public MapperController(@Qualifier("neo4j") DbMapper mapper) 
    {
		this.mapper=mapper;
	}
    
    public void setMapper(DbMapper mapper)
    {
    	this.mapper=mapper;
    }
    
    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping("/1")
    public List<Book> q1(@RequestParam(value="cityName", defaultValue="London") String cityName) throws Exception 
    {
    	return mapper.getBookByCity(cityName);
    }
    
    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping("/2")
    public List<City> q2(@RequestParam(value="bookTitle") String bookTitle) throws Exception 
    {
    	return mapper.getMentionedCitiesByBook(bookTitle);
    }
    
    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping("/3")
    public ArrayList<Book> q3(@RequestParam(value="author") String author) 
    {
    	System.out.println("hey");
    	return mapper.getMentionedCitiesByAuthor(author);
    }
    
    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping("/4")
    public ArrayList<Book> q4(@RequestParam(value="latitude") Double latitude,@RequestParam(value="longitude") Double longitude) 
    {
        
    	return mapper.getAllBooksByCity(latitude, longitude);
    }

}
