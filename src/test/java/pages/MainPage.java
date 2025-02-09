package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPage {
    private final ElementsCollection navigationMenuItems = $$("ul.banner_nav li");
    private final SelenideElement preorderSection = $("#banner_28_preorder");
    private final SelenideElement expansionsPreorderSection = $("#banner_expansions_preorder");
    private final SelenideElement firstVideoSection = $("section#banner_42_youtube");
    private final SelenideElement secondVideoSection = $("section#banner_39_youtube");
    private final SelenideElement thirdVideoSection = $("section#banner_38_youtube");
    private final SelenideElement fourthVideoSection = $("section#banner_36_youtube");
    private final SelenideElement fifthVideoSection = $("section#banner_4_youtube");
    private final SelenideElement videoIframe = $("iframe");
    private final SelenideElement playerDiv = $("div#player");
    private final SelenideElement pauseButton = $("button[data-title-no-tooltip='Пауза']");
    private final SelenideElement languageSwitcher = $(".lang_switcher");
    private final SelenideElement newsMenuItem = $("ul.menu li a");
    private final SelenideElement cookieBanner = $("#legalLightBlock .cont");
    private final ElementsCollection messengerButton = $$(".social .icon a");

    public void openMainPage() {
        open("");
        Selenide.sleep(3000); // Ожидание загрузки страницы
        closeCookieBannerIfVisible();
    }

    public void clickFirstVideo() {
        firstVideoSection.click();
    }

    public void clickSecondVideo() {
        secondVideoSection.click();
    }

    public void clickThirdVideo() {
        thirdVideoSection.click();
    }

    public void clickFourthVideo() {
        fourthVideoSection.click();
    }

    public void clickFifthVideo() {
        fifthVideoSection.click();
    }

    public void switchToVideoIframe() {
        videoIframe.shouldBe(visible);
        switchTo().frame(videoIframe);
    }

    public void checkVideoIsPlaying() {
        playerDiv.shouldBe(visible);
        pauseButton.shouldBe(visible);
    }

    public void switchToDefaultContent() {
        switchTo().defaultContent();
    }

    public void openLanguageSwitcher() {
        languageSwitcher.click();
    }

    public void selectLanguageByIndex(int index) {
        $$(".lang_switcher ul.lang_selector li .lang-name").get(index).click();
    }

    public void checkEnglishLanguage() {
        newsMenuItem.shouldHave(text("News"));
    }

    public void checkRussianLanguage() {
        newsMenuItem.shouldHave(text("Новости"));
    }

    public void closeCookieBannerIfVisible() {
        if (cookieBanner.exists()) {
            cookieBanner.$(".button").click();
        }
    }

    public void clickNavigationMenuItem(int index) {
        navigationMenuItems.get(index).click();
    }

    public void checkPreorderSectionIsVisible() {
        preorderSection.shouldBe(visible);
    }

    public void checkExpansionsPreorderSectionIsVisible() {
        expansionsPreorderSection.shouldBe(visible);
    }

    public void checkYoutubeSection42IsVisible() {
        firstVideoSection.shouldBe(visible);
    }

    public void checkYoutubeSection39IsVisible() {
        secondVideoSection.shouldBe(visible);
    }

    public void checkYoutubeSection38IsVisible() {
        thirdVideoSection.shouldBe(visible);
    }

    public void checkYoutubeSection36IsVisible() {
        fourthVideoSection.shouldBe(visible);
    }

    public void checkYoutubeSection4IsVisible() {
        fifthVideoSection.shouldBe(visible);
    }

    public void checkNewTabOpened(String expectedUrl) {
        switchTo().window(1); // Переключаемся на новую вкладку (индекс 1)
        webdriver().shouldHave(url(expectedUrl)); // Проверяем URL новой вкладки
        closeWindow(); // Закрываем новую вкладку
        switchTo().window(0); // Возвращаемся к основной вкладке
    }

    public void checkMessengerButton(int index) {
        messengerButton.get(index).click();
    }

}