package org.chrisle.netbeans.modules.gitrepoviewer.repositories;

import org.chrisle.netbeans.modules.gitrepoviewer.beans.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chrl
 */
public class UserRepositoryTest {
    private UserRepository _instance;
    
    public UserRepositoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        String host = "Github";
        _instance = new UserRepository();
        _instance.setSelectedHost(host);
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
//        UserRepository instance = new UserRepository();
        String expResult = "TapferMaaaan";
        User result = _instance.getUser();
        
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
