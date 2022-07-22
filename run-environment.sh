#!/usr/bin/env bash

set -x -e

source ./vars.sh

docker-compose down

cd mock-spine-mhs-outbound

chmod +x gradlew

./gradlew bootJar

cd ..

docker network inspect nia-common >/dev/null 2>&1 || \
    docker network create nia-common

docker-compose build

docker-compose up

docker-compose down