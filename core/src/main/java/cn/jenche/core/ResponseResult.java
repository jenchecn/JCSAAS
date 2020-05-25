package cn.jenche.core;

import cn.jenche.saas.dto.ResponseResultDTO;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/24 14:30
 * @Description: 返回结果数据
 */
@Slf4j
public class ResponseResult<T> {
    private ResponseResultDTO resultDTO = new ResponseResultDTO();

    public ResponseResult(ResponseResultDTO responseResultDTO) {
        this.resultDTO = responseResultDTO;
    }

    public ResponseResult(ExceptionMessage exceptionMessage) {
        this.resultDTO.setCode(exceptionMessage.getCode());
        this.resultDTO.setMessage(exceptionMessage.getMsg());
    }

    public ResponseResult(BindingResult bindingResult, Object data) throws SystemException {
        if (bindingResult.hasErrors()) {
            log.debug("<{}> detail:{}", ExceptionMessage.C_50_PARAMS_EXCPTION, bindingResult.getFieldError());
            throw new SystemException(ExceptionMessage.C_50_PARAMS_EXCPTION);
        }

        if (data != null) {
            this.resultDTO.setData(data);
        }
    }

    public String toJson() throws SystemException {
        validData();
        return JSON.toJSONString(this.resultDTO);
    }

    public ResponseResultDTO toDTO() throws SystemException {
        validData();
        return this.resultDTO;
    }

    public ResponseResultDTO build() throws SystemException {
        return toDTO();
    }

    private void validData() throws SystemException {
        if (resultDTO.getCode() > 0) {
            return;
        }

        Object data = this.resultDTO.getData();
        //如果是List
        if (data instanceof List) {
            List<?> _ldata = (List<?>) data;
            if (_ldata.size() < 1) {
                throw new SystemException(ExceptionMessage.C_50_DATA_IS_EMPTY);
            }
        }

        if (data instanceof Map) {
            Map<?, ?> _mdata = (Map<?, ?>) data;
            if (_mdata.size() < 1) {
                throw new SystemException(ExceptionMessage.C_50_DATA_IS_EMPTY);
            }
        }

        if (data instanceof Pager) {
            Pager<?> _pdata = (Pager<?>) data;
            if (_pdata.getTotalRecord() < 1) {
                throw new SystemException(ExceptionMessage.C_50_DATA_IS_EMPTY);
            }
        }
    }
}
