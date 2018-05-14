listView('recommendations') {
    description('Recommendations jobs')
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex(/recommendations-.+/)
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