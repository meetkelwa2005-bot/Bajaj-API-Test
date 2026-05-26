package com.bajaj.apitest.controller;

import com.bajaj.apitest.dto.BfhlRequest;
import com.bajaj.apitest.dto.BfhlResponse;
import com.bajaj.apitest.service.BfhlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/bfhl")
@CrossOrigin(origins = "*") // Allow cross-origin requests for testing and integration
public class BfhlController {

    private final BfhlService bfhlService;

    @Autowired
    public BfhlController(BfhlService bfhlService) {
        this.bfhlService = bfhlService;
    }

    @GetMapping
    public ResponseEntity<java.util.Map<String, Object>> getOperationCode() {
        java.util.Map<String, Object> response = new java.util.HashMap<>();
        response.put("operation_code", 1);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<BfhlResponse> processPayload(@RequestBody(required = false) BfhlRequest request) {
        try {
            if (request == null) {
                return ResponseEntity.ok(new BfhlResponse(
                        false,
                        "meet_kelwa_23071997",
                        "meetkelwa230797@acropolis.in",
                        "0827CI231081",
                        Collections.emptyList(),
                        Collections.emptyList(),
                        Collections.emptyList(),
                        Collections.emptyList(),
                        "0",
                        ""
                ));
            }
            BfhlResponse response = bfhlService.processRequest(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.ok(new BfhlResponse(
                    false,
                    "meet_kelwa_23071997",
                    "meetkelwa230797@acropolis.in",
                    "0827CI231081",
                    Collections.emptyList(),
                    Collections.emptyList(),
                    Collections.emptyList(),
                    Collections.emptyList(),
                    "0",
                    ""
            ));
        }
    }
}
