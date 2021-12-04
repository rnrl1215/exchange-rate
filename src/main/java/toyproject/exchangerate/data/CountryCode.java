package toyproject.exchangerate.data;

public enum CountryCode {
    KRW("한국(KRW)"),
    JPY("일본(JPY)"),
    PHP("필리핀(PHP)");

    private final String displayCountryCode;

    CountryCode(String  countryCode) {
        this.displayCountryCode = countryCode;
    }

    public String getDisplayCountryCode() {
        return displayCountryCode;
    }
}
