package Collin_Le.StatRoyale;

import java.util.List;


/*{
  "items": [
    {
      "index": 0,
      "name": "Golden Chest"
    },
    {
      "index": 1,
      "name": "Tower Troop Chest"
    },
    {
      "index": 2,
      "name": "Golden Chest"
    },
    ]
}*/

public class Chest {
    String index;
    String name;


    public Chest(String index, String name){
        this.index = index;
        this.name = name;
    }

    public void displayUpcomingChest(){
        System.out.println("Chest: " + name);
    }

}
