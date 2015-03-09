package org.chrisle.gitrepoviewer.hosts;

import java.io.IOException;
import java.util.List;
import org.chrisle.gitrepoviewer.components.AddHostDialog;
import org.chrisle.gitrepoviewer.components.ErrorDialog;
import org.eclipse.egit.github.core.IRepositoryIdProvider;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryBranch;
import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.eclipse.egit.github.core.service.UserService;
/**
 *
 * @author chrl
 */
public class Github implements IHost {
    private final String _hostName;
    private final GitHubClient _client;
    private final RepositoryService _repoService;
    private final ErrorDialog _errorDialog;

    public Github(String hostName) {
         _errorDialog = new ErrorDialog(null, true);

        this._hostName = hostName;
        
        _client = new GitHubClient();
        _repoService = new RepositoryService();
    }

    @Override
    public void setToken(String userName, String token) {
        _client.setOAuth2Token(token);

        UserService user = new UserService(_client);
        try {
            User userClient = user.getUser();
            String login = userClient.getLogin();

            if (!login.equals(userName)) {
                throw new IOException("Your credentials are wrong.");
            }
        } catch (IOException ex) {
            _errorDialog.setErrorMessage(ex.getMessage());
            _errorDialog.setVisible(true);
        }
    }

    @Override
    public List<Repository> getRepositories(String userName) {
        try {
            return _repoService.getRepositories(userName);
        } catch (IOException ex) {
            _errorDialog.setErrorMessage(ex.getMessage());
            _errorDialog.setVisible(true);
            return null;
        }
    }

    @Override
    public List<RepositoryBranch> getBranches(IRepositoryIdProvider repositoryId) {
        try {
            return _repoService.getBranches(repositoryId);
        } catch (IOException ex) {
            _errorDialog.setErrorMessage(ex.getMessage());
            _errorDialog.setVisible(true);

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