package uh2;

import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCreateUploadFileGroupParam;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProCreateUploadFileGroupCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProTransferFileOperateCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildFileUploadListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u000eH&J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u000eH&J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u000eH&\u00a8\u0006\u0012"}, d2 = {"Luh2/h;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGuildFileUploadListener;", "listener", "", "addFileUploadListener", "c", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProCreateUploadFileGroupParam;", "createParam", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProCreateUploadFileGroupCallback;", "callback", "createFileGroupUpload", "", "fileGroupId", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProTransferFileOperateCallback;", "removeFileGroupUpload", "pauseFileGroupUpload", "resumeFileGroupUpload", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface h {
    void addFileUploadListener(@NotNull IKernelGuildFileUploadListener listener);

    void c(@NotNull IKernelGuildFileUploadListener listener);

    void createFileGroupUpload(@NotNull GProCreateUploadFileGroupParam createParam, @NotNull IGProCreateUploadFileGroupCallback callback);

    void pauseFileGroupUpload(@NotNull String fileGroupId, @NotNull IGProTransferFileOperateCallback callback);

    void removeFileGroupUpload(@NotNull String fileGroupId, @NotNull IGProTransferFileOperateCallback callback);

    void resumeFileGroupUpload(@NotNull String fileGroupId, @NotNull IGProTransferFileOperateCallback callback);
}
