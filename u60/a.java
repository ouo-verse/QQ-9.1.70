package u60;

import android.text.TextUtils;
import circlesearch.CircleSearchExhibition$PromptShading;
import circlesearch.CircleSearchExhibition$PromptShadingInfo;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private List<String> f438464a;

    /* renamed from: b, reason: collision with root package name */
    private List<String> f438465b;

    /* renamed from: c, reason: collision with root package name */
    private long f438466c;

    public a(CircleSearchExhibition$PromptShading circleSearchExhibition$PromptShading, boolean z16) {
        if (z16) {
            String L0 = QFSVideoView.L0();
            CircleSearchExhibition$PromptShading c16 = h60.a.c(L0);
            if (c16 != null) {
                d(c16.shading_infos.get());
                return;
            }
            h60.a.g(L0, circleSearchExhibition$PromptShading);
        }
        List<CircleSearchExhibition$PromptShadingInfo> list = circleSearchExhibition$PromptShading.shading_infos.get();
        this.f438466c = mb0.a.b(circleSearchExhibition$PromptShading.interval.get());
        d(list);
    }

    private void d(List<CircleSearchExhibition$PromptShadingInfo> list) {
        this.f438464a = new ArrayList();
        this.f438465b = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                String str = list.get(i3).text.get();
                String str2 = list.get(i3).ext_info.attachInfo.get();
                if (!TextUtils.isEmpty(str)) {
                    QLog.d("QFSSearchHintData", 1, "initData, pos: " + i3 + " hint: " + str);
                    this.f438464a.add(str);
                    this.f438465b.add(str2);
                }
            }
        }
    }

    public List<String> a() {
        return this.f438464a;
    }

    public long b() {
        return this.f438466c;
    }

    public List<String> c() {
        return this.f438465b;
    }
}
