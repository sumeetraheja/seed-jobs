categorizedJobsView('paas') {
    description('paas view')
    filterBuildQueue()
    filterExecutors()
    jobs {
        name('seed-jobs')
        regex(/paas-.+/)
    }
    categorizationCriteria {
      regexGroupingRule(/^paas-docker*/)
      regexGroupingRule(/^paas-ami*/)
      regexGroupingRule(/^paas-ansible*/)
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
