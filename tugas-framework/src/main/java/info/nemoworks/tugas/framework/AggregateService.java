package info.nemoworks.tugas.framework;

import info.nemoworks.tugas.framework.boundary.Command;
import info.nemoworks.tugas.framework.boundary.Query;
import info.nemoworks.tugas.framework.domain.Aggregate;

import java.util.List;

public interface AggregateService<T extends Aggregate> {

    public List<T> handleQuery(Query<T> query);

    public void handleCommand(Command<T> command);

}
