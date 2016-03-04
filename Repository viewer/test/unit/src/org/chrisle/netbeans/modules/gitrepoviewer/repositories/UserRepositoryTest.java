package org.chrisle.netbeans.modules.gitrepoviewer.repositories;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.chrisle.netbeans.modules.gitrepoviewer.beans.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.junit.Assert.assertEquals;
import org.junit.Ignore;

/**
 *
 * @author chrl
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({
    Gson.class
})
public class UserRepositoryTest {
    private UserRepository _userRepo;
    private final Gson _gsonProvider = PowerMockito.mock(Gson.class);

    private String _selectedHost;
    private String _dirName;
    private String _filePrefix;
    
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();
    
    public Reader _fileReader;

    @Before
    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
        this._selectedHost = "Github";
        this._filePrefix = "User.json";
    }

    /**
     * Test of getUser method, of class UserRepository.
     * @throws java.io.IOException
     */
//    @Ignore
    @Test
    public void testGetUser() throws IOException {
        System.out.println("getUser");
        
        String expResult = "ChrisLE";
        File tempFile = testFolder.newFile(this._selectedHost + this._filePrefix);
        
        this._dirName = testFolder.getRoot().getPath();
        this._fileReader = new FileReader(testFolder.getRoot().getPath() + "\\" + tempFile.getName());
        this._userRepo = new UserRepository(this._gsonProvider, this._fileReader, this._dirName);
        this._userRepo.setSelectedHost(this._selectedHost);

        Mockito.when(this._gsonProvider.fromJson(_fileReader, User.class)).thenReturn(new User("ChrisLE", "MyToken"));
        User result = this._userRepo.getUser();
        
        assertEquals(expResult, result.getUserName());
    }
    
    /**
     * Test of getUser method, of class UserRepository.
     * @throws java.io.FileNotFoundException
     */
//    @Ignore
    @Test(expected = FileNotFoundException.class)
    public void testGetUserFileNotFound() throws FileNotFoundException {
        System.out.println("getUserFileNotFound");
        
        Mockito.when(this._gsonProvider.fromJson(new FileReader("Foooooooooooooooo.json"), User.class)).thenReturn(new User("ChrisLE", "MyToken"));
        User result = this._userRepo.getUser();
    }

    /**
     * Test of saveUser method, of class UserRepository.
     * @throws java.lang.Exception
     */
    @Test
    public void testSaveUser() throws Exception {
        // Save user:
        System.out.println("saveUser");
        
        String userName = "ChrisTest";
        String authToken = "te8t9se9tst7etzts8";
        User user = new User(userName, authToken);
        File tempFile = testFolder.newFile(this._selectedHost + this._filePrefix);
        
        this._dirName = testFolder.getRoot().getPath();
        this._fileReader = new FileReader(testFolder.getRoot().getPath() + "\\" + tempFile.getName());
        this._userRepo = new UserRepository(this._gsonProvider, this._fileReader, this._dirName);
        this._userRepo.setSelectedHost("Github");
                
        Mockito.when(this._gsonProvider.toJson(user)).thenReturn("{\"_userName\":\"" + userName + "\",\"_authToken\":\"" + authToken + "\"}");
        _userRepo.saveUser(user);

        
        // Get user:
        this._userRepo = new UserRepository(this._gsonProvider, this._fileReader, this._dirName);
        
        User newUser = new User("ChrisTest", "te8t9se9tst7etzts8");

        Mockito.when(this._gsonProvider.fromJson(this._fileReader, User.class)).thenReturn(newUser);
        User result = this._userRepo.getUser();
        
        assertEquals(userName, result.getUserName());
        assertEquals(authToken, result.getAuthToken());
    }
}