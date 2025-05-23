package v30;

import android.text.TextUtils;
import com.gcore.abase.utils.PatternUtils;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.biz.qqcircle.utils.bj;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import uq3.c;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static AtomicReference<FeedCloudMeta$StFeed> f440901a;

    /* renamed from: b, reason: collision with root package name */
    private static int f440902b;

    public static void a(List<e30.b> list, int i3) {
        if (list == null || list.isEmpty() || i3 >= list.size()) {
            return;
        }
        list.set(i3, new e30.b(j()));
    }

    private static void b(UIStateData<List<e30.b>> uIStateData, String str) {
        List<e30.b> data;
        int h16;
        if (uIStateData == null) {
            data = null;
        } else {
            data = uIStateData.getData();
        }
        if (uIStateData != null && data != null && !data.isEmpty() && data.size() >= (h16 = h(str)) && h16 != 0) {
            if (com.tencent.mobileqq.qcircle.api.utils.b.c()) {
                QLog.e("FDC-QFSLayerDataSourceClipUtils", 1, "[clearUselessDataResult] current hit clip data black list, end flow.");
                return;
            }
            try {
                int d16 = d(data);
                int size = data.size() - (h16 + d16);
                if (size < 0) {
                    size = 0;
                }
                for (int i3 = d16; i3 < size; i3++) {
                    a(data, i3);
                }
                QLog.d("FDC-QFSLayerDataSourceClipUtils", 1, "[clearUselessDataResult] clear start index: " + d16 + " | clearStartCount: " + size);
            } catch (Throwable th5) {
                QLog.e("FDC-QFSLayerDataSourceClipUtils", 1, "[getClipDataResult] error: ", th5);
            }
        }
    }

    public static void c(UIStateData<List<e30.b>> uIStateData, String str, List<e30.b>... listArr) {
        if (uIStateData == null || uIStateData.getIsUpTurning() || !c.G5()) {
            return;
        }
        b(uIStateData, str);
    }

    private static int d(List<e30.b> list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (i(list.get(i3))) {
                int i16 = i3 - 1;
                if (i16 < 0) {
                    return 0;
                }
                return i16;
            }
        }
        return 0;
    }

    public static int e(List<e30.b> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            if (i(list.get(size))) {
                return size;
            }
        }
        return 0;
    }

    public static QFSPageTurnContainer.f f(List<e30.b> list, int i3, boolean z16) {
        if (list == null || list.isEmpty() || !z16 || !c.G5()) {
            return null;
        }
        int max = Math.max(i3 - 1, 0);
        boolean i16 = i((e30.b) RFSafeListUtils.get(list, max));
        boolean i17 = i((e30.b) RFSafeListUtils.get(list, i3));
        String g16 = bj.g((e30.b) RFSafeListUtils.get(list, i3));
        if (i16) {
            QLog.d("FDC-QFSLayerDataSourceClipUtils", 1, "[isClipLimitToHeadOut] position: " + i3 + " | size: " + RFSafeListUtils.getSize(list) + " | feedId: " + g16 + " | prePosition(" + max + ") is empty feed id.");
        }
        return new QFSPageTurnContainer.f(i16, i17);
    }

    private static int g(String str) {
        if (TextUtils.equals(str, "tab_feed")) {
            return c.n2();
        }
        if (TextUtils.equals(str, "personal_layer")) {
            return c.m2();
        }
        return 0;
    }

    private static int h(String str) {
        if (!TextUtils.equals(str, "tab_feed")) {
            return g(str);
        }
        ExpEntityInfo expEntityByLayerCode = ABTestController.getInstance().getExpEntityByLayerCode("exp_qcircle_load_more_limit_clip_new_1505");
        if (expEntityByLayerCode.isExpInvalid()) {
            return g(str);
        }
        Map<String, String> tabParams = expEntityByLayerCode.getTabParams();
        if (tabParams != null && !tabParams.isEmpty()) {
            String str2 = tabParams.get("qqcircle.qqcircle_load_more_tab_feed_max_length");
            if (TextUtils.isEmpty(str2)) {
                return g(str);
            }
            try {
                int parseInt = Integer.parseInt(str2);
                if (f440902b != parseInt) {
                    QLog.d("FDC-QFSLayerDataSourceClipUtils", 1, "[getLoadMoreSceneExpByMaxLength] clip length: " + parseInt);
                    f440902b = parseInt;
                }
                return parseInt;
            } catch (Throwable th5) {
                QLog.e("FDC-QFSLayerDataSourceClipUtils", 1, "[getLoadMoreSceneExpByMaxLength] ex: ", th5);
                return g(str);
            }
        }
        return g(str);
    }

    public static boolean i(e30.b bVar) {
        if (bVar == null || bVar.g() == null) {
            return false;
        }
        String str = bVar.g().f398449id.get();
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, PatternUtils.NO_MATCH)) {
            return false;
        }
        return true;
    }

    private static FeedCloudMeta$StFeed j() {
        if (f440901a == null) {
            synchronized (b.class) {
                if (f440901a == null) {
                    FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
                    feedCloudMeta$StFeed.f398449id.set(PatternUtils.NO_MATCH);
                    f440901a = new AtomicReference<>(feedCloudMeta$StFeed);
                }
            }
        }
        return f440901a.get();
    }
}
