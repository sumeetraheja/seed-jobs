multibranchPipelineJob('checkout-backend-checkout-service-config') {
    triggers {
        cron('* * * * *')
    }
    branchSources {
        configure { node ->
          node / sources(class: 'jenkins.branch.MultiBranchProject$BranchSourceList') / data / 'jenkins.branch.BranchSource' / source(class: 'jenkins.plugins.git.GitSCMSource') {
            remote 'ssh://git@gitlab.deveng.systems:2222/checkout/checkout-service-config.git'
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
            daysToKeep(7)
        }
    }
    primaryView('checkout')
}
  