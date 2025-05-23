package wa3;

import com.tencent.mobileqq.winkpublish.fs.task.FlockImageUploadTask;
import com.tencent.mobileqq.winkpublish.model.params.ImageParams;
import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.data.ImageUploadTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lwa3/a;", "Lwa3/d;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "taskContext", "Lcom/tencent/mobileqq/winkpublish/model/params/ImageParams;", "imageParams", "", "indexInMediaList", "Lcom/tencent/upload/uinterface/IUploadTaskCallback;", "callback", "Lcom/tencent/upload/uinterface/data/ImageUploadTask;", "a", "<init>", "()V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a extends d {

    /* renamed from: b, reason: collision with root package name */
    public static final a f445337b = new a();

    a() {
    }

    @Override // wa3.d
    public ImageUploadTask a(TaskContext taskContext, ImageParams imageParams, int indexInMediaList, IUploadTaskCallback callback) {
        Intrinsics.checkNotNullParameter(taskContext, "taskContext");
        Intrinsics.checkNotNullParameter(imageParams, "imageParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        FlockImageUploadTask flockImageUploadTask = new FlockImageUploadTask(false, "qevent_photo", imageParams.getLocalPath(), taskContext.getPublishParams().getTraceId(), taskContext.d());
        d(flockImageUploadTask, taskContext, imageParams, indexInMediaList, callback);
        return flockImageUploadTask;
    }
}
