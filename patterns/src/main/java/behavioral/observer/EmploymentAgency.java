package behavioral.observer;

import java.util.ArrayList;
import java.util.Collection;

public class EmploymentAgency {

    private Collection<JobSeeker> jobSeekers;

    public EmploymentAgency () {
        this.jobSeekers = new ArrayList<> ();
    }

    public void attach(JobSeeker jobSeeker){
        this.jobSeekers.add (jobSeeker);
    }

    public void addPost(JobPost jobPost){
        notification (jobPost);
    }

    private void notification(JobPost jobPost){
        System.out.printf ("Add job post: %s%n", jobPost.getTitle ());
        jobSeekers.forEach (jobSeeker -> jobSeeker.onJobPosted (jobPost));
    }
}
