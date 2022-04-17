package info.nemoworks.tugas.framework.boundary;

import info.nemoworks.tugas.framework.domain.Entity;
import lombok.Data;

@Data
public class Boundary<T extends Entity> {
    private Command<T> command;
    private Query<T> query;
}
