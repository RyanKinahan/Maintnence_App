import java.io.*;
import java.lang.invoke.TypeDescriptor;
import java.util.*;

class app {

    public ArrayList<vehicle> vehicles = new ArrayList<vehicle>();

    public int current_vid = 0;

    public HashMap<Integer, ArrayList<maintnence>> maintencDict = new HashMap<Integer, ArrayList<maintnence>>();

    public int readVehicles(String filename){
        try{
            FileInputStream stream = new FileInputStream(filename);
            Scanner scan = new Scanner(stream);
            scan.useDelimiter("[,\r\n]+");

            while(scan.hasNext()){
                int vid = Integer.parseInt(scan.next());
                int vyr = Integer.parseInt(scan.next());
                String make = scan.next();
                String model = scan.next();
                String aq_date = scan.next();
                String sell_date = scan.next();

                vehicles.add(new vehicle(vid, vyr, make, model, aq_date, sell_date));
            }

            stream.close();
            scan.close();
        }
        catch(IOException e) {
            System.out.println("error reading vehicle file");
        }

        return 1;
    }

    public int readMaintence(String filename){
        try{
            FileInputStream stream = new FileInputStream(filename);
            Scanner scan = new Scanner(stream);
            scan.useDelimiter("[,\r\n]+");

            ArrayList<maintnence> tempMaintence = new ArrayList<maintnence>();

            while(scan.hasNext()){
                int vid = Integer.parseInt(scan.next());
                String date = scan.next();
                String desc = scan.next();
                int odo = Integer.parseInt(scan.next());
                Float price = Float.parseFloat(scan.next());

                tempMaintence.add(new maintnence(vid, date, desc, odo, price));
            }

            maintencDict.put(current_vid, tempMaintence);

            stream.close();
            scan.close();
        }
        catch(IOException e) {
            System.out.println("error reading maintnence file");
            System.out.println(e.toString());
        }

        return 1;
    }


    public int writeToCSV(String filename, List csvHeader){
        
        //PrintWriter writer = new PrintWriter(new File (filename));
        //writer.close();
        return 1;


    }

    public static void main(String[] args) {
        app myApp = new app();
        String input = "";
        Boolean run = true;
        System.out.println("Hello! This is a car maintence management tool.");
        System.out.println("Please select a vehicle.");
        myApp.readVehicles("vehicles.csv");
        System.out.println(myApp.vehicles);
        while (run) {
            input = "";
            InputStreamReader reader = new InputStreamReader(System.in);
            BufferedReader buff = new BufferedReader(reader);

            try{
                input = buff.readLine();
            }
            catch (IOException e ){
                System.out.println(e);
            }

            if(input.equals("exit") ){
                System.out.println("Thanks for using this app!");
                break;
            }
            else{
                try{
                    Integer.parseInt(input);
                }   
                catch(Exception e){
                    System.out.println("i did not understand that input. Please input the ID of an existing vehicle.");
                    System.out.println(myApp.vehicles);
                    continue;
                }
                
                if(Integer.parseInt(input) > myApp.vehicles.size()){
                    System.out.println("There are no vehicles with that id, please pick an existing vehicle.");
                    // will need to loop below statement to 
                    System.out.println(myApp.vehicles.toString());
                }
                else if(Integer.parseInt(input) <= myApp.vehicles.size()){
                    myApp.current_vid = Integer.parseInt(input);
                    // will need to loop below statement to 
                    System.out.println("Thank you for selecing vehicle number " + myApp.current_vid + "\n");
                    System.out.println("You are now in the maintence sub-menu. Your options are as follows -\n");
                    System.out.println("view: Type 'view' to view all availible maintence records for the selected vehicle.");
                    System.out.println("add: Type 'add' to add a new maintence record to the database.");
                    System.out.println("edit: Type 'edit' to modify an existing maintence record.");
                    System.out.println("remove: Type 'remove' to delete a specified record.");
                    System.out.println("exit: Exit this menu and return to the vehicle selection menu.");
                    System.out.println("help: Type 'help' to see this list of commands again." );
                    Boolean submenu1 = true;
                    while(submenu1) {
                        input = "";
                        try{
                            input = buff.readLine();
                        }
                        catch (IOException e ){
                            System.out.println(e);
                        }
                        switch(input){
                            case "view": 
                                myApp.readMaintence("maint1.csv");
                                System.out.println(myApp.maintencDict.get(myApp.current_vid).toString());
                                continue;
                            case "add": 
                                // add logic here
                                System.out.println("this feature is a work in progress - thanks for understanding");
                                continue;
                            case "edit": 
                                //edit logic here
                                System.out.println("this feature is a work in progress - thanks for understanding");
                                continue;
                            case "remove": 
                                //remove logic here
                                System.out.println("this feature is a work in progress - thanks for understanding");
                                continue;
                            case "exit":
                                System.out.println("returning to vehicle selection\n\n");
                                submenu1=false;
                                break;
                            case "help":
                                System.out.println("You are now in the maintence sub-menu. Your options are as follows -\n");
                                System.out.println("view: Type 'view' to view all availible maintence records for the selected vehicle.");
                                System.out.println("add: Type 'add' to add a new maintence record to the database.");
                                System.out.println("edit: Type 'edit' to modify an existing maintence record.");
                                System.out.println("remove: Type 'remove' to delete a specified record.");
                                System.out.println("exit: Exit this menu and return to the vehicle selection menu.");
                                System.out.println("help: Type 'help' to see this list of commands again." );
                            default:
                                System.out.println("Please input one of the listed commands.");
                        }
                    }
                    //System.out.println("what is going on");
                }
                System.out.println("Please select a vehicle.");
                System.out.println(myApp.vehicles);
            }
        }
    }
}
//start with writing entries to csv
//infinite loop + maintence object probably
//infinite loop to read in + navigation objects