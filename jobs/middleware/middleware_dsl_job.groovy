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
            
            external('jobs/*.groovy')
           
            additionalClasspath('target/jenkins2-job-1.0.jar')
        }
    }
}