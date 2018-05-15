job('middleware') {
   scm {
        git {
            remote {
                url('https://github.com/sumeetraheja/jenkins.git')
              }
           
           }
      }  
    steps {
        dsl {
            //text(readFileFromWorkspace('jobs/*.groovy'))
            external('jobs/*.groovy')
           
            additionalClasspath('target/jenkins-job-0.0.1-SNAPSHOT.jar')
        }
    }
}