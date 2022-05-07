package info.nemoworks.tugas.framework.chart;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.scxml2.Context;
import org.apache.commons.scxml2.Evaluator;
import org.apache.commons.scxml2.SCXMLExecutor;
import org.apache.commons.scxml2.TriggerEvent;
import org.apache.commons.scxml2.env.SimpleDispatcher;
import org.apache.commons.scxml2.env.SimpleErrorReporter;
import org.apache.commons.scxml2.env.jexl.JexlContext;
import org.apache.commons.scxml2.env.jexl.JexlEvaluator;
import org.apache.commons.scxml2.io.SCXMLReader;
import org.apache.commons.scxml2.model.ModelException;
import org.apache.commons.scxml2.model.SCXML;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.net.URL;

public abstract class AbstractChart {
    private SCXML stateMachine;
    private SCXMLExecutor engine;
    private Log log;


    public AbstractChart(URL scxmlDocument) throws ModelException {
        this((URL) scxmlDocument, new JexlContext(), new JexlEvaluator());
    }

    private AbstractChart(URL scxmlDocument, Context rootCtx, Evaluator evaluator) throws ModelException {
        this.log = LogFactory.getLog(this.getClass());

        try {
            this.stateMachine = SCXMLReader.read(scxmlDocument);
        } catch (IOException var5) {
            this.logError(var5);
        } catch (XMLStreamException var6) {
            this.logError(var6);
        } catch (ModelException var7) {
            this.logError(var7);
        }

        this.initialize(this.stateMachine, rootCtx, evaluator);
    }


    private void initialize(SCXML stateMachine, Context rootCtx, Evaluator evaluator) throws ModelException {
        this.engine = new SCXMLExecutor(evaluator, new SimpleDispatcher(), new SimpleErrorReporter());
        this.engine.setStateMachine(stateMachine);
        this.engine.setRootContext(rootCtx);
        try {
            this.engine.go();
        } catch (ModelException var5) {
            this.logError(var5);
        }
    }

    public boolean fireEvent(String event) {

        TriggerEvent[] events = new TriggerEvent[]{new TriggerEvent(event, 3)};

        try {
            this.engine.triggerEvents(events);
        } catch (ModelException var4) {
            this.logError(var4);
        }

        return this.engine.getCurrentStatus().isFinal();
    }

    public SCXMLExecutor getEngine() {
        return this.engine;
    }

    public Log getLog() {
        return this.log;
    }

    public void setLog(Log log) {
        this.log = log;
    }


    public boolean resetMachine() {
        try {
            this.engine.reset();
            return true;
        } catch (ModelException var2) {
            this.logError(var2);
            return false;
        }
    }

    protected void logError(Exception exception) {
        if (this.log.isErrorEnabled()) {
            this.log.error(exception.getMessage(), exception);
        }

    }

    public abstract boolean invoke(String state);


}
