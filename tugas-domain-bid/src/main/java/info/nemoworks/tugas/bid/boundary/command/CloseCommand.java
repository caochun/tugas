package info.nemoworks.tugas.bid.boundary.command;

import info.nemoworks.tugas.bid.domain.Bid;

public class CloseCommand extends BidCommand {
    private String closer;

    public CloseCommand(Bid bid, String closer) {
        super(bid);
        this.closer = closer;
    }
}