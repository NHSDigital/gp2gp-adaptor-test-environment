# GP2GP Adaptor Test Environment

The test environment is designed to perform local e2e testing of the 
[GP2GP Adaptor](https://github.com/nhsconnect/integration-adaptor-gp2gp). 
It makes it possible to send GP2GP messages directly to the 
[MHS Adaptor](https://github.com/nhsconnect/integration-adaptor-mhs.git) 
and read the response messages that would be sent through Spine.

### Getting Started

There is a bash script provided to run the environment. To use it, run 
the following command from the project root directory. 

```shell
./run-environment.sh
```

By default, the test environment uses a mock GP Connect producer. To connect an 
alternative producer change the appropriate GPC Consumer environment variables in 
`vars.sh`. More information about these variables can be found in the 
[GPC Consumer Adaptor](https://github.com/nhsconnect/integration-adaptor-gpc-consumer) 
documentation.

### Running tests 

A collection of tests has been provided to send requests using 
Postman and verify the responses, which can be found in `/postman`.

As the MHS adaptor expects inbound requests to use HTTPS, a set of certificates for localhost has 
been provided in `/postman/localhost-certificates`. These should be added to Postman in 
*settings > certificates*. 

#### Running tests against an alternative GPC producer

The Postman collection variables can be configured to work with an alternative producer 
by changing the ASID and ODS codes to appropriate values. Please note, the `to-party-id` 
variable is verified by the MHS Adaptor and therefore needs to match the 
`MHS_SECRET_PARTY_KEY` environment variable defined in `vars.sh`.

Each test has a unique NHS number which can be configured by changing the current value 
of the appropriate collection variable, i.e. 
`test-{number}-nhs-number`.
