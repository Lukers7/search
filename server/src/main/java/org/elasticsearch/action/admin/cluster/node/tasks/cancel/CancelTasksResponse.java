/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License
 * 2.0 and the Server Side Public License, v 1; you may not use this file except
 * in compliance with, at your election, the Elastic License 2.0 or the Server
 * Side Public License, v 1.
 */

package org.elasticsearch.action.admin.cluster.node.tasks.cancel;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.TaskOperationFailure;
import org.elasticsearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
import org.elasticsearch.common.io.stream.StreamInput;
import org.elasticsearch.tasks.TaskInfo;
import org.elasticsearch.xcontent.ConstructingObjectParser;
import org.elasticsearch.xcontent.XContentParser;

import java.io.IOException;
import java.util.List;

/**
 * Returns the list of tasks that were cancelled
 */
public class CancelTasksResponse extends ListTasksResponse {

    private static final ConstructingObjectParser<CancelTasksResponse, Void> PARSER = setupParser(
        "cancel_tasks_response",
        CancelTasksResponse::new
    );

    public CancelTasksResponse(StreamInput in) throws IOException {
        super(in);
    }

    public CancelTasksResponse(
        List<TaskInfo> tasks,
        List<TaskOperationFailure> taskFailures,
        List<? extends ElasticsearchException> nodeFailures
    ) {
        super(tasks, taskFailures, nodeFailures);
    }

    public static CancelTasksResponse fromXContent(XContentParser parser) {
        return PARSER.apply(parser, null);
    }
}
