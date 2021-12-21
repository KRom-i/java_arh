package creational.factory.method;

abstract class HiringManager {

    abstract protected Interviewer createInterviewer();

    public void takeInterview(){
        createInterviewer ().askQuestions ();
    }
}
