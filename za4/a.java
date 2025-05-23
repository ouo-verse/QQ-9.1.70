package za4;

import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.data.CameraKey;
import com.tencent.sqshow.zootopia.nativeui.data.d;
import dw4.b;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \r2\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lza4/a;", "Lcom/tencent/sqshow/zootopia/nativeui/data/d;", "", "a", "", "E", "Lqu4/a;", "x0", "d", "Lqu4/a;", "mAvatarCharacter", "<init>", "()V", "e", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a implements d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private qu4.a mAvatarCharacter;

    public a() {
        a();
    }

    private final void a() {
        b k3 = com.tencent.sqshow.dresskey.b.f369818a.k("ZPlanAvatarInitDataController_refreshData", true, null);
        UEAvatarGender s16 = k3 != null ? r94.b.s(k3) : null;
        qu4.a q16 = k3 != null ? r94.b.q(k3) : null;
        QLog.i("ZPlanAvatarInitDataController_", 1, "refreshData gender:" + s16 + ", genderInAc:" + (q16 != null ? Integer.valueOf(q16.f429576e) : null));
        this.mAvatarCharacter = q16;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.d
    /* renamed from: E */
    public boolean getMInitDataReady() {
        a();
        return this.mAvatarCharacter != null;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.d
    public CameraKey Y() {
        return d.a.a(this);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.d
    public qu4.a x0() {
        a();
        return this.mAvatarCharacter;
    }
}
