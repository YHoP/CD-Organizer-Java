// import java.util.HashMap;

import java.util.ArrayList;

public class CDOrganizer {

  private static ArrayList<CDOrganizer> instances = new ArrayList<CDOrganizer>();
  private int mId;
  private String mCDTitle;


  public CDOrganizer(String cdTitle) {
    mCDTitle = cdTitle;
    instances.add(this);
    mId = instances.size();
  }

  // public ArrayList<CDOrganizer> getCDs() {
  //   return mCDs;
  // }

  public String getInfo() {
    return mCDTitle;
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

}
