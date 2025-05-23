package re;

import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.share.d;
import com.qzone.reborn.share.i;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import ge.h;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007R>\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b`\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lre/a;", "Lcom/qzone/reborn/share/i;", "", WadlProxyConsts.SCENE_ID, "", "T1", "getLogTag", "Lge/h;", "data", "U1", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", UserInfo.SEX_FEMALE, "Ljava/util/HashMap;", "S1", "()Ljava/util/HashMap;", "setQrCodeResult", "(Ljava/util/HashMap;)V", "qrCodeResult", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a extends i {

    /* renamed from: F, reason: from kotlin metadata */
    private HashMap<String, Boolean> qrCodeResult;

    public a() {
        T1("qzone_feedpicture");
        this.qrCodeResult = new HashMap<>();
    }

    public final HashMap<String, Boolean> S1() {
        return this.qrCodeResult;
    }

    public final void T1(String sceneId) {
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        Q1(new d(sceneId));
        d config = getConfig();
        if (config != null) {
            config.f(true);
        }
        d config2 = getConfig();
        if (config2 == null) {
            return;
        }
        config2.g("\u66f4\u591a\u64cd\u4f5c");
    }

    public final void U1(h data) {
        Intrinsics.checkNotNullParameter(data, "data");
        R1(data);
    }

    @Override // com.qzone.reborn.share.i, com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QzoneFeedProLayerShareViewModel";
    }
}
