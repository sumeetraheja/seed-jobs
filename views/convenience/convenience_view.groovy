listView('convenience') {
    description('Convenience Team Jenkins Jobs')
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex(/convenience-.+/)
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