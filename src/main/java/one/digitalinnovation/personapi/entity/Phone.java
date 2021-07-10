package one.digitalinnovation.personapi.entity;

import one.digitalinnovation.personapi.enums.PhoneType;

import javax.persistence.*;

@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneType type;

    @Column(nullable = false)
    private String number;

    @Deprecated
    public Phone() {
    }

    public Phone(PhoneType type, String number) {
        this.type = type;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public PhoneType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
