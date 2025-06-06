package com.evolutionnext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

@Controller
public class LoginController {

    // private final String keycloakLogoutUri = "http://localhost:8082/realms/my-realm/protocol/openid-connect/logout";

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, @AuthenticationPrincipal OidcUser oidcUser) {
        model.addAttribute("name", oidcUser.getFullName());
        return "dashboard";
    }
}
