/*Proj2_Rocket
 * 
 * cs127a Fall15, Project 02
 * 
 * Author:Suresh Krishna Devendran
 * SL Name: Jon Weiser
 * 
 * ------
 * This class calculates the performance of a three-stage rocket...
 */

public class Proj2_Rocket
{
    public static void main(String[] args)
    {
        double WePayL; //Number 1
        double NoeS1;  //Number 2
        double AofS1;  //Number 3
        double NoeS2;  //Number 4
        double AofS2;  //Number 5
        double NoeS3;  //Number 6 
        double AofS3;  //Number 7
        
        
        WePayL = Double.parseDouble(args[0]); //Number 1
        NoeS1 = Double.parseDouble(args[1]);  //Number 2
        AofS1 = Double.parseDouble(args[2]);  //Number 3
        NoeS2 = Double.parseDouble(args[3]);  //Number 4
        AofS2 = Double.parseDouble(args[4]);  //Number 5
        NoeS3 = Double.parseDouble(args[5]);  //Number 6
        AofS3 = Double.parseDouble(args[6]);  //Number 7
        
        double total_thrustS1;
        double accelerationS1;
        double burnout_timeS1;
        double delta_vS1;
        double speedS1;
        double altitudeS1;
        double stackS1;
       
        double total_thrustS2;
        double accelerationS2;
        double burnout_timeS2;
        double delta_vS2;
        double speedS2;
        double altitudeS2;
        double stackS2;
        
        double total_thrustS3;
        double accelerationS3;
        double burnout_timeS3;
        double delta_vS3;
        double speedS3;
        double altitudeS3;
        double stackS3;
        
        double time_to_apogee;
        double apogee;
        
        total_thrustS1 = NoeS1*1000;
        stackS1        = (NoeS1*100 +AofS1) + (NoeS2*100 + AofS2) + (NoeS3*100 + AofS3) + WePayL;
        accelerationS1 = NoeS1*1000 - stackS1;
        burnout_timeS1 = (AofS1)/(NoeS1*100);
        delta_vS1      = accelerationS1*burnout_timeS1;
        speedS1        = delta_vS1;
        altitudeS1     = burnout_timeS1*((delta_vS1)/2);   
            
        total_thrustS2 = NoeS2*1000;
        stackS2        = (NoeS2*100 + AofS2) + (NoeS3*100 + AofS3) + WePayL;
        accelerationS2 = NoeS2*1000 - stackS2;
        burnout_timeS2 = (AofS2)/(NoeS2*100);
        delta_vS2      = accelerationS2*burnout_timeS2;
        speedS2        = speedS1 + delta_vS2;
        altitudeS2     = altitudeS1 + (burnout_timeS2*((2*speedS1 + delta_vS2)/2));
        
        total_thrustS3 = NoeS3*1000;
        stackS3        = (NoeS3*100 + AofS3 ) + WePayL;
        accelerationS3 = NoeS3*1000 - stackS3;
        burnout_timeS3 = (AofS3)/(NoeS3*100);
        delta_vS3      = accelerationS3*burnout_timeS3;
        speedS3        = speedS2 + delta_vS3;
        altitudeS3     = altitudeS2 + (burnout_timeS3*((2*speedS2 + delta_vS3)/2));
        
        
        time_to_apogee = speedS3/9.8;
        apogee         = altitudeS3 + (speedS3*time_to_apogee - 4.9*time_to_apogee*time_to_apogee);    
        
        System.out.println("Weight of first stage stack : "+stackS1);
        System.out.println("First stage thrust : "+total_thrustS1);
        System.out.println("Weight of second stage stack : "+stackS2);
        System.out.println("Second stage thrust : "+total_thrustS2);
        System.out.println("Weight of third stage stack : "+stackS3);
        System.out.println("Third stage thrust : "+total_thrustS3);
        
        System.out.println("After the first stage :");
        System.out.println("Speed : "+speedS1);
        System.out.println("Altitude : "+altitudeS1);
        
        System.out.println("After the second stage :");
        System.out.println("Speed : "+speedS2);
        System.out.println("Altitude : "+altitudeS2);
        
        System.out.println("After the third stage :");
        System.out.println("Speed : "+speedS3);
        System.out.println("Altitude : "+altitudeS3);
        
        System.out.println("Apogee : "+apogee);
    
        {
        if (speedS1 <= 0)
            System.out.println("STALL! The speed after the first stage is <= 0.");  
        else if (speedS2 <= 0)
            System.out.println("STALL! The speed after the second stage is <= 0.");    
        else if (speedS3 <= 0)
            System.out.println("STALL! The speed after the third stage is <= 0.");
        }
        
        {
        if (altitudeS1 <=0)
            System.out.println("CRASH! The altitude after the first stage is <= 0.");    
        else if (altitudeS2 <=0)
            System.out.println("CRASH! The altitude after the second stage is <= 0.");
        else if (altitudeS3 <=0)
            System.out.println("CRASH! The altitude after the third stage is <= 0."); 
        }
    }
}