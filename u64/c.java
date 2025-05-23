package u64;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.aio.input.dialog.msgintent.InputDialogPriorityMsgIntent;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.theme.SkinnableBitmapDrawable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a \u0010\t\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u001a\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\f\"'\u0010\u0014\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0010*\u00020\u000f*\b\u0012\u0004\u0012\u00028\u00000\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0015\u0010\u0018\u001a\u00020\u0000*\u00020\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0019"}, d2 = {"", "uin", "Landroid/graphics/drawable/Drawable;", "b", "Lcom/tencent/mvi/api/runtime/b;", "barrier", "Lkotlin/Function0;", "", "block", "e", "Landroid/content/res/Resources;", "resource", "", "resId", "d", "Lcom/tencent/mvi/base/route/MsgIntent;", "I", "Lkotlin/reflect/KClass;", "c", "(Lkotlin/reflect/KClass;)Ljava/lang/String;", QQBrowserActivity.KEY_MSG_TYPE, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "a", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)Ljava/lang/String;", "atMemberNick", "robot-business-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c {
    @NotNull
    public static final String a(@NotNull MsgRecord msgRecord) {
        boolean z16;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        String str = msgRecord.sendMemberName;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!(true ^ z16)) {
            str = null;
        }
        if (str == null) {
            String sendNickName = msgRecord.sendNickName;
            Intrinsics.checkNotNullExpressionValue(sendNickName, "sendNickName");
            return sendNickName;
        }
        return str;
    }

    @Nullable
    public static final Drawable b(@NotNull String uin) {
        AppInterface appInterface;
        Intrinsics.checkNotNullParameter(uin, "uin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        return FaceDrawable.getFaceDrawable(appInterface, 1, uin);
    }

    @Nullable
    public static final <I extends MsgIntent> String c(@NotNull KClass<I> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return JvmClassMappingKt.getJavaClass((KClass) kClass).getCanonicalName();
    }

    @Nullable
    public static final Drawable d(@NotNull Resources resource, @DrawableRes int i3) {
        Drawable mutate;
        Intrinsics.checkNotNullParameter(resource, "resource");
        Drawable drawable = ResourcesCompat.getDrawable(resource, i3, null);
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof SkinnableBitmapDrawable) {
            mutate = ((SkinnableBitmapDrawable) drawable).mutate2();
        } else {
            mutate = drawable.mutate();
        }
        return mutate;
    }

    public static final void e(@NotNull com.tencent.mvi.api.runtime.b bVar, @NotNull String barrier, @NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(barrier, "barrier");
        Intrinsics.checkNotNullParameter(block, "block");
        bVar.e().h(new InputDialogPriorityMsgIntent.AddProcessBarrier(barrier, 0, 2, null));
        block.invoke();
        bVar.e().h(new InputDialogPriorityMsgIntent.RemoveProcessBarrier(barrier, 0, 2, null));
    }
}
