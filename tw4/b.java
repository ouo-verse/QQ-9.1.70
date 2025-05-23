package tw4;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.vas.update.util.FileUtil;
import com.tencent.vas.update.util.MD5Utils;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public class b implements sw4.b {
    @Override // sw4.b
    public long a() {
        return System.currentTimeMillis();
    }

    @Override // sw4.b
    public String b() {
        return Environment.getExternalStorageDirectory() + "/A_VasUpdateSystem/seq/";
    }

    @Override // sw4.b
    public boolean c(String str, String str2) {
        return FileUtil.copyFile(str, str2);
    }

    @Override // sw4.b
    public long d() {
        return 500L;
    }

    @Override // sw4.b
    public String e() {
        return getAppVersion();
    }

    @Override // sw4.b
    public String f(int i3, String str) throws IOException {
        if (qw4.a.f430259c) {
            return FileUtil.unZipFileNew(str, qw4.a.f430261e);
        }
        return FileUtil.unZipFile(str, qw4.a.f430261e);
    }

    @Override // sw4.b
    public boolean g(String str, String str2) {
        return FileUtil.filePatch(str, str2);
    }

    @Override // sw4.b
    public String getAppVersion() {
        return "1.0.0";
    }

    @Override // sw4.b
    public Context getApplicationContext() {
        return null;
    }

    @Override // sw4.b
    public String getFileMd5(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return MD5Utils.encodeFileHexStr(str);
    }

    @Override // sw4.b
    public int getNetType() {
        return 1;
    }
}
