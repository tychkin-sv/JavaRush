package com.javarush.task.task13.task1328;

public abstract class AbstractRobot implements Attackable, Defensable{
    private static int hitCount;
    public BodyPart attack() {
        BodyPart attackedBodyPart = null;
        //System.out.println(hitCount);
        hitCount = hitCount + 1;

        if (hitCount == 1) {
            attackedBodyPart = BodyPart.ARM;
        } else if (hitCount == 10) {
            attackedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 7) {
            //hitCount =1;
            attackedBodyPart = BodyPart.LEG;
        } else if (hitCount == 4) {
            //hitCount =0;
            attackedBodyPart = BodyPart.CHEST;
        }

        return attackedBodyPart;
    }

    public BodyPart defense() {
        BodyPart defencedBodyPart = null;
        //System.out.println(hitCount);
        hitCount = hitCount + 2;

        if (hitCount == 12) { hitCount =0;
            defencedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 9) {
            defencedBodyPart = BodyPart.LEG;
        } else if (hitCount == 3) {
            defencedBodyPart = BodyPart.ARM;
        } else if (hitCount == 6) {

           defencedBodyPart = BodyPart.CHEST;
        }

        return defencedBodyPart;
    }

    abstract public String getName();
}
