package cn.jenche.saas.api.configuration;

import cn.jenche.core.ResponseResult;
import cn.jenche.core.SystemException;
import cn.jenche.saas.dto.ResponseResultDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/24 16:47
 * @Description:
 */
@ControllerAdvice
public class ExceptionToController {
    @ExceptionHandler({SystemException.class})
    @ResponseBody
    public ResponseResultDTO ServiceException(SystemException ex) throws SystemException {
        ResponseResultDTO result = new ResponseResultDTO();
        result.setCode(ex.getErrCode());
        result.setMessage(ex.getMessage());
        return new ResponseResult<String>(result).toDTO();
    }
}
