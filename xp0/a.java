package xp0;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.SparseArrayKt;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.msglist.holder.config.c;
import com.tencent.guild.aio.msglist.holder.config.d;
import com.tencent.guild.aio.msglist.holder.state.MsgListItemState;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.EmojiReplyElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 62\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00017B)\u0012\u0006\u0010$\u001a\u00020\u000b\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010.\u001a\u00020)\u0012\b\b\u0002\u00103\u001a\u00020\u0019\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\u0011\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u000f\u0012\u0006\b\u0001\u0012\u00020\u00100\u000e0\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0016\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J$\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cR\u0017\u0010$\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0017\u0010.\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0017\u00103\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lxp0/a;", "Lcom/tencent/aio/api/list/a;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "Lcom/tencent/guild/aio/msglist/holder/state/MsgListItemState;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "i1", "", "f1", "g1", "Landroid/view/View;", "hostView", "", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/api/list/b;", "b1", "state", "h1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "", "", "payloads", "e1", "d", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "itemView", "Lcom/tencent/guild/aio/msglist/holder/config/d;", "e", "Lcom/tencent/guild/aio/msglist/holder/config/d;", "componentProvider", "Lcom/tencent/guild/aio/msglist/holder/config/c;", "f", "Lcom/tencent/guild/aio/msglist/holder/config/c;", "getFactoryProvider", "()Lcom/tencent/guild/aio/msglist/holder/config/c;", "factoryProvider", h.F, "I", "getViewType", "()I", "viewType", "<init>", "(Landroid/view/View;Lcom/tencent/guild/aio/msglist/holder/config/d;Lcom/tencent/guild/aio/msglist/holder/config/c;I)V", "i", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View itemView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d componentProvider;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c factoryProvider;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int viewType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"xp0/a$b", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends ClickableSpan {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildMsgItem f448267e;

        b(GuildMsgItem guildMsgItem) {
            this.f448267e = guildMsgItem;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            a.this.g1(this.f448267e);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            Intrinsics.checkNotNullParameter(ds5, "ds");
            ds5.setColor(ds5.linkColor);
            ds5.setUnderlineText(false);
        }
    }

    public a(@NotNull View itemView, @NotNull d componentProvider, @NotNull c factoryProvider, int i3) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(componentProvider, "componentProvider");
        Intrinsics.checkNotNullParameter(factoryProvider, "factoryProvider");
        this.itemView = itemView;
        this.componentProvider = componentProvider;
        this.factoryProvider = factoryProvider;
        this.viewType = i3;
    }

    private final CharSequence f1(GuildMsgItem msgItem) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(GuildMsgItem.getExtInfoFromExtStr$default(msgItem, "guild_gray_tips_combine_content", null, 2, null));
        spannableStringBuilder.setSpan(new b(msgItem), spannableStringBuilder.length() - 2, spannableStringBuilder.length(), 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ResourcesCompat.getColor(BaseApplication.context.getResources(), R.color.qui_common_text_link, null)), spannableStringBuilder.length() - 2, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g1(GuildMsgItem msgItem) {
        GrayTipElement grayTipElement;
        EmojiReplyElement emojiReplyElement;
        MsgElement firstTypeElement = msgItem.getFirstTypeElement(8);
        if (firstTypeElement != null && (grayTipElement = firstTypeElement.grayTipElement) != null && (emojiReplyElement = grayTipElement.emojiReplyElement) != null) {
            long j3 = emojiReplyElement.msgSeq;
            if (j3 > 0) {
                sendIntent(new a.s(j3));
            }
        }
    }

    private final void i1(GuildMsgItem msgItem) {
        boolean z16;
        this.itemView.setVisibility(0);
        String extInfoFromExtStr$default = GuildMsgItem.getExtInfoFromExtStr$default(msgItem, "guild_gray_tips_combine_status", null, 2, null);
        if (extInfoFromExtStr$default != null) {
            if (extInfoFromExtStr$default.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                TextView textView = (TextView) this.itemView.findViewById(R.id.vs_);
                TextView textView2 = (TextView) this.itemView.findViewById(R.id.vsh);
                switch (extInfoFromExtStr$default.hashCode()) {
                    case 49:
                        if (extInfoFromExtStr$default.equals("1")) {
                            this.itemView.setVisibility(0);
                            this.itemView.getLayoutParams().width = -2;
                            this.itemView.getLayoutParams().height = -2;
                            return;
                        }
                        return;
                    case 50:
                        if (extInfoFromExtStr$default.equals("2")) {
                            this.itemView.setVisibility(0);
                            this.itemView.getLayoutParams().width = -2;
                            this.itemView.getLayoutParams().height = -2;
                            textView2.setText(f1(msgItem));
                            textView.setText(GuildMsgItem.getExtInfoFromExtStr$default(msgItem, "guild_gray_tips_combine_name", null, 2, null));
                            return;
                        }
                        return;
                    case 51:
                        if (extInfoFromExtStr$default.equals("3")) {
                            this.itemView.setVisibility(8);
                            this.itemView.getLayoutParams().width = 0;
                            this.itemView.getLayoutParams().height = 0;
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    @Override // com.tencent.aio.api.list.a
    @Nullable
    public com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> b1() {
        return this.factoryProvider.a(this.viewType).a();
    }

    public final void e1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Iterator valueIterator = SparseArrayKt.valueIterator(this.componentProvider.get());
        while (valueIterator.hasNext()) {
            com.tencent.guild.aio.msglist.holder.component.a aVar = (com.tencent.guild.aio.msglist.holder.component.a) valueIterator.next();
            if (aVar != null) {
                aVar.b1(position, msgItem, payloads);
            }
        }
        i1((GuildMsgItem) msgItem);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull MsgListItemState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        e1(state.getPosition(), state.getData(), state.b());
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        View view;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        ArrayList arrayList = new ArrayList();
        Iterator valueIterator = SparseArrayKt.valueIterator(this.componentProvider.get());
        while (valueIterator.hasNext()) {
            com.tencent.guild.aio.msglist.holder.component.a aVar = (com.tencent.guild.aio.msglist.holder.component.a) valueIterator.next();
            if (aVar != null) {
                view = aVar.getContainerView();
            } else {
                view = null;
            }
            if (view != null) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return this.itemView;
    }
}
