package org.chrisle.netbeans.modules.gitrepoviewer.service;

/**
 *
 * @author chrl
 */
import org.chrisle.netbeans.modules.gitrepoviewer.hosts.HostBase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;

public class GitRepoChildFactory extends ChildFactory<HostBase> {

    private ChangeListener listener;

    protected void addNotify() {
        HostNotifier.addChangeListener(listener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ev) {
                refresh(true);
            }
        });
    }

    protected void removeNotify() {
        if (listener != null) {
            HostNotifier.removeChangeListener(listener);
            listener = null;
        }
    }

    protected Node createNodeForKey(String key) {
        return new HostNode(key);
    }

//    @Override
//    protected boolean createKeys(List<String> toPopulate) {
//        List<String> keys = new ArrayList<>();
//
//        Set<Object> test = new HashSet<>();
//        test.add("1");
//        test.add("2");
//        test.add("3");
//        test.add("4");
//
//        for (Object prop : test) {
//            keys.add((String) prop);
//        }
//
//        Collections.sort(keys);
//        toPopulate.addAll(keys);
//
//        return true;
//    }

    @Override
    protected boolean createKeys(List<HostBase> list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}