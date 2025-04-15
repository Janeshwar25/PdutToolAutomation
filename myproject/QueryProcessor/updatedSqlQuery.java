package myproject.QueryProcessor;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;

import java.util.Scanner;

public class updatedSqlQuery extends BaseClass {
    private String[] updatedQueries = new String[5];


    public void collectUserInput() {
        PageFactory.initElements(getDriver(), this);

    }

    public Object[][] getsqlQueries;

    {
        //access the Stored Sql Query
        String sqlQuery1 = SqlQueryStorage.sqlQuery1;
        String sqlQuery2 = SqlQueryStorage.sqlQuery2;
        String sqlQuery3 = SqlQueryStorage.sqlQuery3;
        String sqlQuery4 = SqlQueryStorage.sqlQuery4;
        String sqlQuery5 = SqlQueryStorage.sqlQuery5;


        //System.out.println(sqlQuery5);

        Scanner scanner = new Scanner(System.in);

        //Accepting input for plan id and eff date from user

        System.out.print("Enter plan Id: ");
        String planID = scanner.nextLine();
        System.out.print("Enter effectiveDate(YYYY-MM-DD): ");
        String effectiveDate = scanner.nextLine();

        // Optional input for benefitBundleId
        System.out.print("Enter benefitBundleId(optional, press Enter to skip):");
        String benefitBundleID = scanner.nextLine();


        // Replace planId and effective in each query

        String updatedSqlQuery1 = sqlQuery1.replace("2018-01-01", effectiveDate).replace("RX01000085", planID);
        String updatedSqlQuery2 = sqlQuery2.replace("2018-01-01", effectiveDate).replace("RX01000085", planID);
        String updatedSqlQuery3 = sqlQuery3.replace("2018-01-01", effectiveDate).replace("RX01000085", planID);
        String updatedSqlQuery4 = sqlQuery4.replace("2018-01-01", effectiveDate).replace("RX01000085", planID);

        //Optional benefitBundleId in sqlQuery5
        String updatedSqlQuery5 = sqlQuery5.replace("2018-01-01", effectiveDate).replace("RX01000085", planID);

        if (!benefitBundleID.isEmpty()) {
            updatedSqlQuery5 = updatedSqlQuery5.replace("51765352", benefitBundleID);
        } else {
            updatedSqlQuery5 = updatedSqlQuery5.replace("{benefitBundleId}", "");
        }

        /*System.out.println(updatedSqlQuery1);
        System.out.println(updatedSqlQuery2);
        System.out.println(updatedSqlQuery3);
        System.out.println(updatedSqlQuery4);*/
        //System.out.println(updatedSqlQuery5);

    }


        public String[] getUpdatedQueries () {
        return this.updatedQueries;
    }

        public String getQuery ( int index){
        return updatedQueries[index];
    }
    }
