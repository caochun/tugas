package info.nemoworks.tugas.framework.boundary;

import info.nemoworks.tugas.framework.domain.Aggregate;
import lombok.Data;

@Data
public class Boundary<T extends Aggregate> {
    private Command<T> command;
    private Query<T> query;
}
