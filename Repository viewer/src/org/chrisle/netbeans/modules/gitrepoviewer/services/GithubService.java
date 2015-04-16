package org.chrisle.netbeans.modules.gitrepoviewer.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.chrisle.netbeans.modules.gitrepoviewer.beans.Github;
import org.chrisle.netbeans.modules.gitrepoviewer.beans.User;
import org.chrisle.netbeans.modules.gitrepoviewer.components.ErrorDialog;
import org.chrisle.netbeans.modules.gitrepoviewer.nodes.IRepository;
import org.chrisle.netbeans.modules.gitrepoviewer.nodes.Repository;
import org.eclipse.egit.github.core.IRepositoryIdProvider;
import org.eclipse.egit.github.core.RepositoryBranch;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.RepositoryService;
/**
 *
 * @author Chris
 */
public class GithubService extends HostService<Github> {
    private final User _user;
    private final GitHubClient _client;
    private final RepositoryService _repoService;

    public GithubService(User user) {
        super(user);

        this._user = user;
        
        _client = new GitHubClient();
        _repoService = new RepositoryService();
    }

//    @Override
//    public void setUserCredentials(String userName, String token) {
//        _client.setOAuth2Token(token);
//
//        UserService user = new UserService(_client);
//        try {
//            User userClient = user.getUser();
//            String login = userClient.getLogin();
//
//            if (!login.equals(userName)) {
//                throw new IOException("Your credentials are wrong.");
//            }
//
//            super.saveUserCredentials(login, token);
//        } catch (IOException ex) {
//            _errorDialog.setErrorMessage(ex.getMessage());
//            _errorDialog.setVisible(true);
//        }
//    }

    @Override
    public List<IRepository> getRepositories(String userName) {
        try {
            final ArrayList<IRepository> arrayList = new ArrayList<>();

            arrayList.add(new Repository("Repo1"));
            arrayList.add(new Repository("Repo2"));
            arrayList.add(new Repository("Repo3"));
            arrayList.add(new Repository("Repo4"));

            return arrayList;
//            return (List<IRepository>)(IRepository)_repoService.getRepositories(userName);
//        } catch (IOException ex) {
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public List<RepositoryBranch> getBranches(IRepositoryIdProvider repositoryId) {
        try {
            return _repoService.getBranches(repositoryId);
        } catch (IOException ex) {
            return null;
        }
    }

    @Override
    public List<String> getTags() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public String getHostName() {
//        return _user.getUserName();
//    }
//
//    @Override
//    public String getHostIcon() {
//        return "org/chrisle/gitrepoviewer/resources/github.png";
//    }
}