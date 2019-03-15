#!/usr/bin/env sh

./gradlew clean check assemble
docker build -t pl.braintelligence -f docker/prometheus/Dockerfile .
docker build -t pl.braintelligence -f docker/app/Dockerfile .
