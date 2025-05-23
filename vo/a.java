package vo;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.util.aq;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.util.QZLog;
import yo.g;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {
    public static void a(long j3, int i3) {
        int i16;
        try {
            if (aq.a(j3)) {
                i16 = 0;
            } else {
                i16 = aq.b(j3) ? 60 : 61;
            }
            AllInOne allInOne = new AllInOne(String.valueOf(j3), i16);
            allInOne.profileEntryType = i3;
            if (i3 == 125) {
                allInOne.f260789pa = 96;
                allInOne.subSourceId = 3;
            }
            ProfileUtils.openProfileCard(BaseApplication.getContext(), allInOne);
        } catch (Throwable th5) {
            QZLog.e("QZoneJumpExternalManager", "jump to qq profile card failed!", th5);
        }
    }

    public static void b(Context context, long j3, g gVar) {
        if (gVar == null || TextUtils.isEmpty(gVar.f450709b)) {
            return;
        }
        yo.d.d(gVar.f450709b, context, null);
    }
}
