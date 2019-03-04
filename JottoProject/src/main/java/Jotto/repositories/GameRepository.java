package Jotto.repositories;

import Jotto.domain.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Integer> {

    @Query(value = "select * from game a where a.username = :username", nativeQuery = true)
    List<Game> getMatchHistory(@Param("username") String username);

}