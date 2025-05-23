package qk4;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.widget.PopupWindow;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.timi.game.liveroom.impl.room.quickgift.quicksendgift.QuickSendGiftConfirmView;
import cooperation.vip.tianshu.TianShuMMKVConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qk4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lqk4/b;", "", "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JN\u0010\u0016\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014R\u0014\u0010\u0017\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lqk4/b$a;", "", "", "giftId", "", "b", "", "c", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "bigGiftUrl", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "giftData", "", "balance", "marketingBalance", "roomId", "roomType", "abTestId", "Lqk4/b$b;", "callback", "d", "LAST_SHOW_GIFT_ID_KEY", "Ljava/lang/String;", "TAG", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qk4.b$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"qk4/b$a$a", "Lcom/tencent/timi/game/liveroom/impl/room/quickgift/quicksendgift/QuickSendGiftConfirmView$b;", "", "onClose", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: qk4.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        public static final class C11083a implements QuickSendGiftConfirmView.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ PopupWindow f429020a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ InterfaceC11084b f429021b;

            C11083a(PopupWindow popupWindow, InterfaceC11084b interfaceC11084b) {
                this.f429020a = popupWindow;
                this.f429021b = interfaceC11084b;
            }

            @Override // com.tencent.timi.game.liveroom.impl.room.quickgift.quicksendgift.QuickSendGiftConfirmView.b
            public void a() {
                this.f429020a.dismiss();
                InterfaceC11084b interfaceC11084b = this.f429021b;
                if (interfaceC11084b != null) {
                    interfaceC11084b.a();
                }
            }

            @Override // com.tencent.timi.game.liveroom.impl.room.quickgift.quicksendgift.QuickSendGiftConfirmView.b
            public void onClose() {
                this.f429020a.dismiss();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean b(int giftId) {
            int c16 = rm4.a.c("last_show_quick_gift_id", 0);
            AegisLogger.INSTANCE.i("Gift|quick_send_gift", TianShuMMKVConstant.LicenseInfoKey.CAN_SHOW, "lastGiftId=" + c16 + ", giftId=" + giftId);
            if (giftId == c16) {
                return false;
            }
            return true;
        }

        private final void c(int giftId) {
            rm4.a.i("last_show_quick_gift_id", giftId);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(long j3, int i3, com.tencent.mobileqq.qqgift.data.service.d giftData, long j16) {
            Intrinsics.checkNotNullParameter(giftData, "$giftData");
            i.b("dt_imp_end", "em_qqlive_quickgift_sure", j3, i3, String.valueOf(giftData.f264874d), j16);
            i.b("dt_imp_end", "em_qqlive_quickgift_cancel", j3, i3, String.valueOf(giftData.f264874d), j16);
        }

        public final boolean d(@NotNull Activity activity, @NotNull String bigGiftUrl, @NotNull final com.tencent.mobileqq.qqgift.data.service.d giftData, long balance, long marketingBalance, final long roomId, final int roomType, final long abTestId, @NotNull InterfaceC11084b callback) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(bigGiftUrl, "bigGiftUrl");
            Intrinsics.checkNotNullParameter(giftData, "giftData");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (!b(giftData.f264874d)) {
                AegisLogger.INSTANCE.e("Gift|quick_send_gift", "show", "fail, has showed, giftId=" + giftData.f264874d);
                return false;
            }
            QuickSendGiftConfirmView quickSendGiftConfirmView = new QuickSendGiftConfirmView(activity);
            quickSendGiftConfirmView.setParams(activity, bigGiftUrl, giftData, balance, marketingBalance, roomId, roomType, abTestId);
            PopupWindow popupWindow = new PopupWindow(quickSendGiftConfirmView, -2, -2);
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
            popupWindow.setAnimationStyle(R.style.f246468z);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setTouchable(true);
            popupWindow.setFocusable(true);
            popupWindow.showAtLocation(activity.getWindow().getDecorView(), 80, 0, (int) (ScreenUtils.getScreenHeight(activity) * 0.3d));
            quickSendGiftConfirmView.setListener(new C11083a(popupWindow, callback));
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: qk4.a
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    b.Companion.e(roomId, roomType, giftData, abTestId);
                }
            });
            c(giftData.f264874d);
            return true;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lqk4/b$b;", "", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qk4.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public interface InterfaceC11084b {
        void a();
    }
}
