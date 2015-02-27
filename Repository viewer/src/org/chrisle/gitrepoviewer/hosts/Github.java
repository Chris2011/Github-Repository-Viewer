package org.chrisle.gitrepoviewer.hosts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.openide.util.Exceptions;
/**
 *
 * @author chrl
 */
public class Github implements IHost {
    private String _hostName;
//    private String _userName;
//    private String _password;
    private GitHubClient _client;
    private RepositoryService _repoService;

    public Github(String hostName, String userName, String password) {
        this._hostName = hostName;
//        this._userName = userName;
//        this._password = password;
        
        _client = new GitHubClient();
        _client.setCredentials(userName, password);
        _repoService = new RepositoryService();
    }

    @Override
    public List<Repository> getRepositories() {
        try {
            return _repoService.getRepositories(_client.getUser());
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
            return null;
        }
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