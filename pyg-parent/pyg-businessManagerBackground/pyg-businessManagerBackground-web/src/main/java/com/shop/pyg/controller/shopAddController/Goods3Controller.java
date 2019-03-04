package com.shop.pyg.controller.shopAddController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shop.pyg.domain.Goods;
import com.shop.pyg.entity.PageResult;
import com.shop.pyg.entity.Result;
import com.shop.pyg.service.GoodsService;
import com.shop.pyg.util.fastDFS.FastDFSUtil;
import com.shop.pyg.vo.GoodsVO;
import com.shop.pyg.vo.ResultVO;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
/**
 * controller
 * @author 王德胜
 *
 */
@RestController
@RequestMapping("/goods")
public class Goods3Controller {

	@Reference
	private GoodsService goodsService;

	@Value("${fastFDSServer}")
	private String FASTFDSSERVER;

	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows){
		return goodsService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param goods
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody GoodsVO goodsVO){
		try {
			// 获得商家信息:
			String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();

			goodsVO.getGoods().setSellerId(sellerId);
			
			goodsService.add(goodsVO);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}

	/**
	 * 文件上传
	 *
	 * @param file 图片
	 * @return
	 */
	@PostMapping("/uploadImage")
	public ResultVO upload(MultipartFile file) {
		ResultVO resultVO = new ResultVO();
		try {

			FastDFSUtil fastDFSUtil = new FastDFSUtil();
			String extension = FilenameUtils.getExtension(file.getOriginalFilename());
			String s = fastDFSUtil.uploadFile(file.getBytes(), extension);
			String https = FASTFDSSERVER + s;
			resultVO.setFlag(1);
			resultVO.setMessage(https);
		} catch (Exception e) {
			resultVO.setFlag(0);
			resultVO.setMessage("上传失败");
			e.printStackTrace();
		}
		return resultVO;
	}
	
	/**
	 * 修改
	 * @param goods
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody Goods goods){
		// 获得商家信息:
		/*String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
		
		Goods goods2 = goodsService.findOne(goods.getGoods().getId());
		if(!sellerId.equals(goods2.getGoods().getSellerId()) || !sellerId.equals(goods.getGoods().getSellerId())){
			return new Result(false, "非法操作");
		}
		
		try {
			goodsService.update(goods);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}*/
		return null;
	}
}
