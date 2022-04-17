package info.nemoworks.tugas.framework.boundary;

import info.nemoworks.tugas.framework.domain.Entity;
import lombok.Getter;
import lombok.NonNull;

public class Query<T extends Entity> {

    @Getter
    private T source;

    public Query(@NonNull T source) {
        this.source = source;
    }
}