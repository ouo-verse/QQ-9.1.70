package us1;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.f;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001$B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J \u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u00018BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lus1/c;", "Lus1/b;", "Lcom/tencent/mobileqq/guild/media/core/logic/h;", "", "u", "p", "", "userId", "", "needShowVideo", "Landroid/view/View;", "l", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "ignoreSelf", "L", "Lcom/tencent/mobileqq/guild/media/core/data/p;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, BdhLogUtil.LogTag.Tag_Conn, "", "w", h.F, "N", "Lcom/tencent/mobileqq/guild/media/core/f;", "e", "Lcom/tencent/mobileqq/guild/media/core/f;", "core", "f", "Lus1/b;", "innerHelper", "O", "()Lus1/b;", "requireHelper", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c extends com.tencent.mobileqq.guild.media.core.logic.h implements b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f core;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b innerHelper;

    public c(@NotNull f core) {
        Intrinsics.checkNotNullParameter(core, "core");
        this.core = core;
    }

    private final b O() {
        b bVar = this.innerHelper;
        if (bVar != null) {
            Intrinsics.checkNotNull(bVar);
            return bVar;
        }
        d dVar = new d(this.core);
        this.innerHelper = dVar;
        Intrinsics.checkNotNull(dVar);
        return dVar;
    }

    @Override // us1.b
    public boolean A(boolean ignoreSelf) {
        return O().A(ignoreSelf);
    }

    @Override // us1.b
    public boolean C() {
        return O().C();
    }

    @Override // us1.b
    @Nullable
    public View L(boolean ignoreSelf) {
        return O().L(ignoreSelf);
    }

    @Override // us1.b
    public void N(@NotNull String userId, int w3, int h16) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        O().N(userId, w3, h16);
    }

    @Override // us1.b
    @NotNull
    public View l(@NotNull String userId, boolean needShowVideo) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        return O().l(userId, needShowVideo);
    }

    @Override // us1.b
    @Nullable
    public p m(boolean ignoreSelf) {
        return O().m(ignoreSelf);
    }

    @Override // us1.b
    public void n(@NotNull String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        O().n(userId);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void p() {
        super.p();
        E0();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void u() {
        super.u();
        b bVar = this.innerHelper;
        if (bVar != null) {
            bVar.z();
        }
        this.innerHelper = null;
    }

    @Override // us1.b
    public void z() {
        O().z();
    }
}
