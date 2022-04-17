package info.nemoworks.tugas.framework.boundary;

import info.nemoworks.tugas.framework.domain.Entity;
import lombok.Getter;
import lombok.NonNull;

public abstract class Command<T extends Entity> {

    @Getter
    private T target;

    public Command(@NonNull T target) {
        this.target = target;
    }
}
