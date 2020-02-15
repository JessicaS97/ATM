/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jessi
 */
public class User {
    private String name;
    private String last_name;
    private String gender;
    private String email;
    private int phone;
    private String address;
    private String city;
    private String card_number;
    private int password;
    private int balance;
    
    User getUser(String card_number) {
        return new User();
    }
}
