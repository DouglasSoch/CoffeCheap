///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.coffecheap.bean;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.Serializable;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
//import javax.faces.context.FacesContext;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletResponse;
//
//
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Font;
//
//import com.itextpdf.text.FontFactory;
//
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.text.Paragraph;
//import org.primefaces.context.RequestContext; 
//
//@ManagedBean
//@SessionScoped
//public class pruebafactura implements Serializable{
//    
//    
//    
//      private static final long serialVersionUID = 1L;
//      private Alumno alumno;
//      private List<Alumno> alumnos;
//      private AlumnoDao alumnoDao;
//
//      public AlumnoBean() {
//            alumno = new Alumno();
//      }
//
//      public Alumno getAlumno() {
//            return alumno;
//      }
//
//      public void setAlumno(Alumno alumno) {
//            this.alumno = alumno;
//      }
//
//      public List<Alumno> getAlumnos() {
//            alumnoDao = new AlumnoDao();
//            alumnos = alumnoDao.buscarTodos();
//            return alumnos;
//      }
//
//     
//   
//       public void imprimir() {
//             
//             Document document = new Document(PageSize.LETTER);
//             ByteArrayOutputStream baos = new ByteArrayOutputStream();
//             try {
//                   PdfWriter.getInstance(document, baos);
//                  //METADATA
//                   AlumnoDao alumnodaos = new AlumnoDao();
//                   List<Alumno> alList = alumnodaos.buscarTodos();
//                  document.open();
//                 
//                  document.add(new Paragraph(" ESTUDIANTES INSCRITOS \n"));
//                 
//                  DateFormat formatter= new SimpleDateFormat("dd/MM/yy '-' hh:mm:ss:");
//                   Date currentDate = new Date();
//                   String date = formatter.format(currentDate);
//                  document.add(new Paragraph("Fecha Generado: "+date)); 
//                  document.add(new Paragraph("\n"));
//                 
//                  PdfPTable table = new PdfPTable(6);
//                 
//                  table.setTotalWidth(new float[]{ 20,72, 110, 95, 170, 72 });
//              table.setLockedWidth(true);
//                 
//             
//               PdfPCell cell = new PdfPCell(new Paragraph("Listado de ALumnos" ,
//                       FontFactory.getFont("arial",   // fuente
//                         8,                            // tamaño
//                     Font.BOLD,                   // estilo
//                               BaseColor.MAGENTA)));
//                  cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                  cell.setBackgroundColor(BaseColor.GRAY);
//                        cell.setColspan(6);
//                  table.addCell(cell);
//
//                  cell = new PdfPCell(new Paragraph ("ID", FontFactory.getFont("arial",8,Font.BOLD,BaseColor.GRAY )));
//                   
//                
//                 
//                  table.addCell("Paterno");
//                 
//                  table.addCell("Materno");
//                 
//                  table.addCell("Nombre");
//                 
//                  table.addCell("Correo");
//                 
//                  table.addCell("Dni");
//                 
//                  for (int i = 0; i < alList.size(); i++) {
//                        Alumno id = alList.get(i);
//                        table.addCell(id.getId().toString());
//                        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
//                        table.addCell(id.getPaterno());
//                        table.addCell(id.getMaterno());
//                        table.addCell(id.getNombres());
//                        table.addCell(id.getCorreo());
//                        table.addCell(id.getDni());
//                  }
//                  document.add(table);
//            } catch (Exception ex) {
//                  System.out.println("Error " + ex.getMessage());
//            }
//            document.close();
//            FacesContext context = FacesContext.getCurrentInstance();
//            Object response = context.getExternalContext().getResponse();
//            if (response instanceof HttpServletResponse) {
//                  HttpServletResponse hsr = (HttpServletResponse) response;
//                  hsr.setContentType("application/pdf");
//                  hsr.setHeader("Content-disposition", "attachment");
//                  hsr.setContentLength(baos.size());
//                  try {
//                        ServletOutputStream out = hsr.getOutputStream();
//                        baos.writeTo(out);
//                        out.flush();
//                  } catch (IOException ex) {
//                        System.out.println("Error:  " + ex.getMessage());
//                  }
//                  context.responseComplete();
//            }
//       }
//       
//       public void reset() { 
//              RequestContext.getCurrentInstance().reset("formEditar:panel"); 
//          }
//       
//
//}
