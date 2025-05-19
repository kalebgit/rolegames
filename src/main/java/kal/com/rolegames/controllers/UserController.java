package kal.com.rolegames.controllers;

import kal.com.rolegames.models.users.User;
import kal.com.rolegames.repositories.users.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

@Controller
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {


    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal User user){
        String username = user.getUsername();
        Collection<? extends GrantedAuthority> authorities  = user.getAuthorities();
        Map<String, Object> response = new Hashtable<>();
        response.put("username", username);
        response.put("authorities", authorities);
        return ResponseEntity.ok(response);
    }

}
