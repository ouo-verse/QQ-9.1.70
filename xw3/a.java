package xw3;

import com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanAdapterApi;

/* compiled from: P */
/* loaded from: classes24.dex */
public class a {
    public static void a() {
        ((INTZPlanAdapterApi) com.tencent.qqnt.aio.adapter.a.b(INTZPlanAdapterApi.class)).reportExpExposure("exp_zplan_emote_rec_test");
    }

    public static boolean b() {
        return ((INTZPlanAdapterApi) com.tencent.qqnt.aio.adapter.a.b(INTZPlanAdapterApi.class)).isContrast("exp_zplan_emote_rec_test");
    }

    public static boolean c() {
        return ((INTZPlanAdapterApi) com.tencent.qqnt.aio.adapter.a.b(INTZPlanAdapterApi.class)).isExperiment("exp_zplan_emote_rec_test", "exp_zplan_emote_rec_test_B");
    }

    public static boolean d() {
        return ((INTZPlanAdapterApi) com.tencent.qqnt.aio.adapter.a.b(INTZPlanAdapterApi.class)).isExperiment("exp_zplan_emote_rec_test", "exp_zplan_emote_rec_test_C");
    }

    public static boolean e() {
        return ((INTZPlanAdapterApi) com.tencent.qqnt.aio.adapter.a.b(INTZPlanAdapterApi.class)).isExperiment("exp_zplan_emote_rec_test", "exp_zplan_emote_rec_test_D");
    }
}
