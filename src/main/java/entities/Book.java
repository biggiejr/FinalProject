package entities;

import java.util.ArrayList;
import java.util.List;

public class Book
{
    Integer id;
    String title;
    String author;
    String language;
    private List<City> cities = new ArrayList<City>();

    public Book() {
    }

    public Book(Integer id, String title, String author, String language)
    {
        this.id=id;
        this.title=title;
        this.author=author;
        this.language=language;
    }
    public Book(int id)
    {
        this.id=id;
    }

    public void addCity(City city)
    {
        if (!cities.contains(city)) cities.add(city);
    }

    public void setTitle(String title)
    {
        this.title=title;
    }

    public void setAuthor(String author)
    {
        this.author=author;
    }

    public void setLanguage(String language)
    {
        this.language=language;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getLanguage() {
        return language;
    }

    public List<City> getCities() {
        return cities;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", language=" + language + ", cities="
                + "("+citiesToString()+")" + "]";
    }

    public String citiesToString()
    {
        String container="";
        for (int i=0;i<cities.size();i++) container+=", "+cities.get(i);
        return container;
    }

//	public String toString()
//	{
//		return author;
//
//	}



}