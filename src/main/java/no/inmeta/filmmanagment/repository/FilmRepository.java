package no.inmeta.filmmanagment.repository;

import no.inmeta.filmmanagment.model.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.sql.Date;
import java.util.List;

@RepositoryRestResource
public interface FilmRepository extends PagingAndSortingRepository<Film, Integer> {

  List<Film> findByFilmId(@Param("filmId") Integer filmId);

  List<Film> findAllByReleaseYear(@Param("release_year") Date releaseYear);

  List<Film> findFilmByLengthGreaterThanEqual(@Param("filmLength") Integer filmLength);

  List<Film> findFilmByRentalRateBetween(@Param("rental_Rate_from") float rentalRateFrom, @Param("rental_rate_to") float rentalRateTo);

}