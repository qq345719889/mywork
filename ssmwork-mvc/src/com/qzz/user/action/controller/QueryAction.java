package com.qzz.user.action.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.qzz.common.pojo.PartPoet;
import com.qzz.common.pojo.Work;
import com.qzz.user.service.QueryService;

@Controller
@RequestMapping(value = "/new")
public class QueryAction {
	@Autowired
	private QueryService queryService;

	@RequestMapping(value = "/findname.do")
	public ModelAndView findName(HttpServletRequest request,
			HttpSession httpSession) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		List<String> title = new ArrayList<String>();
		int count; // 结果总计
		int minCt;
		int maxCt;
		int maxPage;
		boolean isMax;
		boolean isP;
		boolean isMin;
		int nwPage;
		nwPage = 1;
		title = queryService.findByName(name, nwPage - 1);
		count = queryService.findCount(name);
		if (count > 10) {
			minCt = (nwPage - 1) * 10 + 1;
			maxCt = nwPage * 10;
			if (count % 10 == 0) {
				maxPage = count / 10;
			} else {
				maxPage = count / 10 + 1;
			}
		} else {
			minCt = (nwPage - 1) * 10 + 1;
			maxCt = count;
			maxPage = 1;
		}
		if (maxPage != 1) {
			if (nwPage == maxPage) {
				isMax = true;
			} else {
				isMax = false;
			}
			if (nwPage != maxPage && nwPage != 1) {
				isP = true;
			} else {
				isP = false;
			}
			if (nwPage == 1) {
				isMin = true;
			} else {
				isMin = false;
			}
		} else {
			isMax = false;
			isP = false;
			isMin = false;
		}
		httpSession.setAttribute("name", name);
		httpSession.setAttribute("count", count);
		httpSession.setAttribute("maxPage", maxPage);
		httpSession.setAttribute("nwPage", nwPage);
		if (title.size() != 0) {
			ModelAndView model = new ModelAndView("fname/success");
			model.addObject("minCt", minCt);
			model.addObject("maxCt", maxCt);
			model.addObject("msg1", title);
			model.addObject("nwPage", nwPage);
			model.addObject("isMax", isMax);
			model.addObject("isP", isP);
			model.addObject("isMin", isMin);
			model.addObject("maxPage", maxPage);
			return model;
		} else {
			ModelAndView model = new ModelAndView("fname/error");
			model.addObject("name", name);
			return model;
		}
	}

	@RequestMapping(value = "/findwork.do")
	public ModelAndView findWork(HttpServletRequest request)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String titles = request.getParameter("titles");
		Work work = queryService.findWork(titles);
		if (work != null) { // 判断搜索结果不为空 return
			ModelAndView model = new ModelAndView("fwork/success");
			model.addObject("titles", titles);
			model.addObject("msg2", work);
			return model;
		} else {
			ModelAndView model = new ModelAndView("fwork/error");
			model.addObject("titles", titles);
			return model;
		}
	}

	@RequestMapping(value = "/part.do")
	public ModelAndView findPart(HttpServletRequest request)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		List<PartPoet> pts;
		String part = request.getParameter("part");
		pts = queryService.findPart("%" + part + "%");
		if (part.equals("")) { // 判断输入内容不为空
			ModelAndView model = new ModelAndView("fpart/error");
			model.addObject("part", part);
			return model;
		}
		if (pts.size() != 0) { // 判断搜索结果不为空
			ModelAndView model = new ModelAndView("fpart/success");
			model.addObject("msg3", pts);
			model.addObject("count", pts.size());
			return model;
		} else {
			ModelAndView model = new ModelAndView("fpart/error");
			model.addObject("part", part);
			return model;
		}
	}

	@RequestMapping(value = "/turn.do")
	public ModelAndView findTurn(@RequestParam int nwPage,
			HttpServletRequest request, HttpSession httpSession)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		List<String> title = new ArrayList<String>();
		int minCt;
		int maxCt;
		int maxPage = Integer.parseInt(httpSession.getAttribute("maxPage")
				.toString());
		boolean isMax;
		boolean isP;
		boolean isMin;
		minCt = (nwPage - 1) * 10 + 1;
		maxCt = nwPage * 10;
		String name = httpSession.getAttribute("name").toString();
		title = queryService.findByName(name, nwPage - 1);
		httpSession.setAttribute("nwPage", nwPage);
		if (maxPage != 1) {
			if (nwPage == maxPage) {
				isMax = true;
			} else {
				isMax = false;
			}
			if (nwPage != maxPage && nwPage != 1) {
				isP = true;
			} else {
				isP = false;
			}
			if (nwPage == 1) {
				isMin = true;
			} else {
				isMin = false;
			}
		} else {
			isMax = false;
			isP = false;
			isMin = false;
		}
		if (title.size() != 0) {
			ModelAndView model = new ModelAndView("fname/success");
			model.addObject("minCt", minCt);
			model.addObject("maxCt", maxCt);
			model.addObject("msg1", title);
			model.addObject("nwPage", nwPage);
			model.addObject("isMax", isMax);
			model.addObject("isP", isP);
			model.addObject("isMin", isMin);
			return model;
		} else {
			ModelAndView model = new ModelAndView("fname/error");
			model.addObject("name", name);
			return model;
		}
	}
}
