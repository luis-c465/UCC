package luisc.ucc.dialogue;

import luisc.ucc.App;

public class BeginDialogue extends Dialogue {

  public BeginDialogue(App app) {
    super(app);
  }

  @Override
  protected void _setup() {
    add(
      "MC/thumbs-up: The Skeld. A sizeable freighter, but still feels cramped. Maybe going to Mira HQ on this ship wasn't the best idea. But i'll be damned if I wasn't lucky enough to get a case to work on there."
    );

    add("Gunner: Really? It's that hard to find a case?");

    add(
      "MC: Not really, I'm just not what you'd call reputable. I just started a week ago, and no one wants a start-up attorney with little to no real experience defending them."
    );

    add(
      "Gunner/thumbs-up: That's a fair point. But it's good that you've atleast got a case. I'm going to go check in with the navigator and see what the hold up is about. We aren't flying through an asteroid belt so i'm a little concerned."
    );

    add(
      "MC/ligma: Alright, got it. I'll be in the med-bay trying to get some shut-eye. For some reason they didn't even consider putting a living quarters around here so I've gotta sleep on those grimy medical beds..."
    );

    add("Gunner/chad: Sleep well. See you when you wake up.");

    add("[About 7 hours later]");

    add(
      "MC/worried: ...yawn... *Man how long did I sleep for? I just wanted a nap...*"
    );

    add("[ALERT SOUND]");

    add("MC/worried: Oh come on... what's going on now?");

    add("Engineer/crying: Joe! Wake up, you need to come see this...");

    add("[Dead body in navigation room]");

    add("MC/ligma: JeSUS christ... *That's-!*");

    add(
      "Engineer: Yeah. We found her here around half an hour ago. It's unknown when she died. All we know is that there are an odd number of things out of place around the ship."
    );

    add(
      "Navigator/crying: This can't be happening. This can't be real... I didn't kill her, I swear!!"
    );

    add(
      "Gunner/pointing: That's what they all say before they kill everyone else you sick bastard!"
    );

    add("Electrician/ligma: WHAT ARE WE GOING TO DO?!");

    add("[murmuring and chaos in the room]");

    add(
      "MC/pointing: QUIET! I can barely hear myself think! Look, we've got a body, and we know that it's someone on this ship. There's no use accusing one another without proper evidence. "
    );
    add(
      "MC: If there are things out of place, we can likely find out who it is based off of that."
    );
    add(
      "MC:  Make sure we have a way to call for a meeting in case there's any significant evidence."
    );

    add("Gunner/thinking: We have an emergency alert button in the cafeteria.");

    add(
      "MC/thumbs-up: Perfect. We'll meet there and go to the admin room for discussion. Keep on your toes. You never know if they'll strike again..."
    );

    add(
      "MC/thinking: Alright. Time to check out the rooms. So she died in navigation huh? *Christ, they'll think it was me if I tell them I saw her last before she died. I've gotta play it safe for now...*"
    );

    add(
      "Medic: I am the Medic. If you have any evidence that you need to be inspected for details such as the time it was used, I can trace it."
    );

    add(
      "MC/worried: Well that was a sudden introduction... uh, thanks... I'll make sure to come back for it..."
    );
    add(
      "[Top tip use the m key to bring up the map to teleport to different rooms to explore them :)]"
    );

    a.evidence.add("blood-examiner");
    a.evidence.add("blood");
  }

  @Override
  public void onDone() {
    a.mainScene.inCourt = false;
    setDialogue(new StartDialogue(a));
  }
}
