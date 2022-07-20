package model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payload {

    private static final String ODS_SYSTEM_VALUE = "https://fhir.nhs.uk/Id/ods-organization-code";

    @JsonProperty("requesting_organization")
    private RequestingOrganization requestingOrganization;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RequestingOrganization {

        @JsonProperty("identifier")
        private List<Identifier> identifierList;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Identifier {
            private String system;
            private String value;

            public boolean isOdsCode() {
                return system.equals(ODS_SYSTEM_VALUE);
            }
        }
    }


}

