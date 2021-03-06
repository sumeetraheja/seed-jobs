multibranchPipelineJob('checkout-backend-api-tests') {
    branchSources {
        configure { node ->
          node / sources(class: 'jenkins.branch.MultiBranchProject$BranchSourceList') / data / 'jenkins.branch.BranchSource' / source(class: 'jenkins.plugins.git.GitSCMSource') {
            remote 'ssh://git@gitlab.deveng.systems:2222/checkout/checkout-api-tests.git'
            credentialsId 'jenkins-ci'
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
            numToKeep(30)
        }
    }
    primaryView('checkout')
}
  