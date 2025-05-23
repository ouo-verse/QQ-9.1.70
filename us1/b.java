package us1;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\bH&J\u0014\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0004H&J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000b\u001a\u00020\u0004H&J\u0012\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0004H&J\b\u0010\u0010\u001a\u00020\u0004H&J \u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H&\u00a8\u0006\u0015"}, d2 = {"Lus1/b;", "", "", "userId", "", "needShowVideo", "Landroid/view/View;", "l", "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "ignoreSelf", "L", "Lcom/tencent/mobileqq/guild/media/core/data/p;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, BdhLogUtil.LogTag.Tag_Conn, "", "w", h.F, "N", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class a {
        public static /* synthetic */ View a(b bVar, String str, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = true;
                }
                return bVar.l(str, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createVideoView");
        }

        public static /* synthetic */ View b(b bVar, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = true;
                }
                return bVar.L(z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createVideoViewByFindFirstOpenVideoUser");
        }
    }

    boolean A(boolean ignoreSelf);

    boolean C();

    @Nullable
    View L(boolean ignoreSelf);

    void N(@NotNull String userId, int w3, int h16);

    @NotNull
    View l(@NotNull String userId, boolean needShowVideo);

    @Nullable
    p m(boolean ignoreSelf);

    void n(@NotNull String userId);

    void z();
}
