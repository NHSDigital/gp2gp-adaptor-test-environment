#!/usr/bin/env bash

set -x -e

docker-compose down

source vars.sh

cd mock-spine-mhs-outbound

./gradlew bootJar

cd ..

docker-compose build

docker-compose up