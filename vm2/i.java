package vm2;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.StringRes;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.stt.sub.api.IVideoSubtitleDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vm2.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lvm2/i;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "subtitleView", "", "c", "<init>", "()V", "a", "qq-richmediabrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f441880a = new i();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J8\u0010\u000e\u001a\u00020\r2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J.\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J,\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0012\u001a\u00020\u0011\u00a8\u0006\u0018"}, d2 = {"Lvm2/i$a;", "", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/richmediabrowser/presenter/e;", "aioVideoPresenter", "Landroid/widget/ImageButton;", "actionSheetBtn", "", "balloonStrId", "", "delayMillis", "", "g", "", "i", "Lvm2/i$a$a;", "callback", "d", "j", "<init>", "()V", "a", "qq-richmediabrowser-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f441881a = new a();

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lvm2/i$a$a;", "", "", MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, "", "a", "qq-richmediabrowser-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: vm2.i$a$a, reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        public interface InterfaceC11427a {
            void a(boolean confirm);
        }

        a() {
        }

        private final void d(final com.tencent.mobileqq.richmediabrowser.presenter.e aioVideoPresenter, final ImageButton actionSheetBtn, final WeakReference<Activity> activity, final InterfaceC11427a callback) {
            if (!aioVideoPresenter.B()) {
                return;
            }
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: vm2.f
                @Override // java.lang.Runnable
                public final void run() {
                    i.a.e(activity, aioVideoPresenter, actionSheetBtn, callback);
                }
            }, 2000L);
            aioVideoPresenter.m();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(final WeakReference activity, final com.tencent.mobileqq.richmediabrowser.presenter.e aioVideoPresenter, final ImageButton actionSheetBtn, final InterfaceC11427a callback) {
            Intrinsics.checkNotNullParameter(activity, "$activity");
            Intrinsics.checkNotNullParameter(aioVideoPresenter, "$aioVideoPresenter");
            Intrinsics.checkNotNullParameter(actionSheetBtn, "$actionSheetBtn");
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Activity activity2 = (Activity) activity.get();
            if (f441881a.i(activity2)) {
                return;
            }
            c.f441865a.d();
            ((IVideoSubtitleDialog) QRoute.api(IVideoSubtitleDialog.class)).showEnableSubtitleDialog(activity2, new IVideoSubtitleDialog.a() { // from class: vm2.h
                @Override // com.tencent.mobileqq.stt.sub.api.IVideoSubtitleDialog.a
                public final void onDismiss(boolean z16) {
                    i.a.f(activity, aioVideoPresenter, actionSheetBtn, callback, z16);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(WeakReference activity, com.tencent.mobileqq.richmediabrowser.presenter.e aioVideoPresenter, ImageButton actionSheetBtn, InterfaceC11427a callback, boolean z16) {
            int i3;
            Intrinsics.checkNotNullParameter(activity, "$activity");
            Intrinsics.checkNotNullParameter(aioVideoPresenter, "$aioVideoPresenter");
            Intrinsics.checkNotNullParameter(actionSheetBtn, "$actionSheetBtn");
            Intrinsics.checkNotNullParameter(callback, "$callback");
            c.f441865a.b(z16);
            a aVar = f441881a;
            if (z16) {
                i3 = R.string.f221556b5;
            } else {
                i3 = R.string.f221756bo;
            }
            aVar.g(activity, aioVideoPresenter, actionSheetBtn, i3, 1000L);
            callback.a(z16);
        }

        private final void g(final WeakReference<Activity> activity, com.tencent.mobileqq.richmediabrowser.presenter.e aioVideoPresenter, final ImageButton actionSheetBtn, @StringRes final int balloonStrId, long delayMillis) {
            if (!aioVideoPresenter.A()) {
                return;
            }
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: vm2.g
                @Override // java.lang.Runnable
                public final void run() {
                    i.a.h(activity, actionSheetBtn, balloonStrId);
                }
            }, delayMillis);
            aioVideoPresenter.l();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(WeakReference activity, ImageButton actionSheetBtn, int i3) {
            Intrinsics.checkNotNullParameter(activity, "$activity");
            Intrinsics.checkNotNullParameter(actionSheetBtn, "$actionSheetBtn");
            if (f441881a.i((Activity) activity.get())) {
                return;
            }
            ((IVideoSubtitleDialog) QRoute.api(IVideoSubtitleDialog.class)).showGuideBalloon(actionSheetBtn, HardCodeUtil.qqStr(i3), 3000);
        }

        private final boolean i(Activity activity) {
            boolean z16;
            if (activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
                z16 = false;
            } else {
                z16 = true;
            }
            QLog.i("SubtitleViewUtils", 1, "aioVideoViewSubtitle, activity is not ready: " + z16);
            return z16;
        }

        public final void j(@NotNull com.tencent.mobileqq.richmediabrowser.presenter.e aioVideoPresenter, @NotNull ImageButton actionSheetBtn, @NotNull WeakReference<Activity> activity, @NotNull InterfaceC11427a callback) {
            Intrinsics.checkNotNullParameter(aioVideoPresenter, "aioVideoPresenter");
            Intrinsics.checkNotNullParameter(actionSheetBtn, "actionSheetBtn");
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(callback, "callback");
            int c16 = k.f441884a.c();
            if (c16 == 1) {
                if (!aioVideoPresenter.y()) {
                    g(activity, aioVideoPresenter, actionSheetBtn, R.string.f221756bo, 2000L);
                    return;
                } else {
                    d(aioVideoPresenter, actionSheetBtn, activity, callback);
                    return;
                }
            }
            if (c16 > 1 && c16 <= 3) {
                g(activity, aioVideoPresenter, actionSheetBtn, R.string.f221756bo, 2000L);
            }
        }
    }

    i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(View subtitleView, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(subtitleView, "$subtitleView");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        if (i3 == 0) {
            k.f441884a.h(false);
            subtitleView.setVisibility(8);
            c.f441865a.c(0);
            actionSheet.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ActionSheet actionSheet, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        c.f441865a.c(1);
        actionSheet.mDefaultDismissListener.onClick(null);
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void c(@Nullable Context context, @NotNull final View subtitleView) {
        Intrinsics.checkNotNullParameter(subtitleView, "subtitleView");
        Dialog createDialog = ActionSheetHelper.createDialog(context, null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.addButton(R.string.f221816bu, 3);
        actionSheet.setMainTitle(R.string.f221576b7);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: vm2.d
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                i.d(subtitleView, actionSheet, view, i3);
            }
        });
        actionSheet.addCancelButton(R.string.f221546b4);
        actionSheet.setOnBottomCancelListener(new View.OnClickListener() { // from class: vm2.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.e(ActionSheet.this, view);
            }
        });
        actionSheet.show();
    }
}
