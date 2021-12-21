package creational.factory.method;

public class DevelopmentManager extends HiringManager{

    @Override
    protected Interviewer createInterviewer () {
        return new Developer ();
    }
}
