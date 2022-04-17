package info.nemoworks.tugas.bid.domain;

import info.nemoworks.tugas.framework.service.AbstractChart;
import org.apache.commons.scxml2.model.EnterableState;
import org.apache.commons.scxml2.model.ModelException;

import java.util.function.BiConsumer;

public class BidChart extends AbstractChart<Bid> {

    private static final String SCXML_MODEL = "scxml/bidchart.xml";

    public BidChart(Bid bid, BiConsumer<EnterableState, Bid> stateConsumer) throws ModelException {
        super(Bid.class.getClassLoader().getResource(SCXML_MODEL), stateConsumer, bid);
    }

}