package creational.factory.method;

public class MarketingManager extends HiringManager{

    @Override
    protected Interviewer createInterviewer () {
        return new CommunityExecutive ();
    }
}
