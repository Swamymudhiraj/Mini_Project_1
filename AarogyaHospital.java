//package aarogya_hospital;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.*;

// the main class
public class AarogyaHospital{

	
        // class for storing the patient information
	class AarogyaMember{
          // declare all the details for the patient including name, age, gender, Aadhar Card number, contact number, city, address, date of admission, guardian name, guardian address, guardian contact number
        String name, gender, city, address, dateOfAdmission, guardianName, guardianAddress; 
        long aadharNumber,contactNumber,guardianContactNumber;
        int age;
        boolean recovered;
        int id;
	    // make constructor for the class and assign it a unique Id
	    public AarogyaMember(int id){
	    	this.id = id;
	    }
    	    // for taking patient information
	    public void input(){
	    	Scanner sc = new Scanner(System.in);
            try{
            System.out.print("Enter Name: ");
            name = sc.nextLine();

            System.out.print("Enter Age: ");
            age = sc.nextInt();
            sc.nextLine();
            while(age<1||age>100){
                System.out.println("Enter valid age b/w 1 to 100");
                age=sc.nextInt();
                sc.nextLine();
            }
            

            System.out.print("Enter Gender:(M/F) ");
            gender = sc.nextLine();
            while(!gender.equalsIgnoreCase("M")&&!gender.equalsIgnoreCase("F")){
                System.out.println("Enter valid Input like (M/F)");
                gender=sc.nextLine();
            }

            System.out.print("Enter Aadhar Card Number: ");
            aadharNumber = sc.nextLong();
            sc.nextLine();
            while(String.valueOf(aadharNumber).length()!=12){
                System.out.println("Enter valid Aadhar having 12 digit number");
                aadharNumber = sc.nextLong();
                sc.nextLine();
            }

            System.out.print("Enter Contact Number: ");
            contactNumber = sc.nextLong();
            sc.nextLine();
            while(String.valueOf(contactNumber).length()!=10){
                System.out.println("Enter valid contact number having 10 digits");
                contactNumber=sc.nextLong();
                sc.nextLine();
            }

            System.out.print("Enter City: ");
            city = sc.nextLine();

            System.out.print("Enter Address: ");
            address = sc.nextLine();

            System.out.print("Enter Date of Admission: ");
            dateOfAdmission = sc.nextLine();
            String datePattern="^\\d{2}/\\d{2}/\\d{4}$";
            while(!dateOfAdmission.matches(datePattern)){
                System.out.println("Enter valid date of having format like(dd/mm/yyyy):");
                dateOfAdmission = sc.nextLine();
            }

            System.out.print("Enter Guardian Name: ");
            guardianName = sc.nextLine();

            System.out.print("Enter Guardian Address: ");
            guardianAddress = sc.nextLine();

            System.out.print("Enter Guardian Contact Number: ");
            guardianContactNumber = sc.nextLong();
            sc.nextLine();
            while(String.valueOf(guardianContactNumber).length()!=10){
                System.out.println("Enter valid contact number having 10 digits");
                guardianContactNumber=sc.nextLong();
                sc.nextLine();
            }
            }
            catch(InputMismatchException e){
              System.out.println("Invalid input! Please enter valid input:");
                sc.nextLine();
                input();
            }
            
            recovered = false;
	    }
	      
	}

	// pick the choice of task to be performed
	static long choices(){
    Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for adding new member");
		System.out.println("Press 2 to view list of all available members");
		System.out.println("Press 3 to search member by ID");
		System.out.println("Press 4 to search member from a particular city");
		System.out.println("Press 5 to search member from a particular age group");
		System.out.println("Press 6 to mark recovery of a member");
		System.out.println("Press 7 to delete data of a member");
		System.out.println("Press 0 to exit");
		
            // create scanner class to take input
	    long option=sc.nextLong();
	    return option;
	}

	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
	  int id=1;
		// initialise array list to store list of patients information
		ArrayList<AarogyaMember> members = new ArrayList<AarogyaMember>();
		//for adding aarogya member information
		while(true){

			//take choice
			long option=choices();
			
			//invalid choice
			if(option<0||option>7){
			   System.out.println("Invalid choice");
			}
			// take the input and add in the arrayList
			else if(option==1){
	           AarogyaHospital ah = new AarogyaHospital();
                AarogyaMember member = ah.new AarogyaMember(id++);
                member.input();
                members.add(member);
                System.out.println("New member added successfully!"); 
        	        }
			//iterate and print all the patients information
	       		 else if(option==2){
	           System.out.println("List of all members: ");
                for(AarogyaMember member: members){
                    System.out.println("ID: " + member.id);
                    System.out.println("Name: " + member.name);
                    System.out.println("Age: " + member.age);
                    System.out.println("Gender: " + member.gender);
                    System.out.println("Aadhar Card Number: " + member.aadharNumber);
                    System.out.println("Contact Number: " + member.contactNumber);
                    System.out.println("City: " + member.city);
                    System.out.println("Address: " + member.address);
                    System.out.println("Date of Admission: " + member.dateOfAdmission);
                    System.out.println("Guardian Name: " + member.guardianName);
                    System.out.println("Guardian Address: " + member.guardianAddress);
                    System.out.println("Guardian Contact Number: " + member.guardianContactNumber);
                    System.out.println("Recovered: " + member.recovered);
                    System.out.println();
                }
	       		 }
			
			// print details of the patient with a particular id (take id as input)
	                else if(option==3){
	               System.out.println("Enter member ID: ");
                int memberId = sc.nextInt();
                boolean found = false;
                for(AarogyaMember member: members){
                    if(member.id == memberId){
                        System.out.println("ID: " + member.id);
                        System.out.println("Name: " + member.name);
                        System.out.println("Age: " + member.age);
                        System.out.println("Gender: " + member.gender);
                        System.out.println("Aadhar Card Number: " + member.aadharNumber);
                        System.out.println("Contact Number: " + member.contactNumber);
                        System.out.println("City: " + member.city);
                        System.out.println("Address: " + member.address);
                        System.out.println("Date of Admission: " + member.dateOfAdmission);
                        System.out.println("Guardian Name: " + member.guardianName);
                        System.out.println("Guardian Address: " + member.guardianAddress);
                        System.out.println("Guardian Contact Number: " + member.guardianContactNumber);
                        System.out.println("Recovered: " + member.recovered);
                        found = true;
                        break;
                    }
                }       
                if(!found){
                    System.out.println("Member with ID " + memberId + " not found.");
                }
	                }
			
			// to print all the patients from a particular city (take city as input)
	                else if(option==4){
	        	System.out.println("Enter city name: ");
            String city = sc.nextLine();
            boolean found = false;
            for(AarogyaMember member: members){
            if(member.city.equalsIgnoreCase(city)){
            System.out.println("ID: " + member.id);
            System.out.println("Name: " + member.name);
            System.out.println("Age: " + member.age);
            System.out.println("Gender: " + member.gender);
            System.out.println("Aadhar Card Number: " + member.aadharNumber);
            System.out.println("Contact Number: " + member.contactNumber);
            System.out.println("City: " + member.city);
            System.out.println("Address: " + member.address);
            System.out.println("Date of Admission: " + member.dateOfAdmission);
            System.out.println("Guardian Name: " + member.guardianName);
            System.out.println("Guardian Address: " + member.guardianAddress);
            System.out.println("Guardian Contact Number: " + member.guardianContactNumber);
            System.out.println("Recovered: " + member.recovered);
            System.out.println();
            found = true;
            }
            }
            if(!found){
              System.out.println("No members found in " + city + ".");
            }
	               }
			// to print details of all the patients in a particular age group (take age limits as input)
	               else if(option==5){
	           System.out.println("Enter minimum age: ");
          int minAge = sc.nextInt();
          System.out.println("Enter maximum age: ");
          int maxAge = sc.nextInt();
          boolean found=false;
          System.out.println("List of members in age group " + minAge + " to " + maxAge + ":");
          for(AarogyaMember member : members) {
          if(member.age >= minAge && member.age <= maxAge) {
            System.out.println("ID: " + member.id);
            System.out.println("Name: " + member.name);
            System.out.println("Age: " + member.age);
            System.out.println("Gender: " + member.gender);
            System.out.println("Aadhar Card Number: " + member.aadharNumber);
            System.out.println("Contact Number: " + member.contactNumber);
            System.out.println("City: " + member.city);
            System.out.println("Address: " + member.address);
            System.out.println("Date of Admission: " + member.dateOfAdmission);
            System.out.println("Guardian Name: " + member.guardianName);
            System.out.println("Guardian Address: " + member.guardianAddress);
            System.out.println("Guardian Contact Number: " + member.guardianContactNumber);
            System.out.println("Recovered: " + member.recovered);
            System.out.println("------------------------------------");
            found=true;
            }
            }
            if (!found) {
                System.out.println("Members with given age group are not found.");
            } 
	              }
	              // take member id as input to maintain recovered information of patient
	               else if(option==6){
	           System.out.println("Enter Member ID to mark as recovered: ");
            int mid = sc.nextInt();
            boolean found = false;
            for (AarogyaMember member : members) {
                if (member.id == mid) {
                    member.recovered = true;
                    System.out.println("Member " + mid + " marked as recovered.");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Member with ID " + mid + " not found.");
            } 
	              }
	              //take member id as input to delete patient information
	              else if(option==7){
			      System.out.println("Enter Member ID to delete data: ");
            int mid = sc.nextInt();
            boolean found = false;
            for (AarogyaMember member : members) {
                if (member.id == mid) {
                    members.remove(member);
                    System.out.println("Member " + mid + " data deleted.");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Member with ID " + mid + " not found.");
            }
	              }
			
	              else{
	             break;
                }
		}
	}
}