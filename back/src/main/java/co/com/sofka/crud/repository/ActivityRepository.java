package co.com.sofka.crud.repository;

import co.com.sofka.crud.model.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity,Long> {
}
