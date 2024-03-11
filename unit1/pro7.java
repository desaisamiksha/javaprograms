import java.sql.*;
import java.io.*;

class pro7 {
    public static void main(String[] args) {
        try {
            Statement stmt = null;
            ResultSet rs = null;
            PreparedStatement ps = null;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String name, area;
            int population, choice;
           Class.forName("org.postgresql.Driver");
       Connection conn = DriverManager.getConnection("jdbc:postgresql:district","postgres", "");
        stmt = conn.createStatement();

            if (conn != null)
                System.out.println("Connection successful..");
            else
                System.out.println("Connection Failed..");

           
                System.out.println("1: Insert Record");
                System.out.println("2: Modify Record");
                System.out.println("3: Delete Record");
                System.out.println("4: Search Record");
                System.out.println("5: View All Records");
                System.out.println("6: Exit");
                System.out.println("\nEnter your choice : ");
                choice = Integer.parseInt(br.readLine());

                switch (choice) {
                    case 1:
                        System.out.println("Enter Name of District:");
                        name = br.readLine();
                        System.out.println("Enter Area of District:");
                        area = br.readLine();
                        System.out.println("Enter Population of District:");
                        population = Integer.parseInt(br.readLine());
                        ps = conn.prepareStatement("INSERT INTO District (name, area, population) VALUES (?, ?, ?)");
                        ps.setString(1, name);
                        ps.setString(2, area);
                        ps.setInt(3, population);
                        int i=ps.executeUpdate();
                        System.out.println(i+ "Record inserted successfully");
                        break;

                    case 2:
                        System.out.println("Enter Name of District:");
                        name = br.readLine();
                        System.out.println("Enter New Area of District:");
                        area = br.readLine();
                        System.out.println("Enter New Population of District:");
                        population = Integer.parseInt(br.readLine());
                        ps = conn.prepareStatement("UPDATE District SET area=?, population=? WHERE name=?");
                        ps.setString(1, area);
                        ps.setInt(2, population);
                        ps.setString(3, name);
                        ps.executeUpdate();
                        System.out.println("Record modified successfully");
                        break;

                    case 3:
                        System.out.println("Enter the district name to be deleted:");
                        name = br.readLine();
                        ps = conn.prepareStatement("DELETE FROM District WHERE name=?");
                        ps.setString(1, name);
                        ps.executeUpdate();
                        System.out.println("Record deleted successfully");
                        break;

                    case 4:
                        System.out.println("Enter the district name to be searched:");
                        name = br.readLine();
                        ps = conn.prepareStatement("SELECT * FROM District WHERE name=?");
                        ps.setString(1, name);
                        rs = ps.executeQuery();
                        if (rs.next()) {
                            System.out.println("District name = " + rs.getString("name"));
                            System.out.println("District area = " + rs.getString("area"));
                            System.out.println("District population = " + rs.getInt("population"));
                        } else
                            System.out.println("Record not found");
                        break;

                    case 5:
                        rs = stmt.executeQuery("SELECT * FROM District");
                        while (rs.next()) {
                            System.out.println("Name = " + rs.getString("name"));
                            System.out.println("Area = " + rs.getString("area"));
                            System.out.println("Population = " + rs.getInt("population"));
                        }
                        break;
                       
                    case 6:
                            // Exit
                            conn.close();
                            System.out.println("Exiting program.");
                            System.exit(0);
                            break;
                   
                   default:
                            System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                }
           
            conn.close();

        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found: " + ex);
        } catch (SQLException ex1) {
            System.out.println("SQL Error: " + ex1);
        } catch (IOException ex2) {
            System.out.println("IO Error: " + ex2);
        } catch (Exception ex3) {
            System.out.println("Error: " + ex3);
        }
    }
}


