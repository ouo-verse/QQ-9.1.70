package w74;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qu4.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R2\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0013\u001a\u0004\b\f\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lw74/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/ArrayList;", "Lqu4/p;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "b", "()Ljava/util/ArrayList;", "setColors", "(Ljava/util/ArrayList;)V", NodeProps.COLORS, "I", "()I", "setColorPosition", "(I)V", "colorPosition", "<init>", "(Ljava/util/ArrayList;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: w74.b, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class UgcColorInfoData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private ArrayList<p> colors;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int colorPosition;

    public UgcColorInfoData(ArrayList<p> colors, int i3) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.colors = colors;
        this.colorPosition = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getColorPosition() {
        return this.colorPosition;
    }

    public final ArrayList<p> b() {
        return this.colors;
    }

    public int hashCode() {
        return (this.colors.hashCode() * 31) + this.colorPosition;
    }

    public String toString() {
        return "UgcColorInfoData(colors=" + this.colors + ", colorPosition=" + this.colorPosition + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UgcColorInfoData)) {
            return false;
        }
        UgcColorInfoData ugcColorInfoData = (UgcColorInfoData) other;
        return Intrinsics.areEqual(this.colors, ugcColorInfoData.colors) && this.colorPosition == ugcColorInfoData.colorPosition;
    }
}
