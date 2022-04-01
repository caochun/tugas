package info.nemoworks.tugas.bid.boundary.command;

import info.nemoworks.tugas.bid.domain.Bid;
import lombok.Getter;
import lombok.NonNull;

public class CreateCommand extends BidCommand {

    @Getter
    @NonNull
    private String title;

    @Getter
    private String creator;

    public CreateCommand(@NonNull Bid target, @NonNull String title, String creator) {
        super(target);
        this.title = title;
        this.creator = creator;
    }
}
