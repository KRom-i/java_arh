package behavioral.observer;

public class JobSeeker {

    private String name;

    public JobSeeker (String name) {
        this.name = name;
    }

    public void onJobPosted(JobPost jobPost){
        System.out.printf ("Hi %s! New job posted: %s%n", this.name, jobPost.getTitle ());
    }
}
