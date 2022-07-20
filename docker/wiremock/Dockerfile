FROM wiremock/wiremock:2.33.2

COPY stubs /home/wiremock

COPY ./extensions /var/wiremock/extensions

CMD ["--extensions", "extensions.JwtOdsExtractor", "--global-response-templating", "--verbose"]