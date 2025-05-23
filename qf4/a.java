package qf4;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\f\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0017\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Lqf4/a;", "", "", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "yesId", "", "b", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "g", "(Ljava/lang/Integer;)V", VirtualAppProxy.KEY_GAME_ID, "c", "f", "currentYesUid", "d", "i", "subId", h.F, WadlProxyConsts.SCENE_ID, "<init>", "()V", "timi-game-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String yesId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String currentYesUid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer gameId = 0;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer subId = 0;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer sceneId = 0;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getCurrentYesUid() {
        return this.currentYesUid;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Integer getGameId() {
        return this.gameId;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Integer getSceneId() {
        return this.sceneId;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final Integer getSubId() {
        return this.subId;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getYesId() {
        return this.yesId;
    }

    public final void f(@Nullable String str) {
        this.currentYesUid = str;
    }

    public final void g(@Nullable Integer num) {
        this.gameId = num;
    }

    public final void h(@Nullable Integer num) {
        this.sceneId = num;
    }

    public final void i(@Nullable Integer num) {
        this.subId = num;
    }

    public final void j(@Nullable String str) {
        this.yesId = str;
    }
}
