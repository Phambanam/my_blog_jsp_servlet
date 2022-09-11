package com.phambanam.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.phambanam.model.NewModel;
import com.phambanam.model.UserModel;
import com.phambanam.service.INewService;
import com.phambanam.util.HttpUtil;
import com.phambanam.util.SessionUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-admin-new"})
public class NewAPI extends HttpServlet {
    @Inject
    INewService newService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        NewModel model = HttpUtil.of(req.getReader()).toModel(NewModel.class);
        model.setCreatedBy(((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getUserName());
        model = newService.save(model);
        mapper.writeValue(resp.getOutputStream(), model);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        NewModel model = HttpUtil.of(req.getReader()).toModel(NewModel.class);
        model.setModifiedBy(((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getUserName());
        model = newService.update(model);
        mapper.writeValue(resp.getOutputStream(), model);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        NewModel model = HttpUtil.of(req.getReader()).toModel(NewModel.class);
        newService.delete(model.getIds());
        mapper.writeValue(resp.getOutputStream(), "{}");
    }
}
