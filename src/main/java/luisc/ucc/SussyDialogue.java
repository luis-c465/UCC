package luisc.ucc;

public class SussyDialogue extends Dialogue {

  @Override
  protected void _setup() {
    bg = r.i.intro;
    add("Captain/", p.loadImage("captain.png"));
    add("Engineer/", p.loadImage("engineer.png"));
    add("Navigator/", p.loadImage("navigator.png"));
    add("Doctor/", p.loadImage("medic.png"));
    add("Security Officer/", p.loadImage("pollice.png"));
    add("/", p.loadImage("transparent.png"));

    add(
      "Captain//Alright team, we have reason to believe that there is an imposter on board. We need to work together to identify and eliminate them."
    );

    add("Engineer//How do we know who to trust?");

    add(
      "Navigator//I suggest we all stick together and keep an eye on each other."
    );

    add(
      "Doctor//We also need to keep an eye on our supplies. The imposter could sabotage them."
    );

    add("Security Officer//I'll sweep the ship for any signs of sabotage.");

    add(
      "Captain//Good idea. And let's all report back here in an hour to discuss our findings."
    );

    add("//(One hour later)");

    add("Engineer//I found some wires that were cut in the engine room.");

    add(
      "Navigator//I noticed some strange readings on the navigation console."
    );

    add("Doctor//Some medical supplies have gone missing from the med bay.");

    add(
      "Security Officer//And I found a hidden compartment with some suspicious tools."
    );

    add(
      "Captain//It seems like we have multiple suspects. Let's all gather in the conference room and discuss this further."
    );

    add("//(They all gather in the conference room)");

    add(
      "Captain//Alright, we have some evidence to suggest that multiple crew members may be the imposter. I propose we all take a vote on who we suspect the most."
    );

    add(
      "Engineer//I think it's the navigator. The strange readings on the navigation console seem suspicious."
    );

    add(
      "Navigator//I think it's the doctor. Why would medical supplies go missing unless they were planning something?"
    );

    add(
      "Doctor//I think it's the security officer. Those tools could be used to sabotage the ship."
    );

    add(
      "Security Officer//And I think it's the engineer. Cutting wires in the engine room is a clear sign of sabotage."
    );

    add(
      "Captain//It seems like we all suspect each other. This is a difficult situation. But we need to work together to find the imposter."
    );

    add(
      "//(they continue to debate and discuss until they are able to identify and eliminate the imposter.)"
    );
    // add("Black//Something Racist");
    // add("Blue//AAAAAAA");
    // add("Brown//AAAAAAAAA");
    // add("Cyan//Guy's why are we all screaming??");
    // add("Green//AAAAAA, Idk, bc it fells good");
    // add("Cyan//AAAAAA");
    // add("Cyan//Understandable");
    // add("Orange/");
    // add("Pink/");
    // add("Purple/");
    // add("Red/");
    // add("White/");
    // add("Yellow/");
  }

  public SussyDialogue(App app) {
    super(app);
  }
}
