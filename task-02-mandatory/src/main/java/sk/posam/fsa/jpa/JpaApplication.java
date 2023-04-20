package sk.posam.fsa.jpa;

//import sk.posam.fsa.jpa.domain.Actor;
import sk.posam.fsa.jpa.domain.*;
//import sk.posam.fsa.jpa.domain.Film;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

public class JpaApplication {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dvdrental-pu-name");
        EntityManager em = factory.createEntityManager();

        //printing all actors for every film (there is more than one actor in film)
        Query q = em.createQuery("select f from Film f");
        List<Film> films = q.getResultList();
        for (Film film : films) {
            Set<Actor> actors = film.getActors();

            System.out.println("Actors in film " + film.getTitle() + ":");
            for (Actor actor : actors) {
                System.out.println(actor.getName() + " " + actor.getSurname());
            }
            System.out.println("-----------------");
        }
        System.out.println("Size: " + films.size());

/*
        //language for film from (from table INVENTORY, testing mapping)
        Query q = em.createQuery("select i from Inventory i");
        List<Inventory> inventories = q.getResultList();
        for (Inventory inventory : inventories) {
            System.out.println(inventory.getInventoryFilm().getLanguage().getName());

        }
        System.out.println("Size: " + inventories.size());
*/
/*
        //printing categories for every film (every film have only one category :D)
        Query q = em.createQuery("select f from Film f");
        List<Film> films = q.getResultList();
        for (Film film : films) {
            Set<Category> categories = film.getFilmCategories();

            System.out.println("Size: " + categories.size());
            System.out.println("Categories for film " + film.getTitle() + ":");
            for (Category category : categories) {
                System.out.println(category.getName());
            }

        }
        System.out.println("Size: " + films.size());
 */
/*
        //printing addresses for staff members
        Query q = em.createQuery("select s from Staff s");
        List<Staff> staffList = q.getResultList();
        for (Staff staff : staffList) {
            Address addresses = staff.getAddressStaff();
            System.out.println("Address for " + staff.getName() + ": " + addresses.getAddress() + " and city: " + addresses.getCity().getCityName());
        }
        System.out.println("Size: " + staffList.size());
*/
/*
        //printing all cities in country
        Query q = em.createQuery("select c from Country c");
        List<Country> countries = q.getResultList();
        for (Country country : countries) {
            Set<City> cities = country.getCity();
            System.out.println("Cities in " + country.getCountry() + ":");
            for (City city : cities) {
                System.out.println(city.getCityName());
            }
            System.out.println("--------------------------------");
        }
        System.out.println("Size: " + countries.size());
*/
/*
        // create new entry
        em.getTransaction().begin();
        Category category = new Category();
        category.setName("This is a test");
        category.setLastUpdated(new Date());
        em.persist(category);
        em.getTransaction().commit();
*/
        em.close();
    }
}
