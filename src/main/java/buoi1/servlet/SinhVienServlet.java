package buoi1.servlet;

import buoi1.entity.SinhVien;
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

    private void detail(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. lấy toàn bộ danh sách Sinh viên
        List<SinhVien> listSV= sinhVienRepo.getAll();
        //2. set thuộc tính cho listSV
        req.setAttribute("listSV",listSV);
        //3. gửi thông tin sang jsp
        req.getRequestDispatcher("/buoi1/hien-thi.jsp").forward(req,resp);
    }

}
