package org.adamsArkAndAvery.web;


import org.adamsArkAndAvery.model.Customer;
import org.adamsArkAndAvery.service.RegistrationStore;
import javax.faces.bean.ManagedProperty;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "registrationBean")
@SessionScoped
public class RegistrationBean {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private String message;

    @ManagedProperty("#{registrationStore}")
    private RegistrationStore registrationStore;
    public void     setRegistrationStore(RegistrationStore registrationStore) {
        this.registrationStore = registrationStore;
    }
    

    //Username Getter and Setters
    public String getUsername() {
        return username; }
    public void setUsername(String username) {
        this.username = username; }

    //Password Getter and Setters
    public String getPassword() {
        return password; }
    public void setPassword(String password) {
        this.password = password; }

    //Email getters and setters
    public String getEmail() {
        return email; }
    public void setEmail(String email) {
        this.email = email; }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }


    public String register() {

        //Clear Message
        message = null;

        if (confirmPassword == null || !confirmPassword.equals(password)) {
            message = "Passwords do not match Please try again";
            return null; // To stay on page
        }
        try {
            registrationStore.register(new Customer(username, password, email));
            message = "Registration Successful!";
            return "servicePage?faces-redirect=true"; //Redirects to welcome.xhtml and updates url
        } catch (IllegalArgumentException e) {
            message = "Invalid input: Check all fields are correct and password is longer than 5 characters.";
            return null;
        } catch (IllegalStateException e) {
            message = "Username is already taken, please choose another.";
            return null;
        }
    }
    public int getUserCount() {
        return registrationStore.count();
    }

    public String getLastInputUsername(){
        return username;
    }
    
    
    
}
