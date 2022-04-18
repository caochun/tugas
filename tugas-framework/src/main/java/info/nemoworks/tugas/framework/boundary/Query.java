package info.nemoworks.tugas.framework.boundary;

import info.nemoworks.tugas.framework.domain.Aggregate;
import lombok.Getter;
import lombok.NonNull;

public class Query<T extends Aggregate> {

    @Getter
    private T source;

    public Query(@NonNull T source) {
        this.source = source;
    }
}