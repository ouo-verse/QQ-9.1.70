package se1;

import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.aisearch.models.AiChatSession;
import com.tencent.mobileqq.guild.aisearch.models.a;
import com.tencent.mobileqq.guild.discoveryv2.share.picture.GuildSearchLLMChatPictureGenerator;
import com.tencent.mobileqq.search.api.impl.SearchGuildDaTongApiImpl;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lse1/b;", "", "", "b", "d", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textView", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "selectionRunnable", "c", "hiddenObj", "<init>", "(Landroid/widget/TextView;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView textView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable selectionRunnable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView hiddenObj;

    public b(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        this.textView = textView;
        TextView textView2 = new TextView(textView.getContext());
        this.hiddenObj = textView2;
        VideoReport.setElementId(textView2, "em_sgrp_copy_float");
        VideoReport.setLogicParent(textView2, textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(b this$0) {
        GuildSearchLLMChatPictureGenerator.b bVar;
        String str;
        HashMap hashMapOf;
        AiChatSession m06;
        a.QuestionItem c16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object tag = this$0.textView.getTag(R.id.x1r);
        if (tag instanceof GuildSearchLLMChatPictureGenerator.b) {
            bVar = (GuildSearchLLMChatPictureGenerator.b) tag;
        } else {
            bVar = null;
        }
        if (bVar == null || (m06 = bVar.m0()) == null || (c16 = m06.c()) == null || (str = c16.getQuestion()) == null) {
            str = "";
        }
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(SearchGuildDaTongApiImpl.GUILD_SEARCH_ITEM_RECALL_QUERY, str));
        VideoReport.reportEvent("dt_imp", this$0.hiddenObj, hashMapOf);
    }

    public final void b() {
        Runnable runnable = this.selectionRunnable;
        if (runnable != null) {
            this.textView.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: se1.a
            @Override // java.lang.Runnable
            public final void run() {
                b.c(b.this);
            }
        };
        this.selectionRunnable = runnable2;
        this.textView.postDelayed(runnable2, 1000L);
    }

    public final void d() {
        GuildSearchLLMChatPictureGenerator.b bVar;
        String str;
        HashMap hashMapOf;
        AiChatSession m06;
        a.QuestionItem c16;
        Object tag = this.textView.getTag(R.id.x1r);
        if (tag instanceof GuildSearchLLMChatPictureGenerator.b) {
            bVar = (GuildSearchLLMChatPictureGenerator.b) tag;
        } else {
            bVar = null;
        }
        if (bVar == null || (m06 = bVar.m0()) == null || (c16 = m06.c()) == null || (str = c16.getQuestion()) == null) {
            str = "";
        }
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(SearchGuildDaTongApiImpl.GUILD_SEARCH_ITEM_RECALL_QUERY, str));
        VideoReport.reportEvent("dt_clck", this.hiddenObj, hashMapOf);
    }
}
