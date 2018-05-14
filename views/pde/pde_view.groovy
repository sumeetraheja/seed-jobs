listView('pde') {
    description('PDE jobs')
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex(/pde-.+/)
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