package info.nemoworks.tugas.framework.boundary;

import info.nemoworks.tugas.framework.domain.Aggregate;
import lombok.Getter;
import lombok.NonNull;

public abstract class Command<T extends Aggregate> {

    @Getter
    private T target;

    public Command(@NonNull T target) {
        this.target = target;
    }
}
