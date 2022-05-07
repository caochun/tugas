package info.nemoworks.tugas.framework.domain;

import info.nemoworks.tugas.framework.boundary.Command;
import info.nemoworks.tugas.framework.boundary.Query;

import java.util.List;

public interface QCRService<T extends Aggregate> {

    public List<Query<T>> queries();

    public List<Command<T>> commands();

    public Query<T> present(String state);

    public void handle(Command<T> command, String state);

}
