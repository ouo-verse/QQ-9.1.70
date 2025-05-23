package u20;

import android.graphics.Point;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\tB5\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0010\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lu20/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "minSize", "maxSize", "", "c", "D", "d", "()D", "weight", "", "Landroid/graphics/Point;", "Ljava/util/List;", "()Ljava/util/List;", "points", "<init>", "(IIDLjava/util/List;)V", "e", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: u20.g, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class QFSKMeansConfig {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int minSize;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int maxSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final double weight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<Point> points;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\t\u001a\u00020\b*\u00020\u0007\u00a8\u0006\f"}, d2 = {"Lu20/g$a;", "", "Lorg/json/JSONArray;", "jsonArray", "", "Landroid/graphics/Point;", "a", "Lorg/json/JSONObject;", "Lu20/g;", "b", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: u20.g$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final List<Point> a(JSONArray jsonArray) {
            ArrayList arrayListOf;
            IntRange until;
            IntProgression step;
            if (jsonArray == null) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new Point(5, 2), new Point(8, 3), new Point(11, 4));
                return arrayListOf;
            }
            ArrayList arrayList = new ArrayList();
            until = RangesKt___RangesKt.until(0, jsonArray.length());
            step = RangesKt___RangesKt.step(until, 2);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
                while (true) {
                    arrayList.add(new Point(jsonArray.optInt(first), jsonArray.optInt(first + 1)));
                    if (first == last) {
                        break;
                    }
                    first += step2;
                }
            }
            return arrayList;
        }

        @NotNull
        public final QFSKMeansConfig b(@NotNull JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "<this>");
            if (jSONObject.length() == 0) {
                return new QFSKMeansConfig(0, 0, 0.0d, null, 15, null);
            }
            return new QFSKMeansConfig(jSONObject.optInt("min_pic_size"), jSONObject.optInt("max_pic_size"), jSONObject.optDouble("weight"), a(jSONObject.optJSONArray("point")));
        }

        Companion() {
        }
    }

    public QFSKMeansConfig() {
        this(0, 0, 0.0d, null, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getMaxSize() {
        return this.maxSize;
    }

    /* renamed from: b, reason: from getter */
    public final int getMinSize() {
        return this.minSize;
    }

    @NotNull
    public final List<Point> c() {
        return this.points;
    }

    /* renamed from: d, reason: from getter */
    public final double getWeight() {
        return this.weight;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QFSKMeansConfig)) {
            return false;
        }
        QFSKMeansConfig qFSKMeansConfig = (QFSKMeansConfig) other;
        if (this.minSize == qFSKMeansConfig.minSize && this.maxSize == qFSKMeansConfig.maxSize && Double.compare(this.weight, qFSKMeansConfig.weight) == 0 && Intrinsics.areEqual(this.points, qFSKMeansConfig.points)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.minSize * 31) + this.maxSize) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.weight)) * 31) + this.points.hashCode();
    }

    @NotNull
    public String toString() {
        return "QFSKMeansConfig(minSize=" + this.minSize + ", maxSize=" + this.maxSize + ", weight=" + this.weight + ", points=" + this.points + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public QFSKMeansConfig(int i3, int i16, double d16, @NotNull List<? extends Point> points) {
        Intrinsics.checkNotNullParameter(points, "points");
        this.minSize = i3;
        this.maxSize = i16;
        this.weight = d16;
        this.points = points;
    }

    public /* synthetic */ QFSKMeansConfig(int i3, int i16, double d16, List list, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 3 : i3, (i17 & 2) != 0 ? 10 : i16, (i17 & 4) != 0 ? 0.935d : d16, (i17 & 8) != 0 ? CollectionsKt__CollectionsKt.arrayListOf(new Point(5, 2), new Point(8, 3), new Point(11, 4)) : list);
    }
}
