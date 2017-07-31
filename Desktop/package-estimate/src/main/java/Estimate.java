import pack.Parcel;

import java.util.List;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;


public class Estimate {
    public static void main(String[] args) throws java.io.IOException {

        float totalCost = 0;
        boolean keepRunning = true;
        float orderTotalCost = 0;
        List<Parcel> packages = new ArrayList<>();

        while (keepRunning) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            try {
                System.out.println("Enter the height of your package in inches");
                String parcelHeight = bufferedReader.readLine();
                float height = Float.parseFloat(parcelHeight);

                System.out.println("Enter the width of your package in inches");
                String parcelWidth = bufferedReader.readLine();
                float width = Float.parseFloat(parcelWidth);

                System.out.println("Enter the depth of your package in inches");
                String parcelDepth = bufferedReader.readLine();
                float depth = Float.parseFloat(parcelDepth);

                System.out.println("Enter the weight of your package in lbs");
                String parcelWeight = bufferedReader.readLine();
                float weight = Float.parseFloat(parcelWeight);

                Parcel userPackage = new Parcel(height, width, depth, weight);

                packages.add(userPackage);

                System.out.println("Would you like wrapping?");
                String stringWrappingAnswer = bufferedReader.readLine().toLowerCase();


                if (stringWrappingAnswer.equals("yes") || stringWrappingAnswer.equals("yeah") || stringWrappingAnswer.equals("yep")) {
                    System.out.println("Your wrapping cost is $" + userPackage.costToWrap());
                } else {
                    totalCost = userPackage.costToShip();
                }

                System.out.println("Your shipping cost is $" + userPackage.costToShip());

                System.out.println("This package's total cost is $" + userPackage.totalCost());
                System.out.println("Would you like to send another package?");
                String stringNewPackage = bufferedReader.readLine().toLowerCase();

                if (stringNewPackage.equals("yes") || stringNewPackage.equals("ya") || stringNewPackage.equals("yeah") || stringNewPackage.equals("yep")) {
                    keepRunning = true;
                } else {
                    keepRunning = false;
                }


                for (Parcel eachOrder : packages) {
                    orderTotalCost += eachOrder.totalCost;
                }

                System.out.println("Your total shipping cost is $" + orderTotalCost);

        } catch(IOException e){
            e.printStackTrace();
        }

        }
    }
}