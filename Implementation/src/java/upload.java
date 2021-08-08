/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DBConnection.DBquery;
import Logic.path;
import com.oreilly.servlet.MultipartRequest;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

/**
 *
 * @author fgfdg
 */
public class upload extends HttpServlet {
 private String fpath = path.path_upload;
 
    private String filename;
    private String filenames;
    String hashCode = "";
    String fPath = "";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
              RequestDispatcher rd = null;
        HttpSession session = request.getSession(); 

        String id ="";// request.getParameter("id");
        String name ="";// request.getParameter("name");
        String author ="";// request.getParameter("author");
        String fname ="";//  request.getParameter("fname");
        String paramname = "", foldername = "upload", user = "";
        ServletContext sc = getServletContext();

        String src_filepath = "";
      
        System.out.println("fpath--" + fpath);
        MultipartRequest multi = new MultipartRequest(request, fpath, 25 * 1024 * 1024); // 10MB
        Enumeration params = multi.getParameterNames();

        while (params.hasMoreElements()) {
            paramname = (String) params.nextElement();
            if (paramname.equalsIgnoreCase("id")) {
                id = multi.getParameter(paramname);
                System.out.println("id-" + id);
            }
             if (paramname.equalsIgnoreCase("name")) {
                name = multi.getParameter(paramname);
                System.out.println("name-" + name);
            }
              if (paramname.equalsIgnoreCase("author")) {
                author = multi.getParameter(paramname);
                System.out.println("author-" + author);
            } if (paramname.equalsIgnoreCase("fname")) {
                fname = multi.getParameter(paramname);
                System.out.println("fname-" + fname);
            }
              
        }

        Enumeration parameter = multi.getFileNames();
        String  varname = "", filename = "";

        while (parameter.hasMoreElements()) {
            varname = (String) parameter.nextElement();

            if (varname != null && varname.equals("file")) {
                filename = multi.getFilesystemName(varname);
                System.out.println("file name" + filename);
            }
        }
        
            DBquery db=new DBquery();
            try {
                db.add_book_det(id, name, author, filename);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(upload.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(upload.class.getName()).log(Level.SEVERE, null, ex);
            }
             
            
            get_input_Data(new File(fpath+filename),id);
            
            
             try (final PDDocument document = PDDocument.load(new File(fpath+filename))){
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            System.out.println(document.getNumberOfPages());
            for (int page = 0; page < document.getNumberOfPages(); ++page)
            {
                BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 600, ImageType.RGB);
                String fileName = fpath + id+"_" + page + ".png";
                ImageIOUtil.writeImage(bim, fileName, 600);
            }
            document.close();
        } catch (IOException e){
            System.err.println("Exception while trying to create pdf document - " + e);
        }
            
            
            
            
            
            
            
            
            
            
            
                session.setAttribute("msg", "Book Details Added");
             rd = request.getRequestDispatcher("admin_home.jsp");
                   rd.forward(request, response);  
           
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

        public static String get_input_Data(File file,String id){
              String exp="",all_page_data="";	
		System.out.println("File Name = "+file.getName());
		String Data = "";
		try{
			PDDocument document = PDDocument.load(file);
			document.getClass();
			if (!document.isEncrypted()) {
		        PDFTextStripperByArea stripper = new PDFTextStripperByArea();
		        stripper.setSortByPosition(true);
		        Rectangle rect = new Rectangle( 0, 0, 600, 6000 );
	            stripper.addRegion( "class1", rect );
	            PDPageTree allPages =  document.getDocumentCatalog().getPages();
                    
                    for(int i=0;i<allPages.getCount();i++)
                    {
                    
	            PDPage firstPage = (PDPage)allPages.get( i );
	            stripper.extractRegions( firstPage );
	           // System.out.println( "Text in the area:" + rect );
	          //  System.out.println( stripper.getTextForRegion( "class1" ) );
		        
                    String page_data=stripper.getTextForRegion( "class1" ) ;
                    
                     String page_data_arr1[]=page_data.split("\n");
                       page_data="";
                       for(int j=0;j<page_data_arr1.length-1;j++)
                       {
                       page_data+=page_data_arr1[j]+"\n";
                       }
                    
                    
                    all_page_data+=page_data+"\n";
                      

                    }
                    
                    
                    
                    
                    
                    String page_data_arr1[]=all_page_data.split("\n");
                   
                    all_page_data="";
                    for(int i=0;i<page_data_arr1.length;i++)
                    {
                    
                    if(!page_data_arr1[i].startsWith("Page") && !page_data_arr1[i].startsWith("\n"))
                    {
                    all_page_data+=page_data_arr1[i]+"\n";
                    
                    }
                    
                    }
                    
                       String page_data_arr[]=all_page_data.split("\n");
                     
                   
                    
                    
                    
                           System.out.println(""+all_page_data);
                    
                    
                   File f=new File(path.path_upload_ts+"summary_test/text.txt");
                   FileWriter fw=new FileWriter(f);
                   fw.write(all_page_data);
                   fw.close();
                
                   
                   
                   File f1=new File(path.path_upload_ts+"id.txt");
                   FileWriter fw1=new FileWriter(f1);
                   fw1.write(id);
                   fw1.close();
               
                    
		    }
			}catch(Exception e){
				e.printStackTrace();
			}
		System.out.println("---------------------@@@@@@@@@@@@@@@@@@#################################*************************************************************");
		return Data;
                
                
     
	}
}
