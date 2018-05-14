listView('payments') {
    description('Payments Team Jenkins Jobs')
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex(/payments-.+/)
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
