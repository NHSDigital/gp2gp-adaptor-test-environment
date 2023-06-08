# GP2GP Adaptor Test Environment

The test environment is designed to perform local e2e testing of the 
[GP2GP Adaptor](https://github.com/nhsconnect/integration-adaptor-gp2gp). 
It makes it possible to send GP2GP messages directly to the 
[MHS Adaptor](https://github.com/nhsconnect/integration-adaptor-mhs.git) 
and read the response messages that would be sent through Spine.

## Getting Started

There is a bash script provided to run the environment. To use it, run 
the following command from the project root directory. 

Linux/mac
```shell
./run-environment.sh
```

### docker images

The current release of the GP2GP Adaptor has separate docker images optimised for ARM and x86 architecture. 
By default, the test environment uses the ARM image. This can be changed by commenting / uncommenting *line 111* 
and *line 112* in the [docker compose file](docker-compose.yml).


## Running tests 

A collection of tests has been provided to send requests using 
Postman and verify the responses, which can be found in `/postman`.

As the MHS adaptor expects inbound requests to use HTTPS, a set of certificates for localhost has 
been provided in `/postman/localhost-certificates`. These should be added to Postman in 
*settings > certificates*. 

## Running tests against an alternative GPC producer

By default, the test environment uses a mock GP Connect producer. To connect an
alternative producer change the following variables in `vars.sh`:

| KEY                         | Value                                                                                                  |
|-----------------------------|--------------------------------------------------------------------------------------------------------|
| GPC_CONSUMER_SDS_URL        | Must equal: *http://stub-gpc-sds:8080/spine-directory/*                                                |
| STUB_GPC_SDS_STRUCTURED_URL | URL of your structured record endpoint:  e.g. *https://example.com/L23456/STU3/1/gpconnect/structured* |
| STUB_GPC_SDS_DOCUMENTS_URL  | URL of your documents' endpoint: e.g. *https://example.com/L23456/STU3/1/gpconnect/documents*          |

Please note, the `to-party-id` variable in the Postman collection is verified by the MHS Adaptor 
and therefore needs to match the `MHS_SECRET_PARTY_KEY` environment variable defined in `vars.sh`.

Each test has a unique NHS number which can be configured by changing the current value 
of the appropriate collection variable, i.e. 
`test-{number}-nhs-number`.


