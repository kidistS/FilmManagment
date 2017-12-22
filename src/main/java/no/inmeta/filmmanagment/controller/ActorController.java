/*
package no.inmeta.filmmanagment.controller;

import no.inmeta.filmmanagment.model.Actor;
import no.inmeta.filmmanagment.repository.ActorRepository;
import no.inmeta.filmmanagment.resource.ActorResource;
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
@RequestMapping(value = "/actor", produces = "application/hal+json")
public class ActorController {

    final ActorRepository actorRepository;

    public ActorController(final ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @GetMapping
    public ResponseEntity<Resources<ActorResource>> all(){

        final List<ActorResource> collection = actorRepository.findAll().stream().map(ActorResource::new).collect(Collectors.toList());
        final Resources<ActorResource> resources = new Resources<>(collection);
        final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        resources.add(new Link(uriString, "self"));

        return ResponseEntity.ok(resources);
    }

    // Accessing Actor by actorId
    @GetMapping("/{actorId}")
    public ResponseEntity<ActorResource> get(@PathVariable final Integer actorId){

        return actorRepository
                .findById(actorId)
                .map(p->ResponseEntity.ok(new FilmResource(p)))
                .orElseThrow(()-> new ActorNotFoundException(actorId));
    }

    // Create a new Actor data
    @PostMapping
    public ResponseEntity<ActorResource> post(@RequestBody Actor actorFromRequest){

        final Actor actor = new Actor(actorFromRequest);
        actorRepository.save(actor);
        final URI uri = MvcUriComponentsBuilder.fromController(getClass())
                .path("/{actorId")
                .buildAndExpand(actor.getActorId())
                .toUri();

        return  ResponseEntity.created(uri).body(new ActorResource(actor));
    }

    // Update the Film data
    @PutMapping("/{actorId}")
    public ResponseEntity<ActorResource> put(@PathVariable ("actorId") final Integer actorId, @RequestBody Actor actorFromRequest){

        final Actor actor = new Actor(actorFromRequest);
        actorRepository.save(actor);
        final ActorResource resource = new ActorResource(actor);
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

        return ResponseEntity.created(uri).body(resource);
    }
}

*/