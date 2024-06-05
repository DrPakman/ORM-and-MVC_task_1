package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("Toyota", 123);
      User user1 = new User("User1", "Lastname1", "user1@mail.com", car1);
      userService.add(user1);

      Car car2 = new Car("Honda", 456);
      User user2 = new User("User2", "Lastname2", "user2@mail.com", car2);
      userService.add(user2);

      Car car3 = new Car("Ford", 789);
      User user3 = new User("User3", "Lastname3", "user3@mail.com", car3);
      userService.add(user3);

      Car car4 = new Car("BMW", 101);
      User user4 = new User("User4", "Lastname4", "user4@mail.com", car4);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car Model = "+user.getCar().getModel());
         System.out.println("Car Series = "+user.getCar().getSeries());
         System.out.println();
      }

      context.close();
   }
}
