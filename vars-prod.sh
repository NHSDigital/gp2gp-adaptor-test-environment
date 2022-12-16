#!/usr/bin/env bash

#Keep Docker image versions in a separate vars file to use across test and prod versions
source ./vars-versions.sh

####################################
# MHS VARS

#SECRET KEY VARS
export MHS_SECRET_PARTY_KEY="REQUIRED - FILL IN"
export MHS_SECRET_CLIENT_CERT="REQUIRED - FILL IN"
export MHS_SECRET_CLIENT_KEY="REQUIRED - FILL IN"
export MHS_SECRET_CA_CERTS="REQUIRED - FILL IN"

#DYNAMODB VARS
export DYNAMODB_PORT="8000"

#MONGODB VARS
export MONGODB_PORT="27017"

#REDIS VARS
export REDIS_PORT="6379"

#GLOBAL VARS
export AWS_ACCESS_KEY_ID="FILL IN"
export AWS_SECRET_ACCESS_KEY="FILL IN"
export MHS_STATE_TABLE_NAME="mhs_state"
export MHS_SYNC_ASYNC_STATE_TABLE_NAME="sync_async_state"
export MHS_DB_ENDPOINT_URL="http://dynamodb:`echo $DYNAMODB_PORT`"

# MHS OUTBOUND VARS
export MHS_OUTBOUND_PORT="80"
export MHS_RESYNC_INTERVAL="1"
export MAX_RESYNC_RETRIES="20"
export MHS_SPINE_ROUTE_LOOKUP_URL="REQUIRED - FILL IN" # e.g. http://mock-spine-mhs:8085"
export MHS_SPINE_ORG_CODE="YES"
export MHS_SPINE_REQUEST_MAX_SIZE="4999600"
export MHS_FORWARD_RELIABLE_ENDPOINT_URL="REQUIRED - FILL IN" #e.g. https://mock-spine-mhs:8443/reliablemessaging/forwardreliable"
export MHS_OUTBOUND_VALIDATE_CERTIFICATE="False"
#MHS_OUTBOUND_ROUTING_LOOKUP_METHOD = SPINE_ROUTE_LOOKUP or SDS_API VARS
export MHS_OUTBOUND_ROUTING_LOOKUP_METHOD="SPINE_ROUTE_LOOKUP"
#export MHS_SDS_API_URL=""
#export MHS_SDS_API_KEY=""

#MHS INBOUND VARS
export MHS_INBOUND_PORT="443"
export MHS_INBOUND_SERVICE_PORTS="`echo $MHS_INBOUND_PORT`,`echo $MHS_OUTBOUND_PORT`"
export MHS_INBOUND_QUEUE_BROKERS="amqp://activemq:5672"
export MHS_INBOUND_QUEUE_NAME="inbound"
export MHS_SECRET_INBOUND_QUEUE_USERNAME="guest"
export MHS_SECRET_INBOUND_QUEUE_PASSWORD="guest"
export MHS_INBOUND_QUEUE_MESSAGE_TTL_IN_SECONDS="1000"
export MHS_INBOUND_USE_SSL="True"
export MHS_INBOUND_QUEUE_MAX_RETRIES="3"
export MHS_INBOUND_QUEUE_RETRY_DELAY="500"
export MHS_INBOUND_HEALTHCHECK_SERVER_PORT="8083"

#MHS ROUTE VARS
export MHS_ROUTE_PORT="8082"
export MHS_SDS_URL="REQUIRED - FILL IN" #e.g. ldap://192.168.XXX.XXX"
export MHS_SDS_SEARCH_BASE="ou=services,o=nhs"
export MHS_DISABLE_SDS_TLS="True"
export MHS_SDS_REDIS_CACHE_HOST="redis"
export MHS_SDS_REDIS_DISABLE_TLS="True"
export MHS_SDS_REDIS_DISABLE_TLS="True"
export MHS_STATE_TABLE_NAME="mhs_state"
export MHS_SYNC_ASYNC_STATE_TABLE_NAME="sync_async_state"

####################################
# GP2GP VARS
export GP2GP_SERVER_PORT="8183"
export GP2GP_AMQP_BROKERS="amqp://activemq:5672"
export GP2GP_MONGO_URI="mongodb://mongodb:27017"
export GP2GP_MONGO_DATABASE_NAME="gp2gp"
export GP2GP_MHS_OUTBOUND_URL="http://outbound:80"
export GP2GP_GPC_GET_URL="http://gpcc:8090/@ODS_CODE@/STU3/1/gpconnect"
export GP2GP_LARGE_ATTACHMENT_THRESHOLD="80000"
export GP2GP_LARGE_EHR_EXTRACT_THRESHOLD="80000"

# GP CONNECT CONSUMER ADAPTOR VARS
export GPC_CONSUMER_SERVER_PORT="8090"
export GPC_CONSUMER_SDS_URL="REQUIRED - FILL IN" # E.g. http://wiremock:8080/spine-directory/"
export GPC_CONSUMER_SDS_APIKEY="REQUIRED - FILL IN"

# these variables are ignored if they are not present
export GPC_CONSUMER_SSP_URL="REQUIRED - FILL IN"
export GPC_CONSUMER_SPINE_CLIENT_CERT="REQUIRED - FILL IN"
export GPC_CONSUMER_SPINE_CLIENT_KEY="REQUIRED - FILL IN"
export GPC_CONSUMER_SPINE_ROOT_CA_CERT="REQUIRED - FILL IN"
export GPC_CONSUMER_SPINE_SUB_CA_CERT="REQUIRED - FILL IN"

####################################
# STUB SDS VARS

# GPC Producer endpoints
export STUB_GPC_SDS_STRUCTURED_URL="https://example.com/L23456/STU3/1/gpconnect/structured"
export STUB_GPC_SDS_DOCUMENTS_URL="https://example.com/L23456/STU3/1/gpconnect/documents"

####################################
# LOGGING

export MHS_LOG_LEVEL="DEBUG"
export GP2GP_LOGGING_LEVEL="DEBUG"
export GPC_CONSUMER_LOGGING_LEVEL="DEBUG"
