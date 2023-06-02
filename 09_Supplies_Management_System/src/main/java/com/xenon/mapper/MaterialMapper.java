package com.xenon.mapper;

import com.xenon.entity.Material;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Xenon
 * @description 针对表【material】的数据库操作Mapper
 * @createDate 2023-05-30 22:23:52
 * @Entity com.xenon.entity.Material
 */
@Repository
public interface MaterialMapper extends BaseMapper<Material>
{
    List<Material> selectMaterialAndSupplier(@Param("material") Material material);

    // Integer insertMaterial(@Param("material") Material material);

    // List<Material> updateMaterial(@Param("material") Material material);

    // List<Material> deleteMaterialAndSupplier(@Param("materialId") Integer materialId);
}




