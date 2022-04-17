package info.nemoworks.tugas.framework.domain;

import info.nemoworks.tugas.framework.boundary.Command;
import info.nemoworks.tugas.framework.boundary.Query;

import java.util.List;

public interface Service<T extends Entity> {

    public List<String> states();

    public Query<T> present(String state);

    public void handle(Command<T> command, String state);

}
