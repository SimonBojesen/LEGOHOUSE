/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Simon
 */
public class HouseCalculator {

    public Bricks makeHouse(int length, int width, int height) {
        Bricks bricksCalculated = new Bricks();
        int four, two, one;
        int l, w;
        //mindst et lag og looper til og med den specificerede højde.
        for (int i = 1; i <= height; i++) {
            //hvis det er et ulige lag altså 1,3,5,7 osv. bygger vi længden først og helt ud til og med hjørnerne.
            if (i % 2 == 1) {
                l = length;
                w = width - 4;
            } //omvendt hvis det er et lige lag bygger vi stadig længden først men uden hjørnerne som jo er 4 dots.
            else {
                l = length - 4;
                w = width;
            }
            //til sidst udregner vi hvor mange af hver type brik der skal bruges til dette lag.
            //FOUR: angivet længde divideret med brikkens længde gange med 2 fordi vi har 2 ens sider. også samme process med width.
            //TWO: angivet længde modulus med 4 for at få resten, og derefter dividerer vi med brikkens længde og ganger med 2.
            //ONE: angivet længde modulus først med 4 og derefter med 2 og ganger med 2.
            four = (l / 4) * 2 + (w / 4) * 2;
            two = ((l % 4) / 2) * 2 + ((w % 4) / 2) * 2;
            one = ((l % 4) % 2) * 2 + ((w % 4) % 2) * 2;
            bricksCalculated.addBricklayers(four, two, one);
        }
        return bricksCalculated;
    }
}
