categorizedJobsView('cmc') {
    description('Contact Management Center Team Jenkins Jobs')
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex(/cmc-.+/)
    }
    categorizationCriteria {
        regexGroupingRule(/^cmc-deployment*/)
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
