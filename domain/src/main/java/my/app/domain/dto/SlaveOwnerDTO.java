package my.app.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SlaveOwnerDTO implements Serializable {

    @JsonProperty
    private String name;

    @JsonProperty
    private String province;

    @JsonProperty
    private String occupation;

    @JsonProperty
    private int bullshit;
}
