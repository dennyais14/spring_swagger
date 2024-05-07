package com.develhope.swagger01;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.models.media.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/v1")

public class SpringController {

    @ApiResponses(value = {
            @ApiResponse(description = "get your name", responseCode = "200", content = {
                    @Content(mediaType = "Application/String")
            })
    })
    @RequestMapping(method = RequestMethod.GET, path = "/name")
    public String getName(@Parameter(description = "return the name")
                              @RequestParam(value = "name", defaultValue = "default") String name) {
        return name;
    }

    @ApiResponses(value = {
            @ApiResponse(description = "reverse your name", responseCode = "200", content = {
                    @Content(mediaType = "Application/String")
            })
    })

    @RequestMapping(method = RequestMethod.POST, path = "/name")
    public String postName(@RequestBody String name) {
        return new StringBuilder(name).reverse().toString();
    }
}
