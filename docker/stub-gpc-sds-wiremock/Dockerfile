FROM wiremock/wiremock:2.33.2

COPY stubs /home/wiremock

CMD ["--permitted-system-keys", "STUB_GPC_SDS.*", "--global-response-templating", "--verbose"]