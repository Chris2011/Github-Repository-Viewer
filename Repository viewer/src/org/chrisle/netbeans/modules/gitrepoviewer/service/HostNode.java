package org.chrisle.netbeans.modules.gitrepoviewer.service;

/**
 *
 * @author chrl
 */
import java.io.IOException;
import javax.swing.Action;
import javax.swing.event.ChangeListener;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.NbBundle.Messages;

public class HostNode extends AbstractNode {

    private String key;
    private ChangeListener listener;

    @Messages("HINT_HostNode=Represents a git repository.")
    public HostNode(String key) {
        super(Children.LEAF);
        this.key = key;
//        setIconBaseWithExtension("org/myorg/systemproperties/onePropIcon.gif");
        super.setName(key);
        setShortDescription(Bundle.HINT_HostNode());
    }

    @Override
    public Action[] getActions(boolean context) {
        Action[] result = new Action[]{
            new RemoveHostAction()
        };

        return result;
    }

//    @Override
//    public Action getPreferredAction() {
//        return SystemAction.get(PropertiesAction.class);
//    }
//
//    @Override
//    public Node cloneNode() {
//        return new HostNode(key);
//    }

//    @Messages({"PROP_value=Value","HINT_value=Value of this system property."})
//    @Override
//    protected Sheet createSheet() {
//        Sheet sheet = super.createSheet();
//        Sheet.Set props = sheet.get(Sheet.PROPERTIES);
//        if (props == null) {
//            props = Sheet.createPropertiesSet();
//            sheet.put(props);
//        }
//        props.put(new PropertySupport.Name(this));
//        class ValueProp extends PropertySupport.ReadWrite {
//            public ValueProp() {
//                super("value", String.class, Bundle.PROP_value(), Bundle.HINT_value());
//            }
//            @Override
//            public Object getValue() {
//                return System.getProperty(key);
//            }
//            @Override
//            public void setValue(Object nue) {
//                System.setProperty(key, (String) nue);
//                HostNotifier.changed();
//            }
//        }
//        props.put(new ValueProp());
//        HostNotifier.addChangeListener(listener = new ChangeListener() {
//            @Override
//            public void stateChanged(ChangeEvent ev) {
//                firePropertyChange("value", null, null);
//            }
//        });
//        return sheet;
//    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if (listener != null) {
            HostNotifier.removeChangeListener(listener);
        }
    }

    @Override
    public boolean canDestroy() {
        return true;
    }

    @Override
    public void destroy() throws IOException {
//        Properties
//        List<Host> hosts = HostBaseHosts();
//        hosts.remove(key);
//        HostBase.setHosts(hosts);
//        HostNotifier.changed();
    }
    
}