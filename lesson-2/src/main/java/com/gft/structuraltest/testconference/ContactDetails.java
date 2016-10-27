package com.gft.structuraltest.testconference;

import com.gft.structuraltest.testconference.enums.ApplicationMode;

public class ContactDetails  {

    String firstName;

    String surname;

    String email;

    String  emailRepeat;

    String  phone;

    String  city;

    boolean contractType;

    boolean permanentType;

    boolean graduateType;

    boolean summerType;

    private String applicationMode;

    public static boolean validateEmail(String email) {
        final String emailRegex = "[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?";
        return email.matches(emailRegex);

    }

    public static boolean validatePhone(String phone) {
        final String phoneRegex = "^[0-9- ]+$";
        return phone.matches(phoneRegex);

    }

    public static  boolean validateFirstName(String firstName) {
        final String nameRegex = "[a-zA-ZółśćńźąężŁÓŚĆŃĄĘŻŹ]{1,20}";
        return firstName.matches(nameRegex);

    }

    public static  boolean validateSurName(String surname) {
        final String surnameRegex = "^[a-zA-ZółśćńźąężŁÓŚĆŃĄĘŻŹ]+[\\. - ']?(?:[\\s-][a-zA-ZółśćńźąężŁÓŚĆŃĄĘŻŹ]+)*$";
        return surname.matches(surnameRegex);

    }

    public static  boolean validateCity(String city) {
        final String cityRegex = "^[a-zA-ZółśćńźąężŁÓŚĆŃĄĘŻŹ]+[\\. - ']?(?:[\\s-][a-zA-ZółśćńźąężŁÓŚĆŃĄĘŻŹ]+)*$";
        return city.matches(cityRegex);

    }

    public boolean checkData() {

        boolean isCorrect = true;
        if (!validateFirstName(firstName)
                || firstName == null) {
            isCorrect = false;
        }
        if (!validateSurName(surname) || surname == null) {
            isCorrect = false;
        }
        if (applicationMode != ApplicationMode.CONTACT.toString()) {
            if (!validatePhone(phone) || phone == null) {
                isCorrect = false;
            }

            if (!validateCity(city) || city == null) {
                isCorrect = false;
            }

            if (!contractType && !permanentType && !graduateType && !summerType) {
                isCorrect = false;
            }
        }

        if (!validateEmail(email) || email == null) {
            isCorrect = false;
        }
        if (emailRepeat.length() == 0
                || !emailRepeat
                .equals(email)) {
            isCorrect = false;
        }
        return isCorrect;
    }

}
