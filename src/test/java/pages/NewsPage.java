package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class NewsPage {

    private final SelenideElement newsMenuLink = $("ul.menu li a");
    private final SelenideElement newsSectionHeader = $("section#news h2");
    private final ElementsCollection newsHeadlines = $$("ul#news-list li .headtext a");
    private final ElementsCollection newsDescriptions = $$("ul#news-list li .description");
    private final SelenideElement patchNotesTab = $$(".news_filter .inline").get(1);

    public void navigateToNewsPage() {
        newsMenuLink.shouldHave(text("Новости")).click();
    }

    public void checkNewsSectionHeader() {
        newsSectionHeader.shouldHave(text("Новости"));
    }

    public void checkNewsItem(int index) {
        newsHeadlines.get(index).shouldBe(visible).shouldNotBe(empty);
        newsDescriptions.get(index).shouldBe(visible).shouldNotBe(empty);
    }

    public void switchToPatchNotesTab() {
        patchNotesTab.shouldHave(text("Патчноуты")).click();
    }
}