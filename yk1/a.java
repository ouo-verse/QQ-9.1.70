package yk1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.weight.GuildFeedCommentEmojiShortcutBar;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.weight.GuildFeedInputBarCompatExpand;
import com.tencent.mobileqq.guild.feed.widget.comment.CommentEditText;
import com.tencent.mobileqq.guild.widget.qqui.RoundRectImageView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import xk1.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010N\u001a\u00020M\u00a2\u0006\u0004\bO\u0010PJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001c\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001a\u0010\f\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010$\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0006\u001a\u0004\b#\u0010\u000eR\u001a\u0010*\u001a\u00020%8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010,\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b+\u0010\u0006\u001a\u0004\b\u001d\u0010\u000eR\u0017\u0010-\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u001e\u001a\u0004\b&\u0010 R\u0017\u0010/\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b.\u0010 R\u0017\u00101\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b0\u0010\u001e\u001a\u0004\b\u0017\u0010 R\u0017\u00106\u001a\u0002028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u00103\u001a\u0004\b4\u00105R\u0017\u00107\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0006\u001a\u0004\b\u0011\u0010\u000eR$\u0010:\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u0006\u001a\u0004\b+\u0010\u000e\"\u0004\b8\u00109R\u0017\u0010>\u001a\u00020;8\u0006\u00a2\u0006\f\n\u0004\b4\u0010<\u001a\u0004\b\"\u0010=R\u0017\u0010@\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b?\u0010 R\u0017\u0010B\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b?\u0010\u0012\u001a\u0004\bA\u0010\u0014R\u0017\u0010G\u001a\u00020C8\u0006\u00a2\u0006\f\n\u0004\bA\u0010D\u001a\u0004\bE\u0010FR\u0017\u0010I\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\bH\u0010\u001e\u001a\u0004\bH\u0010 R\u0011\u0010L\u001a\u00020J8F\u00a2\u0006\u0006\u001a\u0004\b0\u0010K\u00a8\u0006Q"}, d2 = {"Lyk1/a;", "Lxk1/f;", "Landroid/view/View;", "getRoot", "kotlin.jvm.PlatformType", "a", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/ViewGroup;", "b", "Landroid/view/ViewGroup;", "()Landroid/view/ViewGroup;", "inputPanelContainer", "c", "()Landroid/view/View;", "blankView", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/widget/FrameLayout;", "panelLayout", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/weight/GuildFeedInputBarCompatExpand;", "e", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/weight/GuildFeedInputBarCompatExpand;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/weight/GuildFeedInputBarCompatExpand;", "inputLayout", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", DomainData.DOMAIN_NAME, "()Landroid/widget/ImageView;", "inputShadow", "g", "k", "inputContainer", "Lcom/tencent/mobileqq/guild/feed/widget/comment/CommentEditText;", h.F, "Lcom/tencent/mobileqq/guild/feed/widget/comment/CommentEditText;", "j", "()Lcom/tencent/mobileqq/guild/feed/widget/comment/CommentEditText;", "input", "i", "ctrlLayout", "emotionButton", "o", "keyboardButton", "l", "atButton", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "p", "()Landroid/widget/TextView;", "lengthLimitTipsView", "sendBtn", "v", "(Landroid/view/View;)V", "emotionPanelView", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/weight/GuildFeedCommentEmojiShortcutBar;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/weight/GuildFeedCommentEmojiShortcutBar;", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/weight/GuildFeedCommentEmojiShortcutBar;", "emoShortcut", "r", "picButton", ReportConstant.COSTREPORT_PREFIX, "picContainer", "Lcom/tencent/mobileqq/guild/widget/qqui/RoundRectImageView;", "Lcom/tencent/mobileqq/guild/widget/qqui/RoundRectImageView;", "u", "()Lcom/tencent/mobileqq/guild/widget/qqui/RoundRectImageView;", "picIv", "t", "picDelete", "", "()I", "inputHeightIncludingDecoration", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final View rootView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup inputPanelContainer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View blankView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout panelLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFeedInputBarCompatExpand inputLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView inputShadow;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View inputContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CommentEditText input;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View ctrlLayout;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView emotionButton;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView keyboardButton;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView atButton;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView lengthLimitTipsView;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View sendBtn;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View emotionPanelView;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFeedCommentEmojiShortcutBar emoShortcut;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView picButton;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout picContainer;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RoundRectImageView picIv;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView picDelete;

    public a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.epk, (ViewGroup) null);
        this.rootView = inflate;
        View findViewById = inflate.findViewById(R.id.wjr);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026ld_input_panel_container)");
        this.inputPanelContainer = (ViewGroup) findViewById;
        View findViewById2 = getRoot().findViewById(R.id.aav);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.blank)");
        this.blankView = findViewById2;
        View findViewById3 = getInputPanelContainer().findViewById(R.id.wth);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "inputPanelContainer.find\u2026id.guild_panel_container)");
        this.panelLayout = (FrameLayout) findViewById3;
        View findViewById4 = getInputPanelContainer().findViewById(R.id.u1n);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "inputPanelContainer.find\u2026(R.id.comment_input_edit)");
        GuildFeedInputBarCompatExpand guildFeedInputBarCompatExpand = (GuildFeedInputBarCompatExpand) findViewById4;
        this.inputLayout = guildFeedInputBarCompatExpand;
        View findViewById5 = getInputPanelContainer().findViewById(R.id.tai);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "inputPanelContainer.find\u2026wById(R.id.bottom_shadow)");
        this.inputShadow = (ImageView) findViewById5;
        View findViewById6 = getInputPanelContainer().findViewById(R.id.xog);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "inputPanelContainer.find\u2026R.id.input_bar_container)");
        this.inputContainer = findViewById6;
        View findViewById7 = guildFeedInputBarCompatExpand.findViewById(R.id.jha);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "inputLayout.findViewById(R.id.text_input)");
        this.input = (CommentEditText) findViewById7;
        View findViewById8 = guildFeedInputBarCompatExpand.findViewById(R.id.uc_);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "inputLayout.findViewById(R.id.ctrl_layout)");
        this.ctrlLayout = findViewById8;
        View findViewById9 = guildFeedInputBarCompatExpand.findViewById(R.id.ah5);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "inputLayout.findViewById(R.id.btn_emotion)");
        this.emotionButton = (ImageView) findViewById9;
        View findViewById10 = guildFeedInputBarCompatExpand.findViewById(R.id.f164667tf0);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "inputLayout.findViewById(R.id.btn_keyborad)");
        this.keyboardButton = (ImageView) findViewById10;
        View findViewById11 = guildFeedInputBarCompatExpand.findViewById(R.id.tcu);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "inputLayout.findViewById(R.id.btn_at)");
        this.atButton = (ImageView) findViewById11;
        View findViewById12 = guildFeedInputBarCompatExpand.findViewById(R.id.wfn);
        TextView textView = (TextView) findViewById12;
        textView.setVisibility(8);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "inputLayout.findViewById\u2026_length).apply { gone() }");
        this.lengthLimitTipsView = textView;
        View findViewById13 = guildFeedInputBarCompatExpand.findViewById(R.id.aiz);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "inputLayout.findViewById(R.id.btn_post)");
        this.sendBtn = findViewById13;
        View findViewById14 = getInputPanelContainer().findViewById(R.id.f165082ut4);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "inputPanelContainer.find\u2026(R.id.emoji_shortcut_bar)");
        this.emoShortcut = (GuildFeedCommentEmojiShortcutBar) findViewById14;
        View findViewById15 = getInputPanelContainer().findViewById(R.id.tfw);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "inputPanelContainer.findViewById(R.id.btn_pic)");
        this.picButton = (ImageView) findViewById15;
        View findViewById16 = getInputPanelContainer().findViewById(R.id.u2d);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "inputPanelContainer.find\u2026id.comment_top_container)");
        this.picContainer = (FrameLayout) findViewById16;
        View findViewById17 = getInputPanelContainer().findViewById(R.id.u2f);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "inputPanelContainer.find\u2026omment_top_container_pic)");
        this.picIv = (RoundRectImageView) findViewById17;
        View findViewById18 = getInputPanelContainer().findViewById(R.id.u2e);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "inputPanelContainer.find\u2026ent_top_container_delete)");
        this.picDelete = (ImageView) findViewById18;
    }

    @Override // xk1.f
    @NotNull
    /* renamed from: b, reason: from getter */
    public ViewGroup getInputPanelContainer() {
        return this.inputPanelContainer;
    }

    @Override // xk1.f
    @NotNull
    /* renamed from: c, reason: from getter */
    public View getBlankView() {
        return this.blankView;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final View getSendBtn() {
        return this.sendBtn;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final ImageView getAtButton() {
        return this.atButton;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final View getCtrlLayout() {
        return this.ctrlLayout;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final GuildFeedCommentEmojiShortcutBar getEmoShortcut() {
        return this.emoShortcut;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NotNull
    public View getRoot() {
        View rootView = this.rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        return rootView;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final ImageView getEmotionButton() {
        return this.emotionButton;
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public final View getEmotionPanelView() {
        return this.emotionPanelView;
    }

    @Override // xk1.f
    @NotNull
    /* renamed from: j, reason: from getter and merged with bridge method [inline-methods] */
    public CommentEditText a() {
        return this.input;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final View getInputContainer() {
        return this.inputContainer;
    }

    public final int l() {
        return this.inputContainer.getHeight();
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final GuildFeedInputBarCompatExpand getInputLayout() {
        return this.inputLayout;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final ImageView getInputShadow() {
        return this.inputShadow;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final ImageView getKeyboardButton() {
        return this.keyboardButton;
    }

    @NotNull
    /* renamed from: p, reason: from getter */
    public final TextView getLengthLimitTipsView() {
        return this.lengthLimitTipsView;
    }

    @NotNull
    /* renamed from: q, reason: from getter */
    public final FrameLayout getPanelLayout() {
        return this.panelLayout;
    }

    @NotNull
    /* renamed from: r, reason: from getter */
    public final ImageView getPicButton() {
        return this.picButton;
    }

    @NotNull
    /* renamed from: s, reason: from getter */
    public final FrameLayout getPicContainer() {
        return this.picContainer;
    }

    @NotNull
    /* renamed from: t, reason: from getter */
    public final ImageView getPicDelete() {
        return this.picDelete;
    }

    @NotNull
    /* renamed from: u, reason: from getter */
    public final RoundRectImageView getPicIv() {
        return this.picIv;
    }

    public final void v(@Nullable View view) {
        this.emotionPanelView = view;
    }
}
