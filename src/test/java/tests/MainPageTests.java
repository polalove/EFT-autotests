package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.NewsPage;

import static io.qameta.allure.Allure.step;

public class MainPageTests extends TestConfiguration {

    MainPage mainPage = new MainPage();
    NewsPage newsPage = new NewsPage();

    @Test
    @DisplayName("Проверка работы смены языка с русского на английский")
    @Tag("smoke")
    void languageChangeTest() {
        step("Открываем главную страницу ", () -> {
            mainPage.openMainPage();
        });
        step("Кликаем на меню с выбором языка ", () -> {
            mainPage.openLanguageSwitcher();
        });
        step("Выбираем английский язык ", () -> {
            mainPage.selectLanguageByIndex(1); // 1 — английский язык
        });
        step("Проверяем, что язык поменялся на английский ", () -> {
            mainPage.checkEnglishLanguage();
        });
        step("Кликаем на меню с выбором языка ", () -> {
            mainPage.openLanguageSwitcher();
        });
        step("Возвращаем русский язык ", () -> {
            mainPage.selectLanguageByIndex(0); // 0 — русский язык
        });
        step("Проверяем, что язык поменялся на русский ", () -> {
            mainPage.checkRussianLanguage();
        });
    }

    @Test
    @DisplayName("Проверка запуска видео на главной странице")
    @Tag("smoke")
    void playbackVideoInIframeTest() {
        step("Открываем главную страницу ", () -> {
            mainPage.openMainPage();
        });
        step("Ищем первое видео, кликаем на него ", () -> {
            mainPage.clickFirstVideo();
        });
        step("Ищем iframe с видео и переключаемся на него ", () -> {
            mainPage.switchToVideoIframe();
        });
        step("Проверяем, что видео запустилось ", () -> {
            mainPage.checkVideoIsPlaying();
        });
        step("Возвращаемся на основной контент ", () -> {
            mainPage.switchToDefaultContent();
        });

        step("Ищем второе видео, кликаем на него ", () -> {
            mainPage.clickSecondVideo();
        });
        step("Ищем iframe с видео и переключаемся на него ", () -> {
            mainPage.switchToVideoIframe();
        });
        step("Проверяем, что видео запустилось ", () -> {
            mainPage.checkVideoIsPlaying();
        });
        step("Возвращаемся на основной контент ", () -> {
            mainPage.switchToDefaultContent();
        });

        step("Ищем третье видео, кликаем на него ", () -> {
            mainPage.clickThirdVideo();
        });
        step("Ищем iframe с видео и переключаемся на него ", () -> {
            mainPage.switchToVideoIframe();
        });
        step("Проверяем, что видео запустилось ", () -> {
            mainPage.checkVideoIsPlaying();
        });
        step("Возвращаемся на основной контент ", () -> {
            mainPage.switchToDefaultContent();
        });

        step("Ищем четвертое видео, кликаем на него ", () -> {
            mainPage.clickFourthVideo();
        });
        step("Ищем iframe с видео и переключаемся на него ", () -> {
            mainPage.switchToVideoIframe();
        });
        step("Проверяем, что видео запустилось ", () -> {
            mainPage.checkVideoIsPlaying();
        });
        step("Возвращаемся на основной контент ", () -> {
            mainPage.switchToDefaultContent();
        });

        step("Ищем пятое видео, кликаем на него ", () -> {
            mainPage.clickFifthVideo();
        });
        step("Ищем iframe с видео и переключаемся на него ", () -> {
            mainPage.switchToVideoIframe();
        });
        step("Проверяем, что видео запустилось ", () -> {
            mainPage.checkVideoIsPlaying();
        });
    }

    @Test
    @DisplayName("Проверка, что новость видима и содержит какой-либо текст")
    @Tag("smoke")
    void checkingHeadlineAndMainTextNewsAndPatchTest() {
        step("Открываем главную страницу", () -> {
            mainPage.openMainPage();
        });
        step("Находим кнопку 'Новости' в меню и нажимаем на нее ", () -> {
            newsPage.navigateToNewsPage();
        });
        step("Проверяем наличие заголовка над новостями ", () -> {
            newsPage.checkNewsSectionHeader();
        });
        step("Проверяем наличие заголовка и подзаголовка первой новости ", () -> {
            newsPage.checkNewsItem(0);
        });
        step("Проверяем наличие заголовка и подзаголовка второй новости ", () -> {
            newsPage.checkNewsItem(1);
        });
        step("Проверяем наличие заголовка и подзаголовка третьей новости ", () -> {
            newsPage.checkNewsItem(2);
        });
        step("Переключаемся на таб 'Патчноуты' ", () -> {
            newsPage.switchToPatchNotesTab();
        });
        step("Проверяем наличие заголовка и подзаголовка первой новости в табе патчей ", () -> {
            newsPage.checkNewsItem(0);
        });
        step("Проверяем наличие заголовка и подзаголовка второй новости в табе патчей ", () -> {
            newsPage.checkNewsItem(1);
        });
        step("Проверяем наличие заголовка и подзаголовка третьей новости в табе патчей ", () -> {
            newsPage.checkNewsItem(2);
        });
    }

    @Test
    @DisplayName("Проверка текста и перехода на секцию при нажатии на элемент в навигационном меню в правой части экрана")
    @Tag("smoke")
    void rightNavigationMenuButtonClickTest() {

        step("Открываем главную страницу", () -> {
            mainPage.openMainPage();
        });
        step("Находим первый элемент в меню, кликаем на него ", () -> {
            mainPage.clickNavigationMenuItem(0);
        });
        step("Проверяем переход к секции, после нажатия на первый элемент в меню ", () -> {
            mainPage.checkPreorderSectionIsVisible();
        });

        step("Находим второй элемент в меню, кликаем на него ", () -> {
            mainPage.clickNavigationMenuItem(1);
        });
        step("Проверяем переход к секции, после нажатия на второй элемент в меню ", () -> {
            mainPage.checkExpansionsPreorderSectionIsVisible();
        });

        step("Находим третий элемент в меню, кликаем на него ", () -> {
            mainPage.clickNavigationMenuItem(2);
        });
        step("Проверяем переход к секции, после нажатия на третий элемент в меню ", () -> {
            mainPage.checkYoutubeSection42IsVisible();
        });

        step("Находим четвертый элемент в меню, кликаем на него ", () -> {
            mainPage.clickNavigationMenuItem(3);
        });
        step("Проверяем переход к секции, после нажатия на четвертый элемент в меню ", () -> {
            mainPage.checkYoutubeSection39IsVisible();
        });

        step("Находим пятый элемент в меню, кликаем на него ", () -> {
            mainPage.clickNavigationMenuItem(4);
        });
        step("Проверяем переход к секции, после нажатия на пятый элемент в меню ", () -> {
            mainPage.checkYoutubeSection38IsVisible();
        });

        step("Находим шестой элемент в меню, кликаем на него ", () -> {
            mainPage.clickNavigationMenuItem(5);
        });
        step("Проверяем переход к секции, после нажатия на шестой элемент в меню ", () -> {
            mainPage.checkYoutubeSection36IsVisible();
        });

        step("Находим седьмой элемент в меню, кликаем на него ", () -> {
            mainPage.clickNavigationMenuItem(6);
        });
        step("Проверяем переход к секции, после нажатия на седьмой элемент в меню ", () -> {
            mainPage.checkYoutubeSection4IsVisible();
        });
    }

    @Test
    @DisplayName("Проверка перехода по кнопкам Telegram / Discord")
    @Tag("smoke")
    void testMain() {
        step("Открываем главную страницу ", () -> {
            mainPage.openMainPage();
        });
        step("Нажимам на кнопку Telegram ", () -> {
            mainPage.checkMessengerButton(0);
        });
        step("Проверяем, произошел переход по кнопке, открылась нужная ссылка ", () -> {
            mainPage.checkNewTabOpened("https://t.me/escapefromtarkovRU");
        });
        step("Нажимам на кнопку Discord ", () -> {
            mainPage.checkMessengerButton(1);
        });
        step("Проверяем, произошел переход по кнопке, открылась нужная ссылка ", () -> {
            mainPage.checkNewTabOpened("https://discord.com/invite/escapefromtarkovofficial");
        });
    }
}
