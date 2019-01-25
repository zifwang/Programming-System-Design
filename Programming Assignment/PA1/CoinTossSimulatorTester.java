// Name: Zifan Wang  
// USC NetID: 9505587296
// CS 455 PA1
// Spring 2019

/**
 * class CoinTossSimulatorTester
 * 
 * This class is used to test the accuracy of CoinTossSimulator class.
 * 
 * This will be a console-based program -- i.e., no GUI. 
 * It will be a non-interactive program (i.e., fixed data, nothing read in from the user), 
 * that tests every method multiple times, 
 * printing informative output to the console with the results of each operation.
 */


public class CoinTossSimulatorTester {

    public static void main(String[] args){

        String correction;
        CoinTossSimulator coinToss = new CoinTossSimulator();
        
        // After constructor test
        System.out.println("After constructor:");
        System.out.print("Number of trials [exp:0]: ");
        System.out.println(coinToss.getNumTrials());
        System.out.print("Two-head tosses: ");
        System.out.println(coinToss.getTwoHeads());
        System.out.print("Two-tail tosses: ");
        System.out.println(coinToss.getTwoTails());
        System.out.print("One-head one-tail tosses: ");
        System.out.println(coinToss.getHeadTails());
        if(coinToss.getNumTrials() == (coinToss.getTwoHeads()+coinToss.getTwoTails()+coinToss.getHeadTails())){
            correction = "True";
        }else{
            correction = "False";
        }
        System.out.print("Tosses add up correctly? ");
        System.out.println(correction);
        System.out.println();

        // After 1 run
        coinToss.run(1);
        System.out.println("After run(1):");
        System.out.print("Number of trials [exp:1]: ");
        System.out.println(coinToss.getNumTrials());
        System.out.print("Two-head tosses: ");
        System.out.println(coinToss.getTwoHeads());
        System.out.print("Two-tail tosses: ");
        System.out.println(coinToss.getTwoTails());
        System.out.print("One-head one-tail tosses: ");
        System.out.println(coinToss.getHeadTails());
        if(coinToss.getNumTrials() == (coinToss.getTwoHeads()+coinToss.getTwoTails()+coinToss.getHeadTails())){
            correction = "True";
        }else{
            correction = "False";
        }
        System.out.print("Tosses add up correctly? ");
        System.out.println(correction);
        System.out.println();

        // After 10 run
        coinToss.run(10);
        System.out.println("After run(10):");
        System.out.print("Number of trials [exp:11]: ");
        System.out.println(coinToss.getNumTrials());
        System.out.print("Two-head tosses: ");
        System.out.println(coinToss.getTwoHeads());
        System.out.print("Two-tail tosses: ");
        System.out.println(coinToss.getTwoTails());
        System.out.print("One-head one-tail tosses: ");
        System.out.println(coinToss.getHeadTails());
        if(coinToss.getNumTrials() == (coinToss.getTwoHeads()+coinToss.getTwoTails()+coinToss.getHeadTails())){
            correction = "True";
        }else{
            correction = "False";
        }
        System.out.print("Tosses add up correctly? ");
        System.out.println(correction);
        System.out.println();

        // After 100 run
        coinToss.run(100);
        System.out.println("After run(100):");
        System.out.print("Number of trials [exp:111]: ");
        System.out.println(coinToss.getNumTrials());
        System.out.print("Two-head tosses: ");
        System.out.println(coinToss.getTwoHeads());
        System.out.print("Two-tail tosses: ");
        System.out.println(coinToss.getTwoTails());
        System.out.print("One-head one-tail tosses: ");
        System.out.println(coinToss.getHeadTails());
        if(coinToss.getNumTrials() == (coinToss.getTwoHeads()+coinToss.getTwoTails()+coinToss.getHeadTails())){
            correction = "True";
        }else{
            correction = "False";
        }
        System.out.print("Tosses add up correctly? ");
        System.out.println(correction);
        System.out.println();

        // After reset:
        coinToss.reset();
        System.out.println("After reset:");
        System.out.print("Number of trials [exp:111]: ");
        System.out.println(coinToss.getNumTrials());
        System.out.print("Two-head tosses: ");
        System.out.println(coinToss.getTwoHeads());
        System.out.print("Two-tail tosses: ");
        System.out.println(coinToss.getTwoTails());
        System.out.print("One-head one-tail tosses: ");
        System.out.println(coinToss.getHeadTails());
        if(coinToss.getNumTrials() == (coinToss.getTwoHeads()+coinToss.getTwoTails()+coinToss.getHeadTails())){
            correction = "True";
        }else{
            correction = "False";
        }
        System.out.print("Tosses add up correctly? ");
        System.out.println(correction);
        System.out.println();

        // After 1000 run
        coinToss.run(1000);
        System.out.println("After run(1000):");
        System.out.print("Number of trials [exp:1000]: ");
        System.out.println(coinToss.getNumTrials());
        System.out.print("Two-head tosses: ");
        System.out.println(coinToss.getTwoHeads());
        System.out.print("Two-tail tosses: ");
        System.out.println(coinToss.getTwoTails());
        System.out.print("One-head one-tail tosses: ");
        System.out.println(coinToss.getHeadTails());
        if(coinToss.getNumTrials() == (coinToss.getTwoHeads()+coinToss.getTwoTails()+coinToss.getHeadTails())){
            correction = "True";
        }else{
            correction = "False";
        }
        System.out.print("Tosses add up correctly? ");
        System.out.println(correction);
        System.out.println();

    }









}