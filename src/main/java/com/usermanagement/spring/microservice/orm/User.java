package com.usermanagement.spring.microservice.orm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "User")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends AuditableBase {
    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String appKey;

    public void mergeMetaData(User userDetailsToMerge) {
        if (userDetailsToMerge != null) {
            userDetailsToMerge.setFirstName(userDetailsToMerge.getFirstName());
            userDetailsToMerge.setLastName(userDetailsToMerge.getLastName());
            userDetailsToMerge.setEmail(userDetailsToMerge.getEmail());
            userDetailsToMerge.setPassword(userDetailsToMerge.getPassword());
           // userDetailsToMerge.setLastModifiedBy("System");
            userDetailsToMerge.setAppKey(UUID.randomUUID().toString().replaceAll("-", ""));
        }
    }
}
