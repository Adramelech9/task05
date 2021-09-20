package com.itransition.training.task05.Users.controllers;

import com.itransition.training.task05.Users.GameApplication;
import com.itransition.training.task05.Users.alfa.TableHelp;
import com.itransition.training.task05.Users.models.Rooms;
import com.itransition.training.task05.Users.models.TableUsers;
import com.itransition.training.task05.Users.repository.RoomRepository;
import com.itransition.training.task05.Users.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Controller
public class MainController {
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    public MainController(RoomRepository roomRepository, UserRepository userRepository) {
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
    }


    @GetMapping ("/")
    public String controlPanel(Model model) {
        model.addAttribute("rooms", roomRepository.findAll());
        
        return "../static/index";
    }

    @GetMapping("/create_room")
    public String creatingRoom(@RequestParam(name = "setOfMoves", required=false, defaultValue="") String setOfMoves, Model model) {
        String[] s = setOfMoves.toLowerCase().split(" ");
        List<String> list = Arrays.asList(s);
        if (list.size() == new HashSet<>(list).size())
        if ( s.length == 3 || s.length == 5 || s.length == 7) {
            String author = GameApplication.userName.substring(6, GameApplication.userName.length()-1);
            TableUsers tableUsers = userRepository.findByUserName(author);
                        Rooms newRooms = new Rooms(setOfMoves, author, tableUsers.getId());
            roomRepository.save(newRooms);
            return "redirect:/room/" + newRooms.getId();
        }
        model.addAttribute("rooms", roomRepository.findAll());

        return "roomSettings";
    }

    @GetMapping("/room/{id}")
    public String room(@PathVariable(value = "id") long id, Model model) {
        Rooms rooms = roomRepository.findById(id).orElseThrow();
        String username = GameApplication.userName.substring(6, GameApplication.userName.length()-1);
        if (rooms.getAuthor().equals(username)) model.addAttribute("playerNum", "Player1");
        else model.addAttribute("playerNum", "Player2");

        String[] moves = rooms.getSetOfMoves().split(" ");
        new TableHelp(moves.length, moves);
        model.addAttribute("table" , TableHelp.a);
        model.addAttribute("moves", rooms.getSetOfMoves());
        return "room";
    }

    @GetMapping("/room/join/{id}")
    public String joinRoom(@PathVariable(value = "id") long id) {
        if (!roomRepository.existsById(id)) return "redirect:/";
        Rooms rooms = roomRepository.findById(id).orElseThrow();
        rooms.setFreeRoom(false);
        roomRepository.save(rooms);
        return "redirect:/room/{id}";
    }

    @GetMapping("/room/{id}/delete")
    public String del(@PathVariable(value = "id") long id, Model model) {
        String username = GameApplication.userName.substring(6, GameApplication.userName.length()-1);
        Rooms rooms = roomRepository.findById(id).orElseThrow();
        if (rooms.getAuthor().equals(username)) roomRepository.delete(rooms);
        return "redirect:/";
    }
}
