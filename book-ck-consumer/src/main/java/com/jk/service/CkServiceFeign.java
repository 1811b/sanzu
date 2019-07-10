package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

import java.util.HashMap;

@FeignClient(value = "provider-ck",fallback = CkServiceError.class)
public interface CkServiceFeign extends CkService{

}
