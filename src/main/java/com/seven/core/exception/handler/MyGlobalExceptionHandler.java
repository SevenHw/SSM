package com.seven.core.exception.handler;

import com.seven.core.exception.CommonException;
import com.seven.core.response.JSONResult;
import com.seven.core.response.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class MyGlobalExceptionHandler {

    /**
     * 自定义异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(CommonException.class)
    public JSONResult commonExceptionHandler(CommonException e) {
//        printLog("自定义异常", e);
        return ResultUtil.error(e.getCode().toString(), e.getMessage());
    }


    /**
     * 运行时异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public JSONResult runtimeExceptionHandler(RuntimeException e) {
        printLog("运行时异常", e);
        return ResultUtil.error("运行时异常");
    }

    /**
     * 空指针异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    public JSONResult nullPointerExceptionHandler(NullPointerException e) {
        printLog("空指针异常", e);
        return ResultUtil.error("空指针异常");
    }

    /**
     * 类型转换异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ClassCastException.class)
    public JSONResult classCastExceptionHandler(ClassCastException e) {
        printLog("类型转换异常", e);
        return ResultUtil.error("类型转换异常");
    }

    /**
     * 数字格式异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(NumberFormatException.class)
    public JSONResult NumberFormatException(NumberFormatException e) {
        printLog("数字格式异常", e);
        return ResultUtil.error("数字格式异常");
    }

    /**
     * sql异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(SQLException.class)
    public JSONResult SQLException(SQLException e) {
        printLog("sql异常", e);
        return ResultUtil.error("sql异常");
    }

    /**
     * 类型不存在异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(TypeNotPresentException.class)
    public JSONResult TypeNotPresentException(TypeNotPresentException e) {
        printLog("类型不存在异常", e);
        return ResultUtil.error("类型不存在");
    }

    /**
     * IO异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(IOException.class)
    public JSONResult iOExceptionHandler(IOException e) {
        printLog("IO异常", e);
        return ResultUtil.error("IO异常");
    }

    /**
     * 未知方法异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(NoSuchMethodException.class)
    public JSONResult noSuchMethodExceptionHandler(NoSuchMethodException e) {
        printLog("未知方法异常", e);
        return ResultUtil.error("未知方法");
    }

    /**
     * 数组越界异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public JSONResult indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException e) {
        printLog("数组越界异常", e);
        return ResultUtil.error("数组越界");
    }

    /**
     * 类型不匹配异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler({TypeMismatchException.class})
    public JSONResult requestTypeMismatch(TypeMismatchException e) {
        printLog("类型不匹配异常", e);
        return ResultUtil.error("类型不匹配");
    }

    /**
     * 栈溢出
     *
     * @param e
     * @return
     */
    @ExceptionHandler({StackOverflowError.class})
    public JSONResult requestStackOverflow(StackOverflowError e) {
        printLog("栈溢出异常", e);
        return ResultUtil.error("栈溢出");
    }

    /**
     * 除数不能为0
     *
     * @param e
     * @return
     */
    @ExceptionHandler({ArithmeticException.class})
    public JSONResult arithmeticException(ArithmeticException e) {
        printLog("除数不能为0异常", e);
        return ResultUtil.error("除数不能为0");
    }

    /**
     * 文件未找到异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(FileNotFoundException.class)
    public JSONResult FileNotFoundException(FileNotFoundException e) {
        printLog("文件未找到异常", e);
        return ResultUtil.error("文件未找到");
    }

    /**
     * 无法注入bean异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(NoSuchBeanDefinitionException.class)
    public JSONResult NoSuchBeanDefinitionException(NoSuchBeanDefinitionException e) {
        printLog("无法注入bean异常", e);
        return ResultUtil.error("无法注入bean");
    }

    /**
     * 安全异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(SecurityException.class)
    public JSONResult SecurityException(SecurityException e) {
        printLog("发生其他异常", e);
        return ResultUtil.error("安全异常");
    }

    /**
     * 其他异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler({Exception.class})
    public JSONResult exception(Exception e) {
        printLog("其他异常", e);
        return ResultUtil.error("其他异常");
    }

    /**
     * 打印日志
     *
     * @param title
     * @param e
     */
    private void printLog(String title, Throwable e) {
        log.error("发生".concat(title).concat(":{}"), e.getMessage(), e);
    }
}
