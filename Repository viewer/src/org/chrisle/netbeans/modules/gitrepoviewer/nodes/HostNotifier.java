package org.chrisle.netbeans.modules.gitrepoviewer.nodes;

/**
 *
 * @author chrl
 */
import javax.swing.event.ChangeListener;
import org.openide.util.ChangeSupport;

public class HostNotifier {
    private static final ChangeSupport cs = new ChangeSupport(HostNotifier.class);

    public static void addChangeListener(ChangeListener listener) {
        cs.addChangeListener(listener);
    }

    public static void removeChangeListener(ChangeListener listener) {
        cs.removeChangeListener(listener);
    }

    public static void changed() {
        cs.fireChange();
    }
}