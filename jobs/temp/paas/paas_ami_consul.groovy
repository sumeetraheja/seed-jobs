multibranchPipelineJob('paas-ami-consul') {
    // Need to do this to be able to tell git plugin to fetch tags.
    branchSources {
        configure { node ->
          node / sources(class: 'jenkins.branch.MultiBranchProject$BranchSourceList') / data / 'jenkins.branch.BranchSource' / source(class: 'jenkins.plugins.git.GitSCMSource') {
            remote 'ssh://git@gitlab.deveng.systems:2222/machine-images/consul.git'
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
    properties {
        folderLibraries {
            libraries {
                libraryConfiguration {
                    name 'paas-pipeline-shared-libs'
                    retriever {
                        modernSCM {
                            scm {
                                git {
                                    id ''
                                    remote 'ssh://git@gitlab.deveng.systems:2222/paas-shared/pipeline-shared-libs.git'
                                    credentialsId 'jenkins-ci'
                                }
                            }
                        }
                    }
                    allowVersionOverride true
                    defaultVersion 'master'
                    implicit true
                }
            }
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
    primaryView('paas')
}
