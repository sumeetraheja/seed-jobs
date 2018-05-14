listView('order-management') {
    description('Order Management jobs')
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex(/om-.+/)
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