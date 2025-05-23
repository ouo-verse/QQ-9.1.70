package um2;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    public static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str2.startsWith(AppConstants.SDCARD_IMG_SAVE)) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("src_file_path", str);
            hashMap.put("des_file_path", str2);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "qq_images_file_delete", true, 0L, 0L, hashMap, "");
        }
    }
}
