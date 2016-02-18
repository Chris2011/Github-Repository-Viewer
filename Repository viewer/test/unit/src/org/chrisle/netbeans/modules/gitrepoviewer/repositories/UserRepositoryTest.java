package org.chrisle.netbeans.modules.gitrepoviewer.repositories;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
        
        File tempFile = testFolder.newFile(this._selectedHost + this._filePrefix);
        
        this._fileReader = new FileReader(testFolder.getRoot().getPath() + "\\" + tempFile.getName());
        this._userRepo = new UserRepository(this._gsonProvider, this._fileReader);
    }

    /**
     * Test of getUser method, of class UserRepository.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        
        String expResult = "ChrisLE";
        
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
        System.out.println("saveUser");
        
        String userName = "ChrisTest";
        String authToken = "te8t9se9tst7etzts8e";
        User user = new User(userName, authToken);
        
        this._userRepo.setSelectedHost("Github2");
        
        Mockito.when(this._gsonProvider.toJson(user)).thenReturn("{\"_userName\":\"" + userName + "\",\"_authToken\":\"" + authToken + "\"}");
        _userRepo.saveUser(user);
        
        File tempFile = testFolder.newFile(this._userRepo.getSelectedHost() + this._filePrefix);

        this._fileReader = new FileReader(testFolder.getRoot().getPath() + "\\" + tempFile.getName());
        this._userRepo = new UserRepository(this._gsonProvider, this._fileReader);

        Mockito.when(this._gsonProvider.fromJson(this._fileReader, User.class)).thenReturn(user);
        User result = this._userRepo.getUser();
        
        assertEquals(userName, result.getUserName());
        assertEquals(authToken, result.getAuthToken());
    }
}