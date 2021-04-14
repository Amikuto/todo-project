package uni.ami.todoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.ami.todoproject.model.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
}
