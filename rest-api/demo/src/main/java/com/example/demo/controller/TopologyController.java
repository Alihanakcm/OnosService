package com.example.demo.controller;

import com.example.demo.dto.topology.Cluster;
import com.example.demo.dto.topology.ClusterList;
import com.example.demo.dto.topology.Topology;
import com.example.demo.service.ITopologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller for Topology.
@RestController
@RequestMapping("/topology")
public class TopologyController {

    //Constructor injection.
    private final ITopologyService topologyService;

    @Autowired
    public TopologyController(ITopologyService topologyService
    ){
        this.topologyService = topologyService;
    }

    //GET requests.
    @GetMapping("")
    public Topology getTopology(){
        return topologyService.getTopology();
    }

//    @GetMapping("/clusters/{id}")
//    public Cluster getClusterById(@PathVariable("id") long id){
//        return topologyService.getClustersById(id);
//    }
//
//    @GetMapping("/clusters")
//    public ClusterList getClusters() {
//        return topologyService.getClusters();
//    }
}
