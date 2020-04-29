package com.cognizant.moviecruiser.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;


public class MovieServiceTest {
	static {
		System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "debug");
	}
	private static MovieService movieService;
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceTest.class);
    public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	movieService=context.getBean(MovieService.class);
	testfindByAdmin();
	testfindByHasTeaserTrueForCustomer();
	testfindByActiveTrueAndDateOfLaunchBefore();
	testModifyMovieById();
}
    
    public static void testfindByAdmin() {
    	LOGGER.info("Start");
    	List<Movie> movies=movieService.findAll();
    	LOGGER.debug("Movies{}",movies);
		LOGGER.info("end");
    }
    public static void testfindByHasTeaserTrueForCustomer() {
    	LOGGER.info("Start");
    	List<Movie> movies=movieService.findByHasTeaserTrueForCustomer();
    	LOGGER.debug("Movies{}",movies);
		LOGGER.info("end");
    }
    public static void testfindByActiveTrueAndDateOfLaunchBefore() {
    	LOGGER.info("Start");
    	List<Movie> movies=movieService.findByActiveTrueAndDateOfLaunchBefore(DateUtil.convertToDate("04/29/2020"));
    	LOGGER.debug("Movies{}",movies);
		LOGGER.info("end");
    }
    public static void testModifyMovieById() {
    	LOGGER.info("Start");
    	Movie movie=new Movie();
    	movie.setGenre("fiction");
    	movie.setBoxOffice("$ 1.23854");
    	movieService.modifyMovieById(1,movie);
    	List<Movie> movies=movieService.findAll();
    	
    	LOGGER.debug("Movies{}",movies);
		LOGGER.info("end");
    }
    
}
