package com.yuyue_learn.yupicturebackend.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuyue_learn.yupicturebackend.model.dto.file.UploadPictureResult;
import com.yuyue_learn.yupicturebackend.model.dto.picture.PictureQueryRequest;
import com.yuyue_learn.yupicturebackend.model.dto.picture.PictureReviewRequest;
import com.yuyue_learn.yupicturebackend.model.dto.picture.PictureUploadByBatchRequest;
import com.yuyue_learn.yupicturebackend.model.dto.picture.PictureUploadRequest;
import com.yuyue_learn.yupicturebackend.model.entity.Picture;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuyue_learn.yupicturebackend.model.entity.User;
import com.yuyue_learn.yupicturebackend.model.vo.PictureVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author Lenovo
* @description 针对表【picture(图片)】的数据库操作Service
* @createDate 2026-03-15 14:52:26
*/
public interface PictureService extends IService<Picture> {
    /**
     * 上传图片
     *
     * @param pictureUploadRequest
     * @param loginUser
     * @return
     */
    public PictureVO uploadPicture(Object inputSource, PictureUploadRequest pictureUploadRequest, User loginUser);

    /**
     * 获取图片查询条件
     *
     * @param pictureQueryRequest 图片查询请求
     * @return QueryWrapper<Picture>
     */
    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);
    /**
     * 获取单个图片的 VO 对象
     * @param picture picture 对象
     * @param request request 请求
     * @return 对应图片的 VO
     */
    PictureVO getPictureVO(Picture picture, HttpServletRequest request);

    /**
     * 分页获取图片 VO 对象
     * @param picturePage  page 对象
     * @param request request 请求
     * @return 分页的 VO
     */
    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);
    /**
     * 校验参数
     * @param picture 需要校验的 picture 对象
     */
    void validPicture(Picture picture);

    /**
     * 图片审核
     *
     * @param pictureReviewRequest 图片审核请求
     * @param loginUser            当前登录的 user
     */
    void doPictureReview(PictureReviewRequest pictureReviewRequest, User loginUser);

    /**
     * 填充审核参数，方便其他方法使用
     *
     * @param picture   picture
     * @param loginUser 登录的用户
     */
    void fillReviewParams(Picture picture, User loginUser);

    /**
     * 通过 url 上传图片
     *
     * @param fileUrl       图片 url
     * @param uploadPathPrefix 上传路径前缀
     * @return 图片上传结果
     */
    UploadPictureResult uploadPictureByUrl(String fileUrl, String uploadPathPrefix);
    /**
     * 批量抓取和创建图片
     *
     * @param pictureUploadByBatchRequest
     * @param loginUser
     * @return 成功创建的图片数
     */
    Integer uploadPictureByBatch(
            PictureUploadByBatchRequest pictureUploadByBatchRequest,
            User loginUser
    );

    void clearPictureFile(Picture oldPicture);
}
