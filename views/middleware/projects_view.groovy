listView('middleware') {
    description('Middleware Jenkins Jobs')
    filterBuildQueue()
    filterExecutors()
    jobs {       
        //names('middleware-jobs-commons','middleware-jobs-commons-all-env','middleware-jobs-dev','middleware-jobs-production','middleware-jobs-staging')
        regex('middleware-jobs*')
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