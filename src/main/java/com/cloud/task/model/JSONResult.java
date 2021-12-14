package com.cloud.task.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <功能描述><br/>
 *
 * @author zwl
 * @create 2019/04/09 10:30:27
 * @since 0.1
 */
@ApiModel
public class JSONResult<T> implements Serializable {

  private static final long serialVersionUID = -5708920009608618218L;

  /**
   * 成功标志
   */
  @ApiModelProperty(value = "调用成功标志")
  private String status;

  /**
   * 消息
   */
  @ApiModelProperty(value = "调用返回消息")
  private String msg;

  /**
   * 数据<br/>
   * 1、列表数据（含分页信息） 2、单行数据 3、自定义数据
   */
  @ApiModelProperty(value = "业务数据")
  private T data;

  /**
   * JSON返回结果必须包含status、code、msg三个参数
   *
   * @param status
   * @param msg
   */
  private JSONResult(String status, String msg) {
    super();
    this.status = status;
    this.msg = msg;
  }

  /**
   * <业务操作成功结果><br/>
   *
   * @return
   * @author zwl
   * @create 2019/04/09 14:09:00
   * @since 0.1
   */
  public static JSONResult getSuccessResult() {
    return new JSONResult("success", "请求处理成功");
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public JSONResult() {
    super();
    // TODO Auto-generated constructor stub
  }

  @Override
  public String toString() {
    return "JSONResult [status=" + status + ", msg=" + msg + "]";
  }

}
