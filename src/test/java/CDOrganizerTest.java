import java.time.LocalDateTime;

import org.junit.*;
import static org.junit.Assert.*;

public class CDOrganizerTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void CDOrganizer_instantiatesCorrectly_true() {
    CDOrganizer myCDOrg = new CDOrganizer("Hello Word","xyz");
    assertEquals(true, myCDOrg instanceof CDOrganizer);
  }

  @Test
  public void CDOrganizer_instantiatesWithGetInfo_true() {
    CDOrganizer myCDOrg = new CDOrganizer("Hello Word","xyz");
    assertEquals("CD Title: Hello Word<br>CD Artist: xyz", myCDOrg.getInfo());
  }

  @Test
  public void all_returnsAllInstancesOfTask_true() {
    CDOrganizer firstCD = new CDOrganizer("Hello Word","xyz");
    CDOrganizer secondCD = new CDOrganizer("Hello India", "mk");
    assertTrue(CDOrganizer.all().contains(firstCD));
    assertTrue(CDOrganizer.all().contains(secondCD));
  }

  @Test
  public void newId_myCDOrgInstantiateWithAnID_true() {
    CDOrganizer myCDOrg = new CDOrganizer("Hello Word", "abc");
    assertEquals(CDOrganizer.all().size(), myCDOrg.getId());
  }

  @Test
  public void find_returnsCDWithSameId_secondCD() {
    CDOrganizer firstCD = new CDOrganizer("Hello Word","xyz");
    CDOrganizer secondCD = new CDOrganizer("Hello India", "mk");
    assertEquals(CDOrganizer.find(secondCD.getId()), secondCD);
  }

  @Test
  public void find_returnsNullWhenNoCDFound_null() {
    assertTrue(CDOrganizer.find(999) == null);
  }

  @Test
  public void clear_emptiesAllCDsFromArrayList() {
    CDOrganizer myCDOrg = new CDOrganizer("Hello Word","xyz");
    CDOrganizer.clear();
    assertEquals(CDOrganizer.all().size(), 0);
  }
}
