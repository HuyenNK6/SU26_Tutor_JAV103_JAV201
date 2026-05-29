package buoi1.servlet;

import buoi1.entity.Lop;
import buoi1.entity.SinhVien;
import buoi1.repository.LopRepository;
import buoi1.repository.SinhVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "sinhVienServlet", value = {
        "/sinh-vien/hien-thi",//GET
        "/sinh-vien/add",//POST
        "/sinh-vien/detail",//GET
        "/sinh-vien/delete",//GET
        "/sinh-vien/update",//POST
        "/sinh-vien/view-update",//GET
        "/sinh-vien/search",//GET
        "/sinh-vien/paging",//GET
        "/sinh-vien/top3"//GET
        })
public class SinhVienServlet extends HttpServlet {
    SinhVienRepository sinhVienRepo= new SinhVienRepository();
    LopRepository lopRepo= new LopRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri= req.getRequestURI();
        if(uri.contains("hien-thi")){
            this.hienThi(req, resp);
        }else if(uri.contains("detail")){
            this.detail(req, resp);
        }else if(uri.contains("delete")){
            this.delete(req, resp);
        }else if(uri.contains("view-update")){
            this.viewUpdate(req, resp);
        }else if(uri.contains("search")){
            this.search(req, resp);
        }else if(uri.contains("paging")){
            this.paging(req, resp);
        }else if(uri.contains("top3")){
            this.top(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri= req.getRequestURI();
        if(uri.contains("add")){
            this.add(req, resp);
        }else if(uri.contains("update")){
            this.update(req, resp);
        }

    }
    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. Lấy thông tin mới dc nhập từ JSP
        String ma= req.getParameter("ma");
        String ten= req.getParameter("ten");
        Integer tuoi= Integer.valueOf(req.getParameter("tuoi"));
        String diaChi= req.getParameter("diaChi");
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));
        Integer lopId= Integer.valueOf(req.getParameter("lopId"));
        Lop lop = lopRepo.getOne(lopId); //tìm kiếm đối tượng Lớp qua ID
        //2. Tạo đối tượng SV mới -> sử dụng Builder
        SinhVien sv= new SinhVien(null, ma, ten, tuoi, diaChi,gioiTinh,lop);
        //3. Thêm vào csdl
        sinhVienRepo.add(sv);
        //4. Load lại danh sách vào table
        //Cách 1
//        req.setAttribute("listSV", sinhVienRepo.getAll());
//        req.setAttribute("listLop", lopRepo.getAll());
//        req.getRequestDispatcher("/buoi1/hien-thi.jsp").forward(req,resp);
        //Cách 2
        resp.sendRedirect("/sinh-vien/hien-thi");
    }
    private void update(HttpServletRequest req, HttpServletResponse resp) {
    }



    private void top(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void paging(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id= Integer.valueOf(req.getParameter("id"));
        SinhVien sv= sinhVienRepo.getOne(id);
        req.setAttribute("sv",sv); //gửi đối tượng SV vừa tìm thấy
        req.setAttribute("listSV", sinhVienRepo.getAll());//rút gọn hoặc viết đầy đủ như phần hienThi
        req.setAttribute("listLop", lopRepo.getAll());
        req.getRequestDispatcher("/buoi1/hien-thi.jsp").forward(req,resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. lấy toàn bộ danh sách Sinh viên & Lớp
        List<SinhVien> listSV= sinhVienRepo.getAll();
        List<Lop> listLop = lopRepo.getAll(); //bổ sung + khởi tạo LopRepository lopRepo= new LopRepository();
        //2. set thuộc tính cho listSV
        req.setAttribute("listSV",listSV);
        req.setAttribute("listLop",listLop);//bổ sung
        //3. gửi thông tin sang jsp
        req.getRequestDispatcher("/buoi1/hien-thi.jsp").forward(req,resp);
    }

}
