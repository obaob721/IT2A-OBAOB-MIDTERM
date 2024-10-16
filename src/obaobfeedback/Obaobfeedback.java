
package obaobfeedback;

import java.util.Scanner;

public class Obaobfeedback {
       
    public void addFeedback(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Student ID: ");
        int stud_id = sc.nextInt();
        System.out.print("COURSE ID: ");
        String course = sc.next();
        System.out.print("Feedback: ");
        String feedback = sc.next();
        System.out.print("Date: ");
        String date = sc.next();
        System.out.print("Rate (1-5): ");
        int rate = sc.nextInt();

        String sql = "INSERT INTO feedback (student_id, course_id, feedback_text, feedback_date, rating) VALUES (?, ?, ?, ?, ?)";

        config conf = new config();
        conf.addRecord(sql, stud_id, course, feedback, date, rate);

    }
    
    private void viewFeedback() {
        String query = "SELECT * FROM feedback";
        String[] headers = {"FEEDBACK ID", "STUDENT ID", "COURSE ID", "FEEDBACK", "DATE", "RATING"};
        String[] columns = {"feedback_id", "student_id", "course_id", "feedback_text", "feedback_date", "rating"};

        config conf = new config();
        conf.viewRecords(query, headers, columns);
    }
    
    
    private void updateFeedback(){
    
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        
        System.out.print("Enter new Student ID: ");
        int new_id = sc.nextInt();
        System.out.print("Enter new Course ID: ");
        String new_course = sc.next();
        System.out.print("Enter new Feedback: ");
        String new_feed = sc.next();
        System.out.print("Enter Date updated: ");
        String new_date = sc.next();
        System.out.print("Enter new rating: ");
        int new_rate = sc.nextInt();
        
        String query = "UPDATE feedback SET student_id = ?, course_id = ?, feedback_text = ?, feedback_date = ?, rating = ? WHERE student_id = ?";
        
        config conf = new config();
        conf.updateRecord(query, new_id, new_course, new_feed, new_date, new_rate, id);
        
    }
    
    private void deleteFeedback(){
    
        Scanner sc = new Scanner (System.in);
        
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        
        String query = "Delete FROM feedback WHERE student_id = ?";
       
        config conf = new config();
        conf.deleteRecord(query, id);

    }
    

    public static void main(String[] args) {
        
        Obaobfeedback test = new Obaobfeedback();
        Scanner input = new Scanner(System.in);
        String response;
        
        do{    
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");

            System.out.print("Enter Action: ");
            int action = input.nextInt();

            switch(action){
                case 1:
                    test.addFeedback();
                break; 
                case 2:
                    test.viewFeedback();
                break;
                case 3:
                    test.viewFeedback();
                    test.updateFeedback();
                    break;
                case 4:
                    test.viewFeedback();
                    test.deleteFeedback();
                    test.viewFeedback();
                break;
            }
            
            System.out.print("Do you want to CONTINUE? ");
            response = input.next();
            
        }while(response.equalsIgnoreCase("yes"));
            System.out.println("Thank You!");
            
    }
     
}

    


    
    

