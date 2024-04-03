package com.etiya.customerservice.services.messages;

public class Messages {

    public static class BusinessErrors{
        public static final String CITY_NAME_EXIST = "Bu şehir adı zaten mevcut";
    }

    public class IdMessage{
        public static final String ID_IS_NOT_NULL = "id is not null";
    }

    public class Customer{

        public static final String EMAIL_IS_NOT_EMPTY ="Email is not empty!";

        public static final String INVALID_EMAIL_FORMAT ="Invalid email format!";
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


    }
    public class CityMessage{
    }

}
