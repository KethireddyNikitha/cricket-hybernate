/*
 * 
 * You can use the following import statemets
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * import org.springframework.beans.factory.annotation.Autowired;
 * 
 */

// Write your code here
package com.example.player.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;


import com.example.player.service.PlayerJpaService;
import com.example.player.model.Player;

@RestController
public class PlayerController{

    @Autowired
    private PlayerJpaService playerService;

    @GetMapping("/players")
    public ArrayList<Player> getAllPlayers(){
        return playerService.getAllPlayers();
    }


    @GetMapping("/players/{playerId}")
    public Player getPlayerById(@PathVariable("playerId") int playerId){
        return playerService.getPlayerById(playerId);
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player){
        return playerService.addPlayer(player);
    }


    @PutMapping("/players/{playerId}")
    public Player updatePlayer(@PathVariable("playerId") int playerId,@RequestBody Player player){
        return playerService.updatePlayer(playerId, player);
    }


    @DeleteMapping("/players/{playerId}")
    public void deltePlayer(@PathVariable("playerId") int playerId){
        playerService.deletePlayer(playerId);
    }
}
