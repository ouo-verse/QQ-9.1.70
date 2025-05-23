package zh4;

import android.app.Activity;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.timi.game.api.auth.AuthScene;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import oh2.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJR\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000428\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006H\u0002J\u0006\u0010\u000f\u001a\u00020\fJ\u0010\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010JX\u0010\u0015\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u001028\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006J\u0010\u0010\u0016\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lzh4/d;", "", "", "code", "", "message", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "errMsg", "", "onResult", "i", "g", "Lcom/tencent/timi/game/api/auth/AuthScene;", "authScene", "k", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "d", "j", "b", "I", "authStatus", "c", "Z", "isRealNameAuthed", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f452579a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int authStatus = -1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isRealNameAuthed;

    d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(AuthScene authScene, final Function2 function2, oh2.c cVar, Activity activity, boolean z16, int i3, String message) {
        authStatus = i3;
        if (i3 == -11153) {
            if (f452579a.j(authScene)) {
                if (function2 != null) {
                    Boolean bool = Boolean.TRUE;
                    Intrinsics.checkNotNullExpressionValue(message, "message");
                    function2.invoke(bool, message);
                    return;
                }
                return;
            }
            cVar.n(activity, cVar.getVerifyUrl(), new c.a() { // from class: zh4.c
                @Override // oh2.c.a
                public final void a(boolean z17, int i16, String str) {
                    d.f(Function2.this, z17, i16, str);
                }
            });
            return;
        }
        d dVar = f452579a;
        Intrinsics.checkNotNullExpressionValue(message, "message");
        dVar.i(i3, message, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function2 function2, boolean z16, int i3, String message1) {
        authStatus = i3;
        d dVar = f452579a;
        Intrinsics.checkNotNullExpressionValue(message1, "message1");
        dVar.i(i3, message1, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(boolean z16, int i3, String str) {
        boolean z17;
        if (i3 == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        isRealNameAuthed = z17;
        authStatus = i3;
    }

    private final void i(int code, String message, Function2<? super Boolean, ? super String, Unit> onResult) {
        if (code != -11154 && code != -3 && code != -2 && code != -1) {
            if (code != 0) {
                if (onResult != null) {
                    onResult.invoke(Boolean.FALSE, message);
                    return;
                }
                return;
            } else {
                isRealNameAuthed = true;
                if (onResult != null) {
                    onResult.invoke(Boolean.TRUE, message);
                    return;
                }
                return;
            }
        }
        if (onResult != null) {
            onResult.invoke(Boolean.FALSE, message);
        }
    }

    public final void d(@Nullable final Activity activity, @Nullable final AuthScene authScene, @Nullable final Function2<? super Boolean, ? super String, Unit> onResult) {
        final oh2.c cVar;
        if (!k(authScene)) {
            if (onResult != null) {
                onResult.invoke(Boolean.TRUE, "\u5df2\u5b9e\u540d\u8ba4\u8bc1");
                return;
            }
            return;
        }
        nh2.c sDKImpl = ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getSceneId());
        if (sDKImpl != null) {
            cVar = sDKImpl.e();
        } else {
            cVar = null;
        }
        if (cVar == null) {
            if (onResult != null) {
                onResult.invoke(Boolean.FALSE, "giftSDK is null");
                return;
            }
            return;
        }
        cVar.C(new c.a() { // from class: zh4.a
            @Override // oh2.c.a
            public final void a(boolean z16, int i3, String str) {
                d.e(AuthScene.this, onResult, cVar, activity, z16, i3, str);
            }
        });
    }

    public final void g() {
        oh2.c cVar;
        if (isRealNameAuthed) {
            return;
        }
        nh2.c sDKImpl = ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getSceneId());
        if (sDKImpl != null) {
            cVar = sDKImpl.e();
        } else {
            cVar = null;
        }
        if (cVar == null) {
            return;
        }
        cVar.C(new c.a() { // from class: zh4.b
            @Override // oh2.c.a
            public final void a(boolean z16, int i3, String str) {
                d.h(z16, i3, str);
            }
        });
    }

    public final boolean j(@Nullable AuthScene authScene) {
        boolean z16;
        boolean z17;
        if (ht3.a.b("qqlive_hide_gift_auth_dialog", 0) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (ht3.a.b("qqlive_hide_recharge_auth_dialog", 1) == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if ((authScene != AuthScene.GIFT || !z16) && (authScene != AuthScene.RECHARGE || !z17)) {
            return false;
        }
        return true;
    }

    public final boolean k(@Nullable AuthScene authScene) {
        if (isRealNameAuthed) {
            return false;
        }
        if (authStatus == -11153 && j(authScene)) {
            return false;
        }
        return true;
    }
}
