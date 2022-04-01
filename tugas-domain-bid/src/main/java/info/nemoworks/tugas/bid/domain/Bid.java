package info.nemoworks.tugas.bid.domain;

import info.nemoworks.tugas.framework.entity.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Bid extends Entity {

    private String creator;

    private String title;

    private Content content;

    private List<Addon> addons = new ArrayList<>();

    private boolean approved;

    private boolean closed;

}