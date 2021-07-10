package one.digitalinnovation.personapi.enums;

import lombok.Getter;

@Getter
public enum PhoneType{

    HOME("Home"),
    MOBILE("Mobile"),
    COMMERCIAL("Commercial");

    PhoneType(String description) {
        this.description = description;
    }

    private final String description;
}
