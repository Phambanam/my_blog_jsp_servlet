package com.phambanam.controller.login;

import com.phambanam.constant.SystemConstant;
import com.phambanam.model.UserModel;
import com.phambanam.service.IUserService;
import com.phambanam.util.FormUtil;

import com.phambanam.util.SessionUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/dang-nhap"})
public class LoginController extends HttpServlet {
    @Inject
    IUserService userService;
    ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

    @Override


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel model = FormUtil.toModel(UserModel.class, req);
        if (model != null && model.getMessage() != null){
            String message = resourceBundle.getString(model.getMessage());
            String alert = model.getAlert();
            req.setAttribute("message", message);
            req.setAttribute("alert", alert);
        }

        String action = req.getParameter("action");
        String view = "";
        switch (action) {
            case SystemConstant.LOGIN:
                view = "/views/login/login.jsp";
                break;
            case SystemConstant.REGISTER:
                view = "/views/login/register.jsp";
                break;
            case SystemConstant.FORGOT_PASSWORD:
                view = "/views/login/forgotpassword.jsp";
                break;
        }
        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals(SystemConstant.LOGIN)) {
            UserModel model = FormUtil.toModel(UserModel.class, request);
            model = userService.findByUserNameAndPasswordAndStatus(model.getUserName(), model.getPassword(), 1);
            if (model != null) {
                SessionUtil.getInstance().putValue(request, "USERMODEL", model);
                if (model.getRole().getCode().equals("USER")) {
                    response.sendRedirect(request.getContextPath() + "/trang-chu");
                } else if (model.getRole().getCode().equals("ADMIN")) {
                    response.sendRedirect(request.getContextPath() + "/admin-home");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=username_password_invalid&alert=danger");
            }
        } else if (action != null && action.equals(SystemConstant.REGISTER)) {
            UserModel model = FormUtil.toModel(UserModel.class, request);
            model.setRoleId(2L);
            model.setStatus(1);
            Long result = userService.insert(model);
            if (result != null) {
                SessionUtil.getInstance().putValue(request, "USERMODEL", model);
                response.sendRedirect(request.getContextPath() + "/dang-nhap?type=login");
            }
        }
    }
}
