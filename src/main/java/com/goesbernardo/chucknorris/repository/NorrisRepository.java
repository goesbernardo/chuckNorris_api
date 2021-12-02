package com.goesbernardo.chucknorris.repository;

import com.goesbernardo.chucknorris.model.Norris;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NorrisRepository extends JpaRepository<Norris,Long> {
}
