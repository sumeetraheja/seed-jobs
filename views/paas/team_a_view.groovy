listView('team-A') {
    description('Team As jobs')
    filterBuildQueue()
    filterExecutors()
    jobs {
        name('team-A-java-pipeline-example')
        regex(/team-A-.+/)
    }
    columns {
        status()
        weather()
        name()
        lastSuccess()
        lastFailure()
        lastDuration()
        buildButton()
    }
}