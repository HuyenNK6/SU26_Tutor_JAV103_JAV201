package buoi1.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor //ctor ko tham số
@AllArgsConstructor //ctor có tham số
@Getter
@Setter
@Entity//đánh dấu class này là 1 bảng trong database
@Table(name = "sinh_vien") //Map Java class -> bảng sinh_vien
public class SinhVien {
    @Id//khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY)//ko cần insert id
    private Integer id;
    @Column(name = "ma")// -> dùng để Map trường field với tên cột trong bảng database
    private String ma;
    @Column(name = "ten")
    private String ten;
    @Column(name = "tuoi")
    private Integer tuoi;
    @Column(name = "dia_chi")
    private String diaChi;
    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;
    //@Column(name = "lop_id")//FK
    //Mapping mối quan hệ ORM (Object Relational Mapping) chuẩn
    @ManyToOne//Quan hệ: Nhiều Sinh viên - 1 Lớp
    @JoinColumn(name = "lop_id", referencedColumnName = "id")
    //Cột khóa ngoại "lop_id" trong bảng Sinh viên -> Tham chiếu tới cột "id" bảng Lớp
    private Lop lop;
}
