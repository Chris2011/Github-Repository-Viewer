package org.chrisle.gitrepoviewer.hosts;

import java.io.IOException;
import java.util.List;
import org.eclipse.egit.github.core.IRepositoryIdProvider;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryBranch;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.eclipse.egit.github.core.service.UserService;
import org.openide.util.Exceptions;
/**
 *
 * @author chrl
 */
public class Github implements IHost {
    private final String _hostName;
    private final GitHubClient _client;
    private final RepositoryService _repoService;

    public Github(String hostName) {
        this._hostName = hostName;
        
        _client = new GitHubClient();
        _repoService = new RepositoryService();
    }
    
    @Override
    public void setUserCredentials(String userName, String password) {
        _client.setCredentials(userName, password);
        
        UserService user = new UserService(_client);
        
        try {
            user.getUser();
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    @Override
    public void setToken(String token) {
        _client.setOAuth2Token(token);
        
        UserService user = new UserService(_client);
        
        try {
            user.getUser();
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    @Override
    public List<Repository> getRepositories(String userName) {
        try {
            return _repoService.getRepositories(userName);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
            return null;
        }
    }

    @Override
    public List<RepositoryBranch> getBranches(IRepositoryIdProvider repositoryId) {
        try {
            return _repoService.getBranches(repositoryId);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
            return null;
        }
    }

    @Override
    public List<String> getTags() {
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