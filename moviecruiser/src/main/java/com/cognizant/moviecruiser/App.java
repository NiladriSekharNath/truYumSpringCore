package com.cognizant.moviecruiser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;
import com.cognizant.moviecruiser.util.DateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
	private static ApplicationContext ctx;
	
	 static MovieService movieService;
    public static void main( String[] args )
    {
    	ctx = new ClassPathXmlApplicationContext("spring-config.xml");
    	movieService=ctx.getBean(MovieService.class);
    	//System.out.println(movieService.getMovieListAdmin());
    	//System.out.println(movieService.getMovieListCustomer());
    	//System.out.println(movieService.getMovie(3));
    	Movie movie=new Movie(1,"3 idiots","4.0",false,DateUtil.convertToDate("02/2/1987"),"super-hero",false);
    	//movieService.modifyMovie(movie);
    	//System.out.println(movieService.getMovieListAdmin());
    }
}
