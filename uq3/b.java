package uq3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f439795a = {"exp_qq_circle_feed_input_style", "exp_qq_circle_feed_comment_hot", "exp_qqcircle_feed_details_1505_20210224", "exp_wezone_externalpage_newrecommendationmodule1", "exp_qqcircle_feed_details_1505_20210224", "exp_qq_wezone_compose_lbs_style", "exp_qq_wezone_publisher_smartblockbuster", "exp_qq_wezone_publisher_onboarding", "exp_xsj_low_device_fast_mode_2_1505", "exp_xsj_lazy_load_home_page_mode_1505", "exp_qcircle_video_spr_8923", "exp_xsj_preload_count", "exp_qcircle_video_low_av1_new", "exp_qfs_pcdn_opt"};

    /* renamed from: b, reason: collision with root package name */
    private static volatile String f439796b = null;

    private static List<String> a() {
        int m16 = c.m1();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 1; i3 <= m16; i3++) {
            arrayList.add(d() + "_" + i3);
        }
        return arrayList;
    }

    public static List<String> b() {
        ArrayList arrayList = new ArrayList(Arrays.asList(f439795a));
        arrayList.addAll(a());
        return arrayList;
    }

    public static String c(String str) {
        return "exp_xsj_edge_rerank_test_" + str.replaceAll("\\.", "_");
    }

    public static String d() {
        if (f439796b == null) {
            synchronized (b.class) {
                if (f439796b == null) {
                    f439796b = c(a.a());
                }
            }
        }
        return f439796b;
    }
}
