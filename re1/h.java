package re1;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.aisearch.AIChatListPart;
import com.tencent.mobileqq.guild.aisearch.models.AiChatSession;
import com.tencent.mobileqq.guild.aisearch.models.ChatAnswerData;
import com.tencent.mobileqq.guild.aisearch.models.a;
import com.tencent.mobileqq.guild.discoveryv2.share.picture.GuildSearchLLMChatPictureGenerator;
import com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.o;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchAISearchInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.impl.SearchGuildDaTongApiImpl;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001 B\u001d\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\rH\u0002J(\u0010\u001b\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00010\u0019j\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u0001`\u001aH\u0002J\u0016\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010*\u00a8\u0006."}, d2 = {"Lre1/h;", "", "Lcom/tencent/mobileqq/guild/aisearch/models/e;", "data", "Lre1/h$a;", "o", "newState", "", "p", "j", "Landroid/widget/ImageView;", "apngView", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, tl.h.F, "l", "k", "i", "e", DomainData.DOMAIN_NAME, "r", "state", "", "c", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "d", "Lcom/tencent/mobileqq/guild/aisearch/models/a$b;", "answerData", "f", "Lvp1/b;", "a", "Lvp1/b;", "binding", "Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "b", "Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$b;", "adapter", "Lre1/h$a;", "currentState", "Lcom/tencent/mobileqq/guild/aisearch/models/a$b;", "currentAnswerItem", "<init>", "(Lvp1/b;Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$b;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final vp1.b binding;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildSearchLLMChatPictureGenerator.b<RecyclerView.ViewHolder> adapter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private a currentState;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a.AnswerItem currentAnswerItem;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b\u00a8\u0006\f"}, d2 = {"Lre1/h$a;", "", "<init>", "()V", "a", "b", "c", "d", "Lre1/h$a$a;", "Lre1/h$a$b;", "Lre1/h$a$c;", "Lre1/h$a$d;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static abstract class a {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lre1/h$a$a;", "Lre1/h$a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/guild/aisearch/models/e;", "a", "Lcom/tencent/mobileqq/guild/aisearch/models/e;", "()Lcom/tencent/mobileqq/guild/aisearch/models/e;", "data", "<init>", "(Lcom/tencent/mobileqq/guild/aisearch/models/e;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: re1.h$a$a, reason: collision with other inner class name and from toString */
        /* loaded from: classes12.dex */
        public static final /* data */ class Content extends a {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private final ChatAnswerData data;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Content(@NotNull ChatAnswerData data) {
                super(null);
                Intrinsics.checkNotNullParameter(data, "data");
                this.data = data;
            }

            @NotNull
            /* renamed from: a, reason: from getter */
            public final ChatAnswerData getData() {
                return this.data;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if ((other instanceof Content) && Intrinsics.areEqual(this.data, ((Content) other).data)) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return this.data.hashCode();
            }

            @NotNull
            public String toString() {
                return "Content(data=" + this.data + ")";
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lre1/h$a$b;", "Lre1/h$a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "()I", "type", "<init>", "(I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: re1.h$a$b, reason: from toString */
        /* loaded from: classes12.dex */
        public static final /* data */ class Error extends a {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            private final int type;

            public Error(int i3) {
                super(null);
                this.type = i3;
            }

            /* renamed from: a, reason: from getter */
            public final int getType() {
                return this.type;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if ((other instanceof Error) && this.type == ((Error) other).type) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return this.type;
            }

            @NotNull
            public String toString() {
                return "Error(type=" + this.type + ")";
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lre1/h$a$c;", "Lre1/h$a;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes12.dex */
        public static final class c extends a {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final c f431159a = new c();

            c() {
                super(null);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lre1/h$a$d;", "Lre1/h$a;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes12.dex */
        public static final class d extends a {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final d f431160a = new d();

            d() {
                super(null);
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public h(@NotNull vp1.b binding, @NotNull GuildSearchLLMChatPictureGenerator.b<RecyclerView.ViewHolder> adapter) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.binding = binding;
        this.adapter = adapter;
        this.currentState = a.c.f431159a;
    }

    private final String c(int state) {
        String str;
        IGProGuildSearchAISearchInfo searchInfo;
        switch (state) {
            case 6:
                return "\u62b1\u6b49\uff0c\u6211\u6682\u65f6\u65e0\u6cd5\u56de\u7b54\u4f60\u7684\u95ee\u9898\u3002\u8bf7\u7a0d\u540e\u91cd\u8bd5\u3002";
            case 7:
                a.AnswerItem answerItem = this.currentAnswerItem;
                if (answerItem != null && (searchInfo = answerItem.getSearchInfo()) != null) {
                    str = searchInfo.getDefaultText();
                } else {
                    str = null;
                }
                String str2 = str;
                if (str2 == null) {
                    return "\u62b1\u6b49\uff0c\u5f53\u524d\u95ee\u9898\u6211\u6682\u65f6\u65e0\u6cd5\u56de\u7b54\uff0c\u8bf7\u6362\u4e2a\u95ee\u9898\u91cd\u8bd5\u3002";
                }
                return str2;
            case 8:
            case 9:
                return "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u70b9\u51fb\u91cd\u8bd5";
            case 10:
                return "\u62b1\u6b49\uff0c\u6682\u65e0\u76f8\u5173\u5185\u5bb9";
            default:
                return "";
        }
    }

    private final HashMap<String, Object> d() {
        String str;
        String str2;
        String messageId;
        a.QuestionItem c16;
        HashMap<String, Object> hashMap = new HashMap<>();
        AiChatSession m06 = this.adapter.m0();
        String str3 = "";
        if (m06 == null || (c16 = m06.c()) == null || (str = c16.getQuestion()) == null) {
            str = "";
        }
        hashMap.put(SearchGuildDaTongApiImpl.GUILD_SEARCH_ITEM_RECALL_QUERY, str);
        if (m06 == null || (str2 = m06.getSessionId()) == null) {
            str2 = "";
        }
        hashMap.put("sgrp_ai_session_id", str2);
        a.AnswerItem answerItem = this.currentAnswerItem;
        if (answerItem != null && (messageId = answerItem.getMessageId()) != null) {
            str3 = messageId;
        }
        hashMap.put("sgrp_dialog_id", str3);
        return hashMap;
    }

    private final void e(ChatAnswerData data) {
        n();
        r(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map g(h this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.d();
    }

    private final void h(int errorType) {
        vp1.b bVar = this.binding;
        n();
        bVar.f442369e.setVisibility(0);
        bVar.f442367c.setVisibility(8);
        bVar.f442374j.setVisibility(8);
        bVar.f442379o.setVisibility(8);
        bVar.f442368d.setText(c(errorType));
        if (errorType != 7 && errorType != 10) {
            Unit unit = Unit.INSTANCE;
            return;
        }
        ImageView imageView = bVar.f442375k;
        imageView.setVisibility(8);
        Intrinsics.checkNotNullExpressionValue(imageView, "retryBtn.gone()");
    }

    private final void i(ChatAnswerData data) {
        boolean z16;
        vp1.b bVar = this.binding;
        ImageView thinkingIcon = bVar.f442380p;
        Intrinsics.checkNotNullExpressionValue(thinkingIcon, "thinkingIcon");
        if (thinkingIcon.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ImageView thinkingIcon2 = bVar.f442380p;
            Intrinsics.checkNotNullExpressionValue(thinkingIcon2, "thinkingIcon");
            te1.c.c(thinkingIcon2, 0L, 1, null);
            ImageView thinkFinishIcon = bVar.f442377m;
            Intrinsics.checkNotNullExpressionValue(thinkFinishIcon, "thinkFinishIcon");
            te1.c.f(thinkFinishIcon, 0L, 1, null);
        } else {
            bVar.f442380p.setVisibility(8);
            bVar.f442377m.setVisibility(0);
        }
        TextView textView = bVar.f442378n;
        textView.setText(textView.getContext().getString(R.string.f157691nl, Integer.valueOf(data.m())));
    }

    private final void j() {
        vp1.b bVar = this.binding;
        bVar.f442369e.setVisibility(8);
        bVar.f442373i.setVisibility(0);
        bVar.f442367c.setVisibility(8);
        bVar.f442374j.setVisibility(8);
        bVar.f442379o.setVisibility(8);
        bVar.f442371g.setVisibility(8);
        ImageView loadingLottie = bVar.f442371g;
        Intrinsics.checkNotNullExpressionValue(loadingLottie, "loadingLottie");
        q(loadingLottie);
        bVar.f442372h.setText(o.INSTANCE.a().getLoadingText());
    }

    private final void k() {
        vp1.b bVar = this.binding;
        ImageView thinkingIcon = bVar.f442380p;
        Intrinsics.checkNotNullExpressionValue(thinkingIcon, "thinkingIcon");
        q(thinkingIcon);
        bVar.f442377m.setVisibility(8);
        bVar.f442378n.setText(HardCodeUtil.qqStr(R.string.f157701nm));
    }

    private final void l(ChatAnswerData data) {
        vp1.b bVar = this.binding;
        bVar.f442379o.setVisibility(0);
        bVar.f442376l.setVisibility(0);
        if (data.getState() == 2) {
            k();
        } else {
            i(data);
        }
        if (data.getState() == 5) {
            this.binding.f442379o.post(new Runnable() { // from class: re1.g
                @Override // java.lang.Runnable
                public final void run() {
                    h.m(h.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(h this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoReport.reportEvent("dt_imp", this$0.binding.f442379o, this$0.d());
    }

    private final void n() {
        vp1.b bVar = this.binding;
        bVar.f442373i.setVisibility(8);
        bVar.f442369e.setVisibility(8);
    }

    private final a o(ChatAnswerData data) {
        a content;
        if (data.j()) {
            return a.d.f431160a;
        }
        if (data.i()) {
            content = new a.Error(data.getState());
        } else {
            content = new a.Content(data);
        }
        return content;
    }

    private final void p(a newState) {
        if (newState instanceof a.d) {
            j();
        } else if (newState instanceof a.Error) {
            h(((a.Error) newState).getType());
        } else if (newState instanceof a.Content) {
            e(((a.Content) newState).getData());
        }
        this.currentState = newState;
    }

    private final void q(ImageView apngView) {
        boolean z16;
        if (apngView.getVisibility() == 8) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            apngView.setVisibility(0);
            ApngOptions apngOptions = new ApngOptions();
            apngOptions.setRequestWidth(apngView.getWidth());
            apngOptions.setRequestHeight(apngView.getHeight());
            apngView.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("MsgStateController", AIChatListPart.INSTANCE.a(), apngOptions));
        }
    }

    private final void r(ChatAnswerData data) {
        boolean z16;
        vp1.b bVar = this.binding;
        if (data.getReasonContent().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            bVar.f442374j.setVisibility(8);
            LinearLayout linearLayout = bVar.f442379o;
            linearLayout.setVisibility(8);
            Intrinsics.checkNotNullExpressionValue(linearLayout, "{\n                reason\u2026psLl.gone()\n            }");
            return;
        }
        l(data);
    }

    public final void f(@NotNull ChatAnswerData data, @NotNull a.AnswerItem answerData) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(answerData, "answerData");
        a o16 = o(data);
        this.currentAnswerItem = answerData;
        p(o16);
        ch.V0(this.binding.f442379o, "em_sgrp_fold", new IDynamicParams() { // from class: re1.f
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map g16;
                g16 = h.g(h.this, str);
                return g16;
            }
        });
        VideoReport.setElementExposePolicy(this.binding.f442379o, ExposurePolicy.REPORT_NONE);
    }
}
