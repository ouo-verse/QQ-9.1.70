package sd4;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B;\u0012\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0006\u0012\u0004\u0018\u00010+0*\u0012\b\u00106\u001a\u0004\u0018\u00010+\u0012\u0006\u00108\u001a\u00020+\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b>\u0010?R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\"\u0010&\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\f\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000fR\"\u0010)\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\f\u001a\u0004\b'\u0010\r\"\u0004\b(\u0010\u000fR0\u00100\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0006\u0012\u0004\u0018\u00010+0*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010,\u001a\u0004\b \u0010-\"\u0004\b.\u0010/R$\u00106\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b\u000b\u00103\"\u0004\b4\u00105R\"\u00108\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u00102\u001a\u0004\b1\u00103\"\u0004\b7\u00105R$\u0010=\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u00109\u001a\u0004\b\u0019\u0010:\"\u0004\b;\u0010<\u00a8\u0006@"}, d2 = {"Lsd4/b;", "", "", "a", "I", "g", "()I", "setSkipFrames", "(I)V", "skipFrames", "", "b", "Z", "()Z", "setAddEmptyTrackEnable", "(Z)V", "addEmptyTrackEnable", "Lorg/light/lightAssetKit/Entity;", "c", "Lorg/light/lightAssetKit/Entity;", "()Lorg/light/lightAssetKit/Entity;", "l", "(Lorg/light/lightAssetKit/Entity;)V", "entity", "", "d", "J", "j", "()J", "o", "(J)V", "stickerStartTime", "e", h.F, DomainData.DOMAIN_NAME, "stickerEndTime", "f", "setPlayerSkipFrame", "playerSkipFrame", "k", "setUpdateStickerInLoading", "updateStickerInLoading", "", "", "Ljava/util/Map;", "()Ljava/util/Map;", "setModePath", "(Ljava/util/Map;)V", "modePath", "i", "Ljava/lang/String;", "()Ljava/lang/String;", "setCachePath", "(Ljava/lang/String;)V", QAdRewardDefine$VideoParams.CACHE_PATH, "setStickerName", "stickerName", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/Integer;)V", TemplateParser.KEY_ENTITY_ID, "<init>", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int skipFrames;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean addEmptyTrackEnable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Entity entity;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long stickerStartTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long stickerEndTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean playerSkipFrame;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean updateStickerInLoading;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, String> modePath;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String cachePath;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String stickerName;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer entityId;

    public b(@NotNull Map<String, String> modePath, @Nullable String str, @NotNull String stickerName, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(modePath, "modePath");
        Intrinsics.checkParameterIsNotNull(stickerName, "stickerName");
        this.modePath = modePath;
        this.cachePath = str;
        this.stickerName = stickerName;
        this.entityId = num;
        this.skipFrames = 3;
        this.addEmptyTrackEnable = true;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getAddEmptyTrackEnable() {
        return this.addEmptyTrackEnable;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getCachePath() {
        return this.cachePath;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Entity getEntity() {
        return this.entity;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final Integer getEntityId() {
        return this.entityId;
    }

    @NotNull
    public final Map<String, String> e() {
        return this.modePath;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getPlayerSkipFrame() {
        return this.playerSkipFrame;
    }

    /* renamed from: g, reason: from getter */
    public final int getSkipFrames() {
        return this.skipFrames;
    }

    /* renamed from: h, reason: from getter */
    public final long getStickerEndTime() {
        return this.stickerEndTime;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getStickerName() {
        return this.stickerName;
    }

    /* renamed from: j, reason: from getter */
    public final long getStickerStartTime() {
        return this.stickerStartTime;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getUpdateStickerInLoading() {
        return this.updateStickerInLoading;
    }

    public final void l(@Nullable Entity entity) {
        this.entity = entity;
    }

    public final void m(@Nullable Integer num) {
        this.entityId = num;
    }

    public final void n(long j3) {
        this.stickerEndTime = j3;
    }

    public final void o(long j3) {
        this.stickerStartTime = j3;
    }

    public /* synthetic */ b(Map map, String str, String str2, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, str, str2, (i3 & 8) != 0 ? null : num);
    }
}
