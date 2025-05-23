package px2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.PopupWindow;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tvideo.Video;
import uq3.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0007R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lpx2/b;", "", "Landroid/view/View;", "channelIcon", "Ltvideo/Video;", "video", "", "e", "channelView", "d", "Landroid/view/ViewParent;", "contentView", "c", "b", "g", "Landroid/widget/PopupWindow;", "Landroid/widget/PopupWindow;", "popupWindow", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f427879a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static PopupWindow popupWindow;

    b() {
    }

    private final void b() {
        try {
            try {
                PopupWindow popupWindow2 = popupWindow;
                if (popupWindow2 != null) {
                    popupWindow2.dismiss();
                }
            } catch (Exception e16) {
                QLog.e("TVideoChannelGuideHelper", 2, "dismiss Exception: " + e16);
            }
        } finally {
            popupWindow = null;
        }
    }

    private final void c(ViewParent contentView, Video video) {
        if (contentView == null) {
            return;
        }
        VideoReport.setElementParams(contentView, gy2.c.i(video));
        VideoReport.setElementClickPolicy(contentView, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(contentView, "guide_channel_icon");
        VideoReport.reportEvent("imp", contentView, null);
    }

    private final void d(View channelView) {
        try {
            PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(channelView.getContext()).inflate(R.layout.i2_, (ViewGroup) null), -2, -2, true);
            popupWindow = popupWindow2;
            popupWindow2.setFocusable(true);
            PopupWindow popupWindow3 = popupWindow;
            if (popupWindow3 != null) {
                popupWindow3.setOutsideTouchable(true);
            }
            PopupWindow popupWindow4 = popupWindow;
            if (popupWindow4 != null) {
                popupWindow4.showAsDropDown(channelView, 0, (-channelView.getHeight()) / 2);
            }
            PopupWindow popupWindow5 = popupWindow;
            if (popupWindow5 != null) {
                popupWindow5.update();
            }
        } catch (Exception e16) {
            QLog.e("TVideoChannelGuideHelper", 2, "Exception: " + e16);
        }
    }

    @JvmStatic
    public static final void e(@NotNull View channelIcon, @Nullable Video video) {
        Intrinsics.checkNotNullParameter(channelIcon, "channelIcon");
        if (ScreenUtils.isPortrait()) {
            int e16 = k.a().e("tvideo_sp_is_show_channel_guide_key", 0);
            if (e16 == 1) {
                b bVar = f427879a;
                bVar.d(channelIcon);
                RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: px2.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.f();
                    }
                }, 5000L);
                ViewParent parent = channelIcon.getParent();
                Intrinsics.checkNotNullExpressionValue(parent, "channelIcon.parent");
                bVar.c(parent, video);
            }
            k.a().m("tvideo_sp_is_show_channel_guide_key", e16 + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        f427879a.b();
    }

    @JvmStatic
    public static final void g() {
        f427879a.b();
    }
}
