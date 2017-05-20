package api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entities.Book;
import entities.City;
import interfaces.DbMapper;

@RestController
public class MapperController 
{
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private DbMapper mapper;

    @Autowired
    public MapperController(@Qualifier("sql") DbMapper mapper) 
    {
		this.mapper=mapper;
	}
    
    public void setMapper(DbMapper mapper)
    {
    	this.mapper=mapper;
    }
    
    @RequestMapping("/1")
    public List<Book> q1(@RequestParam(value="name", defaultValue="London") String name) throws Exception 
    {
        
    	return mapper.getBookByCity(name);
    }
    
    @RequestMapping("/2")
    public String q2(@RequestParam(value="name", defaultValue="World") String name) 
    {
        
    	return name;
    }
    
    @RequestMapping("/3")
    public String q3(@RequestParam(value="name", defaultValue="World") String name) 
    {
        
    	return name;
    }
    
    @RequestMapping("/4")
    public String q4(@RequestParam(value="name", defaultValue="World") String name) 
    {
        
    	return name;
    }

}
