package com.bajaj.apitest.service;

import com.bajaj.apitest.dto.BfhlRequest;
import com.bajaj.apitest.dto.BfhlResponse;

public interface BfhlService {
    BfhlResponse processRequest(BfhlRequest request);
}
