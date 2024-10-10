package ru.education.spring.course.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import ru.education.spring.course.models.Notation;

@Component
public class NotationDAO {
    private List<Notation> notation = new ArrayList();
    private static int ID_COUNT;

    public NotationDAO() {
        this.notation.add(new Notation(++ID_COUNT, "Notation1", "12:00"));
        this.notation.add(new Notation(++ID_COUNT, "Notation2", "13:00"));
        this.notation.add(new Notation(++ID_COUNT, "Notation3", "14:00"));
        this.notation.add(new Notation(++ID_COUNT, "Notation4", "15:00"));
        this.notation.add(new Notation(++ID_COUNT, "Notation5", "16:00"));
        this.notation.add(new Notation(++ID_COUNT, "Notation6", "17:00"));
    }

    public List<Notation> index() {
        return this.notation;
    }

    public Notation show(int id) {
        return this.notation.stream()
                .filter(n -> n.getId() == id)
                .findFirst()
                .orElse(null);  // Метод orElse вернет либо найденный объект, либо null
    }


    public void save(Notation notation) {
        notation.setId(++ID_COUNT);
        this.notation.add(notation);
    }

    public void update(int id, Notation updatedNotation) {
        Notation notationToBeUpdated = this.show(id);
        notationToBeUpdated.setDescription(updatedNotation.getDescription());
        notationToBeUpdated.setTime(updatedNotation.getTime());
    }

    public void delete(int id) {
        this.notation.removeIf((n) -> {
            return n.getId() == id;
        });
    }
}
