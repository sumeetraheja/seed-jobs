listView('seed') {
    description('seed-jobs view')
    filterBuildQueue()
    filterExecutors()
    jobs {
        name('seed-jobs')
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
