import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("CD Organizer list!");
  }

  @Test
  public void CDIsCreatedCD() {
    goTo("http://localhost:4567/");
    click("a", withText("Add new CD"));
    fill("#cdTitle").with("Hello World");
    fill("#cdArtist").with("xyz");
    submit(".btn");
    assertThat(pageSource()).contains("Your CD infomation has been saved.");
  }

  @Test
  public void CDIsDisplayedCD() {
    goTo("http://localhost:4567/cdList/new");
    fill("#cdTitle").with("Hello World");
    fill("#cdArtist").with("xyz");
    submit(".btn");
    click("a", withText("View all CDs"));
    assertThat(pageSource()).contains("Hello World");
  }

  @Test
  public void multipleCDsAreDisplayedCDs() {
    goTo("http://localhost:4567/cdList/new");
    fill("#cdTitle").with("Hello World");
    fill("#cdArtist").with("xyz");
    submit(".btn");
    // click("a", withText("Add new CD"));
    goTo("http://localhost:4567/cdList/new");
    fill("#cdTitle").with("Hello India");
    fill("#cdArtist").with("mk");
    submit(".btn");
    click("a", withText("View all CDs"));
    assertThat(pageSource()).contains("Hello World");
    assertThat(pageSource()).contains("Hello India");
  }

  @Test
  public void CDArtistShowPageDisplaysCDInfo() {
    goTo("http://localhost:4567/cdList/new");
    fill("#cdTitle").with("Hello Taiwan");
    fill("#cdArtist").with("xyz");
    submit(".btn");
    click("a", withText("View all Artists"));
    click("a", withText("xyz"));
    assertThat(pageSource()).contains("Hello Taiwan");
    assertThat(pageSource()).contains("xyz");
  }

  @Test
  public void taskNotFoundMessageShown() {
    goTo("http://localhost:4567/cdList/999");
    assertThat(pageSource()).contains("CD not found");
  }
}
