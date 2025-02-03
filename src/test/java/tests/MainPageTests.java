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
    @DisplayName("Проверка работы навигационного меню в правой части экрана.")
    @Tag("smoke")
    void rightNavigationMenuButtonClickCheckTest() {
        step("Открываем главную страницу ", () -> {
            open("");
        });
        step("Находим первый элемент в меню, проверяем текст в нем и кликаем на него ", () -> {
            $$("ul.banner_nav li").get(0).hover().shouldHave(text("Приобрести")).click();
        });
        step("Находим второй элемент в меню, проверяем текст в нем и кликаем на него ", () -> {
            $$("ul.banner_nav li").get(1).hover().shouldHave(text("Расширения")).click();
        });
        step("Находим третий элемент в меню, проверяем текст в нем и кликаем на него ", () -> {
            $$("ul.banner_nav li").get(2).hover().shouldHave(text("patch 0.16")).click();
        });
        step("Находим четвертый элемент в меню, проверяем текст в нем и кликаем на него ", () -> {
            $$("ul.banner_nav li").get(3).hover().shouldHave(text("Streets of Tarkov teaser #3")).click();
        });
        step("Находим пятый элемент в меню, проверяем текст в нем и кликаем на него ", () -> {
            $$("ul.banner_nav li").get(4).hover().shouldHave(text("RAID")).click();
        });
        step("Находим шестой элемент в меню, проверяем текст в нем и кликаем на него ", () -> {
            $$("ul.banner_nav li").get(5).hover().shouldHave(text("Улицы Таркова - тизер")).click();
        });
        step("Находим седьмой элемент в меню, проверяем текст в нем и кликаем на него ", () -> {
            $$("ul.banner_nav li").get(6).hover().shouldHave(text("Official Announcement Trailer")).click();
        });
    }

    @Test
    @DisplayName("Запуск видео на главном экране")
    @Tag("smoke")
    void playbackVideoOnMainPageTest() {
        step("Открываем главную страницу ", () -> {
            open("");
        });
        step("Ищем первое видео и запускаем его ", () -> {
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
    }

    @Test
    @DisplayName("Проверка заголовка и подзаголовка в новостях")
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
            $$("ul#news-list li .description").get(0).shouldHave(text("Представляем вашему вниманию результаты опроса по Барахолке."));
            $$("ul#news-list li .description").get(0).shouldHave(text("Представляем вашему вниманию результаты опроса по Барахолке."));
        });
        step("Проверяем наличие заголовка и подзаголовка второй новости ", () -> {
            $$("ul#news-list li .headtext a").get(1).shouldHave(text("Twitch Drops за подписки на стримеров!"));
            $$("ul#news-list li .description").get(1).shouldHave(text("С 27 января 16:00 МСК по 3 февраля 16:00 МСК игроки могут получить уникальную Twitch Drops награду за подписку на стримеров на платформе."));
        });
        step("Проверяем наличие заголовка и подзаголовка третьей новости ", () -> {
            $$("ul#news-list li .headtext a").get(2).shouldHave(text("Конкурс «Косплей на персонажа Escape from Tarkov и Escape from Tarkov: Arena»"));
            $$("ul#news-list li .description").get(2).shouldHave(text("Приглашаем принять участие в конкурсе «Косплей на персонажа Escape from Tarkov и Escape from Tarkov: Arena»!"));
        });
        step("Переключаемся на таб 'Патчноуты' ", () -> {
            $$(".news_filter .inline").get(1).shouldHave(text("Патчноуты")).click();
        });
        step("Проверяем наличие заголовка и подзаголовка первой новости в табе патчей ", () -> {
            $$("ul#news-list li .headtext a").get(0).shouldHave(text("Патч 0.16.0.0"));
            $$("ul#news-list li .description").get(0).shouldHave(text("Список изменений патча 0.16.0.0 для Escape from Tarkov."));
        });
        step("Проверяем наличие заголовка и подзаголовка второй новости в табе патчей ", () -> {
            $$("ul#news-list li .headtext a").get(1).shouldHave(text("Патч 0.15.5.1"));
            $$("ul#news-list li .description").get(1).shouldHave(text("Список изменений патча 0.15.5.1 для Escape from Tarkov."));
        });
        step("Проверяем наличие заголовка и подзаголовка третьей новости в табе патчей ", () -> {
            $$("ul#news-list li .headtext a").get(2).shouldHave(text("Патч 0.15.5.0"));
            $$("ul#news-list li .description").get(2).shouldHave(text("Список изменений патча 0.15.5.0 для Escape from Tarkov."));
        });
    }

    @Test
    @DisplayName("Проверка работоспособности кнопок для управления новостями")
    @Tag("smoke")
    void checkFunctionalityButtonsUnderTheNewsTest() {
        step("Открываем главную страницу ", () -> {
            open("");
        });
        step("Переходим к новостям ", () -> {
            $("ul.menu li a").shouldHave(text("Новости")).click();
        });
        step("Переходим на следующею новость по кнопке ", () -> {
            $(".pager .pager-link.pager-next").click();
            sleep(100);
        });
        step("Переходим на последнюю страницу новостей ", () -> {
            $(".pager .pager-link.pager-last").click();
        });
        step("Переходим на первую страницу новостей ", () -> {
            $(".pager .pager-link.pager-first").click();
        });
        step("Переключаемся на разные станицы новостей ", () -> {
            $$(".pager .pager-link").get(1).click();
            $$(".pager .pager-link").get(2).click();
            $$(".pager .pager-link").get(3).click();
            $$(".pager .pager-link").get(4).click();
            $$(".pager .pager-link").get(0).click();
        });
        step("Жмем на кнопку 'Показать еще' ", () -> {
            $("#show_more_news.button").click();
        });
        step("Жмем на кнопку 'Показать все' ", () -> {
            $(".show_all .button").click();
        });
    }
}