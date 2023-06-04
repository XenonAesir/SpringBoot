package com.xenon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xenon.entity.Supplier;
import com.xenon.service.SupplierService;
import com.xenon.mapper.SupplierMapper;
import com.xenon.utils.Result;
import org.springframework.stereotype.Service;

/**
* @author Xenon
* @description 针对表【supplier】的数据库操作Service实现
* @createDate 2023-06-01 13:33:42
*/
@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier>
    implements SupplierService{

    public Result getAllSupplier()
    {
        return Result.pass("供应商已传输").data("data", this.list());

    }

    public Result saveSupplier(Supplier supplier)
    {
        return Result.pass("供应商已收录").data("data", this.saveOrUpdate(supplier));

    }

    public Result updateSupplier(Supplier supplier)
    {
        return Result.pass("供应商已更新").data("data", this.saveOrUpdate(supplier));

    }

    public Result deleteSupplier(Integer supplierId)
    {
        boolean remove;
        try{
            remove = this.removeById(supplierId);
        }catch (Exception e)
        {
            return Result.errorFK();
        }
        return Result.pass("供应商已删除").data("data", remove);

    }
}




