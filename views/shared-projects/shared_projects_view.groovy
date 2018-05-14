listView('shared-projects') {
    description('Shared projects Jenkins Jobs')
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex(/shared-.+/)
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