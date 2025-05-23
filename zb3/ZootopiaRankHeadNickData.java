package zb3;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lzb3/l;", "", "", "d", "", "toString", "", "hashCode", "other", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "nick", "headUrl", "c", "openId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: zb3.l, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ZootopiaRankHeadNickData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String nick;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String headUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String openId;

    public ZootopiaRankHeadNickData(String nick, String headUrl, String openId) {
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(headUrl, "headUrl");
        Intrinsics.checkNotNullParameter(openId, "openId");
        this.nick = nick;
        this.headUrl = headUrl;
        this.openId = openId;
    }

    /* renamed from: a, reason: from getter */
    public final String getHeadUrl() {
        return this.headUrl;
    }

    /* renamed from: b, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    /* renamed from: c, reason: from getter */
    public final String getOpenId() {
        return this.openId;
    }

    public final boolean d() {
        return TextUtils.isEmpty(this.headUrl) || TextUtils.isEmpty(this.nick);
    }

    public int hashCode() {
        return (((this.nick.hashCode() * 31) + this.headUrl.hashCode()) * 31) + this.openId.hashCode();
    }

    public String toString() {
        return "ZootopiaRankHeadNickData(nick=" + this.nick + ", headUrl=" + this.headUrl + ", openId=" + this.openId + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaRankHeadNickData)) {
            return false;
        }
        ZootopiaRankHeadNickData zootopiaRankHeadNickData = (ZootopiaRankHeadNickData) other;
        return Intrinsics.areEqual(this.nick, zootopiaRankHeadNickData.nick) && Intrinsics.areEqual(this.headUrl, zootopiaRankHeadNickData.headUrl) && Intrinsics.areEqual(this.openId, zootopiaRankHeadNickData.openId);
    }
}
