package st0;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lst0/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/google/gson/JsonArray;", "tagsArray", "Lcom/google/gson/JsonArray;", "a", "()Lcom/google/gson/JsonArray;", "<init>", "(Lcom/google/gson/JsonArray;)V", "ic-game-common-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: st0.g, reason: from toString */
/* loaded from: classes7.dex */
public final /* data */ class ICGameAegisLogBean {

    @SerializedName(ComicCancelRedPointPopItemData.JSON_KEY_TAGS)
    @Nullable
    private final JsonArray tagsArray;

    public ICGameAegisLogBean() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final JsonArray getTagsArray() {
        return this.tagsArray;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof ICGameAegisLogBean) && Intrinsics.areEqual(this.tagsArray, ((ICGameAegisLogBean) other).tagsArray)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        JsonArray jsonArray = this.tagsArray;
        if (jsonArray == null) {
            return 0;
        }
        return jsonArray.hashCode();
    }

    @NotNull
    public String toString() {
        return "ICGameAegisLogBean(tagsArray=" + this.tagsArray + ")";
    }

    public ICGameAegisLogBean(@Nullable JsonArray jsonArray) {
        this.tagsArray = jsonArray;
    }

    public /* synthetic */ ICGameAegisLogBean(JsonArray jsonArray, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : jsonArray);
    }
}
