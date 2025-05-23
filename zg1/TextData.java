package zg1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0001H\u0016J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u00d6\u0003R\u0017\u0010\u0014\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lzg1/d;", "Lzg1/a;", "", "getItemType", "", "getItemId", "newItem", "", "a", "b", "", "c", "", "toString", "hashCode", "other", "equals", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "tips", "I", "getType", "()I", "type", "<init>", "(Ljava/lang/String;I)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: zg1.d, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class TextData implements a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tips;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    public TextData(@NotNull String tips, int i3) {
        Intrinsics.checkNotNullParameter(tips, "tips");
        this.tips = tips;
        this.type = i3;
    }

    @Override // zg1.a
    public boolean a(@NotNull a newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if ((newItem instanceof TextData) && this.type == ((TextData) newItem).type) {
            return true;
        }
        return false;
    }

    @Override // zg1.a
    public boolean b(@NotNull a newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Intrinsics.areEqual(this, newItem);
    }

    @Override // zg1.a
    @Nullable
    public Object c(@NotNull a newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return null;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTips() {
        return this.tips;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextData)) {
            return false;
        }
        TextData textData = (TextData) other;
        if (Intrinsics.areEqual(this.tips, textData.tips) && this.type == textData.type) {
            return true;
        }
        return false;
    }

    @Override // zg1.a
    public long getItemId() {
        return this.type;
    }

    @Override // zg1.a
    /* renamed from: getItemType, reason: from getter */
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.tips.hashCode() * 31) + this.type;
    }

    @NotNull
    public String toString() {
        return "TextData(tips=" + this.tips + ", type=" + this.type + ')';
    }
}
