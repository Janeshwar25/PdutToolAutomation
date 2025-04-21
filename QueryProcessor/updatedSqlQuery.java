package myproject.QueryProcessor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class updatedSqlQuery extends BaseClass {
    private String[] updatedQueries = new String[5];
    private static final Scanner SYSTEM_SCANNER = new Scanner(System.in);
    private String planID;
    private String effectiveDate;
    private String benefitBundleID;


    public void collectUserInput() {


        //Scanner scanner = new Scanner(System.in);
        System.out.print("Enter plan Id: ");
        planID = SYSTEM_SCANNER.nextLine();

        //String planID = scanner.nextLine();
        System.out.print("Enter effectiveDate(YYYY-MM-DD): ");
        effectiveDate = SYSTEM_SCANNER.nextLine();

        //String effectiveDate = scanner.nextLine();

        // Optional input for benefitBundleId
        System.out.print("Enter benefitBundleId(optional, press Enter to skip):");
        benefitBundleID = SYSTEM_SCANNER.nextLine();
        //String benefitBundleID = scanner.nextLine();

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

    public String getSecondQuery(){
        return updatedQueries[1];
    }

    public String getThirdQuery(){
        return updatedQueries[2];
    }

    public String getFourthQuery(){
        return updatedQueries[3];
    }

    public String getFifthQuery(){
        return updatedQueries[4];
    }

    public String getBenefitBundleID(){
        return this.benefitBundleID;
    }

    public String[] getAllQueries(){
        return updatedQueries;
    }

    public class QueryPair{
        private String rollbackQuery;
        private String sqlQuery;

        public QueryPair(String rollbackQuery, String sqlQuery){
            this.rollbackQuery = rollbackQuery;
            this.sqlQuery = sqlQuery;

        }

        public String getRollbackQuery(){
            return rollbackQuery;
        }
        public String getSqlQuery(){
            return sqlQuery;
        }

        public List<QueryPair> getAllQueryPair(){
            List<QueryPair> pairs = new ArrayList<>();
            pairs.add(new QueryPair(rollbackQuery1, sqlQuery1));
            pairs.add(new QueryPair(rollbackQuery2, sqlQuery2));
            pairs.add(new QueryPair(rollbackQuery3, sqlQuery3));
            pairs.add(new QueryPair(rollbackQuery4, sqlQuery4));
            pairs.add(new QueryPair(rollbackQuery5, sqlQuery5));

            return pairs;


        }
    }

    }
