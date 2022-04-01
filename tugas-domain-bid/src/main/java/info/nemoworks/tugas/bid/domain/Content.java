package info.nemoworks.tugas.bid.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Content {

    @NonNull
    private String content;
    private String editor;

}
