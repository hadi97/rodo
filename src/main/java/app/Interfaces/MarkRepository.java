package app.Interfaces;
import app.modules.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MarkRepository extends JpaRepository<Mark,Integer> {

}
