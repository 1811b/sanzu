package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value ="qsy")
public interface BookService extends BookServiceapi {

}
