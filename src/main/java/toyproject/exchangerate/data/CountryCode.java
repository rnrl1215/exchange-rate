package toyproject.exchangerate.data;


import lombok.Getter;

@Getter
public enum CountryCode {
    KRW("한국(KRW)"),
    JPY("일본(JPY)"),
    PHP("필리핀(PHP)");

    private final String description;
    CountryCode(String  countryCode) {
        this.description = countryCode;
    }
}
