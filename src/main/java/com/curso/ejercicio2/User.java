package com.curso.ejercicio2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author juan.calvopina
 * */

public class User {

    private String username;
    private String fullName;
    private String email;
    private String password;
    private Role role;
    private Set<Role> roles = new HashSet<Role>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null) {
            throw new IllegalArgumentException("The username cannot be null");
        } else {
            this.username = username;
        }
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName == null) {
            throw new IllegalArgumentException("The user fullname cannot be null");
        } else {
            this.fullName = fullName;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("The password cannot be null");
        } else {
            this.password = password;
        }
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
        roles.add(role);
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public User() {
    }

    public User(String username, String email) {
        if (username == null) {
            throw new IllegalArgumentException("The user name cannot be null");
        } else {
            this.username = username;
        }
        if (email == null) {
            throw new IllegalArgumentException("The user email cannot be null");
        } else {
            this.email = email;
        }
    }

    public void modify(String newUsername, String newEmail) {
        if (newUsername == null) {
            throw new IllegalArgumentException("The user name cannot be null");
        } else {
            this.username = newUsername;
        }
        if (newEmail == null) {
            throw new IllegalArgumentException("The user email cannot be null");
        } else {
            this.email = newEmail;
        }
    }

    public void changePassword(String newPassword) {
        if (newPassword == null) {
            throw new IllegalArgumentException("The password cannot be null");
        } else {
            this.password = newPassword;
        }
    }

    public boolean validatePassword(String newPassword) {
        if (newPassword != null) {
            this.password = newPassword;
            return true;
        } else {
            return false;
        }
    }

    public boolean hasRole(String role) {
        return (getRoles().contains(new Role(role)));
    }

    @Override
    public int hashCode() {
        final int id = 31;
        int valorHashCode = 1;
        valorHashCode = id * valorHashCode + ((email == null) ? 0 : email.hashCode());
        valorHashCode = id * valorHashCode + ((username == null) ? 0 : username.hashCode());
        return valorHashCode;
    }

    @Override
    public boolean equals(Object objUser) {
        if (this == objUser)
            return true;
        if (objUser == null)
            return false;
        if (getClass() != objUser.getClass())
            return false;
        User user = (User) objUser;
        if (email == null) {
            if (user.email != null)
                return false;
        } else if (!email.equals(user.email))
            return false;
        if (username == null) {
            if (user.username != null)
                return false;
        } else if (!username.equals(user.username))
            return false;
        return true;
    }

}
