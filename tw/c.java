package tw;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c extends a {
    public c(int i3, int i16, float f16, float f17) {
        this.f437854a = i3;
        this.f437855b = i16;
        this.f437856c = f16;
        this.f437857d = f17;
    }

    public boolean b(@NonNull a aVar) {
        if (this.f437854a <= aVar.f437854a && this.f437855b <= aVar.f437855b && this.f437856c <= aVar.f437856c && this.f437857d <= aVar.f437857d) {
            return true;
        }
        return false;
    }

    public void c(String str) {
        int indexOf;
        QLog.i("MachineLevelLine", 2, str);
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(";")) {
                if (str2 != null && (indexOf = str2.indexOf(61)) > 0 && indexOf < str2.length()) {
                    try {
                        String substring = str2.substring(0, indexOf);
                        float parseFloat = Float.parseFloat(str2.substring(indexOf + 1));
                        if ("MemoryLimit".equalsIgnoreCase(substring)) {
                            QLog.i("MachineLevelLine", 2, "MemoryLimit:  " + parseFloat);
                            this.f437857d = parseFloat;
                        } else if ("CpuNumLimit".equalsIgnoreCase(substring)) {
                            this.f437855b = (int) parseFloat;
                            QLog.i("MachineLevelLine", 2, "CpuNumLimit:  " + parseFloat);
                        } else if ("CpuFreqLimit".equalsIgnoreCase(substring)) {
                            QLog.i("MachineLevelLine", 2, "CpuFreqLimit:  " + parseFloat);
                            this.f437856c = parseFloat;
                        } else if ("APILevelLimit".equalsIgnoreCase(substring)) {
                            QLog.i("MachineLevelLine", 2, "APILevelLimit:  " + parseFloat);
                            this.f437854a = (int) parseFloat;
                        }
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
            }
        }
    }
}
