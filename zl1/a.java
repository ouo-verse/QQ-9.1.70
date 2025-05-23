package zl1;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.data.GuildContact;
import com.tencent.mobileqq.guild.data.q;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.nativepublish.FeedEditorConfiguration;
import com.tencent.mobileqq.guild.feed.nativepublish.root.f;
import com.tencent.mobileqq.guild.feed.nativepublish.root.g;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\bl\u0010mJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R%\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00020\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010 R\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\"\u0010 R*\u0010-\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b%\u0010&\u0012\u0004\b+\u0010,\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0017\u00102\u001a\u00020.8\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b\u000f\u00101R\"\u0010:\u001a\u0002038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010=\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0005\u001a\u0004\b;\u0010\u0007\"\u0004\b<\u0010 R$\u0010C\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010?\u001a\u0004\b%\u0010@\"\u0004\bA\u0010BR\u0017\u0010G\u001a\u00020D8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010E\u001a\u0004\b\u001d\u0010FR(\u0010L\u001a\u0002038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\bH\u00105\u0012\u0004\bK\u0010,\u001a\u0004\bI\u00107\"\u0004\bJ\u00109R\"\u0010P\u001a\u0002038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u00105\u001a\u0004\bN\u00107\"\u0004\bO\u00109R\"\u0010T\u001a\u0002038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u00105\u001a\u0004\bR\u00107\"\u0004\bS\u00109R\"\u0010W\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010\u0010\u001a\u0004\bM\u0010\u0012\"\u0004\bV\u0010\u0014R\"\u0010Z\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010\u0010\u001a\u0004\bU\u0010\u0012\"\u0004\bY\u0010\u0014R\u0017\u0010^\u001a\u00020[8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\\\u001a\u0004\bQ\u0010]R\"\u0010d\u001a\u00020_8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010`\u001a\u0004\b4\u0010a\"\u0004\bb\u0010cR$\u0010f\u001a\u00020\u00022\u0006\u0010e\u001a\u00020\u00028F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bH\u0010\u0007\"\u0004\b\u0010\u0010 R\u0011\u0010g\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b/\u0010\u0007R\u0011\u0010h\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010k\u001a\u00020i8F\u00a2\u0006\u0006\u001a\u0004\bX\u0010j\u00a8\u0006n"}, d2 = {"Lzl1/a;", "", "", "l", "a", "Ljava/lang/String;", ReportConstant.COSTREPORT_PREFIX, "()Ljava/lang/String;", "selfTinyId", "Lcom/tencent/mobileqq/guild/feed/nativepublish/FeedEditorConfiguration;", "b", "Lcom/tencent/mobileqq/guild/feed/nativepublish/FeedEditorConfiguration;", "()Lcom/tencent/mobileqq/guild/feed/nativepublish/FeedEditorConfiguration;", "configuration", "", "c", "I", "r", "()I", "L", "(I)V", "sceneType", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "d", "Landroidx/lifecycle/MutableLiveData;", "t", "()Landroidx/lifecycle/MutableLiveData;", "_mainTaskId", "e", "f", BdhLogUtil.LogTag.Tag_Conn, "(Ljava/lang/String;)V", "feedId", "y", "draftKey", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "g", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "j", "()Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", UserInfo.SEX_FEMALE, "(Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;)V", "getInitBean$annotations", "()V", "initBean", "Lcom/tencent/mobileqq/guild/data/q;", h.F, "Lcom/tencent/mobileqq/guild/data/q;", "()Lcom/tencent/mobileqq/guild/data/q;", "contact", "", "i", "Z", HippyTKDListViewAdapter.X, "()Z", "H", "(Z)V", "isJsonFeedPresetFormat", "k", "G", "jsonFeed", "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "D", "(Lorg/json/JSONObject;)V", "feedJsonObject", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "extra", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "u", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "isEditDraft$annotations", "isEditDraft", DomainData.DOMAIN_NAME, "w", "B", "isFeedBeingEditedPublished", "o", "v", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "isEdition", "p", "J", "mediaLockSize", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "K", "onPublishRedirectActionId", "Lcom/tencent/mobileqq/guild/feed/nativepublish/root/g;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/root/g;", "()Lcom/tencent/mobileqq/guild/feed/nativepublish/root/g;", "mutableGlobalSharedState", "", "Ljava/lang/CharSequence;", "()Ljava/lang/CharSequence;", "E", "(Ljava/lang/CharSequence;)V", "hintText", "value", "mainTaskId", "guildId", "channelId", "Lcom/tencent/mobileqq/guild/feed/nativepublish/root/f;", "()Lcom/tencent/mobileqq/guild/feed/nativepublish/root/f;", "readOnlyGlobalSharedState", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/guild/feed/nativepublish/FeedEditorConfiguration;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String selfTinyId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FeedEditorConfiguration configuration;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int sceneType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> _mainTaskId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String feedId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String draftKey;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildFeedBaseInitBean initBean;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final q contact;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isJsonFeedPresetFormat;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String jsonFeed;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private JSONObject feedJsonObject;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bundle extra;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isEditDraft;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean isFeedBeingEditedPublished;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean isEdition;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int mediaLockSize;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private int onPublishRedirectActionId;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g mutableGlobalSharedState;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CharSequence hintText;

    public a(@NotNull String selfTinyId, @NotNull FeedEditorConfiguration configuration) {
        Intrinsics.checkNotNullParameter(selfTinyId, "selfTinyId");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.selfTinyId = selfTinyId;
        this.configuration = configuration;
        this._mainTaskId = new MutableLiveData<>("");
        this.feedId = "";
        this.draftKey = "";
        this.contact = new GuildContact("", "", "", "", null, 16, null);
        this.jsonFeed = "";
        this.extra = new Bundle();
        this.mutableGlobalSharedState = new g();
        this.hintText = "";
    }

    public final void A(boolean z16) {
        this.isEdition = z16;
    }

    public final void B(boolean z16) {
        this.isFeedBeingEditedPublished = z16;
    }

    public final void C(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.feedId = str;
    }

    public final void D(@Nullable JSONObject jSONObject) {
        this.feedJsonObject = jSONObject;
    }

    public final void E(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
        this.hintText = charSequence;
    }

    public final void F(@Nullable GuildFeedBaseInitBean guildFeedBaseInitBean) {
        this.initBean = guildFeedBaseInitBean;
    }

    public final void G(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jsonFeed = str;
    }

    public final void H(boolean z16) {
        this.isJsonFeedPresetFormat = z16;
    }

    public final void I(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this._mainTaskId.setValue(value);
    }

    public final void J(int i3) {
        this.mediaLockSize = i3;
    }

    public final void K(int i3) {
        this.onPublishRedirectActionId = i3;
    }

    public final void L(int i3) {
        this.sceneType = i3;
    }

    @NotNull
    public final String a() {
        return this.contact.getChannelId();
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final FeedEditorConfiguration getConfiguration() {
        return this.configuration;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final q getContact() {
        return this.contact;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getDraftKey() {
        return this.draftKey;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final Bundle getExtra() {
        return this.extra;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final JSONObject getFeedJsonObject() {
        return this.feedJsonObject;
    }

    @NotNull
    public final String h() {
        return this.contact.getGuildId();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final CharSequence getHintText() {
        return this.hintText;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final GuildFeedBaseInitBean getInitBean() {
        return this.initBean;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getJsonFeed() {
        return this.jsonFeed;
    }

    @NotNull
    public final String l() {
        return "FeedPublishParam{taskId=" + m() + "}";
    }

    @NotNull
    public final String m() {
        String value = this._mainTaskId.getValue();
        if (value == null) {
            return "";
        }
        return value;
    }

    /* renamed from: n, reason: from getter */
    public final int getMediaLockSize() {
        return this.mediaLockSize;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final g getMutableGlobalSharedState() {
        return this.mutableGlobalSharedState;
    }

    /* renamed from: p, reason: from getter */
    public final int getOnPublishRedirectActionId() {
        return this.onPublishRedirectActionId;
    }

    @NotNull
    public final f q() {
        return this.mutableGlobalSharedState;
    }

    /* renamed from: r, reason: from getter */
    public final int getSceneType() {
        return this.sceneType;
    }

    @NotNull
    /* renamed from: s, reason: from getter */
    public final String getSelfTinyId() {
        return this.selfTinyId;
    }

    @NotNull
    public final MutableLiveData<String> t() {
        return this._mainTaskId;
    }

    /* renamed from: u, reason: from getter */
    public final boolean getIsEditDraft() {
        return this.isEditDraft;
    }

    /* renamed from: v, reason: from getter */
    public final boolean getIsEdition() {
        return this.isEdition;
    }

    /* renamed from: w, reason: from getter */
    public final boolean getIsFeedBeingEditedPublished() {
        return this.isFeedBeingEditedPublished;
    }

    /* renamed from: x, reason: from getter */
    public final boolean getIsJsonFeedPresetFormat() {
        return this.isJsonFeedPresetFormat;
    }

    public final void y(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.draftKey = str;
    }

    public final void z(boolean z16) {
        this.isEditDraft = z16;
    }
}
