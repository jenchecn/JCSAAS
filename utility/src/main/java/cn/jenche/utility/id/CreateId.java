package cn.jenche.utility.id;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/7 16:01
 * @Description:
 */
public class CreateId {
    private static CreateId instance;

    private long dataCenter = 1L;
    private long workerId = 1L;

    private int count = 0; //数量
    @Getter
    private long currentId = 0L;

    private List<Long> currentids = new ArrayList<>();

    public static CreateId GetInstance() {
        if (instance == null) {
            instance = new CreateId();
        }
        return instance;
    }

    public CreateId setDataCenterAndWorkerId(long dataCenter, long workerId) {
        this.dataCenter = dataCenter;
        this.workerId = workerId;
        return instance;
    }

    public CreateId setCount(int count) {
        this.count = count;
        return instance;
    }


    public CreateId createId() {
        ExecutorService exec = Executors.newCachedThreadPool();
        IdWorker worker = new IdWorker(workerId, dataCenter);

        if (count <= 0) {
            worker.nextId();
            return instance;
        }

        for (int i = 0; i < count; i++) {
            final long workerId = this.workerId;
            final long dataCenter = this.dataCenter;
  
            Future<Long> future = exec.submit(worker::nextId);

            try {
                currentids.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        return instance;
    }
}
