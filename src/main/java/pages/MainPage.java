package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public SelenideElement blockMenu() {
        return $("#block_top_menu").as("блок меню");
    }

    public SelenideElement productCard() {
        return $("[alt='Faded Short Sleeve T-shirts']").as("карточка товара");
    }

    public SelenideElement addToCartButton() {
        return $("[data-id-product='1']").as("первый товар");
    }

    public SelenideElement modalWindow() {
        return $(".layer_cart_product").as("модалка о добавлении товара");
    }

    public SelenideElement closeModalWindowButton() {
        return  $(".cross").as("кнопка закрытия модалки");
    }

    public SelenideElement cartButton() {
        return  $("[title='View my shopping cart']").as("кнопка корзины");
    }

    public SelenideElement cartPage() {
        return  $("#cart_title").as("страница корзины");
    }

    public SelenideElement productInfo() {
        return $(".cart_ref").as("сведения о товаре");
    }

    public SelenideElement SignInButton() {
        return $("[title='Log in to your customer account']").as("кнопка перехода в раздел авторизации");
    }

    public SelenideElement authenticationPage() {
        return $(".page-heading").as("Страница аутентификации");
    }

    public SelenideElement mailPole() {
        return $("#email").as("поле ввода почты");
    }

    public SelenideElement passwordPole() {
        return  $("#passwd").as("поле ввода пароля");
    }


    public SelenideElement signInButton() {
        return $("#SubmitLogin").as("кнопка 'Sign in'");
    }

    public SelenideElement AccountPage() {
        return $(".navigation_page").as("Страница 'MY ACCOUNT'");
    }

    public SelenideElement uzerButton() {
        return $(".icon-user").as("кнопка иконка юзера");
    }

    public SelenideElement  personalInfoPage() {
        return $(".page-subheading").as("страница персональные данные");
    }

    public SelenideElement  currentPasswordField() {
        return $("#old_passwd").as("поле ввода 'Current Password'");
    }

    public SelenideElement  newPasswordField() {
        return $("#passwd").as("поле ввода 'Current Password'");
    }

    public SelenideElement  confirmationField() {
        return $("#confirmation").as("поле ввода 'Current Password'");
    }

    public SelenideElement  saveButton() {
        return $(byText("Save")).as("кнопка 'Save'");
    }

    public SelenideElement warningPopup() {
        return $(".alert.alert-danger").as("модалка об ошибке");
    }

    public SelenideElement signOutButton() {
        return $(".logout").as("кнопка выход");
    }

}