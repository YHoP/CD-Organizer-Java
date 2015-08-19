// import java.time.LocalDateTime;
// import java.util.HashMap;

import java.util.ArrayList;

public class CDOrganizer {

  // private static CDInfo cdInfo = new CDInfo(String title, String artist);
  private static ArrayList<CDOrganizer> instances = new ArrayList<CDOrganizer>();

  private ArrayList<CDInfo> mCDs;
  private String mType;
  private int mId;

  // private String mDescription;
  // private LocalDateTime mCreatedAt;
  // private boolean mCompleted;

  public CDOrganizer(String type) {
    mType = type;
    mCDs = new ArrayList<CDInfo>();


    // mDescription = description;
    // mCreatedAt = LocalDateTime.now();
    // mCompleted = false;
    // "this" is the curent object that we are constructing
    // instances.add(this);

    // cdInfo = new CDInfo(cdTitle, cdArtist);
    // instances.add(cdInfo);
    // mId = instances.size();
  }

  public String getType() {
    return mType;
  }

  public ArrayList<CDInfo> getCDs() {
    return mCDs;
  }

  public void addCD(CDiNfo cd) {
    mCDs.add(cd);
  }

  public String getInfo() {
    return cdInfo;
  }

  public int getId() {
    return mId;
  }

  public static ArrayList<CDInfo> all() {
    return instances;
  }

  public static CDOrganizer find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      // System.out.println(e.getStackTrace);
      return null;
    }
  }

  public void addCDInfo(CDInfo cd) {

  }

  // public static void clear() {
  //   instances.clear();
  // }
  // public boolean isCompleted() {
  //   return mCompleted;
  // }
  //
  // public LocalDateTime getCreatedAt() {
  //   return mCreatedAt;
  // }
  // public void completeTask() {
  //   mCompleted = true;
  // }
}
