package x73;

import com.tencent.mobileqq.wink.export.model.ExportCompletedParam;
import com.tencent.mobileqq.wink.export.model.ExportErrorParam;
import com.tencent.mobileqq.wink.export.model.ExportStartParam;
import com.tencent.mobileqq.wink.export.model.ExportWaitingParam;
import com.tencent.mobileqq.wink.export.model.ExportingParam;

/* compiled from: P */
/* loaded from: classes21.dex */
public interface a {
    void onCompleted(String str, ExportCompletedParam exportCompletedParam);

    void onExportError(String str, ExportErrorParam exportErrorParam);

    void onExportStart(String str, ExportStartParam exportStartParam);

    void onExportWaiting(String str, ExportWaitingParam exportWaitingParam);

    void onExporting(String str, ExportingParam exportingParam);
}
