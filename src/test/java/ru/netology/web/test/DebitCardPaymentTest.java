package ru.netology.web.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.MainPage;
import ru.netology.web.sql.SqlHelper;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DebitCardPaymentTest {

    MainPage mainPage;

    @BeforeAll
    public static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    public static void tearDownAll() {
        SelenideLogger.removeListener("allure");
        SqlHelper.cleanDb();
    }

    @BeforeEach
    public void setUp() {
        mainPage = open(System.getProperty("http://localhost:8080"), MainPage.class);
    }

    // POSITIVE SCENARIOS

    @Test
    public void shouldDoPaymentByDebitCardWithStatusApproved() {
        val paymentPage = mainPage.getDebitCardPayment();
        val info = DataHelper.getValidApprovedCardData();
        paymentPage.fillPaymentFormat(info);
        paymentPage.checkSuccessNotification();
        val paymentStatus = SqlHelper.getStatusPaymentEntity();
        assertEquals("APPROVED", paymentStatus);
    }
}

