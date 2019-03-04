package com.shop.pyg.controller.advertisingmanager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.shop.pyg.domain.Content;
import com.shop.pyg.domain.ContentCategory;
import com.shop.pyg.service.AdvertisingManagerService;
import com.shop.pyg.util.fastDFS.FastDFSUtil;
import com.shop.pyg.vo.ResultVO;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Auther: 陈远明
 * @Date: 2019/2/25 14 : 29
 * @Description:
 */
@RestController
@RequestMapping("/content")
public class AdvertisingManagerController {

    @Reference
    private AdvertisingManagerService advertisingManagerService;

    @Value("${fastFDSServer}")
    private String FASTFDSSERVER;

    /**
     * 分页查询
     *
     * @param page 当前页数
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    public PageInfo<Content> findPage(int page, int rows) {
        return this.advertisingManagerService.findPage(page, rows);
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
     * 查找广告类目
     *
     * @return
     */
    @GetMapping("/findContentCategory")
    public List<ContentCategory> findContentCategory() {
        List<ContentCategory> contentCategoryList = this.advertisingManagerService.findContentCategory();
        return contentCategoryList;
    }

    /**
     * 添加 广告
     * @param content广告实体类
     * @return
     */
    @PostMapping("/save")
    public ResultVO saveContent(@RequestBody Content content) {
        ResultVO resultVO = new ResultVO();
        try {
            this.advertisingManagerService.saveContent(content);
            resultVO.setFlag(1);
            resultVO.setMessage("添加成功");
        } catch (Exception e) {
            resultVO.setFlag(0);
            resultVO.setMessage("添加失败");
            e.printStackTrace();
        }

        return resultVO;
    }

    /**
     *  根据id删除广告
     * @param ids id的数组
     * @return
     */
    @GetMapping("/deleteContentByIds")
    public ResultVO deleteContentByIds(Long[] ids) {
        ResultVO resultVO = new ResultVO();
        try {
            this.advertisingManagerService.deleteContentByIds(ids);
            resultVO.setFlag(1);
            resultVO.setMessage("删除成功");
        } catch (Exception e) {
            resultVO.setFlag(0);
            resultVO.setMessage("删除失败");
            e.printStackTrace();
        }
        return resultVO;
    }

    /**
     * 设置广告为有效
     * @param ids id的数组
     * @return
     */
    @GetMapping("/updateContentStatus1")
    public ResultVO updateContentStatus1(Long[] ids) {
        ResultVO resultVO = new ResultVO();
        try {
            this.advertisingManagerService.updateContentStatus1(ids);
            resultVO.setFlag(1);
            resultVO.setMessage("开启成功");
        } catch (Exception e) {
            resultVO.setFlag(0);
            resultVO.setMessage("开启失败");
            e.printStackTrace();
        }

        return resultVO;

    }

    /**
     * 设置广告为无效
     * @param ids id的数组
     * @return
     */
    @GetMapping("/updateContentStatus0")
    public ResultVO updateContentStatus0(Long[] ids) {
        ResultVO resultVO = new ResultVO();
        try {
            this.advertisingManagerService.updateContentStatus0(ids);
            resultVO.setFlag(1);
            resultVO.setMessage("屏蔽成功");
        } catch (Exception e) {
            resultVO.setFlag(0);
            resultVO.setMessage("屏蔽失败");
            e.printStackTrace();
        }
        return resultVO;
    }


    /**
     *  根据id查找广告
     * @param id 广告id
     * @return
     */

    @GetMapping("/findContentById")
    public Content findContentById(Long id) {
        return this.advertisingManagerService.findContentById(id);
    }

    /**
     * 修改广告
     * @param content
     * @return
     */
    @PostMapping("/update")
    public ResultVO updateContent(@RequestBody Content content) {
        ResultVO resultVO = new ResultVO();
        try {
            this.advertisingManagerService.updateContent(content);
            resultVO.setFlag(1);
            resultVO.setMessage("修改成功");
        } catch (Exception e) {
            resultVO.setFlag(0);
            resultVO.setMessage("修改失败");
            e.printStackTrace();
        }

        return resultVO;
    }
}
