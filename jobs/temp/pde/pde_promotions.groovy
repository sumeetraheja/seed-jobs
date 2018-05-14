multibranchPipelineJob('pde-promotions') {
    /*triggers {
        cron('* * * * *')
    }*/
    branchSources {
        configure { node ->
            node / sources(class: 'jenkins.branch.MultiBranchProject$BranchSourceList') / data / 'jenkins.branch.BranchSource' / source(class: 'jenkins.plugins.git.GitSCMSource') {
                remote 'ssh://git@gitlab.deveng.systems:2222/productenrichment/promotions.git'
                credentialsId 'jenkins-ci'
                includes 'master'
                excludes '*'
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
                    'jenkins.plugins.git.traits.LocalBranchTrait' () {
                        extension(class: 'hudson.plugins.git.extensions.impl.LocalBranch') {
                            localBranch '**'
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
    primaryView('pde')
}
