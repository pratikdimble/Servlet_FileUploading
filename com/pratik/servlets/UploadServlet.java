
package com.pratik.servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    
      try {
      //create the disk file item factory
          DiskFileItemFactory dfi = new DiskFileItemFactory();
          //create the object for servlet file upload
              ServletFileUpload sfu = new ServletFileUpload(dfi);
                //get the file from servlet file upload in muliparts
                  List<FileItem> multiparts = sfu.parseRequest(request);
                  //upload the file
                      for(FileItem item : multiparts){
                          //get the file
                          File f=new File(item.getName());
                    //save location where to uploded file will be saved
                    String name = f.getName();
                        item.write( new File("E:/uploads/"+name));
              }//for close
              
RequestDispatcher requestDispatcher = request.getRequestDispatcher("/success.html");
    requestDispatcher.forward(request, response);
      }//try close
      
      catch(Exception e) {
    e.printStackTrace();
  }//catch close
}//doPost(-,-) close

}//class close

