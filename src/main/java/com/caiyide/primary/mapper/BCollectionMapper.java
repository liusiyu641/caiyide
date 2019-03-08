package com.caiyide.primary.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

import com.caiyide.primary.entity.BCollection;
import com.caiyide.primary.web.param.BCollectionParam;
import com.caiyide.primary.web.param.CollectParam;
import com.caiyide.primary.web.vo.CollectionVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
  * 收藏表 Mapper 接口
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-28
 */
@Repository
public interface BCollectionMapper extends BaseMapper<BCollection> {

    BCollection getById(String id);

    List<CollectionVo> getPageList(Page page, BCollectionParam bCollectionParam, @Param("userId") String userId);

    BCollection  selectByproductId(@Param("userId") String userId ,@Param("shopId") String shopId);

    void addcollect(CollectParam collectParam);

    void deleteById(@Param("id") String id);
}