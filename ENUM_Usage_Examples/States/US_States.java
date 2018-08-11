package ENUM_Usage_Examples.States;

public enum US_States {
    ALABAMA("Alabama", "AL"), ALASKA("Alaska", "AK"), ARIZONA("Arizona", "AZ"), ARKANSAS(
    "Arkansas", "AR"), CALIFORNIA("California", "CA"), COLORADO("Colorado", "CO"), CONNECTICUT("Connecticut", "CT"), DELAWARE(
    "Delaware", "DE"), DISTRICT_OF_COLUMBIA("District of Columbia", "DC"), FEDERATED_STATES_OF_MICRONESIA(
    "Federated States of Micronesia", "FM"), FLORIDA("Florida", "FL"), GEORGIA("Georgia", "GA"), HAWAII(
    "Hawaii", "HI"), IDAHO("Idaho", "ID"), ILLINOIS("Illinois", "IL"), INDIANA("Indiana", "IN"), IOWA("Iowa", "IA"), KANSAS(
    "Kansas", "KS"), KENTUCKY("Kentucky", "KY"), LOUISIANA("Louisiana", "LA"), MARYLAND("Maryland", "MD"), MASSACHUSETTS("Massachusetts", "MA"),
    MICHIGAN("Michigan", "MI"), MINNESOTA("Minnesota", "MN"), MISSISSIPPI("Mississippi", "MS"), MISSOURI("Missouri", "MO"),
    MONTANA("Montana", "MT"), NEBRASKA("Nebraska", "NE"), NEVADA("Nevada", "NV"), NEW_HAMPSHIRE("New Hampshire", "NH"),
    NEW_JERSEY("New Jersey", "NJ"), NEW_MEXICO("New Mexico", "NM"), NEW_YORK("New York", "NY"), NORTH_CAROLINA("North Carolina", "NC"),
    NORTH_DAKOTA("North Dakota", "ND"), OHIO("Ohio", "OH"), OKLAHOMA("Oklahoma", "OK"), OREGON("Oregon", "OR"), PENNSYLVANIA("Pennsylvania", "PA"),
    PUERTO_RICO("Puerto Rico", "PR"), SOUTH_CAROLINA("South Carolina", "SC"), SOUTH_DAKOTA("South Dakota", "SD"), TENNESSEE("Tennessee", "TN"),
    TEXAS("Texas", "TX"), UTAH("Utah", "UT"), VERMONT("Vermont", "VT"), VIRGINIA("Virginia", "VA"), WASHINGTON("Washington", "WA"),
    WEST_VIRGINIA("West Virginia", "WV"), WISCONSIN("Wisconsin", "WI"),WYOMING("Wyoming", "WY"), UNKNOWN("Unknown", "");

    private final String name;
    private final String abbreviation;

    US_States(String name, String abbr) {
        this.name = name;
        this.abbreviation = abbr;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public static US_States getStateViaName(String name) {
        for (US_States state : values()) {
            if (state.name.equalsIgnoreCase(name))
                return state;
        }
        return null;
    }

    public static US_States getStateViaAbbreviation(String abbreviation) {
        for (US_States state : values()) {
            if (state.abbreviation.equalsIgnoreCase(abbreviation))
                return state;
        }
        return null;
    }

    @Override
    public String toString()
    {
        return name;
    }
}




