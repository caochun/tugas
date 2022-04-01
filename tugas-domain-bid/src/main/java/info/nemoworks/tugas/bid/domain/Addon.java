package info.nemoworks.tugas.bid.domain;

import lombok.*;

import java.time.Instant;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Addon {

    private final Instant timestamp = Instant.now();

    @NonNull
    private String bidId;

    @NonNull
    private String message;

    private String author;

}
