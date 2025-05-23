package ws3;

import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public interface di {
    void onFileDidStartDownload();

    /* renamed from: onFileDownloadDidError-OsBMiQA */
    void mo126onFileDownloadDidErrorOsBMiQA(ab abVar);

    /* renamed from: onFileDownloadProgressChanged-ZFynlJw */
    void mo127onFileDownloadProgressChangedZFynlJw();

    /* renamed from: onFileDownloadSpeedChange-BltQuoY */
    void mo128onFileDownloadSpeedChangeBltQuoY(ab abVar, int i3, int i16);

    void onFileListDidFinishDownload();

    void onFileListDownloadDidCancel(List<ab> list);

    void onFileListDownloadDidError(List<ab> list);

    void onFileListDownloadDidPause(List<ab> list);

    void onFileListDownloadWaitDownloading();

    void onFileSetDownloadTaskProgressChanged(String str, ca caVar);

    void onFileSetDownloadTaskStatusChange(int i3, String str, ca caVar);

    void onProfilerFileDidStartDownload(String str, c cVar);

    /* renamed from: onProfilerFileDownloadProgressChanged-RQJlUXk */
    void mo129onProfilerFileDownloadProgressChangedRQJlUXk(String str, c cVar, long j3, long j16);

    void onProfilerFileListDidFinishDownload(String str, List<w> list);

    /* renamed from: onProfilerFileListDownloadDidCancel-jXDDuk8 */
    void mo130onProfilerFileListDownloadDidCanceljXDDuk8(String str, List list);

    void onProfilerFileListDownloadDidError(String str, List<v> list);

    /* renamed from: onProfilerFileListDownloadDidPause-jXDDuk8 */
    void mo131onProfilerFileListDownloadDidPausejXDDuk8(String str, List<c> list, int i3);

    void onProfilerFileListDownloadWaitDownloading(String str, List<c> list);

    void onThumbnailDownloadResult(List<cc> list);

    void onUserDownloadOperationResultNotify(eu euVar);
}
