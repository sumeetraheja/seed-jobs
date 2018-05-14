multibranchPipelineJob('team-A-java-pipeline-example') {
  triggers {
        cron('* * * * *')
    }
    // Need to do that to be able to tell git plugin to fetch tags.
    branchSources {
      // git {
      //   remote('https://gitlab.deveng.io/matt.oneill/java-jenkins-project.git')
      // }
      configure { node ->
        node / sources(class: 'jenkins.branch.MultiBranchProject$BranchSourceList') / data / 'jenkins.branch.BranchSource' / source(class: 'jenkins.plugins.git.GitSCMSource') {
          remote 'https://gitlab.deveng.io/matt.oneill/java-jenkins-project.git'
          credentialsId ''
          includes '*'
          excludes ''
          ignoreOnPushNotifications 'false'
          id ''
          traits {
            'jenkins.plugins.git.traits.BranchDiscoveryTrait'()
            'jenkins.plugins.git.traits.CloneOptionTrait' () {
              extension(class: 'hudson.plugins.git.extensions.impl.CloneOption') {
                shallow 'false'
                noTags 'false'
                reference ''
                depth '0'
                honorRefspec 'false'
              }
            }
          }
        }
      }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
    primaryView('team-A')
}
