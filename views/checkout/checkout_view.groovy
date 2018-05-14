listView('checkout') {
    description('Checkout Team Jenkins Jobs')
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex(/checkout-.+/)
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