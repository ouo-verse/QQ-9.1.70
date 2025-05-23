package q9;

import com.qzone.reborn.base.n;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.HashMap;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016R>\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005`\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR>\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005`\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lq9/c;", "Lcom/qzone/reborn/base/n;", "", "getLogTag", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "i", "Ljava/util/HashMap;", "N1", "()Ljava/util/HashMap;", "setQrCodeResult", "(Ljava/util/HashMap;)V", "qrCodeResult", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "M1", "setQqCodeResult", "qqCodeResult", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c extends n {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private HashMap<String, Boolean> qrCodeResult = new HashMap<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private HashMap<String, Boolean> qqCodeResult = new HashMap<>();

    public final HashMap<String, Boolean> M1() {
        return this.qqCodeResult;
    }

    public final HashMap<String, Boolean> N1() {
        return this.qrCodeResult;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "CommonShareViewModel";
    }
}
