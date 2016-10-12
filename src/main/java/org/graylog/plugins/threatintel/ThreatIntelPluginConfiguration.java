package org.graylog.plugins.threatintel;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
@AutoValue
public abstract class ThreatIntelPluginConfiguration {

    @JsonProperty("otx_enabled")
    public abstract boolean otxEnabled();

    @JsonProperty("otx_api_key")
    public abstract String otxApiKey();

    @JsonCreator
    public static ThreatIntelPluginConfiguration create(@JsonProperty("otx_enabled") boolean otxEnabled,
                                                        @JsonProperty("otx_api_key") String otxApiKey) {
        return builder()
                .otxEnabled(otxEnabled)
                .otxApiKey(otxApiKey)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_ThreatIntelPluginConfiguration.Builder();
    }

    @JsonIgnore
    public boolean isComplete() {
        return otxApiKey() != null && !otxApiKey().isEmpty();
    }


    @AutoValue.Builder
    public static abstract class Builder {
        public abstract Builder otxEnabled(boolean otxEnabled);

        public abstract Builder otxApiKey(String otxApiKey);

        public abstract ThreatIntelPluginConfiguration build();
    }

}