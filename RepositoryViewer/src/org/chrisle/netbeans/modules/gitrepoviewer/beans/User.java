package org.chrisle.netbeans.modules.gitrepoviewer.beans;

/**
 *
 * @author Chris
 */
public class User {
    private final String _userName;
    private final String _authToken;

    public User(String userName, String authToken) {
        this._userName = userName;
        this._authToken = authToken;
    }

    public String getUserName() {
        return this._userName;
    }

    public String getAuthToken() {
        return this._authToken;
    }
}