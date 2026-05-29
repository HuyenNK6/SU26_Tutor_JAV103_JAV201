package buoi1.repository;

import buoi1.entity.Lop;
import buoi1.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class LopRepository {
    private Session session;

    public LopRepository() {
        session= HibernateConfig.getFACTORY().openSession();
    }
    public List<Lop> getAll(){
        return  session.createQuery("FROM Lop").list();
    }
    public Lop getOne(Integer id){
        return  session.find(Lop.class, id);
    }

    public static void main(String[] args) {
        System.out.println(new LopRepository().getAll());
    }
}
