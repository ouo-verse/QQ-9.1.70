package vr2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.qqnt.kernel.nativeinterface.AIVoiceChatType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u000e"}, d2 = {"Lvr2/b;", "", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/FastDynamicDrawable;", "b", "Landroid/content/Context;", "context", "", "aiChatType", "", "isSelect", "Landroid/graphics/drawable/Drawable;", "a", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f443198a = new b();

    b() {
    }

    public final Drawable a(Context context, int aiChatType, boolean isSelect) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (aiChatType == AIVoiceChatType.KAIVOICECHATTYPESOUND.ordinal()) {
            if (isSelect) {
                return ie0.a.f().o(context, R.drawable.qui_play, R.color.qui_common_feedback_normal, 1001);
            }
            return ContextCompat.getDrawable(context, R.drawable.qui_play);
        }
        if (aiChatType != AIVoiceChatType.KAIVOICECHATTYPESING.ordinal()) {
            return ContextCompat.getDrawable(context, R.drawable.qui_music);
        }
        if (isSelect) {
            return ie0.a.f().o(context, R.drawable.qui_music_box, R.color.qui_common_feedback_normal, 1001);
        }
        return ContextCompat.getDrawable(context, R.drawable.qui_music_box);
    }

    public final FastDynamicDrawable b() {
        return com.tencent.cachedrawable.dynamicdrawable.api.a.a().k("https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9150/aishengliao/qecommerce_shengliao_icon_colour_iSpt.png").l(VasDynamicDrawableCache.INSTANCE).a();
    }
}
