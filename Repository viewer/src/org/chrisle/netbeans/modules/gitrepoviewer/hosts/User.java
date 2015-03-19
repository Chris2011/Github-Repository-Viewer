package org.chrisle.netbeans.modules.gitrepoviewer.hosts;

/**
 *
 * @author Chris
 */
public class User {
    private final String _userName;
    private final String _authToken;

    public User(String userName, String authToken) {
        _userName = userName;
        _authToken = authToken;
    }

    public String getUserName() {
        return _userName;
    }

    public String getAuthToken() {
        return _authToken;
    }
}