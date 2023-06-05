package com.xenon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xenon.echarts.UserWithMaterial;
import com.xenon.entity.*;
import com.xenon.mapper.*;
import com.xenon.service.DepartmentService;
import com.xenon.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xenon
 * @description 针对表【department】的数据库操作Service实现
 * @createDate 2023-06-01 13:33:42
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService
{

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    MaterialMapper materialMapper;
    @Autowired
    MaterialStatusMapper materialStatusMapper;
    @Autowired
    MaterialUnitMapper materialUnitMapper;
    @Autowired
    MaterialTypeMapper materialTypeMapper;
    @Autowired
    SupplierMapper supplierMapper;

    @Autowired
    AllocationMapper allocationMapper;

    public Result getAllDepartment()
    {
        return Result.pass().data("data", this.list());
    }



    public Result getDepartmentAllUser(Integer departmentID)
    {

        ArrayList<UserWithMaterial> arrayList = new ArrayList<>();

        List<User> userList = userMapper.selectList(new QueryWrapper<User>()
                .eq("department_id", departmentID));


        for (User user : userList)
        {

            user.setUserRole(userRoleMapper.selectById(user.getUserRoleId()));
            user.setDepartment(this.getById(user.getDepartmentId()));

            for (Allocation allocation : allocationMapper.selectList(new QueryWrapper<Allocation>()
                    .eq("user_id", user.getUserId())))
            {

                Material material = materialMapper.selectById(allocation.getMaterialId());

                UserWithMaterial userWithMaterial = new UserWithMaterial();

                userWithMaterial.setUserName(user.getUserName());
                userWithMaterial.setUserDepartment(user.getDepartment().getDepartmentName());
                userWithMaterial.setUserRole(user.getUserRole().getUserRoleName());

                userWithMaterial.setMaterialName(material.getMaterialName());
                userWithMaterial.setMaterialUnit(materialUnitMapper.selectById(material.getMaterialUnitId()).getMaterialUnitName());
                userWithMaterial.setMaterialStatus(materialStatusMapper.selectById(material.getMaterialStatusId()).getMaterialStatusName());
                userWithMaterial.setMaterialType(materialTypeMapper.selectById(material.getMaterialTypeId()).getMaterialTypeName());
                userWithMaterial.setMaterialPrice(material.getMaterialPrice());
                userWithMaterial.setMaterialSupplier(supplierMapper.selectById(material.getSupplierId()).getSupplierName());

                userWithMaterial.setIsAsset(material.getIsAsset());
                userWithMaterial.setAssetNumber(material.getAssetNumber());
                userWithMaterial.setAllocationId(allocation.getAllocationId());

                arrayList.add(userWithMaterial);

            }

            user.setMaterialList(materialMapper.selectList(new QueryWrapper<Material>()));
        }

        return Result.pass().data("data", arrayList);

    }
}





