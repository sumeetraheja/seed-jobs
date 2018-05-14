listView('inventory-management') {
    description('Inventory Management jobs')
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex(/im-.+/)
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