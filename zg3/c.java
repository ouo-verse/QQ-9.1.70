package zg3;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.download.BaseDownloadTask;
import com.tencent.mobileqq.zootopia.download.HalleyDownloader;
import com.tencent.mobileqq.zootopia.download.y;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0019\u001a\u00020\r\u0012\u0006\u0010\u001c\u001a\u00020\r\u0012\u0006\u0010\u001f\u001a\u00020\r\u0012\u0006\u0010\"\u001a\u00020\r\u0012\u0006\u0010%\u001a\u00020\r\u0012\u0006\u0010*\u001a\u00020\t\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010+\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0014J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0016\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0016R\u0017\u0010\u0019\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018R\u0017\u0010\"\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018R\u0017\u0010%\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u0016\u001a\u0004\b$\u0010\u0018R\u0017\u0010*\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R$\u00102\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lzg3/c;", "Lcom/tencent/mobileqq/zootopia/download/BaseDownloadTask;", "", "Z", "W", "", "X", "", "startProgress", "", "singleFileSize", "totalSize", "Y", "", "I", "M", "singleProgress", "k", "Lkotlin/Pair;", "", "getIndex", HippyTKDListViewAdapter.X, "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "y", "getCategory", "category", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "getUrl", "url", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getFilePath", "filePath", "B", "getFileName", WadlProxyConsts.PARAM_FILENAME, BdhLogUtil.LogTag.Tag_Conn, "J", "getFileSize", "()J", "fileSize", "Lzg3/a;", "D", "Lzg3/a;", "getMultiDownloadParam", "()Lzg3/a;", "a0", "(Lzg3/a;)V", "multiDownloadParam", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLzg3/a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c extends BaseDownloadTask {

    /* renamed from: A, reason: from kotlin metadata */
    private final String filePath;

    /* renamed from: B, reason: from kotlin metadata */
    private final String fileName;

    /* renamed from: C, reason: from kotlin metadata */
    private final long fileSize;

    /* renamed from: D, reason: from kotlin metadata */
    private MultiDownloadParam multiDownloadParam;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private final String id;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private final String category;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private final String url;

    private final boolean X() {
        QLog.i("Zootopia_DownloadTask", 1, this.id + " decompression " + this.fileName);
        String str = this.filePath;
        String str2 = File.separator;
        File file = new File(str + str2 + this.fileName);
        try {
            ZipUtils.unZipFile(file, this.filePath + str2, false);
            return true;
        } catch (IOException e16) {
            QLog.e("Zootopia_DownloadTask", 1, this.id + " decompression failed " + this.fileName, e16);
            return false;
        } catch (Exception e17) {
            QLog.e("Zootopia_DownloadTask", 1, this.id + " decompression failed " + this.fileName, e17);
            return false;
        }
    }

    private final boolean Y(float startProgress, long singleFileSize, long totalSize) {
        if (startProgress >= 0.0f && singleFileSize > 0 && totalSize > 0 && singleFileSize <= totalSize) {
            return false;
        }
        return true;
    }

    private final void Z() {
        QLog.i("Zootopia_DownloadTask", 1, "decompress begin - " + this);
        boolean X = X();
        QLog.i("Zootopia_DownloadTask", 1, "decompress complete " + X + " - " + this);
        if (X) {
            R(5);
            HalleyDownloader.f327980a.d(this.url, true);
            Iterator<T> it = E().iterator();
            while (it.hasNext()) {
                ((y) it.next()).c(this);
            }
            return;
        }
        W();
    }

    @Override // com.tencent.mobileqq.zootopia.download.BaseDownloadTask
    /* renamed from: I, reason: from getter */
    public String getCategory() {
        return this.category;
    }

    public final void a0(MultiDownloadParam multiDownloadParam) {
        this.multiDownloadParam = multiDownloadParam;
    }

    @Override // com.tencent.mobileqq.zootopia.download.BaseDownloadTask, com.tencent.mobileqq.zootopia.download.x
    public Pair<Integer, Integer> getIndex() {
        MultiDownloadParam multiDownloadParam = this.multiDownloadParam;
        if (multiDownloadParam != null) {
            return new Pair<>(Integer.valueOf(multiDownloadParam.getIndex()), Integer.valueOf(multiDownloadParam.getTotalCount()));
        }
        return null;
    }

    @Override // com.tencent.mobileqq.zootopia.download.BaseDownloadTask, com.tencent.mobileqq.zootopia.download.x
    public float k(float singleProgress) {
        MultiDownloadParam multiDownloadParam = this.multiDownloadParam;
        float startProgress = multiDownloadParam != null ? multiDownloadParam.getStartProgress() : 0.0f;
        long j3 = this.fileSize;
        MultiDownloadParam multiDownloadParam2 = this.multiDownloadParam;
        long totalSize = multiDownloadParam2 != null ? multiDownloadParam2.getTotalSize() : 0L;
        return Y(startProgress, j3, totalSize) ? singleProgress : (singleProgress * ((float) (j3 / totalSize))) + startProgress;
    }

    private final void W() {
        R(6);
        HalleyDownloader.f327980a.d(this.url, false);
        Iterator<T> it = E().iterator();
        while (it.hasNext()) {
            ((y) it.next()).h(-2, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.zootopia.download.BaseDownloadTask
    public void M() {
        R(3);
        Iterator<T> it = E().iterator();
        while (it.hasNext()) {
            ((y) it.next()).a(this);
        }
        Z();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String id5, String category, String url, String filePath, String fileName, long j3, MultiDownloadParam multiDownloadParam) {
        super(id5, url, filePath, fileName, null, 16, null);
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.id = id5;
        this.category = category;
        this.url = url;
        this.filePath = filePath;
        this.fileName = fileName;
        this.fileSize = j3;
        this.multiDownloadParam = multiDownloadParam;
    }
}
