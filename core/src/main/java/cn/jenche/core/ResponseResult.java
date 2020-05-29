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

    public ResponseResult() {
    }

    public ResponseResult(Object data) {
        this.resultDTO.setData(data);
    }

    public ResponseResult(ResponseResultDTO responseResultDTO) {
        this.resultDTO = responseResultDTO;
    }

    public ResponseResult(ExceptionMessage exceptionMessage) {
        this.resultDTO.setCode(exceptionMessage.getCode());
        this.resultDTO.setMessage(exceptionMessage.getMsg());
    }

    public ResponseResult(BindingResult bindingResult, CallBack callBack) throws SystemException {
        if (bindingResult.hasErrors()) {
            log.debug("<{}> detail:{}", ExceptionMessage.C_50_PARAMS_EXCPTION, bindingResult.getFieldError());
            throw new SystemException(ExceptionMessage.C_50_PARAMS_EXCPTION);
        }
        this.resultDTO.setData(callBack.execute());
    }

    /**
     * 将结果转成{@link String}
     *
     * @return 转换成string类型的结果，通过JSON转换器
     * @throws SystemException 自定义的系统异常
     */
    public String toJson() throws SystemException {
        validData();
        return JSON.toJSONString(this.resultDTO);
    }

    /**
     * 提交DTO数据
     *
     * @return 提交DTO数据传输实体
     * @throws SystemException 自定义的系统异常
     */
    public ResponseResultDTO toDTO() throws SystemException {
        validData();
        return this.resultDTO;
    }

    public ResponseResult<T> succeed() {
        this.resultDTO.setCode(0);
        this.resultDTO.setMessage(null);
        this.resultDTO.setData(true);
        return this;
    }

    /**
     * 默认转成DTO
     *
     * @return 使用 {@see toDTO()}
     * @throws SystemException 自定义的系统异常
     */
    public ResponseResultDTO send() throws SystemException {
        return toDTO();
    }

    /**
     * 检验检查数据，根据数据类型检查并抛出异常
     *
     * @throws SystemException 自定义的系统异常
     */
    private void validData() throws SystemException {
        if (resultDTO.getCode() > 0) {
            return;
        }

        Object data = this.resultDTO.getData();
        if (data == null) {
            throw new SystemException(ExceptionMessage.C_50_DATA_IS_EMPTY);
        }

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
