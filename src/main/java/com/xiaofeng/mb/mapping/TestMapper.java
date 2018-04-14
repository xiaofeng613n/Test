package com.xiaofeng.mb.mapping;

import com.xiaofeng.mb.entity.Test;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by xiaofeng on 2018/4/14
 * Description:
 */
public interface TestMapper extends Mapper<Test>
{
    Test selectById(int id);
}