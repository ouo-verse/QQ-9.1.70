package w05;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
import mqq.app.ISecurityFileHelper;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a implements ISecurityFileHelper {

    /* renamed from: a, reason: collision with root package name */
    private Pattern f444146a = Pattern.compile("\\d{5,}");

    /* renamed from: b, reason: collision with root package name */
    private FilenameFilter f444147b = new C11450a();

    /* compiled from: P */
    /* renamed from: w05.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    class C11450a implements FilenameFilter {
        C11450a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            if (file != null && file.isDirectory() && a.this.f444146a.matcher(str).matches()) {
                return true;
            }
            return false;
        }
    }

    @Override // mqq.app.ISecurityFileHelper
    public String declareBusinessFileName() {
        return "ReaderZone";
    }

    @Override // mqq.app.ISecurityFileHelper
    public boolean doMigrate(File file) {
        File file2 = new File(AppConstants.SDCARD_ROOT, "/Tencent/ReaderZone/");
        String[] list = file2.list(this.f444147b);
        if (list != null && list.length != 0) {
            for (String str : list) {
                File file3 = new File(file2, str);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(file.getAbsolutePath());
                String str2 = File.separator;
                sb5.append(str2);
                sb5.append(str);
                sb5.append(str2);
                sb5.append(declareBusinessFileName());
                File file4 = new File(sb5.toString());
                int quickMove = FileUtils.quickMove(file3.getAbsolutePath(), file4.getAbsolutePath());
                QLog.d(ISecurityFileHelper.TAG, 1, "doMigrate\uff1a" + declareBusinessFileName() + " result = " + quickMove + " fromFile = " + file3.getAbsolutePath() + " targetFile = " + file4.getAbsolutePath());
                if (quickMove != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // mqq.app.ISecurityFileHelper
    public boolean needMigration() {
        String[] list = new File(AppConstants.SDCARD_ROOT, "/Tencent/ReaderZone/").list(this.f444147b);
        if (list != null && list.length > 0) {
            return true;
        }
        return false;
    }

    @Override // mqq.app.ISecurityFileHelper
    @NonNull
    public File oldBusinessDir(String str) {
        return new File(new File(AppConstants.SDCARD_ROOT, "/Tencent/ReaderZone/"), str);
    }

    @Override // mqq.app.ISecurityFileHelper
    public boolean oldBusinessDirExist(String str) {
        File oldBusinessDir = oldBusinessDir(str);
        if (oldBusinessDir.isDirectory() && oldBusinessDir.exists()) {
            return true;
        }
        return false;
    }

    @Override // mqq.app.ISecurityFileHelper
    public String[] reportHistoryFileInfo() {
        String[] strArr = new String[2];
        File file = new File(AppConstants.SDCARD_ROOT, "/Tencent/ReaderZone/");
        String[] list = file.list(this.f444147b);
        if (list != null && list.length > 0) {
            long j3 = 0;
            long j16 = 0;
            for (String str : list) {
                j3 += FileUtils.getFileOrFolderSize(new File(file, str).getAbsolutePath());
                j16 += FileUtils.getFileAmount(new File(file, str).getAbsolutePath());
            }
            strArr[0] = Long.toString(j3);
            strArr[1] = Long.toString(j16);
            QLog.d(ISecurityFileHelper.TAG, 1, "reportHistoryFileInfo:" + declareBusinessFileName() + " fileAmount = " + j16 + " fileSize = " + j3);
        }
        return strArr;
    }
}
