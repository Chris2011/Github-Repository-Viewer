package org.chrisle.gitrepoviewer.hosts;

import java.util.ArrayList;
import java.util.List;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;

/**
 *
 * @author chrl
 */
public class Github implements IHost {
    private String _hostName;

    public Github(String _hostName) {
        this._hostName = _hostName;
    }

    
    // TODO: Change with Github API

    @Override
    public List<String> getRepositories() {
        return new ArrayList<String>() {{
            add("Repo1");
            add("Repo2");
            add("Repo3");
        }};
    }

    @Override
    public List<String> getBranches() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getTags() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean isPrivate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getHostName() {
        return _hostName;
    }

    @Override
    public String getHostIcon() {
        return "org/chrisle/gitrepoviewer/resources/github.png";
    }
}