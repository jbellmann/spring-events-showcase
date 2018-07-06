#!/usr/bin/env bash

set -e

./mvnw install

cd spring-events-async-kotlin-gradle
./gradlew clean build --info

