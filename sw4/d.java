package sw4;

import android.os.Bundle;
import com.tencent.vas.update.callback.listener.IDownloadListener;
import com.tencent.vas.update.entity.DownloadInfoParams;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface d {
    void a(DownloadInfoParams downloadInfoParams, IDownloadListener iDownloadListener, Bundle bundle);

    void cancelDownload(String str);
}
