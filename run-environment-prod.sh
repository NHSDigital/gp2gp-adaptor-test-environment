#!/usr/bin/env bash

set -x -e

source ./vars-prod.sh

docker-compose -f docker-compose-prod.yml down

cd mock-spine-mhs-outbound

chmod +x gradlew

./gradlew bootJar

cd ..

docker network inspect nia-common >/dev/null 2>&1 || \
    docker network create nia-common

docker-compose -f docker-compose-prod.yml build

docker-compose -f docker-compose-prod.yml up -d
