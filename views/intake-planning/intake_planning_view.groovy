listView('intake-planning') {
    description('Intake Planning Jenkins Jobs')
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex(/itp-.+/)
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