package com.meituan.web.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.meituan.damian.Shop;
import com.meituan.service.ShopService;


public class EditShopServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*Shop shop=new Shop();
		 try {
			BeanUtils.populate(shop, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 ShopService ss =new ShopService();
		 ss.updateShop(shop);
		 request.getRequestDispatcher("FindAllShopsServlet").forward(request, response);*/
		
		//锟斤拷锟斤拷一锟斤拷DiskFileItemFactory锟斤拷锟斤拷
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//锟斤拷锟斤拷一锟斤拷ServletFileUpload锟斤拷锟斤拷
		ServletFileUpload sfu = new ServletFileUpload(factory);
		sfu.setHeaderEncoding("UTF-8");//锟斤拷锟斤拷洗锟斤拷募锟斤拷锟斤拷锟斤拷锟�
		//锟斤拷锟斤拷request锟斤拷锟襟，凤拷锟斤拷锟斤拷锟叫�?锟斤拷
		List<FileItem> fileItems = new ArrayList<FileItem>(0);
		//锟斤拷锟节凤拷装锟斤拷通锟�?锟斤拷锟斤拷锟斤拷
		Map<String, String[]> map = new HashMap<String, String[]>();
		try {
			fileItems = sfu.parseRequest(request);
			
			//锟斤拷锟絝ileItems锟�?锟斤拷
			for (FileItem fileItem : fileItems) {
				if(fileItem.isFormField()){
					//锟斤拷通锟�?锟斤拷
					String name = fileItem.getFieldName();//锟矫碉拷锟街段碉拷锟斤拷
					String value = fileItem.getString("UTF-8");//锟矫碉拷锟街讹拷值
					map.put(name, new String[]{value});//锟斤拷map锟叫革拷值
					
				}else{
					//锟侥硷拷锟�?锟斤拷
					InputStream inputStream = fileItem.getInputStream();
					String filename = fileItem.getName();//锟矫碉拷锟较达拷锟斤拷锟侥硷拷锟斤拷
					String extension = FilenameUtils.getExtension(filename);
					if(!("jsp".equals(extension)||"exe".equals(extension))){//锟较达拷锟斤拷锟侥硷拷锟斤拷锟斤拷锟斤拷jsp锟斤拷exe
						//锟斤拷锟斤拷目录 
						File storeDirectory = new File(this.getServletContext().getRealPath("/upload"));
						if(!storeDirectory.exists()){
							storeDirectory.mkdirs();//锟斤拷锟侥柯硷拷锟斤拷锟斤拷冢锟斤拷痛锟斤拷锟�
						}
					//锟斤拷锟斤拷锟侥硷拷锟斤拷
					if(filename!=null){
						filename = FilenameUtils.getName(filename);
					}
					// 目录锟斤拷散
					String childDirectory = makeChildDirectory(storeDirectory, filename); // a/b
					
					filename = childDirectory+File.separator+filename;
					System.out.println(filename);
					//锟侥硷拷锟较达拷 
					fileItem.write(new File(storeDirectory,filename));
				
					
					}
					map.put(fileItem.getFieldName(),new String[]{filename});//锟斤拷图片锟�?锟斤拷锟絥ame锟斤拷value锟斤拷锟芥到map锟斤拷
				}
			}
			
			Shop Shop = new Shop();
			BeanUtils.populate(Shop, map);
			
		
			
			ShopService bs = new ShopService();
			bs.updateShop(Shop);
			
						
			request.getRequestDispatcher("FindAllShopsServlet").forward(request, response);
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
		private String makeChildDirectory(File storeDirectory, String filename) {
			int hashcode = filename.hashCode();
			System.out.println(hashcode);
			String code = Integer.toHexString(hashcode); 
															
			System.out.println(code);
			String childDirectory = code.charAt(0) + File.separator
					+ code.charAt(1); // a/b
		
			File file = new File(storeDirectory, childDirectory);
			if (!file.exists()) {
				file.mkdirs();
			}
			return childDirectory;
		}
	

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
