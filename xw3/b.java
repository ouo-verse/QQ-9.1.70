package xw3;

import com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanAdapterApi;

/* compiled from: P */
/* loaded from: classes24.dex */
public class b {
    public static void a() {
        ((INTZPlanAdapterApi) com.tencent.qqnt.aio.adapter.a.b(INTZPlanAdapterApi.class)).reportExpExposure("exp_zplan_emote_rec_no");
    }

    public static boolean b() {
        return ((INTZPlanAdapterApi) com.tencent.qqnt.aio.adapter.a.b(INTZPlanAdapterApi.class)).isExperiment("exp_zplan_emote_rec_no", "exp_zplan_emote_rec_no_B");
    }

    public static boolean c() {
        return ((INTZPlanAdapterApi) com.tencent.qqnt.aio.adapter.a.b(INTZPlanAdapterApi.class)).isContrast("exp_zplan_emote_rec_no");
    }
}
