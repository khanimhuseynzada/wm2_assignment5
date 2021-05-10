package example.micronaut.controller.impl;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import java.security.Principal;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/auth")
public class AuthController {

    @Produces(MediaType.TEXT_PLAIN)
    @Get
    public String getUserData(Principal user) {
        return user.getName();
    }
}
