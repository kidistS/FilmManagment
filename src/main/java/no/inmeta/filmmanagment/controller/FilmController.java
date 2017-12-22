/*
package no.inmeta.filmmanagment.controller;
import no.inmeta.filmmanagment.model.Film;
import no.inmeta.filmmanagment.repository.FilmRepository;
import no.inmeta.filmmanagment.resource.FilmResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/film", produces = "application/hal+json")
public class FilmController {

    final FilmRepository filmRepository;

    public FilmController(final FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping
    public ResponseEntity<Resources<FilmResource>> all(){

        final List<FilmResource> collection = filmRepository.findAll().stream().map(FilmResource::new).collect(Collectors.toList());
        final Resources<FilmResource> resources = new Resources<>(collection);
        final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        resources.add(new Link(uriString, "self"));

        return ResponseEntity.ok(resources);
    }

    // Accessing film by filmId
    @GetMapping("/{filmId}")
    public ResponseEntity<FilmResource> get(@PathVariable final Integer filmId){

        return filmRepository
                .findById(filmId)
                .map(p -> ResponseEntity.ok(new FilmResource(p)))
                .orElseThrow(()-> new FilmNotFoundException(filmId));
    }

    // Create a new Film data
    @PostMapping
    public ResponseEntity<FilmResource> post(@RequestBody Film filmFromRequest){

        final Film film = new Film(filmFromRequest);
        filmRepository.save(film);
        final URI uri = MvcUriComponentsBuilder.fromController(getClass())
                        .path("/{filmId")
                        .buildAndExpand(film.getFilmId())
                        .toUri();

        return  ResponseEntity.created(uri).body(new FilmResource(film));
    }

    // Update the Film data
    @PutMapping("/{filmId}")
    public ResponseEntity<FilmResource> put(@PathVariable ("filmId") final Integer filmId, @RequestBody Film filmFromRequest){

        final Film film = new Film(filmFromRequest);
        filmRepository.save(film);
        final FilmResource resource = new FilmResource(film);
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

        return ResponseEntity.created(uri).body(resource);
    }

}

*/