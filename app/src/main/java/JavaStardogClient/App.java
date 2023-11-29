package JavaStardogClient;

import Backend.DatabaseConn;
import Frontend.AppFrame;

public class App {


    public static void main(String[] args) {
        AppFrame testFrame = new AppFrame();
        
        testFrame.setVisible(true);

        DatabaseConn dbConn = new DatabaseConn();

        String queryString =
                "SELECT DISTINCT ?subject_0 " +
                "FROM <tag:stardog:api:context:default> " +
                "WHERE { " +
                "  { " +
                "    ?subject_0 a <http://www.semanticweb.org/healthcare#Patients> . " +
                "    ?subject_0 <http://www.semanticweb.org/healthcare#hasAge> ?dat_0 . " +
                "    FILTER(STR(?dat_0) = \"55\") . " +
                "  } " +
                "}";

        dbConn.executeQuery(queryString);


    }

}
