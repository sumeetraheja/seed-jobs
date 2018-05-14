listView('middleware') {
    description('Middleware Jenkins Jobs')
    filterBuildQueue()
    filterExecutors()
    jobs {       
        names('build-jobs-commons','build-jobs-commons-all-env','build-jobs-dev','build-jobs-production','build-jobs-staging')
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
    recurse(true)
}