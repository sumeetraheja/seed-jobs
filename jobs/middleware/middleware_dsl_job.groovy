job('middleware') {
   scm {
        git {
            remote {
                github('https://github.com/sumeetraheja/seed-jobs.git')
              }
           
           }
      }  
    steps {
        dsl {
           // text(readFileFromWorkspace('jobs/middleware/devSeedJob.groovy'))
           
            additionalClasspath('target/jenkins-job-0.0.1-SNAPSHOT.jar')
        }
    }
}