package behavioral.template_method;

public class IosBuilder extends Builder {
    public void test () {
        System.out.println ("Running ios tests");
    }

    public void lint () {
        System.out.println ("Linting the ios code");
    }

    public void assemble () {
        System.out.println ("Assembling the ios build");
    }

    public void deploy () {
        System.out.println ("Deploying ios build to server");
    }
}