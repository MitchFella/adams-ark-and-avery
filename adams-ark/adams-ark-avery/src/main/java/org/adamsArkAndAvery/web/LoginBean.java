package org.adamsArkAndAvery.web;

import org.adamsArkAndAvery.model.Customer;
import org.adamsArkAndAvery.service.RegistrationStore;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private String email; 
    private String password;
    private String message;

    @ManagedProperty("#{registrationStore}")
    private RegistrationStore registrationStore;

    public void setRegistrationStore(RegistrationStore registrationStore) {
        this.registrationStore = registrationStore;
    }

    public String login() {
        message = null;

        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            message = "Please enter both email/username and password.";
            return null;
        }

        for (Customer customer : registrationStore.getUsers()) {
            boolean emailMatch = customer.getEmail().equalsIgnoreCase(email);
            boolean usernameMatch = customer.getUsername().equalsIgnoreCase(email);

            if ((emailMatch || usernameMatch) &&
                customer.getPassword().equals(password)) {
                return "servicePage?faces-redirect=true";
            }
        }

        message = "Login failed: Invalid email/username or password.";
        return null;
    }

    // Getters & Setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
