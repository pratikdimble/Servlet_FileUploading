# Servlet_FileUploading
A Servlet can be used with an HTML form tag to allow users to upload files to the server. An uploaded file could be a text file or image file or any document.

Example on File Uploading through Servlets by using Apaches Commons library:

File Uploading through Servlets:
---------------------------------
In web applications, it is very frequently used operation like uploading files from client to server.

To perform upload operation in servlet applications then we have to use the following steps.

1.Create html file:
-------------------
1.In form definition, provide "method" attribute value like "POST".
2.In form definition, provide "enctype" attribute value "multipart/form-data" inorder to give an intemation to the server about the requirest contains uploaded files. 
3.In form definition, we have to provide "file" component to select uploadable file.

2.Create Servlet class:
-------------------------
1. Create DiskFileItemFactory class object

    DiskFileItemFactory factory=new DiskFileItemFactory();
    
2.Create ServletFileUpload class object:
ServletFileUpload servletFileUpload=new ServletFileUpload( factory);

3.Get all the Uploaded files in the form of FileItem objects:
List<FileItem> list=servletFileUpload.parseRequest(request);

4.Get file name from FileItem object:
FileItem item=(FileItem)list.get(0);

String file_path=item.getName();

File file=new File(file_Path);

String file_name=file.getName();


5.Get uploaded data from FileItem object to a File:
File f1=new File("D:\images\uploads\"+file_name);

item.write(f1);

To execute the applications on File Uploading we have to use the following JAR files in lib folder

commons-fileupload-1.1.1.jar
commons-io-1.1.jar


**********************************************************************************************
