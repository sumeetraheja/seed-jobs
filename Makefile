.PHONY: all
all: validate

setup:
DIR = $(shell pwd)

validate:
	docker run --rm -v $(DIR)/jobs:/jobs -v $(DIR)/views:/views docker.deveng.io/jenkins-jobdsl-validator:0.2.3
