package myproject.QueryProcessor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import java.util.Scanner;

public class updatedSqlQuery extends BaseClass {
    private String[] updatedQueries ;
    private static final Scanner SYSTEM_SCANNER = new Scanner(System.in);
    private String planID;
    private String effectiveDate;
    private String benefitBundleID;


    public void collectUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter plan Id: ");
        String planID = scanner.nextLine();
        System.out.print("Enter effectiveDate(YYYY-MM-DD): ");
        String effectiveDate = scanner.nextLine();

        // Optional input for benefitBundleId
        System.out.print("Enter benefitBundleId(optional, press Enter to skip):");
        String benefitBundleID = scanner.nextLine();

        updatedQueries ();
    }

    //access the Stored Sql Query
    private void updatedQueries() {
        updatedQueries[0] = SqlQueryStorage.sqlQuery1.replace("2018-01-01", effectiveDate).replace("RX01000085", planID);
        updatedQueries[1] = SqlQueryStorage.sqlQuery2.replace("2018-01-01", effectiveDate).replace("RX01000085", planID);
        updatedQueries[2] = SqlQueryStorage.sqlQuery3.replace("2018-01-01", effectiveDate).replace("RX01000085", planID);
        updatedQueries[3] = SqlQueryStorage.sqlQuery4.replace("2018-01-01", effectiveDate).replace("RX01000085", planID);
        updatedQueries[4] = SqlQueryStorage.sqlQuery5.replace("2018-01-01", effectiveDate).replace("RX01000085", planID);


       /* String updatedSqlQuery1 = sqlQuery1.replace("2018-01-01", effectiveDate).replace("RX01000085", planID);
        String updatedSqlQuery2 = sqlQuery2.replace("2018-01-01", effectiveDate).replace("RX01000085", planID);
        String updatedSqlQuery3 = sqlQuery3.replace("2018-01-01", effectiveDate).replace("RX01000085", planID);
        String updatedSqlQuery4 = sqlQuery4.replace("2018-01-01", effectiveDate).replace("RX01000085", planID);

        //Optional benefitBundleId in sqlQuery5
        String updatedSqlQuery5 = sqlQuery5.replace("2018-01-01", effectiveDate).replace("RX01000085", planID);*/

        if (!benefitBundleID.isEmpty()) {
            updatedQueries[4] = updatedQueries[4].replace("51765352", benefitBundleID);
        } else {
            updatedQueries[4] = updatedQueries[4].replace("{benefitBundleId}", "");
        }

        /*System.out.println(updatedSqlQuery1);
        System.out.println(updatedSqlQuery2);
        System.out.println(updatedSqlQuery3);
        System.out.println(updatedSqlQuery4);*/
        //System.out.println(updatedSqlQuery5);

    }

    public String getFirstQuery(){
        return updatedQueries[0];
    }


    }
