package wa3;

import com.tencent.mobileqq.winkpublish.fs.task.GuildVideoUploadTask;
import com.tencent.mobileqq.winkpublish.model.params.VideoParams;
import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.data.VideoExportingUploadTask;
import com.tencent.upload.uinterface.data.VideoUploadTask;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J(\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lwa3/c;", "Lwa3/j;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "taskContext", "Lcom/tencent/mobileqq/winkpublish/model/params/VideoParams;", "videoParams", "", "indexInMediaList", "Lcom/tencent/upload/uinterface/IUploadTaskCallback;", "callback", "Lcom/tencent/upload/uinterface/data/VideoUploadTask;", "b", "Lcom/tencent/upload/uinterface/data/VideoExportingUploadTask;", "c", "<init>", "()V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c extends j {

    /* renamed from: b, reason: collision with root package name */
    public static final c f445339b = new c();

    c() {
    }

    @Override // wa3.j
    public VideoUploadTask b(TaskContext taskContext, VideoParams videoParams, int indexInMediaList, IUploadTaskCallback callback) {
        Intrinsics.checkNotNullParameter(taskContext, "taskContext");
        Intrinsics.checkNotNullParameter(videoParams, "videoParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        GuildVideoUploadTask guildVideoUploadTask = new GuildVideoUploadTask(videoParams.getLocalPath(), taskContext.getPublishParams().getTraceId(), taskContext.d());
        e(guildVideoUploadTask, taskContext, videoParams, indexInMediaList, 2, callback);
        return guildVideoUploadTask;
    }

    @Override // wa3.j
    public VideoExportingUploadTask c(TaskContext taskContext, VideoParams videoParams, int indexInMediaList, IUploadTaskCallback callback) {
        Intrinsics.checkNotNullParameter(taskContext, "taskContext");
        Intrinsics.checkNotNullParameter(videoParams, "videoParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
