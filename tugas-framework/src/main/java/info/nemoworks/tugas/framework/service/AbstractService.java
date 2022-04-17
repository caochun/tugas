package info.nemoworks.tugas.framework.service;

import info.nemoworks.tugas.framework.actor.Actor;
import info.nemoworks.tugas.framework.boundary.Command;
import info.nemoworks.tugas.framework.boundary.Query;
import info.nemoworks.tugas.framework.domain.Entity;
import info.nemoworks.tugas.framework.message.Message;
import org.apache.commons.scxml2.model.EnterableState;
import org.apache.commons.scxml2.model.ModelException;
import org.apache.commons.scxml2.model.Transition;
import org.apache.commons.scxml2.model.TransitionTarget;

import java.net.URL;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractService<T extends Entity> implements ChartListener {

    private AbstractChart chart;

    public Actor actor;

    public AbstractService(URL chartURL) throws ModelException {
        this.chart = new AbstractChart(chartURL);
    }

    public abstract Query<T> present(String state);

    @Override
    public void onEntry(EnterableState enterableState) {
        Logger.getLogger(this.getClass().getName()).info("Entering " + enterableState.getId());
        this.actor.pub(new Message<>(this, this.present(enterableState.getId())));
        Logger.getLogger(this.getClass().getName()).info("Query message sent");
    }

    @Override
    public void onExit(EnterableState enterableState) {
        Logger.getLogger(this.getClass().getName()).info("Exiting " + enterableState.getId());
    }

    @Override
    public void onTransition(TransitionTarget transitionTarget, TransitionTarget transitionTarget1, Transition transition, String s) {
        Logger.getLogger(this.getClass().getName()).info("Transiting from " + transitionTarget.getId() + " to " + transitionTarget1.getId());
    }

    public void registerCommandHandle(Command<T> command, Consumer<Command<T>> handler){

    }
}
