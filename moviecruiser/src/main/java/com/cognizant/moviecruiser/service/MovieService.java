package com.cognizant.moviecruiser.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.repository.MovieRepository;

@Service("movieService")
public class MovieService {
	/*@Autowired
     private MovieDao movieDao;*/
	@Autowired
	private MovieRepository movieRepository;

	/*public MovieDao getMovieDao() {
		return movieDao;
	}

	public void setMovieDao(MovieDao movieDao) {
		this.movieDao = movieDao;
	}
	@Transactional
	public List<Movie> getMovieListAdmin(){
		return movieDao.getMovieListAdmin();
		
	}
	public List<Movie> getMovieListCustomer(){
		return movieDao.getMovieListCustomer();
	}
	public Movie getMovie(long movieId) {
		return movieDao.getMovie(movieId);
		
	}
	public void modifyMovie(Movie movie) {
		movieDao.modifyMovie(movie);
	}*/
	
	/*  List of movies displayed for Admin*/
	@Transactional
	public List<Movie> findAll(){
		return movieRepository.findAll();
	}
	/*  List of movies displayed for Customer*/
	@Transactional
	public List<Movie> findByHasTeaserTrueForCustomer(){
		return movieRepository.findByHasTeaserTrue();
	}
	/*  List of movies displayed for customer*/
	@Transactional
	public List<Movie> findByActiveTrueAndDateOfLaunchBefore(Date dateOfLaunch){
		return movieRepository.findByActiveTrueAndDateOfLaunchBefore(dateOfLaunch);
	}
	@Transactional
	public void modifyMovieById(int id,Movie movie){
		Optional<Movie> findById = movieRepository.findById(id);
		if( findById.isPresent()) {
			Movie movie2 = findById.get();
			movie2.setGenre(movie.getGenre());
			movie2.setBoxOffice(movie.getBoxOffice());
			movieRepository.save(movie2);
		}
		
	}
}
