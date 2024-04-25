public class Proj1Car extends BaseCar
{
    /* This method is called over and over by main().  The job of this method
     * is to decide whether the car should speed up (return 1), slow down
     * (return -1), or coast (return 0).
     *
     * There are two basic requirements:
     *   - Try to maintain a distand of exactly 100 units behind the
     *     other car.
     *   - Don't crash into the other car
     *
     * To decide what to do, you have several methods you can call to query
     * the state of your car:
     *   getSpeed()       - gives the speed of your own car
     *   distToNextCar()  - gives the dist to the car in front of you
     *   speedOfNextCar() - gives the speed of the car in front of you
     */
    public int getPedal()
    {
        // you must implement this method from scratch.  For a first pass,
        // how about using the rule "speed up if we are too far behind,
        // and slow down if we are too close".  This will work poorly - and
        // often result in crashes - but it's a good starting point.

        
       if (distToNextCar() > 93)   //Here the car starts acclerating as soon as the distance between the
           return 1;               //car increases to 93 units to catch up with the already acclerating car.  
       if (distToNextCar() < 107)  //The car starts slowing down as soon as the distance reaches 107 as
           return -1;              //100 units is distance that both the car needs to maintain.
       if (distToNextCar() ==100)  //this statement may not be of any use but in some particular case it proves effective.
           return 0;
       
       if (getSpeed() < speedOfNextCar() && distToNextCar() > 100) //this statement is made to ensure that the car catches up
           return 1;                                               //with the other car if the distance keeps on increasing
       if (getSpeed() > speedOfNextCar() && distToNextCar() < 100) //this is to avoid the car going at higher speeds and crashing 
           return -1;                                              //onto the other car

       if (speedOfNextCar() < 15 && speedOfNextCar() < getSpeed()) //if the other car becomes slower than 15 units then our car should
           return -1;                                              //start slowing down because both cars should not crash
       if (speedOfNextCar() > 45 && speedOfNextCar() > getSpeed()) //And starts acclerating as soon as the other car reaches 45 units and
           return 1;                                               //has a higher speed compared our car.
                   
       return 0;
    }
}

