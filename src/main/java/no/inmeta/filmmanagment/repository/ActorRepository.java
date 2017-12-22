package no.inmeta.filmmanagment.repository;

import no.inmeta.filmmanagment.model.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.List;

@RepositoryRestResource
public interface ActorRepository extends CrudRepository <Actor , Integer>, PagingAndSortingRepository<Actor, Integer> {

    Actor findByActorId(@Param("actor_id") Integer actorId);

    List<Actor> findByLastNameLike(@Param("name_like") String name);

    List<Actor> getActorByLastNameEquals(@Param("last_name") String lastName);

    List<Actor> getActorsByLastNameContains(@Param("last_name_Contains") String lastName);

}
