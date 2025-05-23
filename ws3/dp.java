package ws3;

/* compiled from: P */
/* loaded from: classes36.dex */
public interface dp {
    void onFileDidFinishUpload(ab abVar);

    void onFileDidStartUpload(ab abVar);

    void onFileSetUploadProgressChanged(bv bvVar);

    void onFileSetUploadStatusChanged(br brVar);

    void onFileStaticStatusChanged(ab abVar);

    void onFileUploadDidCancel(ab abVar);

    void onFileUploadDidError(ab abVar);

    /* renamed from: onFileUploadProgressChanged-ZFynlJw */
    void mo121onFileUploadProgressChangedZFynlJw(ab abVar, long j3, long j16);

    void onFileUploadStatusChanged(ab abVar);

    void onThumbnailGeneratePath();
}
