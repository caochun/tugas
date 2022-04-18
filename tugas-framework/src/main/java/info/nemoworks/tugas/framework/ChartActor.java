package info.nemoworks.tugas.framework;

import info.nemoworks.tugas.framework.boundary.Boundary;
import info.nemoworks.tugas.framework.boundary.Command;
import info.nemoworks.tugas.framework.domain.Aggregate;
import info.nemoworks.tugas.framework.message.Message;
import info.nemoworks.tugas.framework.message.MessageListener;
import info.nemoworks.tugas.framework.message.MessageStub;
import info.nemoworks.tugas.framework.chart.AbstractChart;
import org.apache.commons.scxml2.model.ModelException;

import java.net.URL;
import java.util.*;
import java.util.function.Consumer;

public abstract class ChartActor<T extends Aggregate> extends AbstractChart {

    private AggregateService<T> service;

    private MessageStub stub;

    public void setStub(MessageStub stub) {
        this.stub = stub;
    }

    public MessageStub getStub() {
        return this.stub;
    }

    public void pub(Message<?> message) {
        this.stub.pub(message);
    }


    public ChartActor(URL scxmlDocument) throws ModelException {
        super(scxmlDocument);
    }

    @Override
    public boolean fireEvent(String event) {
        return super.fireEvent(event);
    }

    @Override
    public boolean invoke(String state) {

        Boundary<T> boundary = this.getStateBoundary(state);
        if (boundary == null)
            return false;

        List<T> result = this.service.handleQuery(boundary.getQuery());

        if (result.size() > 0) {
            this.pub(new Message<>(this, result));
        }
        return true;
    }

    public Boundary<T> getStateBoundary(String state) {
        return this.stateBoundaries.get(state);
    }

    public List<Command<T>> allCommands() {
        Collection<Boundary<T>> boundaries = this.stateBoundaries.values();
        List<Command<T>> commands = new ArrayList<>();
        boundaries.forEach(b -> commands.add(b.getCommand()));
        return commands;
    }

    public void registerListener() {
        this.stub.register(new MessageListener((Consumer<Command<T>>) command -> {
            ChartActor.this.service.handleCommand(command);
            ChartActor.this.fireEvent(ChartActor.this.commandEvent.get(command));
        }));
    }

    // （This should be modelled in the chart later)
    // For each state, we assume a basic coordination:
    // a query is taken against the aggregate, the result is wrapped in a message and published
    // the receiver of the message returns a command for the aggregate which is mapped to an event and the chart goes on.
    private Map<String, Boundary<T>> stateBoundaries = new HashMap<>();
    private Map<Command, String> commandEvent = new HashMap<>();

}
