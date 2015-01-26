package ec.edu.epn.software.configuraciones;

import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.apache.log4j.Logger;

public class SessionSerializationPhaseListener implements PhaseListener {

    private static Logger log = Logger.getLogger(SessionSerializationPhaseListener.class);

    public SessionSerializationPhaseListener() {
    }

    private void serialSession() {
        log.debug("Serializando una session web.");
        final FacesContext facesContext = FacesContext.getCurrentInstance();
        final Map sessionMap = facesContext.getExternalContext().getSessionMap();
        sessionMap.put("forceGaeSessionSerialization", System.currentTimeMillis());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

    @Override
    public void afterPhase(PhaseEvent event) {
        if (event.getPhaseId().equals(PhaseId.RENDER_RESPONSE)
                || event.getPhaseId().equals(PhaseId.INVOKE_APPLICATION)
                || (event.getPhaseId().equals(PhaseId.APPLY_REQUEST_VALUES)
                && event.getFacesContext().getResponseComplete())) {
            serialSession();
        }
    }

    @Override
    public void beforePhase(PhaseEvent pe) {
    }
}
