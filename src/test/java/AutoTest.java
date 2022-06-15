import io.qameta.allure.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Owner("vadimviper")
public class AutoTest {

    @BeforeEach
    public void beforeTest() {
        step ("Открыть сайт http://automationpractice.com/index.php" , () -> {
            open("http://automationpractice.com/index.php");
            TestPages.mainPage.blockMenu()
                    .shouldBe(visible);
        });
    }

    @Test
    @Story("Добавление товара в корзину")
    @DisplayName("Добавление через быструю корзину")
    public void shouldAddCardTest() {
        step("Нажать на кнопку быстрого добавления в корзину и проверить сообщение в модальном окне", () -> {
            TestPages.mainPage.productCard()
                    .hover();
            TestPages.mainPage.addToCartButton()
                    .click();
            TestPages.mainPage.modalWindow()
                    .shouldHave(text("Product successfully added to your shopping cart"));
            TestPages.mainPage.closeModalWindowButton()
                    .click();
        });

        step("Зайти в корзину и проверить, что выбранный товар в ней находится", () -> {
            TestPages.mainPage.cartButton()
                    .click();
            TestPages.mainPage.cartPage()
                    .shouldBe(visible);
            TestPages.mainPage.productInfo()
                    .shouldHave(text("SKU : demo_1"));
        });
    }

    @MethodSource("wrongData")
    @ParameterizedTest(name = "{displayName} :{0}")
    @Story("Смена пароля")
    @DisplayName("Негативные кейсы для смены пароля в разделе личных данных")
    public void negativeTest(String type, String  CurrentPassword, String NewPassword, String Confirmation){
        step("Нажать на кнопку перехода в раздел авторизации", () -> {
            TestPages.mainPage.SignInButton()
                    .click();
            TestPages.mainPage.authenticationPage()
                    .shouldBe(visible);
        });

        step("Авторизоваться и нажать на кнопку 'Sign in'", () -> {
            TestPages.mainPage.mailPole()
                    .sendKeys("natli.d26.l8@gmail.com");
            TestPages.mainPage.passwordPole()
                    .sendKeys("123456789");
            TestPages.mainPage.signInButton()
                    .click();
            TestPages.mainPage.AccountPage()
                    .shouldBe(visible);
        });

        step("Перейти в раздел 'My personal information'", () -> {
            TestPages.mainPage.uzerButton()
                    .click();
            TestPages.mainPage.personalInfoPage()
                    .shouldBe(visible);
        });

        step("Ввести данные в поля пароля и нажать кнопку 'Save'", () -> {
            TestPages.mainPage.currentPasswordField()
                    .scrollTo()
                    .sendKeys(CurrentPassword);
            TestPages.mainPage.newPasswordField()
                    .sendKeys(NewPassword);
            TestPages.mainPage.confirmationField()
                    .sendKeys(Confirmation);
            TestPages.mainPage.saveButton()
                    .click();
        });

        step("Проверить, что появилась ошибка", () -> {
            TestPages.mainPage.warningPopup()
                    .shouldBe(visible);
        });

        step("Выйти из аккаунта", () -> {
            TestPages.mainPage.signOutButton()
                    .click();
            TestPages.mainPage.authenticationPage()
                    .shouldBe(visible);
        });
    }

    static Stream<Arguments> wrongData() {
        return Stream.of(
                arguments(
                        "не вводить данные",
                        "",
                        "",
                        ""
                ),
                arguments(
                        "ввести данные во все поля",
                        "1",
                        "2",
                        "3"
                ),
                arguments(
                        "ввести данные в два поля",
                        "1",
                        "2",
                        ""
                ),
                arguments(
                        "ввести данные в одно поле поля",
                        "1",
                        "",
                        ""
                )
        );
    }
}