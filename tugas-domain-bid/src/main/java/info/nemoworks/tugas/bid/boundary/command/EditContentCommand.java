package info.nemoworks.tugas.bid.boundary.command;

import info.nemoworks.tugas.bid.domain.Bid;
import lombok.Getter;
import lombok.NonNull;

public class EditContentCommand extends BidCommand {

    @Getter
    @NonNull
    private String content;

    @Getter
    private String editor;

    public EditContentCommand(@NonNull Bid target, @NonNull String content, String editor) {
        super(target);
        this.content = content;
        this.editor = editor;
    }
}