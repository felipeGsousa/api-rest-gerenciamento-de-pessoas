package one.digitalinnovation.personapi.dto.request;

import one.digitalinnovation.personapi.enums.PhoneType;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PhoneDTO {

    private Long id;

    @Enumerated
    private PhoneType type;

    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;

    @Deprecated
    public PhoneDTO() {
    }

    public PhoneDTO(PhoneType type, String number) {
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
}
