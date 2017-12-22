/*
package no.inmeta.filmmanagment.resource;

import no.inmeta.filmmanagment.controller.ActorController;
import no.inmeta.filmmanagment.model.Actor;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class ActorResource extends ResourceSupport {

    private final Actor actor;

    public ActorResource(final Actor actor){

        this.actor = actor;
        final Integer actorId = actor.getActorId();

        add(linkTo(ActorController.class).withRel("actor"));
        add(linkTo(methodOn(ActorController.class).all()).withRel("memberships"));
        add(linkTo(methodOn(ActorController.class).get(actorId)).withSelfRel());
    }

}

*/