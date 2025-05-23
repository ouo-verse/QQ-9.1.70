package qo3;

import com.tencent.now.pkgame.pkgame.sei.Pos;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u001f\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR\u0017\u0010\u001d\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\n\u0010\u001b\u00a8\u0006 "}, d2 = {"Lqo3/a;", "", "", "e", "", "toString", "", "hashCode", "other", "equals", "a", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "type", "b", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "mute", "", "Lcom/tencent/now/pkgame/pkgame/sei/Pos;", "c", "Ljava/util/List;", "()Ljava/util/List;", "posList", "d", "I", "()I", "w", h.F, "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;II)V", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qo3.a, reason: from toString */
/* loaded from: classes22.dex */
public final /* data */ class SeiConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Integer mute;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final List<Pos> posList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int w;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int h;

    public SeiConfig(@Nullable String str, @Nullable Integer num, @Nullable List<Pos> list, int i3, int i16) {
        this.type = str;
        this.mute = num;
        this.posList = list;
        this.w = i3;
        this.h = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getH() {
        return this.h;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Integer getMute() {
        return this.mute;
    }

    @Nullable
    public final List<Pos> c() {
        return this.posList;
    }

    /* renamed from: d, reason: from getter */
    public final int getW() {
        return this.w;
    }

    public final boolean e() {
        return Intrinsics.areEqual("linkmic", this.type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SeiConfig)) {
            return false;
        }
        SeiConfig seiConfig = (SeiConfig) other;
        if (Intrinsics.areEqual(this.type, seiConfig.type) && Intrinsics.areEqual(this.mute, seiConfig.mute) && Intrinsics.areEqual(this.posList, seiConfig.posList) && this.w == seiConfig.w && this.h == seiConfig.h) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        String str = this.type;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        Integer num = this.mute;
        if (num == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        List<Pos> list = this.posList;
        if (list != null) {
            i3 = list.hashCode();
        }
        return ((((i17 + i3) * 31) + this.w) * 31) + this.h;
    }

    @NotNull
    public String toString() {
        return "SeiConfig(type=" + this.type + ", mute=" + this.mute + ", posList=" + this.posList + ", w=" + this.w + ", h=" + this.h + ")";
    }
}
