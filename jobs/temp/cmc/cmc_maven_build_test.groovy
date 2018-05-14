multibranchPipelineJob('cmc-maven-build-test') {
    configure {
        it / factory(class: 'org.jenkinsci.plugins.workflow.multibranch.WorkflowBranchProjectFactory') {
            owner(class: 'org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject', reference: '../..')
            scriptPath('cmc-maven-build-test-project/Jenkinsfile')
        }
    }
    branchSources {
        configure { node ->
            node / sources(class: 'jenkins.branch.MultiBranchProject$BranchSourceList') / data / 'jenkins.branch.BranchSource' / source(class: 'jenkins.plugins.git.GitSCMSource') {
                remote 'ssh://git@gitlab.deveng.systems:2222/ContactCentre/cmc-build-test-project.git'
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
            daysToKeep(1)
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
		         libraryConfiguration {
		             name 'cmc-pipeline-shared-libs'
		             retriever {
		                 modernSCM {
		                     scm {
		                         git {
		                             id ''
		                             remote 'ssh://git@gitlab.deveng.systems:2222/ContactCentre/pipeline-shared-libs.git'
		                             credentialsId 'jenkins-ci'
		                         }
		                     }
		                 }
		             }
		             allowVersionOverride true
		             defaultVersion 'master'
		             implicit false
		         }
	         }
         }
    }
    primaryView('cmc')
}
