import model.Group;
import service.impl.GroupServiceImpl;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GroupServiceImpl groupService = new GroupServiceImpl();


        System.out.println(groupService.addNewGroup(new Group(1, "java-9", "The best gorup", 2023)));
        System.out.println(groupService.addNewGroup(new Group(2, "java-8", "The best gorup", 2009)));
        System.out.println(groupService.addNewGroup(new Group(12, "java-7", "The best gorup", 2000)));


        groupService.deleteGroupById(12);
        System.out.println(groupService.filterByYear(2019, "desc"));
        groupService.deleteGroupById(12);


    }
}