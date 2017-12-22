/*
package no.inmeta.filmmanagment.resource;

import no.inmeta.filmmanagment.controller.ActorController;
import no.inmeta.filmmanagment.controller.FilmController;
import no.inmeta.filmmanagment.model.Film;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


public class FilmResource extends ResourceSupport{

    private final Film film;

    public FilmResource(final Film film){

        this.film = film;
        final Integer filmId = film.getFilmId();
        add(linkTo(FilmController.class).withRel("film"));
        add(linkTo(methodOn(ActorController.class).all()).withRel("memberships"));
        add(linkTo(methodOn(FilmController.class).get(filmId)).withSelfRel());
    }

}

*/