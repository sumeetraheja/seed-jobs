listView('findability') {
    description('Findability jobs')
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex(/findability-.+/)
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