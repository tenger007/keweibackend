package cn.cncic.util;

import java.io.File;  

import java.io.IOException;  
  
import java.io.PrintWriter;  
  
import java.util.Iterator;  
  
import java.util.List;  
  
import java.util.regex.Matcher;  
  
import java.util.regex.Pattern;  
  
   
  
import javax.servlet.ServletException;  
  
import javax.servlet.http.HttpServlet;  
  
import javax.servlet.http.HttpServletRequest;  
  
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;  
  
   
  
  
public class MutipartResolver extends HttpServlet {  
  
  
     private static final long serialVersionUID = 1L;  
  
   
  
     public void doPost(HttpServletRequest request, HttpServletResponse response)  
  
              throws ServletException, IOException {  
  
         response.setContentType("text/html; charset=GB2312");  
  
         PrintWriter out = response.getWriter();  
  
         try {  
  
              DiskFileItemFactory factory = new DiskFileItemFactory();   
  
              ServletFileUpload sevletFileUpload = new ServletFileUpload(factory);  
  
              // 设置允许用户上传文件大小,单位:字节，这里设为2m  
  
              sevletFileUpload.setSizeMax(2 * 1024 * 1024);  
  
              // 设置最多只允许在内存中存储的数据,单位:字节  
  
              factory.setSizeThreshold(4096);  
  
              // 设置一旦文件大小超过getSizeThreshold()的值时数据存放在硬盘的目录  
  
              factory.setRepository(new File("d:\\upload\\temp"));  
  
              // 开始读取上传信息   
  
              List fileItems = sevletFileUpload.parseRequest(null);  
  
              // 依次处理每个上传的文件  
  
              Iterator iter = fileItems.iterator();   
  
              // 正则匹配，过滤路径取文件名  
  
              String regExp = ".+\\\\(.+)$";   
  
              // 过滤掉的文件类型  
  
              String[] errorType = { ".exe", ".com", ".cgi", ".asp" };  
  
              Pattern p = Pattern.compile(regExp);  
  
              while (iter.hasNext()) {  
  
                   FileItem item = (FileItem) iter.next();  
  
                   // 忽略其他不是文件域的所有表单信息  
  
                   if (!item.isFormField()) {  
  
                       String name = item.getName();  
  
                       long size = item.getSize();  
  
                       if ((name == null || name.equals("")) && size == 0)  
  
                            continue;  
  
                       Matcher m = p.matcher(name);  
  
                       boolean result = m.find();  
  
                       if (result) {  
  
                            for (int temp = 0; temp < errorType.length; temp++) {  
  
                                 if (m.group(1).endsWith(errorType[temp])) {  
  
                                     throw new IOException(name + ": 非法文件类型禁止上传");  
  
                                 }  
  
                            }  
  
                            try {  
  
                                 // 保存上传的文件到指定的目录  
  
                                 // 在下文中上传文件至数据库时，将对这里改写开始  
  
                                 item.write(new File("d:\\upload\\"+ m.group(1)));  
  
   
  
                                 out.print(name + "&nbsp;&nbsp;" + size + "<br>");  
  
                                 // 在下文中上传文件至数据库时，将对这里改写结束  
  
                            } catch (Exception e) {  
  
                                 out.println(e);  
  
                            }  
                       } else {  
  
                            throw new IOException("fail to upload");  
  
                       }  
  
                   }  
  
              }  
  
         } catch (IOException e) {  
  
              out.println(e);  
  
         } catch (FileUploadException e) {  
  
              out.println(e);  
  
         }  
  
     }  
  
} 
