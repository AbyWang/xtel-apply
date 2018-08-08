package com.cdxt.ds.web.res.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.cdxt.ds.core.model.PagePojo;
import com.cdxt.ds.core.util.FileUtil;
import com.cdxt.ds.web.res.service.ResourcesService;
import com.cdxt.ds.web.sys.pojo.UserInfo;

@Controller
@RequestMapping("/resourcesController")
public class ResourcesController {
	@Autowired
	private ResourcesService  resourcesService;


	/**
	 * @ 
	 * @描述:查询文库的分页信息
	 * @方法名: getLibraryPage
	 * @return
	 * @返回类型 Map<String,Object>
	 * @创建人 张兴成
	 * @创建时间 2018年5月28日上午10:46:28
	 * @修改人 张兴成
	 * @修改时间 2018年5月28日上午10:46:28
	 * @修改备注
	 * @since
	 * @throws
	 */
	@RequestMapping("/listLibraryPage")
	@ResponseBody
	public PagePojo listLibraryPage(@Param(value="strname") String strname,HttpServletRequest request,@RequestParam(value="pageNo",defaultValue="0")Integer pageNo,@RequestParam(value="pageSize",defaultValue="10")Integer pageSize) {

		UserInfo userinfo=(UserInfo) request.getSession().getAttribute("userInfo");
		int userID = userinfo.getUserID();
		Map<String, Object> map=new HashMap<>();
		map.put("userID", userID);
		map.put("strname", strname);
		return resourcesService.listLibraryPage(map,pageNo,pageSize);

	}
	/**
	 * @throws IOException 
	 * @描述:新增文章信息保存文章文件
	 * @方法名: insertLibraryInfo
	 * @return
	 * @返回类型 Map<String,Object>
	 * @创建人 张兴成
	 * @创建时间 2018年5月29日上午10:48:45
	 * @修改人 张兴成
	 * @修改时间 2018年5月29日上午10:48:45
	 * @修改备注
	 * @since
	 * @throws
	 */
	@RequestMapping("/insertLibraryInfo")
	@ResponseBody
	public Map<String,Object> insertLibraryInfo(HttpServletRequest request,@RequestParam(value="Name")String Name,@RequestParam(value="LibraryInfo")String LibraryInfo) throws IOException{
		Map<String,Object> result=new HashMap<String, Object>();
		try {

			UserInfo userinfo=(UserInfo) request.getSession().getAttribute("userInfo");
			int userID = userinfo.getUserID();
			String userName=userinfo.getUserName();
			//获取服务器中保存文件的路径
			Date date=new Date();
			String format=date.getTime()+""+".txt";
			//得到上传文件父路径绝对地址
			//String path = request.getServletContext().getRealPath("upload\\");
			String path ="F:/PersonalDisk";
			//以当前上传时间来当做文件夹放置文件
			String path2=path+"/"+userName;   
			//文件路径不存在则创建 
			File pathFile = new File(path2);  
			if(!pathFile.exists()){  
				pathFile.mkdirs();
			}
			String path3=path+"/"+userName+"/"+format;
			//文件不存在则创建 
			File pathFiletxt = new File(path3);  
			if(!pathFiletxt.exists()){  
				pathFiletxt.createNewFile();
			}
			//把文章类容写进生成的txt文件中
			FileUtil.writeTxtFile(LibraryInfo, path3);
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("userID", userID);
			map.put("Name", Name);
			map.put("uplodaTime",new Date().getTime());
			map.put("URL", path3);
			map.put("Hits", 0);
			map.put("Likes", 0);
			resourcesService.insertLibraryInfo(map);

			result.put("flag", true);
			result.put("message", "上传成功");
		} catch (Exception e) {
			result.put("flag", false);

			result.put("message", "上传失败");
		}

		return result;
	}


	/**
	 * @描述:查看单个文章
	 * @方法名: findLibraryInfo
	 * @param id
	 * @return
	 * @返回类型 Map<String,Object>
	 * @创建人 张兴成
	 * @创建时间 2018年5月30日上午10:27:32
	 * @修改人 张兴成
	 * @修改时间 2018年5月30日上午10:27:32
	 * @修改备注
	 * @since
	 * @throws
	 */
	@RequestMapping("/getLibraryInfo")
	@ResponseBody
	public Map<String,Object> getLibraryInfo(@RequestParam(value="id")int id){

		Map<String,Object> result=new HashMap<String, Object>();
		try {
			Map<String,Object> map=resourcesService.getLibraryInfo(id);
			String  url=(String) map.get("URL");
			String readtxt = FileUtil.readtxt(url);
			map.put("VALUELY", readtxt);
			return map;
		} catch (Exception e) {
			result.put("flag", false);
			result.put("message", "正在查询");
			e.printStackTrace();
			return result;
		}

	}

	/**
	 * @ 
	 * @描述:查询资料信息分页
	 * @方法名: getdataPage
	 * @return
	 * @返回类型 Map<String,Object>
	 * @创建人 张兴成
	 * @创建时间 2018年5月30日上午11:09:59
	 * @修改人 张兴成
	 * @修改时间 2018年5月30日上午11:09:59
	 * @修改备注
	 * @since
	 * @throws
	 */
	@RequestMapping("/listDataPage")
	@ResponseBody
	public PagePojo  listDataPage(@Param(value="strname") String strname,@RequestParam(value="pageNo",defaultValue="0")Integer pageNo,@RequestParam(value="pageSize",defaultValue="10")Integer pageSize) {

		return resourcesService.listDataPage(strname,pageNo,pageSize);

	}


	/**
	 * @描述:修改资料权限
	 * @方法名: updateLearningData
	 * @return
	 * @返回类型 Map<String,Object>
	 * @创建人 张兴成
	 * @创建时间 2018年5月30日下午3:08:54
	 * @修改人 张兴成
	 * @修改时间 2018年5月30日下午3:08:54
	 * @修改备注
	 * @since
	 * @throws
	 */
	@RequestMapping("/updateLearningData")
	@ResponseBody
	public Map<String,Object> updateLearningData(@RequestParam(value="id")int id,@RequestParam(value="uplodaPermissions")int uplodaPermissions,@RequestParam(value="collectionPermissions")int collectionPermissions){
		Map<String,Object> result=new HashMap<String, Object>();
		Map<String,Object> map=new HashMap<String, Object>();
		try {
			map.put("id", id);
			map.put("uplodaPermissions", uplodaPermissions);
			map.put("collectionPermissions", collectionPermissions);
			resourcesService.updateLearningData(map);
			result.put("flag", true);
			result.put("message", "修改成功");
		} catch (Exception e) {
			result.put("flag", false);
			result.put("message", "修改失败");
		}
		return result;
	}



	/**
	 * @描述:上传资料信息
	 * @方法名: uploadDataFile
	 * @param request
	 * @param response
	 * @return
	 * @返回类型 Map<String,Object>
	 * @创建人 张兴成
	 * @创建时间 2018年5月31日下午2:37:24
	 * @修改人 张兴成
	 * @修改时间 2018年5月31日下午2:37:24
	 * @修改备注
	 * @since
	 * @throws
	 */
	@RequestMapping("/uploadDataFile")
	@ResponseBody
	public Map<String,Object> uploadDataFile(HttpServletRequest request,HttpServletResponse response,@RequestParam(value="dataNameId") String dataNameId,
			@RequestParam(value="uplodaPermissions")int uplodaPermissions,@RequestParam(value="collectionPermissions")int collectionPermissions,@RequestParam(value="type")int type){

		Map<String, Object> result=new HashMap<String, Object>();
		try {
			UserInfo userinfo=(UserInfo) request.getSession().getAttribute("userInfo");
			int userID = userinfo.getUserID();
			String userName=userinfo.getUserName();

			//获取服务器中保存文件的路径
			Date date=new Date();
			//时间日期
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			//转换成字符时间
			String format = formatter.format(date);
			//得到上传文件父路径绝对地址
			//String path = request.getServletContext().getRealPath("upload\\");
			String path ="F:/TwoPersonalDisk";
			//以当前上传时间来当做文件夹放置文件
			String path2=path+"/"+userName+"/"+format+"/";
			//获取解析器  
			CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
			//判断是否是文件  
			if(resolver.isMultipart(request)){  
				//进行转换  
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)(request);
				//获取所有文件名称  
				Iterator<String> it = multiRequest.getFileNames();
				//父路径不存在则创建 
				File pathFile = new File(path2);  
				if(!pathFile.exists()){  
					pathFile.mkdirs();  
				}
				while(it.hasNext()){  
					//根据文件名称取文件  
					MultipartFile file = multiRequest.getFile(it.next());  
					String fileName = file.getOriginalFilename();
					String subStr=fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
					String newfileName=date.getTime()+subStr;
					String localPath = path2 + newfileName;  
					//创建一个新的文件对象，创建时需要一个参数，参数是文件所需要保存的位置
					File newFile = new File(localPath);  
					//上传的文件写入到指定的文件中  
					file.transferTo(new File(path2,newfileName)); 
					Map<String, Object> map=new HashMap<String, Object>();
					map.put("type", type);
					map.put("Name", dataNameId);
					map.put("URL", localPath);
					map.put("dataSize", file.getSize());
					map.put("userID", userID);
					map.put("uplodaPermissions", uplodaPermissions);
					map.put("collectionPermissions", collectionPermissions);
					map.put("Downloads", 0);
					map.put("Collects", 0);
					map.put("UploadTime",date.getTime());
					resourcesService.insertLearningData(map);
					result.put("successFlag", true);
					result.put("message", "上传成功");
				}
			}	
		} catch (Exception e) {
			result.put("successFlag", false);
			result.put("message", "上传失败");

		}
		return result;
	}


	/**
	 * @描述:下载资料文件
	 * @方法名: todaloadDatafile
	 * @param request
	 * @param response
	 * @返回类型 void
	 * @创建人 张兴成
	 * @创建时间 2018年5月31日下午6:08:04
	 * @修改人 张兴成
	 * @修改时间 2018年5月31日下午6:08:04
	 * @修改备注
	 * @since
	 * @throws
	 */
	@RequestMapping("/todaloadDatafile/{id}")
	public void  todaloadDatafile(@PathVariable(value="id")int id,HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map;
		try {
			map = resourcesService.getLearningDataByid(id);
			String  datapath = (String)map.get("URL");
			File file=new File(datapath);
			String filename = file.getName();
			System.out.println(file.exists());
			// 读到流中
			InputStream inStream=new FileInputStream(file);
			// 清空response
			response.reset();
			// 设置输出的格式
			response.setContentType("application/force-download");// 设置强制下载不打开
			response.addHeader("Content-Disposition",
					"attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
			response.addHeader("Content-Length",""+ file.length());//显示文件大小
			// 循环取出流中的数据
			byte[] b = new byte[1024];//缓冲区的大小
			int len;
			OutputStream out=response.getOutputStream();
			while ((len = inStream.read(b)) !=-1){
				out.write(b, 0, len);
			}
			out.flush();
			inStream.close();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	/**
	 * @描述:删除资料信息跟文件
	 * @方法名: deletedataInfo
	 * @return
	 * @返回类型 Map<String,Object>
	 * @创建人 张兴成
	 * @创建时间 2018年6月1日下午2:18:29
	 * @修改人 张兴成
	 * @修改时间 2018年6月1日下午2:18:29
	 * @修改备注
	 * @since
	 * @throws
	 */
	@RequestMapping("/deletedataInfo/{id}")
	@ResponseBody
	public Map<String,Object> deletedataInfo(@PathVariable(value="id") int id){
		Map<String,Object> result=new HashMap<String,Object>();

		Map<String, Object> map;
		try {
			map = resourcesService.getLearningDataByid(id);

			String  datapath = (String)map.get("URL");
			File file=new File(datapath);

			if(file.delete()){
				resourcesService.deletedataInfo(id);
				result.put("flag", true);
				result.put("massge", "文件删除成功");
			}else{
				result.put("flag", 1);
				result.put("massge", "文件删除失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	/**
	 * @描述:获取当前用户的文章信息
	 * @方法名: getMyLibraryPage
	 * @param strname
	 * @param request
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @
	 * @返回类型 Map<String,Object>
	 * @创建人 张兴成
	 * @创建时间 2018年6月5日上午10:20:30
	 * @修改人 张兴成
	 * @修改时间 2018年6月5日上午10:20:30
	 * @修改备注
	 * @since
	 * @throws
	 */
	@RequestMapping("/listMyLibraryPage")
	@ResponseBody
	public PagePojo listMyLibraryPage(@Param(value="strname")String strname,HttpServletRequest request,@Param(value="pageNo")Integer pageNo,@RequestParam(value="pageSize")Integer pageSize) {

		UserInfo userinfo=(UserInfo) request.getSession().getAttribute("userInfo");
		int userID = userinfo.getUserID();
		Map<String, Object> map=new HashMap<>();
		map.put("userID", userID);
		map.put("strname", strname);
		return resourcesService.listMyLibraryPage(map,pageNo,pageSize);	
	}


	/**
	 * @描述:获取当前用户的资料信息
	 * @方法名: getMydataPage
	 * @param strname
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @
	 * @返回类型 Map<String,Object>
	 * @创建人 张兴成
	 * @创建时间 2018年6月5日上午10:29:24
	 * @修改人 张兴成
	 * @修改时间 2018年6月5日上午10:29:24
	 * @修改备注
	 * @since
	 * @throws
	 */
	@RequestMapping("/listMydataPage")
	@ResponseBody
	public PagePojo  listMydataPage(HttpServletRequest request,@Param(value="strname") String strname,
			@RequestParam(value="pageNo",defaultValue="0")Integer pageNo,@RequestParam(value="pageSize",defaultValue="10")Integer pageSize) {


		UserInfo userinfo=(UserInfo) request.getSession().getAttribute("userInfo");
		int userID = userinfo.getUserID();
		Map<String, Object> map=new HashMap<>();
		map.put("userID", userID);
		map.put("strname", strname);

		return  resourcesService.listMydataPage(map,pageNo,pageSize);

	}

}
