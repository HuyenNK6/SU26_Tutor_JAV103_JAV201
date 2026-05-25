package buoi1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor //ctor ko tham số
@AllArgsConstructor //ctor có tham số
@Getter
@Setter
@Entity//đánh dấu class này là 1 bảng trong database
@Table(name = "lop")
public class Lop {
    @Id//khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY)//ko cần insert id
    private Integer id;
    @Column(name = "ma")// -> dùng để Map trường field với tên cột trong bảng database
    private String ma;
    @Column(name = "ten")
    private String ten;
}
