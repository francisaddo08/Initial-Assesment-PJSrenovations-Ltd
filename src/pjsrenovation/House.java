
package pjsrenovation;

import java.util.Date;


public class House {

Date assementDate;
//number of rooms

int numbKingSize = 0; int kingSizeWallArea = 60; int kingSizeceilingArea= 16;
int numbDoubleRoom = 0; int doubleRoomWallArea = 45; int doubleRoomCeilingArea = 12;
int numbSingleRoom= 0; int singleRoomCeilingArea = 12; int singleRoomWallArea = 40;
int rooms = 0;

//LIVING ROOMS
 int numbLargeLivingRooms = 0;   int largelivingRoomWallArea = 80; int largeLivingRoomCeilingArea = 30;
int numbNormalLivingRooms = 0;  int normalLivingRoomWallArea = 50; int normalLivingRoomCeilingArea = 24;
int numbSmallLivingRooms= 0;  int smallLivingRoomWallArea = 25; int smallLivingRoomCeilingArea = 16;

// kitchen===============================
 int numbLargeKitchens = 0; int largeKitchenWallArea = 40; int largeKitchenCeilingArea = 24;
int numbNormalKitchens= 0;  int normalKitchenWallArea = 30; int normalKitchenCeilingArea = 15;
int numbSmallKitchen = 0;   int smallKitchenWallArea = 12; int smallKitchenCeilingArea = 7;

// Bath toilets Showers
int numbToiletBathShower = 0;  int toiletBathShowerWallArea = 24; int TBSCeilingArea = 24;
int numbToiletBath = 0;  int toiletBathWallArea = 16; int TBCeilingArea = 7;
int numbToilets = 0; int toiletWallArea = 12; int toiletCeilingArea = 4;

// work categories for rooms
String kingSizeCat = "";
String doubleRoomCat = "";
String singleRoomCate = "";

// number of bath rooms
int toiletBathShower = 0;
int toiletBath = 0;
int toilet = 0;

String TBScat = "";
String TBcat = "";
String toiletCat = "";
String ownerName = "";
String numbRooms_texString;

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public String getNumbRooms_texString() {
        return Integer.toString(getRooms());
    }

    public void setNumbRooms_texString(String numbRooms_texString) {
        this.numbRooms_texString = numbRooms_texString;
    }

}
