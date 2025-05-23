package vh1;

import android.view.View;
import androidx.annotation.IdRes;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lvh1/b;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u0004R\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0016\u00a8\u0006\u001e"}, d2 = {"Lvh1/b$a;", "", "Landroid/view/View;", "view", "", "type", "", "channelId", "", "b", "containerView", "title", "position", "d", "curRootView", "parentViewId", "a", "REPORT_PARAM_CHANNEL_ID", "Ljava/lang/String;", "REPORT_PARAM_TITLE", "REPORT_PARAM_TYPE", "TYPE_ALL", "I", "TYPE_CATEGORY_FEATURE", "TYPE_CREATED_BY_LITTLE_WORLD_AUTHOR", "TYPE_MORE", "TYPE_MY_JOINED", "TYPE_RECENT", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: vh1.b$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void c(Companion companion, View view, int i3, String str, int i16, Object obj) {
            if ((i16 & 4) != 0) {
                str = "";
            }
            companion.b(view, i3, str);
        }

        @Nullable
        public final View a(@NotNull View curRootView, @IdRes int parentViewId) {
            Intrinsics.checkNotNullParameter(curRootView, "curRootView");
            while (curRootView.getParent() != null) {
                View findViewById = curRootView.findViewById(parentViewId);
                if (findViewById != null) {
                    return findViewById;
                }
                Object parent = curRootView.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
                curRootView = (View) parent;
            }
            return null;
        }

        public final void b(@NotNull View view, int type, @NotNull String channelId) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("sgrp_type", Integer.valueOf(type));
            linkedHashMap.put("sgrp_channel_id", channelId);
            com.tencent.mobileqq.guild.api.impl.e.c(view, "em_sgrp_joined_view_list");
            com.tencent.mobileqq.guild.api.impl.e.e(view, linkedHashMap);
            com.tencent.mobileqq.guild.api.impl.e.b(view, "2");
            com.tencent.mobileqq.guild.api.impl.e.d(view, "1");
        }

        public final void d(@NotNull View containerView, @NotNull String title, int position) {
            Intrinsics.checkNotNullParameter(containerView, "containerView");
            Intrinsics.checkNotNullParameter(title, "title");
            com.tencent.mobileqq.guild.api.impl.e.f(containerView, String.valueOf(position));
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("sgrp_title", title);
            com.tencent.mobileqq.guild.api.impl.e.e(containerView, linkedHashMap);
            com.tencent.mobileqq.guild.api.impl.e.c(containerView, "em_sgrp_joined_view");
            com.tencent.mobileqq.guild.api.impl.e.b(containerView, "2");
        }

        Companion() {
        }
    }
}
