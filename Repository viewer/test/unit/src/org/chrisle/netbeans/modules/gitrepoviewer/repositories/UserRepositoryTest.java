package org.chrisle.netbeans.modules.gitrepoviewer.repositories;

import com.google.gson.Gson;
import java.io.FileReader;
import org.chrisle.netbeans.modules.gitrepoviewer.beans.User;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author chrl
 */
@RunWith(PowerMockRunner.class)
//@PrepareForTest({
//    UserRepository.class
//})
public class UserRepositoryTest {
    private UserRepository _userRepo;

//    @Mock
    private Gson _gsonProvider;

//    @Mock
    private FileReader _fileReader;
    private String _host;

    @Before
    public void setUp() {
        this._host = "Github";
        this._gsonProvider = PowerMockito.mock(Gson.class);
        this._fileReader = PowerMockito.mock(FileReader.class);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUser method, of class UserRepository.
     */
    @Test
    public void testGetUser() throws Exception {
        System.out.println("getUser");
        //        _userRepo.setSelectedHost(host);
        
        PowerMockito.whenNew(FileReader.class).withArguments("PathToFile.txt").thenReturn(this._fileReader);

        String expResult = "ChrisLE";

        PowerMockito.when(this._gsonProvider.fromJson(this._fileReader, User.class)).thenReturn(new User("ChrisLE", "MyToken"));

        this._userRepo = new UserRepository(_gsonProvider);
        User result = this._userRepo.getUser();
        
        assertEquals(expResult, result.getUserName());
    }

//    /**
//     * Test of saveUser method, of class UserRepository.
//     */
//    @Test
//    public void testSaveUser() throws Exception {
//        System.out.println("saveUser");
//        User user = null;
//        UserRepository instance = new UserRepository();
//        instance.saveUser(user);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
