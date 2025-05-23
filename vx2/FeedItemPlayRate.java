package vx2;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0015\u001a\u0004\b\r\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lvx2/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "cid", "b", "d", "vid", "c", "I", "()I", com.tencent.luggage.wxa.c8.c.G, "", UserInfo.SEX_FEMALE, "()F", "playRate", "<init>", "(Ljava/lang/String;Ljava/lang/String;IF)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: vx2.b, reason: from toString */
/* loaded from: classes19.dex */
public final /* data */ class FeedItemPlayRate {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String cid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String vid;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int pos;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final float playRate;

    public FeedItemPlayRate(@Nullable String str, @Nullable String str2, int i3, float f16) {
        this.cid = str;
        this.vid = str2;
        this.pos = i3;
        this.playRate = f16;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getCid() {
        return this.cid;
    }

    /* renamed from: b, reason: from getter */
    public final float getPlayRate() {
        return this.playRate;
    }

    /* renamed from: c, reason: from getter */
    public final int getPos() {
        return this.pos;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String getVid() {
        return this.vid;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedItemPlayRate)) {
            return false;
        }
        FeedItemPlayRate feedItemPlayRate = (FeedItemPlayRate) other;
        if (Intrinsics.areEqual(this.cid, feedItemPlayRate.cid) && Intrinsics.areEqual(this.vid, feedItemPlayRate.vid) && this.pos == feedItemPlayRate.pos && Float.compare(this.playRate, feedItemPlayRate.playRate) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        String str = this.cid;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.vid;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return ((((i16 + i3) * 31) + this.pos) * 31) + Float.floatToIntBits(this.playRate);
    }

    @NotNull
    public String toString() {
        return "FeedItemPlayRate(cid=" + this.cid + ", vid=" + this.vid + ", pos=" + this.pos + ", playRate=" + this.playRate + ")";
    }
}
