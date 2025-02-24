package com.example.apigateway;

//@RestController
//class EurekaClientRestController {
//
//    @Autowired
//    private DiscoveryClient discoveryClient;
//
//    @RequestMapping("/clients/{applicationName}")
//    public @ResponseBody String getClientsByApplicationName(@PathVariable String applicationName) {
//        return this.discoveryClient.getInstances(applicationName).get(0).getUri().toString();
//    }
//}