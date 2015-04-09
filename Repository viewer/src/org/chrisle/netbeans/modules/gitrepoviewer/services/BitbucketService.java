package org.chrisle.netbeans.modules.gitrepoviewer.services;

import java.util.List;
import org.chrisle.netbeans.modules.gitrepoviewer.beans.Bitbucket;
import org.chrisle.netbeans.modules.gitrepoviewer.beans.User;
import org.chrisle.netbeans.modules.gitrepoviewer.nodes.IRepository;
import org.eclipse.egit.github.core.IRepositoryIdProvider;
import org.eclipse.egit.github.core.RepositoryBranch;

/**
 *
 * @author chrl
 */
public class BitbucketService extends HostService<Bitbucket> {
    private final User _user;

    public BitbucketService(User user) {
        super(user);
        this._user = user;
    }

    @Override
    public List<IRepository> getRepositories(String userName) {
        return null;
    }

    @Override
    public List<RepositoryBranch> getBranches(IRepositoryIdProvider repositoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
//        return "org/chrisle/gitrepoviewer/resources/bitbucket.png";
//    }
}
