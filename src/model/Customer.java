package model;

import java.util.regex.Pattern;

final public class Customer {
    private String firstName;
    private String lastName;
    private String email;

    Pattern pattern = Pattern.compile("^(.+)@(.+).(.+)$");

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        System.out.println(firstName);
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        System.out.println(lastName);
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        System.out.println(pattern.matcher(email).matches());
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" + "First Name='" + firstName + '\'' + ", \"Last Name='" + lastName + '\'' + ", Email='" + email + '\'' + '}';
    }
}
