package com.arevalo.paola.netby.controller;

import com.arevalo.paola.netby.routers.ServiceRouter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Paola Arevalo <p.arevaloq@hotmail.com>
 * @version 1.0
 * @date 04/06/2024
 */
@RestController
public class ServiceController {

    @GetMapping(ServiceRouter.PROBLEM_ONE)
    public ResponseEntity<?> resultProblemOne( ) {
        return ResponseEntity.ok("ok");
    }


}
