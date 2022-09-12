package com.phambanam.controller.web;

import com.phambanam.constant.SystemConstant;
import com.phambanam.model.NewModel;
import com.phambanam.paging.PageRequest;
import com.phambanam.paging.Pageble;
import com.phambanam.service.INewService;
import com.phambanam.sorts.Sorter;
import com.phambanam.util.FormUtil;

import javax.inject.Inject;
import javax.management.modelmbean.ModelMBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/trang-chu"})
public class HomeController  extends HttpServlet {
    @Inject
    INewService newService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


         NewModel model = new NewModel();
         String pageStr = req.getParameter("page");
         String view = "/views/web/home.jsp";
         int page ;
         if (pageStr == null){
             page = 1;
         }else {
             page = Integer.parseInt(pageStr);
         }
        Pageble pageble = new PageRequest(page,4,
                new Sorter("title", "asc"));
        String newModelId = req.getParameter("newmodelId");
        List<NewModel> listNewModel = newService.findAll(pageble);
        if (newModelId != null){
            long id = Long.parseLong(newModelId);
            view = "/views/web/page_detail.jsp";
            model = newService.findOne(id);
        }

         model.setPage(page);
         model.setMaxPageItem(pageble.getLimit());
         model.setSortName(pageble.getSorter().getSortName());
         model.setSortBy(pageble.getSorter().getSortBy());
         model.setTotalItem(newService.getTotalItem());
         model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
         model.setListResult(listNewModel);

         req.setAttribute(SystemConstant.MODEL,model);
         req.getRequestDispatcher(view).forward(req,resp);
    }
}
