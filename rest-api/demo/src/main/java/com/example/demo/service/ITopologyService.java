package com.example.demo.service;

import com.example.demo.config.Interceptor;
import com.example.demo.dto.topology.Cluster;
import com.example.demo.dto.topology.ClusterList;
import com.example.demo.dto.topology.Topology;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Service for Topology.
@FeignClient(name = "onos-topology", url = "http://192.168.56.1:8181/onos/v1", configuration = Interceptor.class)
public interface ITopologyService {

    //GET requests.
    @GetMapping("/topology")
    Topology getTopology();

    @GetMapping("/topology/clusters")
    ClusterList getClusters();

    @GetMapping("/topology/clusters/{id}")
    Cluster getClustersById(@PathVariable("id") long id);
}
