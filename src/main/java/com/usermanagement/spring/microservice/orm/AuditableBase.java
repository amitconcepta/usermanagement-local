package com.usermanagement.spring.microservice.orm;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public @Data
abstract class AuditableBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

/*    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime createdTime;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime lastModifiedTime;

    @Column(nullable = false)
    private String createdBy = "System";

    @Column(nullable = false)
    private String lastModifiedBy = "System";

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;*/

    protected boolean dateEquals(Date first, Date second) {
        if (first == null && second == null) {
            return true;
        }
        if (first == null && second != null) {
            return false;
        }
        if (first != null && second == null) {
            return false;
        }
        return first.equals(second);
    }

    protected boolean longEquals(Long first, Long second) {
        if (first == null && second == null) {
            return true;
        }
        if (first == null && second != null) {
            return false;
        }
        if (first != null && second == null) {
            return false;
        }
        return first.equals(second);
    }
}


