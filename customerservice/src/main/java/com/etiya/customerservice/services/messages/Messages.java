package com.etiya.customerservice.services.messages;

public class Messages {

    public static class BusinessErrors{
        public static final String CITY_NAME_EXIST = "City name is already exist";
        public static final String AddressDescriptionExists = "addressDescriptionExists";

        public static final String NATIONALITY_ID_EXIST = "This Identity number already exist";

    }

    public class GeneralMessages{
        public static final String REPLACE_ALL_REGEX = "\\s";
        public static final String REPLACE_ALL_REPLACEMENT = "";
        public static final String GSM_REGEX = "^[0-9]{10}$";
    }

    public class IdMessage{
        public static final String ID_IS_NOT_NULL = "id is not null";
        public static final String ID_IS_NOT_FOUND = "id is not found";

    }

    public class Customer{




        public static final String DELETED_CUSTOMER = "This customer is deleted";
        public static final String EMAIL_EXIST = "This e-mail allready exsist";
    }
    public class IndividualCustomer{

        public static final String FIRST_NAME_IS_NOT_EMPTY = "First name is not empty!";
        public static final String FIRST_NAME_MIN_SIZE = "First name must have at least two characters!";
        public static final String MIDDLE_NAME_MIN_SIZE = "Middle name must have at least two characters!";

        public static final String LAST_NAME_IS_NOT_EMPTY = "Last name is not empty!";
        public static final String LAST_NAME_MIN_SIZE = "Last name must have at least two characters!";

        public static final String NATIONALITY_ID_IS_NOT_EMPTY = "Nationality id is not empty!";

        public static final String NATIONALITY_ID_SIZE_RULE = "Nationality ID must be 11 characters long";

        public static final String BIRTH_DATE_MUST_BE_PAST = "Birth date must be in the past";

        public static final String MOTHER_NAME_MIN_SIZE = "Mother name must have at least two characters!";
        public static final String FATHER_NAME_MIN_SIZE = "Father name must have at least two characters!";

        public static final String NO_SUCH_CITIZEN_WAS_FOUND = "No such citizen was found";


    }
    public class CityMessage{
    }

    public class ContactMediumMessage{
        public static final String ContactMediumEmailExists = "Contact Medium Email is already Exist";

        public static final String EMAIL_IS_NOT_EMPTY ="Email is not empty!";

        public static final String INVALID_EMAIL_FORMAT ="Invalid email format!";
    }

    public class AddressMessage{
        public static final String StreetIsNotNull = "Street is not null!";

        public static final String HouseNumberIsNotNull = "House Number is not null!";
    }

}
