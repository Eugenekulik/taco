package by.eugenekulik.taco.domain;


import lombok.Data;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;
    public User toUser() {
        return User.builder()
                .username(username)
                .password(password)
                .fullname(fullname)
                .street(street)
                .state(state)
                .city(city)
                .zip(zip)
                .phoneNumber(phone).build();
    }
}
