package ru.netology.web.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {

    //  TEST DATA

    //  Card Number

    public static String getApprovedCardNumber() {
        return "1111 2222 3333 4444";
    }

    public static String getDeclinedCardNumber() {
        return "5555 6666 7777 8888";
    }

    public static String getEmptyCardNumberField() {
        return "";
    }

    public static String getIncorrectCardNumberWithOneDigit() {
        return "4";
    }

    public static String getIncorrectCardNumberWithFifteenDigits() {
        return "1111 2222 3333 444";
    }

    public static String getInvalidCardNumber() {
        return "0000 0000 0000 0000";
    }

    public static String getAnotherBankFieldCardNumber() {
        return "5555 6666 7778 8888";
    }

    //  Month

    public static String getShiftedMonthFromNow(int shiftedMonth) {
        return LocalDate.now().plusMonths(shiftedMonth).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getInvalidMonth() {
        return "13";
    }

    public static String getInvalidMonthIfFieldZeros() {
        return "00";
    }

    public static String getIncorrectMonthWithOneDigit() {
        return "1";
    }

    public static String getEmptyMonthField() {
        return "";
    }

    //  Year

    public static String getShiftedYearFromNow(int shiftedYears) {
        return LocalDate.now().plusYears(shiftedYears).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getInvalidYearIfFieldZeros() {
        return "00";
    }

    public static String getIncorrectYearWithOneDigit() {
        return "0";
    }

    public static String getEmptyYearField() {
        return "";
    }

    //  Owner

    public static String getValidOwner() {
        Faker faker = new Faker(new Locale("en"));
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String getInvalidOwnerFieldOnCyrillic() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String getInvalidOwnerFieldWithOneWord() {
        Faker faker = new Faker(new Locale("en"));
        return faker.name().firstName();
    }

    public static String getInvalidOwnerFieldWithThreeWords() {
        return "Ivanov Ivan Ivanovich";
    }

    public static String getInvalidOwnerFieldWithLowerCase() {
        return "ivan ivanov";
    }

    public static String getInvalidOwnerFieldWithUpperCase() {
        return "IVAN IVANOV";
    }

    public static String getInvalidOwnerFieldWithOneLetter() {
        return "Q";
    }

    public static String getInvalidOwnerFieldWithLotsNumberOfLetters() {
        return "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq";
    }

    public static String getInvalidOwnerFieldWithDigits() {
        return "123456789";
    }

    public static String getInvalidOwnerFieldWithSymbols() {
        return "!@#$%^&?*";
    }

    public static String getEmptyOwnerField() {
        return "";
    }

    //  CVC/CVV

    public static String getValidCVC() {
        Faker faker = new Faker();
        return faker.numerify("###");
    }

    public static String getInvalidCVC() {
        return "000";
    }

    public static String getIncorrectCVCWithTwoDigits() {
        return "12";
    }

    public static String getIncorrectCVCWithOneDigit() {
        return "1";
    }

    public static String getEmptyFieldCVC() {
        return "";
    }
}