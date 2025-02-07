package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainPageTests extends TestConfiguration {

    @Test
    @DisplayName("Проверка работы смены языка с русского на английский.")
    @Tag("smoke")
    void languageChangeTest() {
        step("Открываем главную страницу ", () -> {
            open("");
        });
        step("Кликаем на меню с выбором языка ", () -> {
            $(".lang_switcher").click();
        });
        step("Выбираем английский язык ", () -> {
            $$(".lang_switcher ul.lang_selector li .lang-name").get(1).click();
        });
        step("Проверяем, что язык поменялся на английский ", () -> {
            $("ul.menu li a").shouldHave(text("News"));
        });
        step("Кликаем на меню с выбором языка ", () -> {
            $(".lang_switcher").click();
        });
        step("Возвращаем русский язык ", () -> {
            $$(".lang_switcher ul.lang_selector li .lang-name").get(0).click();
        });
        step("Проверяем, что язык поменялся на русский ", () -> {
            $("ul.menu li a").shouldHave(text("Новости"));
        });
    }

    @Test
    @DisplayName("Проверка наличия текста при наведении на элемент в навигационном меню в правой части экрана.")
    @Tag("smoke")
    void rightNavigationMenuButtonClickCheckTest() {
        step("Открываем главную страницу ", () -> {
            open("");
        });
        step("Находим первый элемент в меню, проверяем текст в нем ", () -> {
            $$("ul.banner_nav li").get(0).hover().shouldHave(text("Приобрести"));
        });
        step("Находим второй элемент в меню, проверяем текст в нем ", () -> {
            $$("ul.banner_nav li").get(1).hover().shouldHave(text("Расширения"));
        });
        step("Находим третий элемент в меню, проверяем текст в нем ", () -> {
            $$("ul.banner_nav li").get(2).hover().shouldHave(text("patch 0.16"));
        });
        step("Находим четвертый элемент в меню, проверяем текст в нем ", () -> {
            $$("ul.banner_nav li").get(3).hover().shouldHave(text("Streets of Tarkov teaser #3"));
        });
        step("Находим пятый элемент в меню, проверяем текст в нем ", () -> {
            $$("ul.banner_nav li").get(4).hover().shouldHave(text("RAID"));
        });
        step("Находим шестой элемент в меню, проверяем текст в нем ", () -> {
            $$("ul.banner_nav li").get(5).hover().shouldHave(text("Улицы Таркова - тизер"));
        });
        step("Находим седьмой элемент в меню, проверяем текст в нем ", () -> {
            $$("ul.banner_nav li").get(6).hover().shouldHave(text("Official Announcement Trailer"));
        });
    }


    @Test
    @DisplayName("Проверка запуска видео внутри iframe на главной странице")
    @Tag("smoke")
    void playbackVideoInIframeTest() {
        step("Открываем главную страницу", () -> {
            open("");
        });

        step("Ищем первое видео и запускаем его, проверям, что оно запустилось ", () -> {
            $("section#banner_42_youtube").click();
        });

        step("Ищем iframe с видео и переключаемся на него", () -> {
            // Переключаемся на iframe (например, по ID или другим атрибутам)
            $("iframe#yt-player-swVVzwxrRSo").shouldBe(visible);
            switchTo().frame($("iframe#yt-player-swVVzwxrRSo")); // Замени "video-iframe" на реальный идентификатор iframe
        });

        step("Проверяем, что видео запустилось", () -> {
            // Проверяем наличие элемента, указывающего на воспроизведение
            $(".ytp-player-content").shouldBe(visible); // Проверяем, что элемент video видим
            $("button[data-title-no-tooltip='Пауза']").shouldBe(visible); // Проверяем, что кнопка паузы видна
        });

        step("Возвращаемся на основной контент", () -> {
            switchTo().defaultContent(); // Возвращаемся к основному контенту страницы
        });
    }

































    /*   @Test
    @DisplayName("Проверка запуска видео на главном экране")
    @Tag("smoke")
    void playbackVideoOnMainPageTest() {

        step("Открываем главную страницу ", () -> {
            open("");
        });
        step("Ищем первое видео и запускаем его, проверям, что оно запустилось ", () -> {
            $("section#banner_42_youtube").click();

        });
        step("Ищем второе видео и запускаем его ", () -> {
            $("section#banner_39_youtube").click();
        });
        step("Ищем третье видео и запускаем его ", () -> {
            $("section#banner_38_youtube").click();
        });
        step("Ищем четвертое видео и запускаем его ", () -> {
            $("section#banner_36_youtube").click();
        });
        step("Ищем пятое видео и запускаем его ", () -> {
            $("section#banner_4_youtube").click();
        });
    }*/

    @Test
    @DisplayName("Проверка, что новость видима и содержит какой-либо текст")
    @Tag("smoke")
    void checkingHeadlineAndMainTextNewsAndPatchTest() {
        step("Открываем главную страницу ", () -> {
            open("");
        });
        step("Находим кнопку 'Новости' в меню и нажимаем на нее ", () -> {
            $("ul.menu li a").shouldHave(text("Новости")).click();
        });
        step("Проверяем наличие заголовка над новостями ", () -> {
            $("section#news h2").shouldHave(text("Новости"));
        });
        step("Проверяем наличие заголовка и подзаголовка первой новости ", () -> {
            $$("ul#news-list li .headtext a").get(0).shouldBe(visible).shouldNotBe(empty);
            $$("ul#news-list li .description").get(0).shouldBe(visible).shouldNotBe(empty);
        });
        step("Проверяем наличие заголовка и подзаголовка второй новости ", () -> {
            $$("ul#news-list li .headtext a").get(1).shouldBe(visible).shouldNotBe(empty);
            $$("ul#news-list li .description").get(1).shouldBe(visible).shouldNotBe(empty);
        });
        step("Проверяем наличие заголовка и подзаголовка третьей новости ", () -> {
            $$("ul#news-list li .headtext a").get(2).shouldBe(visible).shouldNotBe(empty);
            $$("ul#news-list li .description").get(2).shouldBe(visible).shouldNotBe(empty);
        });
        step("Переключаемся на таб 'Патчноуты' ", () -> {
            $$(".news_filter .inline").get(1).shouldHave(text("Патчноуты")).click();
        });
        step("Проверяем наличие заголовка и подзаголовка первой новости в табе патчей ", () -> {
            $$("ul#news-list li .headtext a").get(0).shouldBe(visible).shouldNotBe(empty);
            $$("ul#news-list li .description").get(0).shouldBe(visible).shouldNotBe(empty);
        });
        step("Проверяем наличие заголовка и подзаголовка второй новости в табе патчей ", () -> {
            $$("ul#news-list li .headtext a").get(1).shouldBe(visible).shouldNotBe(empty);
            $$("ul#news-list li .description").get(1).shouldBe(visible).shouldNotBe(empty);
        });
        step("Проверяем наличие заголовка и подзаголовка третьей новости в табе патчей ", () -> {
            $$("ul#news-list li .headtext a").get(2).shouldBe(visible).shouldNotBe(empty);
            $$("ul#news-list li .description").get(2).shouldBe(visible).shouldNotBe(empty);
        });
    }
}