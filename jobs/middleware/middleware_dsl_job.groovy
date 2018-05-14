node {
  
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/sumeetraheja/jenkins.git'
      echo "workspace directory is ${workspace}"

     
      jobDsl targets: ['jobs/*.groovy'].join('\n'),
         removedJobAction: 'DELETE',
         removedViewAction: 'DELETE',
         lookupStrategy: 'SEED_JOB',
         additionalClasspath: ['target/jenkins-job-0.0.1-SNAPSHOT.jar'].join('\n') 
         
  }
  
}