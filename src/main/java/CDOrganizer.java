// import java.util.HashMap;

import java.util.ArrayList;

public class CDOrganizer {

  private static ArrayList<CDOrganizer> instances = new ArrayList<CDOrganizer>();
  private int mId;
  private String mCDTitle;
  private String mCDArtist;


  public CDOrganizer(String cdTitle, String cdArtist) {
    mCDTitle = cdTitle;
    mCDArtist = cdArtist;
    instances.add(this);
    mId = instances.size();
  }

  public String getTitle(){
    return mCDTitle;
  }

  public String getArtist(){
    return mCDArtist;
  }

  public String getInfo() {
    String cdInfo = "CD Title: " + mCDTitle + "<br>CD Artist: " + mCDArtist;
    return cdInfo;
  }

  public int getId() {
    return mId;
  }

  public static ArrayList<CDOrganizer> all() {
    return instances;
  }

  public static CDOrganizer find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }
  
  public static void clear() {
    instances.clear();
  }
}
