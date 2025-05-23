package ui1;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.media.widget.RoundCornerLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lui1/a;", "", "Lcom/tencent/mobileqq/guild/media/widget/RoundCornerLayout;", "view", "", "position", "itemCount", "", "a", "", "b", UserInfo.SEX_FEMALE, "RADIO_SIZE", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f439021a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final float RADIO_SIZE = ViewUtils.dpToPx(6.0f);

    a() {
    }

    public final void a(@NotNull RoundCornerLayout view, int position, int itemCount) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setRadius(0.0f, 0.0f, 0.0f, 0.0f);
        boolean z16 = true;
        switch (position) {
            case 0:
                if (itemCount > 3) {
                    view.setRadius(RADIO_SIZE, 0.0f, 0.0f, 0.0f);
                    return;
                } else {
                    float f16 = RADIO_SIZE;
                    view.setRadius(f16, 0.0f, 0.0f, f16);
                    return;
                }
            case 1:
                if (itemCount != 2) {
                    if (itemCount == 4) {
                        view.setRadius(0.0f, RADIO_SIZE, 0.0f, 0.0f);
                        return;
                    }
                    return;
                } else {
                    float f17 = RADIO_SIZE;
                    view.setRadius(0.0f, f17, f17, 0.0f);
                    return;
                }
            case 2:
                if (itemCount != 3) {
                    if (itemCount != 4) {
                        if (itemCount != 5) {
                            view.setRadius(0.0f, RADIO_SIZE, 0.0f, 0.0f);
                            return;
                        }
                    } else {
                        view.setRadius(0.0f, 0.0f, 0.0f, RADIO_SIZE);
                        return;
                    }
                }
                float f18 = RADIO_SIZE;
                view.setRadius(0.0f, f18, f18, 0.0f);
                return;
            case 3:
                if (itemCount == 4) {
                    view.setRadius(0.0f, 0.0f, RADIO_SIZE, 0.0f);
                }
                if (5 > itemCount || itemCount >= 7) {
                    z16 = false;
                }
                if (z16) {
                    view.setRadius(0.0f, 0.0f, 0.0f, RADIO_SIZE);
                    return;
                }
                return;
            case 4:
                if (itemCount == 5) {
                    view.setRadius(0.0f, 0.0f, RADIO_SIZE, 0.0f);
                    return;
                }
                return;
            case 5:
                if (6 > itemCount || itemCount >= 9) {
                    z16 = false;
                }
                if (z16) {
                    view.setRadius(0.0f, 0.0f, RADIO_SIZE, 0.0f);
                    return;
                }
                return;
            case 6:
                if (itemCount == 7) {
                    float f19 = RADIO_SIZE;
                    view.setRadius(0.0f, 0.0f, f19, f19);
                    return;
                } else {
                    view.setRadius(0.0f, 0.0f, 0.0f, RADIO_SIZE);
                    return;
                }
            case 7:
                if (itemCount == 8) {
                    view.setRadius(0.0f, 0.0f, RADIO_SIZE, 0.0f);
                    return;
                }
                return;
            case 8:
                view.setRadius(0.0f, 0.0f, RADIO_SIZE, 0.0f);
                return;
            default:
                return;
        }
    }
}
