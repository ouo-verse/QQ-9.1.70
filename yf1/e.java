package yf1;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingUIState;
import com.tencent.mobileqq.guild.channel.managev2.b;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vp1.y;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lyf1/e;", "Lcom/tencent/mobileqq/guild/channel/managev2/a;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lyf1/f;", "g1", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingUIState;", "state", "", "h1", "Lvp1/y;", "e", "Lvp1/y;", "binding", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b;", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "f", "Lcom/tencent/mobileqq/widget/listitem/x;", "viewConfig", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class e extends com.tencent.mobileqq.guild.channel.managev2.a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private y binding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private x<x.b, x.c> viewConfig;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("fastClickGuard")) {
            y yVar = this$0.binding;
            if (yVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                yVar = null;
            }
            QUISingleLineListItem qUISingleLineListItem = yVar.f443144d;
            Intrinsics.checkNotNullExpressionValue(qUISingleLineListItem, "binding.singleLineItem");
            this$0.sendIntent(new b.C7685b(qUISingleLineListItem));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("fastClickGuard")) {
            y yVar = this$0.binding;
            if (yVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                yVar = null;
            }
            TextView textView = yVar.f443142b;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.settingTips1");
            this$0.sendIntent(new b.a(textView));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("fastClickGuard")) {
            y yVar = this$0.binding;
            if (yVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                yVar = null;
            }
            TextView textView = yVar.f443143c;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.settingTips2");
            this$0.sendIntent(new b.a(textView));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l1(Drawable drawable, e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        y yVar = null;
        if (drawable != null) {
            y yVar2 = this$0.binding;
            if (yVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                yVar2 = null;
            }
            int measuredHeight = ((yVar2.f443142b.getMeasuredHeight() - ((int) cw.d(7))) - drawable.getIntrinsicHeight()) / 2;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            y yVar3 = this$0.binding;
            if (yVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                yVar3 = null;
            }
            drawable.setBounds(0, measuredHeight, intrinsicWidth, ((yVar3.f443142b.getMeasuredHeight() - ((int) cw.d(7))) + drawable.getIntrinsicHeight()) / 2);
        }
        y yVar4 = this$0.binding;
        if (yVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            yVar4 = null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(yVar4.f443142b.getContext().getResources().getString(R.string.f140950fc));
        spannableStringBuilder.append((CharSequence) "  ");
        if (drawable != null) {
            spannableStringBuilder.setSpan(new ImageSpan(drawable), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) " ");
        y yVar5 = this$0.binding;
        if (yVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            yVar5 = null;
        }
        spannableStringBuilder.append((CharSequence) yVar5.f443142b.getContext().getResources().getString(R.string.f140960fd));
        y yVar6 = this$0.binding;
        if (yVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            yVar = yVar6;
        }
        yVar.f443142b.setText(spannableStringBuilder);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public f getViewModel() {
        return new f();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull ChannelSettingUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        x<x.b, x.c> xVar = this.viewConfig;
        y yVar = null;
        x<x.b, x.c> xVar2 = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
            xVar = null;
        }
        x.c O = xVar.O();
        Intrinsics.checkNotNull(O, "null cannot be cast to non-null type com.tencent.mobileqq.widget.listitem.SingleLineConfig.Right.Text");
        x.c.g gVar = (x.c.g) O;
        if (state instanceof ChannelSettingUIState.SettingItemDescUIState) {
            gVar.h(((ChannelSettingUIState.SettingItemDescUIState) state).getDesc());
            y yVar2 = this.binding;
            if (yVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                yVar2 = null;
            }
            QUISingleLineListItem qUISingleLineListItem = yVar2.f443144d;
            x<x.b, x.c> xVar3 = this.viewConfig;
            if (xVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
            } else {
                xVar2 = xVar3;
            }
            qUISingleLineListItem.setConfig(xVar2);
            return;
        }
        if (state instanceof ChannelSettingUIState.SettingItemEnableUIState) {
            y yVar3 = this.binding;
            if (yVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                yVar3 = null;
            }
            QUISingleLineListItem qUISingleLineListItem2 = yVar3.f443144d;
            Intrinsics.checkNotNullExpressionValue(qUISingleLineListItem2, "binding.singleLineItem");
            ChannelSettingUIState.SettingItemEnableUIState settingItemEnableUIState = (ChannelSettingUIState.SettingItemEnableUIState) state;
            b1(qUISingleLineListItem2, settingItemEnableUIState.getEnableModify());
            y yVar4 = this.binding;
            if (yVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                yVar4 = null;
            }
            TextView textView = yVar4.f443142b;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.settingTips1");
            b1(textView, settingItemEnableUIState.getEnableModify());
            y yVar5 = this.binding;
            if (yVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                yVar = yVar5;
            }
            TextView textView2 = yVar.f443143c;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.settingTips2");
            b1(textView2, settingItemEnableUIState.getEnableModify());
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        y g16 = y.g(LayoutInflater.from(createViewParams.a()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026reateViewParams.context))");
        this.binding = g16;
        String string = createViewParams.a().getString(R.string.f154561f5);
        Intrinsics.checkNotNullExpressionValue(string, "createViewParams.context\u2026eate_activity_permission)");
        this.viewConfig = new x<>(new x.b.d(string), new x.c.g("", true, false, 4, null));
        y yVar = this.binding;
        y yVar2 = null;
        if (yVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            yVar = null;
        }
        QUISingleLineListItem qUISingleLineListItem = yVar.f443144d;
        x<x.b, x.c> xVar = this.viewConfig;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
            xVar = null;
        }
        qUISingleLineListItem.setConfig(xVar);
        y yVar3 = this.binding;
        if (yVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            yVar3 = null;
        }
        yVar3.f443144d.setStyle(QUIListItemStyle.Card);
        y yVar4 = this.binding;
        if (yVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            yVar4 = null;
        }
        yVar4.f443144d.setBackgroundType(QUIListItemBackgroundType.AllRound);
        y yVar5 = this.binding;
        if (yVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            yVar5 = null;
        }
        yVar5.f443144d.setOnClickListener(new View.OnClickListener() { // from class: yf1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.i1(e.this, view);
            }
        });
        y yVar6 = this.binding;
        if (yVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            yVar6 = null;
        }
        yVar6.f443142b.setOnClickListener(new View.OnClickListener() { // from class: yf1.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.j1(e.this, view);
            }
        });
        y yVar7 = this.binding;
        if (yVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            yVar7 = null;
        }
        yVar7.f443143c.setOnClickListener(new View.OnClickListener() { // from class: yf1.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.k1(e.this, view);
            }
        });
        final Drawable w3 = GuildUIUtils.w(createViewParams.a(), R.drawable.guild_media_setting_activity_info_icon, Integer.valueOf(R.color.qui_common_text_secondary));
        y yVar8 = this.binding;
        if (yVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            yVar8 = null;
        }
        yVar8.f443142b.post(new Runnable() { // from class: yf1.d
            @Override // java.lang.Runnable
            public final void run() {
                e.l1(w3, this);
            }
        });
        y yVar9 = this.binding;
        if (yVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            yVar2 = yVar9;
        }
        LinearLayout root = yVar2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }
}
