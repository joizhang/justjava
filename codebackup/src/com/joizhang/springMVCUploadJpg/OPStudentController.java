package zlj.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import zlj.domain.vo.OPStudentInfo;
import zlj.domain.vo.OPStudentInfoId;
import zlj.service.OPStudentService;
import zlj.utils.IdCardUtils;

/**
 * 外省考生Controller
 * page encode is utf-8
 * */
@Controller
public class OPStudentController {
	@Autowired
	private OPStudentService studentService;
	
	/**
	 * 新增外省考生
	 * */
	@RequestMapping(value = "/zlj.controller.OPStudentController@OtherProvinceStuAdd.cqzk", method = RequestMethod.POST)
	public String OtherProvinceStuAdd(@RequestParam("stuphoto") MultipartFile file,HttpServletRequest request, HttpSession httpSession, Model model)
			throws ServletException,IOException,RuntimeException{
		//获取当前用户id
		String uid = (SecurityUtils.getSubject().getSession().getAttribute("uid") ==null)? "" : (String)SecurityUtils.getSubject().getSession().getAttribute("uid");  
		
		OPStudentInfoId stuInfoId = new OPStudentInfoId();
		OPStudentInfo stuInfo = new OPStudentInfo();

		stuInfoId.setSfzh(request.getParameter("sfzh") == null ? "": request.getParameter("sfzh").trim());//设置id
		stuInfoId.setYCode((short) 2015);
		
		if(studentService.isExist(stuInfoId)){		//若考生已存在
			request.setAttribute("returnMsg", "保存失败，该考生已注册");
			return "/MyApp/ksy/otherprovince_stu_add";
		}
		
		IdCardUtils idCardUtils = new IdCardUtils();		//获取出生日期，性别，密码的util
		
		//姓名
		stuInfo.setXm(request.getParameter("xm") == null ? "": request.getParameter("xm").trim());
		
		//出身日期
		stuInfo.setCsrq(idCardUtils.getCsrq(stuInfoId.getSfzh()));
		//密码
		stuInfo.setMm(idCardUtils.getMm(stuInfoId.getSfzh()));
		//性别
		stuInfo.setXb(idCardUtils.getXb(stuInfoId.getSfzh()));
		
		//民族
		stuInfo.setMz(request.getParameter("mz") == null ? "": request.getParameter("mz").trim());
		//政治面貌
		stuInfo.setZzmm(request.getParameter("zzmm") == null ? "": request.getParameter("zzmm").trim());
		//生源地
		stuInfo.setSyssdm(request.getParameter("syssdm") == null ? "": request.getParameter("syssdm").trim());
		//考生类别
		stuInfo.setCc(request.getParameter("cc") == null ? "": request.getParameter("cc").trim());
		//毕业院校代码
		stuInfo.setYxdm(request.getParameter("yxdm") == null ? "": request.getParameter("yxdm").trim());
		//毕业院校名称
		stuInfo.setYxmc(request.getParameter("yxmc") == null ? "": request.getParameter("yxmc").trim());
		//专业代码
		stuInfo.setZydm(request.getParameter("zydm") == null ? "": request.getParameter("zydm").trim());
		//专业名称
		stuInfo.setZymc(request.getParameter("zymc") == null ? "": request.getParameter("zymc").trim());
		//联系地址
		stuInfo.setTxdz(request.getParameter("txdz") == null ? "": request.getParameter("txdz").trim());
		//联系电话
		stuInfo.setLxdh(request.getParameter("lxdh") == null ? "": request.getParameter("lxdh").trim());
		//计算机语言
		stuInfo.setJsjdm(Integer.parseInt(request.getParameter("jsjdm") == null||"".equals(request.getParameter("jsjdm")) ? "0": request.getParameter("jsjdm")));
		//外语过级情况
		stuInfo.setWygjqk(request.getParameter("wygjqk") == null ? "": request.getParameter("wygjqk").trim());
		//计算机过级情况
		stuInfo.setJsjgjqk(request.getParameter("jsjgjqk") == null ? "": request.getParameter("jsjgjqk").trim());
		//专业科类
		stuInfo.setKldm(request.getParameter("kldm") == null ? "": request.getParameter("kldm").trim());
		//专业门类属性
		stuInfo.setZymldm(request.getParameter("zymldm") == null ? "": request.getParameter("zymldm").trim());
		
		//所学必修课程考试成绩优良率->若优良率等于null或者为空则赋值为零
		stuInfo.setYll(Double.parseDouble(request.getParameter("yll") == null||"".equals(request.getParameter("yll")) ? "0": request.getParameter("yll").trim()));
		//在校成绩综合名次
		stuInfo.setZhmc(Integer.parseInt(request.getParameter("zhmc") == null||"".equals(request.getParameter("zhmc")) ? "0": request.getParameter("zhmc").trim()));
		//已获取何种职业资格证书
		stuInfo.setZyzs(request.getParameter("zyzs") == null ? "": request.getParameter("zyzs").trim());
		//有何特长
		stuInfo.setTc(request.getParameter("tc") == null ? "": request.getParameter("tc").trim());
		//受过何种奖励
		stuInfo.setJl(request.getParameter("jl") == null ? "": request.getParameter("jl").trim());
		//三等功及以上
		stuInfo.setSdg(Short.parseShort(request.getParameter("sdg") == null||"".equals(request.getParameter("sdg")) ? "0": request.getParameter("sdg").trim()));
		//国家技能竞赛二等奖及以上
		stuInfo.setJnds(Short.parseShort(request.getParameter("jnds") == null||"".equals(request.getParameter("jnds")) ? "0": request.getParameter("jnds").trim()));
		
		if (file != null){
			//照片保存
			String realPath = request.getSession().getServletContext().getRealPath("/photos/photo_ksy");
			String uploadFileFileName = file.getOriginalFilename();		//获取源文件名
			String fileType = uploadFileFileName.substring(uploadFileFileName.lastIndexOf("."));//获取源文件类型
			
			System.out.println(fileType);
			System.out.println(file.getSize());
			System.out.println(file.getBytes());
			
			if(!".jpg".equals(fileType) || file.getSize() > (long)30*1024) {
				request.setAttribute("returnMsg", "照片保存失败,请选择JPG格式的小于30KB的照片");
				return "/MyApp/ksy/otherprovince_stu_add";
			}
			
			String updatedname = stuInfoId.getSfzh()+".jpg";		//将文件名修改为-》身份证.jpg
			////////////////test////////////////
			System.out.println(updatedname);
			
			
			try {	
				File targetFile = new File(realPath, updatedname);
				
				////////////////test////////////////
				System.out.println(targetFile.getName());
				
				if (targetFile.exists()) {
					targetFile.delete();
				} 
				file.transferTo(targetFile);
				//file.getFileItem().write(targetFile);
			} catch(Exception e) {
				System.out.println(e.toString());
				request.setAttribute("returnMsg", "照片保存失败！");
				return "/MyApp/ksy/otherprovince_stu_add";
			}
	        
			stuInfo.setPhoto("/photos/photo_ksy/"+stuInfoId.getSfzh()+".jpg");
		} else {
			request.setAttribute("returnMsg", "请选择照片！");
		}
		
		if(stuInfo != null) {
			studentService.save(stuInfo, stuInfoId, uid);
			request.setAttribute("returnMsg", "保存成功");
			model.addAttribute("stuInfoId", stuInfoId);
			model.addAttribute("stuInfo", stuInfo);
		}
		return "/MyApp/ksy/message";
	}
	
	/**
	 * 外省考生信息修改
	 * */
	@RequestMapping(value = "/zlj.controller.OPStudentController@OtherProvinceStuUpdate.cqzk", method = RequestMethod.POST)
	public String OtherProvinceStuUpdate(@RequestParam("stuphotoupdate") MultipartFile file,HttpServletRequest request, HttpSession httpSession, Model model) 
			throws ServletException,IOException,RuntimeException{
		//获取当前用户id
		String uid = (SecurityUtils.getSubject().getSession().getAttribute("uid") ==null)? "" : (String)SecurityUtils.getSubject().getSession().getAttribute("uid");  
				
		OPStudentInfoId stuInfoId = new OPStudentInfoId();
		OPStudentInfo stuInfo = new OPStudentInfo();
		
		String sfzh_hidden = request.getParameter("sfzh_hidden");//若需要修改身份证，则这个是之前的身份证
		
		stuInfoId.setSfzh(request.getParameter("sfzh") == null ? "": request.getParameter("sfzh").trim());//设置id，这个是可能会被修改的身份证
		stuInfoId.setYCode((short) 2015);
		
		if(!sfzh_hidden.equals(stuInfoId.getSfzh())&&studentService.isExist(stuInfoId)){//若考生已存在
			request.setAttribute("returnMsg", "保存失败，您修改后的身份证已经注册！");
			return "/MyApp/ksy/otherprovince_stu_infoupdate";
		}
		
		IdCardUtils idCardUtils = new IdCardUtils();		//获取出生日期，性别，密码的util
		
		//姓名
		stuInfo.setXm(request.getParameter("xm") == null ? "": request.getParameter("xm").trim());
		
		//出身日期
		stuInfo.setCsrq(idCardUtils.getCsrq(stuInfoId.getSfzh()));
		//密码
		stuInfo.setMm(idCardUtils.getMm(stuInfoId.getSfzh()));
		//性别
		stuInfo.setXb(idCardUtils.getXb(stuInfoId.getSfzh()));
		//民族
		stuInfo.setMz(request.getParameter("mz") == null ? "": request.getParameter("mz").trim());
		//政治面貌
		stuInfo.setZzmm(request.getParameter("zzmm") == null ? "": request.getParameter("zzmm").trim());
		//生源地
		stuInfo.setSyssdm(request.getParameter("syssdm") == null ? "": request.getParameter("syssdm").trim());
		//考生类别
		stuInfo.setCc(request.getParameter("cc") == null ? "": request.getParameter("cc").trim());
		//毕业院校代码
		stuInfo.setYxdm(request.getParameter("yxdm") == null ? "": request.getParameter("yxdm").trim());
		//毕业院校名称
		stuInfo.setYxmc(request.getParameter("yxmc") == null ? "": request.getParameter("yxmc").trim());
		//专业代码
		stuInfo.setZydm(request.getParameter("zydm") == null ? "": request.getParameter("zydm").trim());
		//专业名称
		stuInfo.setZymc(request.getParameter("zymc") == null ? "": request.getParameter("zymc").trim());
		//联系地址
		stuInfo.setTxdz(request.getParameter("txdz") == null ? "": request.getParameter("txdz").trim());
		//联系电话
		stuInfo.setLxdh(request.getParameter("lxdh") == null ? "": request.getParameter("lxdh").trim());
		//计算机语言
		stuInfo.setJsjdm(Integer.parseInt(request.getParameter("jsjdm") == null||"".equals(request.getParameter("jsjdm")) ? "0": request.getParameter("jsjdm")));
		//外语过级情况
		stuInfo.setWygjqk(request.getParameter("wygjqk") == null ? "": request.getParameter("wygjqk").trim());
		//计算机过级情况
		stuInfo.setJsjgjqk(request.getParameter("jsjgjqk") == null ? "": request.getParameter("jsjgjqk").trim());
		//专业科类
		stuInfo.setKldm(request.getParameter("kldm") == null ? "": request.getParameter("kldm").trim());
		//专业门类属性
		stuInfo.setZymldm(request.getParameter("zymldm") == null ? "": request.getParameter("zymldm").trim());
		
		//所学必修课程考试成绩优良率->若优良率等于null或者为空则赋值为零
		stuInfo.setYll(Double.parseDouble(request.getParameter("yll") == null||"".equals(request.getParameter("yll")) ? "0": request.getParameter("yll").trim()));
		//在校成绩综合名次
		stuInfo.setZhmc(Integer.parseInt(request.getParameter("zhmc") == null||"".equals(request.getParameter("zhmc")) ? "0": request.getParameter("zhmc").trim()));
		//已获取何种职业资格证书
		stuInfo.setZyzs(request.getParameter("zyzs") == null ? "": request.getParameter("zyzs").trim());
		//有何特长
		stuInfo.setTc(request.getParameter("tc") == null ? "": request.getParameter("tc").trim());
		//受过何种奖励
		stuInfo.setJl(request.getParameter("jl") == null ? "": request.getParameter("jl").trim());
		//三等功及以上
		stuInfo.setSdg(Short.parseShort(request.getParameter("sdg") == null||"".equals(request.getParameter("sdg")) ? "0": request.getParameter("sdg").trim()));
		//国家技能竞赛二等奖及以上
		stuInfo.setJnds(Short.parseShort(request.getParameter("jnds") == null||"".equals(request.getParameter("jnds")) ? "": request.getParameter("jnds").trim()));
		
		if(!file.isEmpty()){
			//照片保存
			String realPath = request.getSession().getServletContext().getRealPath("/photos/photo_ksy");
			String uploadFileFileName = file.getOriginalFilename();		//获取源文件名
			String fileType = uploadFileFileName.substring(uploadFileFileName.lastIndexOf("."));//获取源文件类型
			
			System.out.println(fileType);
			System.out.println(file.getSize());
			System.out.println(file.getBytes());
			
			if(!".jpg".equals(fileType) || file.getSize() > (long)30*1024) {
				request.setAttribute("returnMsg", "照片保存失败,请选择JPG格式的小于30KB的照片");
				return "/MyApp/ksy/otherprovince_stu_infoupdate";
			}
			
			String updatedname = stuInfoId.getSfzh()+".jpg";		//将文件名修改为-》身份证.jpg
			////////////////test////////////////
			System.out.println(updatedname);
			
			
			try {	
				File targetFile = new File(realPath, updatedname);
				
				////////////////test////////////////
				System.out.println(targetFile.getName());
				
				if (targetFile.exists()) {
					targetFile.delete();
				} 
				file.transferTo(targetFile);
				//file.getFileItem().write(targetFile);
			} catch(Exception e) {
				System.out.println(e.toString());
				request.setAttribute("returnMsg", "照片保存失败");
				return "/MyApp/ksy/otherprovince_stu_infoupdate";
			}
			      
			stuInfo.setPhoto("/photos/photo_ksy/"+stuInfoId.getSfzh()+".jpg");
		} 
		
		if(stuInfo != null) {
			String returnMsg = studentService.update(stuInfo, stuInfoId, sfzh_hidden, uid);
			request.setAttribute("returnMsg", returnMsg);
		}
		return "/MyApp/ksy/message";
	}
	
	/**
	 * 外省考生信息审核
	 * */
	@RequestMapping(value = "/zlj.controller.OPStudentController@AuditOPStudent.cqzk", method = RequestMethod.POST)
	public String auditOPStudent(HttpServletRequest request, HttpSession httpSession)
			throws ServletException,IOException,RuntimeException{
		//获取当前用户id
		String uid = (SecurityUtils.getSubject().getSession().getAttribute("uid") ==null) ? "" : (String)SecurityUtils.getSubject().getSession().getAttribute("uid");
		
		OPStudentInfoId stuInfoId = new OPStudentInfoId();
		//设置student的id
		stuInfoId.setSfzh(request.getParameter("sfzh") == null ? "": request.getParameter("sfzh").trim());							//设置id
		stuInfoId.setYCode((short) 2015);
		
		String passOrReject = request.getParameter("passOrReject") == null ? "": request.getParameter("passOrReject").trim();		//通过还是拒绝
		
		String returnMsg = studentService.setPass(stuInfoId, uid, passOrReject);
		if(returnMsg != null){
			request.setAttribute("statusCode", "200");
			request.setAttribute("returnMsg", returnMsg);
			request.setAttribute("navTabId","nav_0301");
			request.setAttribute("callbackType", "closeCurrent");
			return "/MyApp/ksy/messageAjax";
		} else {
			request.setAttribute("statusCode", "300");
			request.setAttribute("returnMsg", "设置失败!!!");
			return "/MyApp/ksy/messageAjax";
		}
	}
}
