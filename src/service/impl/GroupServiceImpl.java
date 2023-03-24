package service.impl;

import db.Database;
import model.Group;
import service.GroupService;

import java.util.*;
import java.util.stream.Collectors;

public class GroupServiceImpl implements GroupService {
    Database database = new Database();

    @Override
    public String addNewGroup(Group group) {
        database.getGroups().add(group);
        return "success " + group.getName();
    }

    @Override
    public String getGroupById(int id) {
        System.out.println(database.getGroups().stream().allMatch(x -> x.getId() == id));
        return " ";
    }

    @Override
    public List<Group> getAllGroups() {
        database.getGroups().forEach(System.out::println);
        return database.getGroups();
    }

    @Override
    public String updateGroupName(int id, String groupName) {
        database.getGroups().stream().map(g -> {
            if (g.getId() == id) {
                g.setName(groupName);
            }
            return g;
        }).collect(Collectors.toList());
        database.setGroups(database.getGroups());
        return "Group name updated successfully.";
    }

    @Override
    public List<Group> filterByYear(int year, String ascDesc) {
        database.getGroups().stream().filter(g -> g.getYear() == year && g.getName().equalsIgnoreCase(ascDesc))
                .collect(Collectors.toList());
        return database.getGroups();
    }

    @Override
    public List<Group> sortGroupByYear(String ascDesc) {
        database.getGroups().stream().sorted(Comparator.comparing(Group::getYear)).collect(Collectors.toList());
        if (ascDesc.equalsIgnoreCase("desc")) {
            Collections.reverse(database.getGroups());
        }
        return database.getGroups();
    }

    @Override
    public void deleteGroupById(int id) {
        database.getGroups().stream().filter(g -> g.getId() != id).collect(Collectors.toList());
        database.setGroups(database.getGroups());
    }
}