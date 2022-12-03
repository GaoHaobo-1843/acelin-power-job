package com.acelin.powerjob.web.processors;

import java.util.Collections;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tech.powerjob.worker.core.processor.ProcessResult;
import tech.powerjob.worker.core.processor.TaskContext;
import tech.powerjob.worker.core.processor.sdk.BasicProcessor;
import tech.powerjob.worker.log.OmsLogger;

/**
 * 单机任务
 * @author Acelin
 */
public class StandAloneJob implements BasicProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(StandAloneJob.class);

    @Override
    public ProcessResult process(TaskContext context) throws Exception {

        LOGGER.debug("单机任务：StandAloneJob被调起执行，作业上下文为：{}", context);
        OmsLogger omsLogger = context.getOmsLogger();
        omsLogger.info("StandaloneJob start process,context is {}.", context);

        boolean isSuccess = Boolean.TRUE;
        String errorMessage = null;
        try {
            Collections.emptyList().add("666");
        }
        catch (Exception e) {
            isSuccess = Boolean.FALSE;
            errorMessage = ExceptionUtils.getStackTrace(e);
            omsLogger.debug("StandAloneJob have an exception! reason: {}", errorMessage);
        }

        return new ProcessResult(isSuccess, context + errorMessage);
    }
}
