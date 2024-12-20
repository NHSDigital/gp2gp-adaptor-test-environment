#!/usr/bin/env bash

####################################
# MHS VARS

#SECRET KEY VARS
#Certificates provided for localhost
export MHS_SECRET_PARTY_KEY="Y90664-9198273"
export MHS_SECRET_CLIENT_CERT="-----BEGIN CERTIFICATE-----
MIIFPTCCAyUCFAKYCULeFVcQCwXCGCiCFVu09NmzMA0GCSqGSIb3DQEBCwUAMF0x
CzAJBgNVBAYTAlVLMRMwEQYDVQQIDApTb21lLVN0YXRlMSEwHwYDVQQKDBhJbnRl
cm5ldCBXaWRnaXRzIFB0eSBMdGQxFjAUBgNVBAMMDWdwMmdwLW1uaC1lMmUwHhcN
MjIwNzA1MTQwNzM5WhcNMzIwNzAyMTQwNzM5WjBZMQswCQYDVQQGEwJVSzETMBEG
A1UECAwKU29tZS1TdGF0ZTEhMB8GA1UECgwYSW50ZXJuZXQgV2lkZ2l0cyBQdHkg
THRkMRIwEAYDVQQDDAlsb2NhbGhvc3QwggIiMA0GCSqGSIb3DQEBAQUAA4ICDwAw
ggIKAoICAQCv++J5CEdRMbVv7VRLyf4peMzffF43Ws4R0zdKeLn0BL3IXAHdpbPz
eKj3kWW/eqBr1D/QiAxmJgYPmyIY2rCyggDVBLh2QtRKiKzsHGWT+8QjT9UzkxAc
cDHF2tBjdmGnDY6QVHSuWpdlc8aXD+zEpRU7tb65FufhzgwJMpDzMlapckMPYdyC
sqZmQJiMTi7cLRvF1X21X0phx6VaZiIZ1LYism7BGmL3EL8rWtPzpOwXZwQ2ZXpK
uSFhrpbOHoyx/XX+sPTzZx6QYmxFMbQQKnebgj2ziHnQYfGjYMG3u+iGJ6NDCu5Q
MtwhscTE0M/T5WOQ7kINGOjVrT5JOAADajQCQBioFpTf82/jlNgc0lqO81EB6QDg
S9unFNSx5Cc2sBdfXoitzIEB+PoYyAa2OjogCdpo+5wAOaj6Ga5L2q6oVAV+vtuf
XtmdQQWtY12RcsWi1Q/Ju5LnJ2ubkLdOSzMJyufma08s+pd3OHBaZ72FrQ7L/XMk
Tq5qzSUohOaEneOPCKWkxLTJyZn0AqKglbn8qdMMuSLUUF/v6bRKyIUOQ9+/RaeD
sB1hoLSxyiS6d+i5gROYe6nGuIpKf3ggTs5H7Ri/m2AbOm8UjqUfP2U4phfxQJ/7
/eZ72L+UNje5OVN9eTInCWq+D9oQaukhmCL/DX7f87gX1Hseta0cmwIDAQABMA0G
CSqGSIb3DQEBCwUAA4ICAQBZa5zNp8IYJfdYoNMwgy4omq4Mpo+wO1mXyrHxmxsy
3o3oOCvg3+b7WREZRmCfI5BdFRKID5dFenqJVXv21ITRp3yEz21YMAYui2zqlm7E
A+IhyMFAwKwbDSjrU2DsCqodTOX/KVFk6Lvlq+/LPpiTW99aG6NO6gQHm2/5P1kH
FSpPzlIItrEegYEQJd9hBk9AFXsm+uQo6smc+ykriv01AKFQ3uv36SlSYptV88ua
3ZLihHUnToMMMcPUCzYToOFass+W7N4tI7+rI0GPV777gQEQM/KKR+lFvZzUijmK
jRe3uTiMc/r/yHwh+U9uEqjh+Gd5KXRe9+oItE3FcbG4C2tvtud/T7gfdnXV3h1t
A7mdmJII2zLHJjFe2yIBOlHuG/kOryD5mAX+FaGk1NFRdpLVbuheh//C4HZrB+N/
gp418dhX0XcynuekyerV98kVOvlR9I9fQvCegmq5B7bHYICp2w4KmBvntZoQJxUh
yaA5gQ96cu9DIxFvJhkVOKsjqKucS/o9jgwebh2Mazd42cDcdWf4WPOA9FTFvcrf
iZYzqfY3DB0POlCi+wo0AtrsgnUKrc1m7GPiJktj0rdodJ5t8D0AJBXLjtg49c5t
4f5BTpShsUi9oolMK4UuIJT6Rs7xVBbLICFFkOTUq4FcqaBLReUrxPZ90vzQWela
PQ==
-----END CERTIFICATE-----"
export MHS_SECRET_CLIENT_KEY="-----BEGIN RSA PRIVATE KEY-----
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
+8E2oWGLEsKyGk9dYzUUzJUSHM7roH31dA==
-----END RSA PRIVATE KEY-----"
export MHS_SECRET_CA_CERTS="-----BEGIN CERTIFICATE-----
MIIFmzCCA4OgAwIBAgIUMqDLTJb+ZWl7o4sXlPD0B7vB5NkwDQYJKoZIhvcNAQEL
BQAwXTELMAkGA1UEBhMCVUsxEzARBgNVBAgMClNvbWUtU3RhdGUxITAfBgNVBAoM
GEludGVybmV0IFdpZGdpdHMgUHR5IEx0ZDEWMBQGA1UEAwwNZ3AyZ3AtbW5oLWUy
ZTAeFw0yMjA3MDUxMzM1NDJaFw0zMjA3MDIxMzM1NDJaMF0xCzAJBgNVBAYTAlVL
MRMwEQYDVQQIDApTb21lLVN0YXRlMSEwHwYDVQQKDBhJbnRlcm5ldCBXaWRnaXRz
IFB0eSBMdGQxFjAUBgNVBAMMDWdwMmdwLW1uaC1lMmUwggIiMA0GCSqGSIb3DQEB
AQUAA4ICDwAwggIKAoICAQDcLaOTbCaKpBY9D2xJJnCRWMkRNupKn2RFxeSfdjOA
iH5cibZNwUVfO78FwLfgGGdfO50/zZv89TGYobjh0VJGh3JWl8W8XMm7QIXT5ECl
et0/js1Sih8MihvZxrfmebEW4ZSqti58Nyq3SkiZiNioUJs0LaICWQ4KsAQDDdJi
GAQiRQt+4h/gimqc9niHiv3U4K6WYrbOaRy7JNS9dFTdZVpUXkZh9uH4FBvaEhi9
54UXVPduvubdqTMa4e+b59IJ41vO7s1BOT5bupd7r1muAAWHe46y7rwLQ4buFjYl
w//WeO9RKUpoLLYkRKyg+Kd3zF17rjZDBZpi5Bir2IlnXquftL+Dq9EnLVMYN8cw
jijyk/MlYvKIsTX1afbKImU3AeM72+xZ9SQ5QvKsTh8YSyR333tqrIILjAfbXL4Z
yz0ulDKo5xuJ/2ZufA9fEB/uOAWHubx5QYOFNMOBD8oJeqhd95yEMxTM0kGgzNqD
QJbdpeAUVmK7u/MsZ6QRxN5fV0umsmXr8YM/ceq0lD0eqgb7MTl7iRgffap6QS/3
JwOx1yARwiYjbzy4hy+vNNclzRm3vx4eGuRZR2FQDQRCKu36mDBLbgiuC/kUlwfb
MvuzLgB8TF1Tvrcd4VjcBJmCHtIlXGjoCvTWpqETarXrvBVHzVcl8QKl2UAnpVZg
awIDAQABo1MwUTAdBgNVHQ4EFgQUhLh8vkQz8qjtbOtmCics3Xn8FOkwHwYDVR0j
BBgwFoAUhLh8vkQz8qjtbOtmCics3Xn8FOkwDwYDVR0TAQH/BAUwAwEB/zANBgkq
hkiG9w0BAQsFAAOCAgEAU8p+XVo2Cael1STmSLnKR8B/PD/y6gIukmLgoUX1u/NY
N5kgPMeuewgr4hg47CB9noiVDQGn6LLGzWR9HMH+LpxpDIXh7M4mguedkHzx7P/D
K/AeCazOvehWcdcBkKK5oUtIqd4Q3WpJ19V/FbHkNhj+hbI3er8P5SbiXU7aoBJE
J7qpvjkH88WQFkFTRW5y0LXNWZZyDC2X7U/c31UI/aWvmCVv53q8o5SWSgdWXZvg
HV4RqJcDWCnfGlw6c3GteFkI7roWRrBkfGdbfBdNc4WDruTSlYQeb8VAU3Uk3hIj
CrpO2PK670+9hawyzMYtjIvnx1+RebN9w7eHlL6uRw3kVz73vf5do5PVFA/6YaU2
VRsOKxzcRa8piw3b5ZJkpCHTkbo8WetqeVOYC1Glykw/0NaXfVGRvDB1rzVe/6GM
UxIWwRbWUiCJ7vqIxDu4geJOq+UHAXpBqhhocyv7en/ymSzsezOFVbgX7Wbw+oIh
+jBM4M4IZATtW9vFzhytO4WpZUQyahto8PYjauj6hjEjZAKak8kK2DwdjcvWj7/W
xt9hUUWhbTUtFfc95694SpTMzRNq1tH0r8TIpsZI0/KJaKau5M5R+5XTAMr/fo/v
T9etrsihBj08g8wbOxQCCeOuydoGCHAXrKyLHjCAGPp+r8LAJyQtjcWivK4arQg=
-----END CERTIFICATE-----"

#DYNAMODB VARS
export DYNAMODB_PORT="8000"

#MONGODB VARS
export MONGODB_PORT="27017"

#REDIS VARS
export REDIS_PORT="6379"

#GLOBAL VARS
export BUILD_TAG="latest"
export BASE_IMAGE_TAG="latest"
export AWS_ACCESS_KEY_ID="FILL IN"
export AWS_SECRET_ACCESS_KEY="FILL IN"
export MHS_STATE_TABLE_NAME="mhs_state"
export MHS_SYNC_ASYNC_STATE_TABLE_NAME="sync_async_state"
export MHS_DB_ENDPOINT_URL="http://dynamodb:`echo $DYNAMODB_PORT`"

# MHS OUTBOUND VARS
export MHS_OUTBOUND_PORT="80"
export MHS_RESYNC_INTERVAL="1"
export MAX_RESYNC_RETRIES="20"
export MHS_SPINE_ROUTE_LOOKUP_URL="http://mock-spine-mhs:8085"
export MHS_SPINE_ORG_CODE="YES"
export MHS_SPINE_REQUEST_MAX_SIZE="4999600"
export MHS_FORWARD_RELIABLE_ENDPOINT_URL="https://mock-spine-mhs:8443/reliablemessaging/forwardreliable"
export MHS_OUTBOUND_VALIDATE_CERTIFICATE="False"
#MHS_OUTBOUND_ROUTING_LOOKUP_METHOD = SPINE_ROUTE_LOOKUP or SDS_API VARS
export MHS_OUTBOUND_ROUTING_LOOKUP_METHOD="SPINE_ROUTE_LOOKUP"
#export MHS_SDS_API_URL=""
#export MHS_SDS_API_KEY=""

#MHS INBOUND VARS
export MHS_INBOUND_PORT="443"
export MHS_INBOUND_SERVICE_PORTS="`echo $MHS_INBOUND_PORT`,`echo $MHS_OUTBOUND_PORT`"
export MHS_INBOUND_QUEUE_BROKERS="amqp://activemq:5672"
export MHS_INBOUND_QUEUE_NAME="gp2gpInboundQueue"
export MHS_SECRET_INBOUND_QUEUE_USERNAME="guest"
export MHS_SECRET_INBOUND_QUEUE_PASSWORD="guest"
export MHS_INBOUND_QUEUE_MESSAGE_TTL_IN_SECONDS="1000"
export MHS_INBOUND_USE_SSL="True"
export MHS_INBOUND_QUEUE_MAX_RETRIES="3"
export MHS_INBOUND_QUEUE_RETRY_DELAY="500"
export MHS_INBOUND_HEALTHCHECK_SERVER_PORT="8083"

#MHS ROUTE VARS
# Route responses are mocked by mock-spine-mhs-outbound

####################################
# GP2GP VARS

export GP2GP_SERVER_PORT="8183"
export GP2GP_AMQP_BROKERS="amqp://activemq:5672"
export GP2GP_MONGO_URI="mongodb://mongodb:27017"
export GP2GP_MONGO_DATABASE_NAME="gp2gp"
export GP2GP_MHS_OUTBOUND_URL="http://outbound:80"
export GP2GP_GPC_GET_URL="http://gpcc:8090/@ODS_CODE@/STU3/1/gpconnect"
export GP2GP_MHS_INBOUND_QUEUE="gp2gpInboundQueue"


# GP CONNECT CONSUMER ADAPTOR VARS (alter to connect the GP2GP Adaptor to a GP Connect Producer)
# connected to a mock producer by default

export GPC_CONSUMER_SERVER_PORT="8090"

# Use http://stub-gpc-sds:8080/spine-directory/ to connect to a GPC Producer endpoint
#export GPC_CONSUMER_SDS_URL="http://stub-gpc-sds:8080/spine-directory/"
export GPC_CONSUMER_SDS_URL="http://wiremock:8080/spine-directory/"
export GPC_CONSUMER_SDS_APIKEY="anykey"

# these variables are ignored if they are not present
#export GPC_CONSUMER_SSP_URL=
#export GPC_CONSUMER_SPINE_CLIENT_CERT=
#export GPC_CONSUMER_SPINE_CLIENT_KEY=
#export GPC_CONSUMER_SPINE_ROOT_CA_CERT=
#export GPC_CONSUMER_SPINE_SUB_CA_CERT=

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

####################################
#AWS/Azure
#export GP2GP_STORAGE_TYPE="S3"
#export GP2GP_STORAGE_CONTAINER_NAME="testbucketnia"
#export AWS_ACCESS_KEY_ID=""
#export AWS_SECRET_ACCESS_KEY=""
#export AWS_REGION="eu-west-2"

export SUPPORTED_FILE_TYPES="text/plain,text/html,application/pdf,text/xml,application/xml,text/rtf,audio/basic,audio/mpeg,image/png,image/gif,image/jpeg,image/tiff,video/mpeg,application/msword,application/octet-stream,application/vnd.ms-excel.addin.macroEnabled.12,application/vnd.ms-excel.sheet.binary.macroEnabled.12,application/vnd.ms-excel.sheet.macroEnabled.12,application/vnd.ms-excel.template.macroEnabled.12,application/vnd.ms-powerpoint.presentation.macroEnabled.12,application/vnd.ms-powerpoint.slideshow.macroEnabled.12,application/vnd.ms-powerpoint.template.macroEnabled.12,application/vnd.ms-word.document.macroEnabled.12,application/vnd.ms-word.template.macroEnabled.12,application/vnd.openxmlformats-officedocument.presentationml.template,application/vnd.openxmlformats-officedocument.presentationml.slideshow,application/vnd.openxmlformats-officedocument.presentationml.presentation,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.openxmlformats-officedocument.spreadsheetml.template,application/vnd.openxmlformats-officedocument.wordprocessingml.template,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/bmp,text/richtext,text/rtf,application/x-hl7,application/pgp-signature,video/msvideo,application/pgp,application/x-shockwave-flash,application/x-rar-compressed,video/x-msvideo,audio/wav,application/hl7-v2,audio/x-wav,application/vnd.ms-excel,audio/x-aiff,audio/wave,application/pgp-encrypted,video/x-ms-asf,image/x-windows-bmp,video/3gpp2,application/x-netcdf,video/x-ms-wmv,application/x-rtf,application/x-mplayer2,chemical/x-pdb,text/csv,image/x-pict,audio/vnd.rn-realaudio,text/css,video/quicktime,video/mp4,multipart/x-zip,application/pgp-keys,audio/x-mpegurl,audio/x-ms-wma,chemical/x-mdl-sdfile,application/x-troff-msvideo,application/x-compressed,image/svg+xml,chemical/x-mdl-molfile,application/EDI-X12,application/postscript,application/xhtml+xml,video/x-flv,application/x-zip-compressed,application/hl7-v2+xml,application/vnd.openxmlformats-package.relationships+xml,video/x-ms-vob,application/x-gzip,audio/x-pn-wav,application/msoutlook,video/3gpp,application/cdf,application/EDIFACT,application/x-cdf,application/x-pgp-plugin,audio/x-au,application/dicom,application/EDI-Consent,application/zip,application/json,application/x-pkcs10,application/pkix-cert,application/x-pkcs12,application/x-pkcs7-mime,application/pkcs10,application/x-x509-ca-cert,application/pkcs-12,application/pkcs7-signature,application/x-pkcs7-signature,application/pkcs7-mime"
