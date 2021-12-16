package com.devcarlos.request;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AnimePostRequestBody {

    @NotEmpty(message = "Campo não pode ser vazio")
    @NotNull(message = " the anime name cannot be null")
    private String name;
}
