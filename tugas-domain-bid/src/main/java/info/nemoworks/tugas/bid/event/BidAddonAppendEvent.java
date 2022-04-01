package info.nemoworks.tugas.bid.event;

import info.nemoworks.tugas.bid.domain.Addon;

public class BidAddonAppendEvent extends Event {

    private Addon addon;

    public BidAddonAppendEvent(Addon addon) {
        super("BidAddonAppendEvent");
        this.addon = addon;
    }
}
