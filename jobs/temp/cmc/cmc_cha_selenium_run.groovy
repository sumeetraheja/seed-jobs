pipelineJob('cmc-cha-selenium-run') {
    definition {
        cpsScm {
//            lightweight(true)
            scm {
                git {
                    remote {
                        name('origin')
                        url('ssh://git@gitlab.deveng.systems:2222/ContactCentre/cha-selenium.git')
                        credentials('jenkins-ci')
                    }
                    branch('develop')
                }
                scriptPath('Jenkinsfile-run')
            }
        }
    }
    triggers {
        upstream('cmc-cha-orders/develop', 'UNSTABLE')
        upstream('cmc-cha-rest-api/develop', 'UNSTABLE')
        upstream('cmc-cha-softphone/develop', 'UNSTABLE')
        upstream('cmc-cha-ui/develop', 'UNSTABLE')
        upstream('cmc-cmc-order-taking/develop', 'UNSTABLE')
        upstream('cmc-cha-selenium/develop', 'UNSTABLE')
    }
    logRotator {
        numToKeep(5)
        artifactNumToKeep(1)
    }
}

