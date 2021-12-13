import server.WebServer;

public class Main {

//    public static void main (String[] args) {
//
////        new WebServer (5000).start ();
//
//        String methodStr = "GET";
//
//        RequestMethod method = RequestMethod.valueOf (methodStr);
//
//        System.out.println (method);
//    }

    public enum RequestMethod{

        GET, POST, PUT, DELETE;

    }


    public static void main (String[] args) {

        System.out.print ("STRING_1 " + System.lineSeparator () + "STRING_2 STRING_3");

    }
}
