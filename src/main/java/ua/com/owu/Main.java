package ua.com.owu;

import ua.com.owu.entity.Room;
import ua.com.owu.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("slayk");
        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();

       /* manager.persist(new User("diana",25));
        System.out.println(manager.find(User.class, 1));
        manager.getTransaction().commit();*/


        /*List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(6));
        rooms.add(new Room(3));
        rooms.add(new Room(1));*/

        List<Room> rooms = manager.createQuery("from Room r", Room.class).getResultList();
        User user = manager.find(User.class, 1);
        user.setRooms(rooms);
        manager.persist(user);

        manager.getTransaction().commit();
        manager.close();
        entityManagerFactory.close();
    }
}
