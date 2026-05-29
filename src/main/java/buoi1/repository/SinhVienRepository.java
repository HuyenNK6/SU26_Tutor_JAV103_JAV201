package buoi1.repository;

import buoi1.entity.SinhVien;
import buoi1.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class SinhVienRepository {
    //CRUD bảng sinh_vien
    //Session giống như kết nối giữa Java vs database -> phiên làm việc
    private Session session;

    public SinhVienRepository() {
        session= HibernateConfig.getFACTORY().openSession();
    }
    /*
     HQL: Hibernate Query Language là ngôn ngữ truy vấn của Hibernate để làm việc với dữ liệu
     thông qua các class Java (Entity) thay vì thao tác trực tiếp với bảng trong database
     SQL: "select * from sinh_vien"
     */
    public List<SinhVien> getAll(){
        //HQL: thao tác với Class Java, ko thao tác trực tiếp vs tên bảng sinh_vien
        return session.createQuery("FROM SinhVien").list();
    }
    public SinhVien getOne(Integer id){
        return session.find(SinhVien.class, id);
    }
    public void add(SinhVien sv){
        try {
            session.getTransaction().begin();
            session.save(sv);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //test nhanh
        System.out.println(new SinhVienRepository().getAll());
    }
}
