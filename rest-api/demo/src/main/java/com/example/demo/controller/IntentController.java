package com.example.demo.controller;

import com.example.demo.dto.intent.*;
import com.example.demo.service.IIntentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/intents")
public class IntentController {

    //Constructor injection.
    private final IIntentService intentService;

    @Autowired
    public IntentController(IIntentService intentService
    ){
        this.intentService = intentService;
    }

    //GET requests.
    @GetMapping("/{appId}/{key}")
    public DetailedIntent getIntentByAppIdAndKey(@PathVariable("appId") String appId, @PathVariable("key") String key){
        return intentService.getIntentByAppIdAndKey(appId, key);
    }

    @GetMapping("")
    public ArrayList<Intent> getIntents(){
        return (ArrayList) intentService.getIntents().get("intents");
    }

    //DELETE requests.
   @DeleteMapping("/{appId}/{key}")
    public String deleteIntentByAppIdAndKey(@PathVariable("appId") String appId, @PathVariable("key") String key){
        return intentService.deleteIntentByAppIdAndKey(appId, key);
    }

    //POST requests.
    @PostMapping("/post")
    public String postIntent(@RequestBody PostIntent stream){
        return intentService.postIntent(stream);
    }
}
