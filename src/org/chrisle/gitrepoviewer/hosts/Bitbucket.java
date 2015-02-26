package org.chrisle.gitrepoviewer.hosts;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chrl
 */
public class Bitbucket implements IHost {
    private String _hostName;

    public Bitbucket(String hostName) {
        _hostName = hostName;
    }

    @Override
    public List<String> getRepositories() {
        return null;
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
        return "org/chrisle/gitrepoviewer/resources/bitbucket.png";
    }
}
