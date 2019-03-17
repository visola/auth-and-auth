package org.visola.authandauth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.visola.authandauth.Service;
import org.visola.authandauth.data.ServiceDao;

@RestController
@RequestMapping("${api.base}/services")
public class ServiceController {

  private final ServiceDao serviceDao;

  public ServiceController(ServiceDao serviceDao) {
    this.serviceDao = serviceDao;
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity createService(@RequestBody Service service) {
    if (serviceDao.count(service.getName()) != 0) {
      return ResponseEntity.status(HttpStatus.CONFLICT)
          .body(String.format("Service with name '%s' already exists.", service.getName()));
    }

    service.setId(serviceDao.create(service));
    return ResponseEntity.ok(service);
  }

}
