package com.curso.ejercicio2;

import static junit.framework.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Unit test for {@link User}
 *
 */
public class UserTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private User user;
    private static final String EMAIL = "some email";
    private static final String USERNAME = "some username";
    private static final String EMAIL2 = "some other email";
    private static final String USERNAME2 = "some other username";
    private static final String NEW_PASSWORD = "some password";
    private static final String ROLE1_NAME = "role1";
    private static final String ROLE2_NAME = "role2";
    private static final Role ROLE1 = new Role(ROLE1_NAME);
    private static final Role ROLE2 = new Role(ROLE2_NAME);
    private static final String NAME = "some name";

    @Before
    public void setUp() {
        user = new User(USERNAME, EMAIL);
    }

    // --- Exception test
    @Test
    public void testConstructorUsernameNull() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The user name cannot be null");
        new User(null, EMAIL);
    }

    // --- Exception test
    @Test
    public void testConstructorEmailNull() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The user email cannot be null");
        new User(USERNAME, null);
    }

    @Test
    public void testModify() {
        user.modify(USERNAME2, EMAIL2);
        assertEquals(USERNAME2, user.getUsername());
        assertEquals(EMAIL2, user.getEmail());
    }

    // --- Exception test
    @Test
    public void testModifyNameNull() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The user name cannot be null");
        user.modify(null, EMAIL);
    }

    // --- Exception test
    @Test
    public void testModifyNameEmail() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The user email cannot be null");
        user.modify(USERNAME, null);
    }

    @Test
    public void testChangePassword() {
        user.changePassword(NEW_PASSWORD);
        assertTrue(user.validatePassword(NEW_PASSWORD));
        assertEquals(NEW_PASSWORD, user.getPassword());
    }

    // --- Exception test
    @Test
    public void testChangePasswordNullParam() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The password cannot be null");
        user.changePassword(null);
    }

    @Test
    public void testHashCode() {
        User user2 = new User(USERNAME, EMAIL2);
        assertFalse(user.hashCode() == user2.hashCode());
    }

    @Test
    public void testEquals() {
        User user2 = new User(USERNAME, EMAIL);
        assertEquals(user, user2);
    }

    @Test
    public void testEqualsDiffEmail() {
        User user2 = new User(USERNAME, EMAIL2);
        assertFalse(user.equals(user2));
    }

    @Test
    public void testEqualsDiffObj() {
        assertFalse(user.equals(USERNAME));
    }

    @Test
    public void testHasRoleFalse() {
        assertFalse(user.hasRole(ROLE1_NAME));
    }

    @Test
    public void testSetRole() {
        user.setRole(ROLE1);
        assertTrue(user.hasRole(ROLE1_NAME));
    }

    @Test
    public void testSetRoles() {
        Set<Role> roles = new HashSet<Role>();
        roles.add(ROLE1);
        roles.add(ROLE2);
        user.setRoles(roles);
        assertTrue(user.hasRole(ROLE1_NAME));
        assertTrue(user.hasRole(ROLE2_NAME));
    }

    @Test
    public void testSettersAndGetters() {
        User user = new User();
        user.setEmail(EMAIL);
        user.setUsername(USERNAME);
        user.setFullName(NAME);
        user.setPassword(NEW_PASSWORD);
        assertEquals(EMAIL, user.getEmail());
        assertEquals(USERNAME, user.getUsername());
        assertEquals(NAME, user.getFullName());
        assertTrue(user.validatePassword(NEW_PASSWORD));
    }

    // --- Exception test
    @Test
    public void testSetUsernameNullParam() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The username cannot be null");
        user.setUsername(null);
    }

    // --- Exception test
    @Test
    public void testSetFullnameNullParam() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The user fullname cannot be null");
        user.setFullName(null);
    }

    // --- Exception test
    @Test
    public void testSetPasswordNullParam() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The password cannot be null");
        user.setPassword(null);
    }

}