listView('post-order') {
    description('Post Order jobs')
    filterBuildQueue()
    filterExecutors()
    jobs {
        regex(/post-order-.+/)
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
