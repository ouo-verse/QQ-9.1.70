package zj3;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.standard.file.IRFile;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lzj3/k;", "Lcom/tencent/raft/standard/file/IRFile;", "", "path", "destination", "", "overwrite", NotificationActivity.PASSWORD, "", "unzipFileAtPath", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class k implements IRFile {
    @Override // com.tencent.raft.standard.file.IRFile
    public int unzipFileAtPath(String path, String destination, boolean overwrite, String password) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(password, "password");
        try {
            QLog.i("ZPlanShiplyRes_FileImpl", 1, "unzipFileAtPath, path= " + path + ", destination= " + destination + ", overwrite= " + overwrite + ", password= " + password + " ");
            long currentTimeMillis = System.currentTimeMillis();
            ZipUtils.unZipFile(new File(path), destination, false);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("unzipFileAtPath, costTime= ");
            sb5.append(currentTimeMillis2);
            sb5.append(" ");
            QLog.i("ZPlanShiplyRes_FileImpl", 1, sb5.toString());
            return 0;
        } catch (IOException e16) {
            QLog.e("ZPlanShiplyRes_FileImpl", 1, "unzipFileAtPath IOException", e16);
            return -1;
        } catch (Exception e17) {
            QLog.e("ZPlanShiplyRes_FileImpl", 1, "unzipFileAtPath Exception", e17);
            return -1;
        }
    }
}
