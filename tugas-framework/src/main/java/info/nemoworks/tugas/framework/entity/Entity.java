package info.nemoworks.tugas.framework.entity;

import lombok.Getter;

import java.util.UUID;

public class Entity {

    @Getter
    private final String id = UUID.randomUUID().toString();
}
