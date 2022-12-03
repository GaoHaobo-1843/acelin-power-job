package com.acelin.powerjob.web.processors;

import java.util.List;

import tech.powerjob.worker.core.processor.ProcessResult;
import tech.powerjob.worker.core.processor.TaskContext;
import tech.powerjob.worker.core.processor.TaskResult;
import tech.powerjob.worker.core.processor.sdk.BroadcastProcessor;

/**
 * 广播任务。需要同时启动多个worker才能看出效果
 * 广播任务的某次运行会调动集群内所有机器参与运算
 *  @author Acelin
 */
public class BroadcastJob implements BroadcastProcessor {


    @Override
    public ProcessResult process(TaskContext context) throws Exception {
        // 撰写整个worker集群都会执行的代码逻辑
        return new ProcessResult(true, "BroadcastJob release resource success");
    }

    @Override
    public ProcessResult preProcess(TaskContext context) throws Exception {
        // 预执行，会在所有 worker 执行 process 方法前调用
        return new ProcessResult(true, "BroadcastJob init success");
    }

    @Override
    public ProcessResult postProcess(TaskContext context, List<TaskResult> taskResults) throws Exception {
        // taskResults 存储了所有worker执行的结果（包括preProcess）
        // 可拿到执行结果进行处理
        // 所有 worker 执行完毕 process 方法后调用，该结果将作为最终的执行结果
        return new ProcessResult(true, "BroadcastJob process success");
    }
}
