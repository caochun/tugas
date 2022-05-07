package info.nemoworks.tugas.framework.domain;

import lombok.Getter;

import java.util.UUID;

public class Aggregate {

    @Getter
    private final String id = UUID.randomUUID().toString();
}
