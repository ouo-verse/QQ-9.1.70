package u73;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lu73/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lu73/b;", "backgrounds", "Ljava/util/List;", "a", "()Ljava/util/List;", "Lu73/i;", com.tencent.luggage.wxa.c8.c.B, "b", "Lu73/j;", "texts", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: u73.f, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class MemeData {

    @SerializedName("backgrounds")
    @Nullable
    private final List<Background> backgrounds;

    @SerializedName(com.tencent.luggage.wxa.c8.c.B)
    @Nullable
    private final List<Sticker> stickers;

    @SerializedName("texts")
    @Nullable
    private final List<Text> texts;

    @Nullable
    public final List<Background> a() {
        return this.backgrounds;
    }

    @Nullable
    public final List<Sticker> b() {
        return this.stickers;
    }

    @Nullable
    public final List<Text> c() {
        return this.texts;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemeData)) {
            return false;
        }
        MemeData memeData = (MemeData) other;
        if (Intrinsics.areEqual(this.backgrounds, memeData.backgrounds) && Intrinsics.areEqual(this.stickers, memeData.stickers) && Intrinsics.areEqual(this.texts, memeData.texts)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        List<Background> list = this.backgrounds;
        int i3 = 0;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        int i16 = hashCode * 31;
        List<Sticker> list2 = this.stickers;
        if (list2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = list2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        List<Text> list3 = this.texts;
        if (list3 != null) {
            i3 = list3.hashCode();
        }
        return i17 + i3;
    }

    @NotNull
    public String toString() {
        return "MemeData(backgrounds=" + this.backgrounds + ", stickers=" + this.stickers + ", texts=" + this.texts + ")";
    }
}
