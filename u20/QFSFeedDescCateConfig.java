package u20;

import com.heytap.databaseengine.model.UserInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\nB!\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lu20/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "getFeedGuideThreshold", "()F", "feedGuideThreshold", "", "b", "Ljava/util/List;", "getSubCateList", "()Ljava/util/List;", "subCateList", "<init>", "(FLjava/util/List;)V", "c", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: u20.e, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class QFSFeedDescCateConfig {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final float feedGuideThreshold;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<String> subCateList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\t\u001a\u00020\b*\u00020\u0007\u00a8\u0006\f"}, d2 = {"Lu20/e$a;", "", "Lorg/json/JSONArray;", "jsonArray", "", "", "a", "Lorg/json/JSONObject;", "Lu20/e;", "b", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: u20.e$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final List<String> a(JSONArray jsonArray) {
            ArrayList arrayList = new ArrayList();
            if (jsonArray != null) {
                int length = jsonArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    String optString = jsonArray.optString(i3);
                    Intrinsics.checkNotNullExpressionValue(optString, "jsonArray.optString(i)");
                    arrayList.add(optString);
                }
            }
            return arrayList;
        }

        @NotNull
        public final QFSFeedDescCateConfig b(@NotNull JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "<this>");
            if (jSONObject.length() == 0) {
                return new QFSFeedDescCateConfig(0.0f, null, 3, 0 == true ? 1 : 0);
            }
            return new QFSFeedDescCateConfig((float) jSONObject.optDouble("feed_guide_threshold"), a(jSONObject.optJSONArray("sub_categories")));
        }

        Companion() {
        }
    }

    public QFSFeedDescCateConfig() {
        this(0.0f, null, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QFSFeedDescCateConfig)) {
            return false;
        }
        QFSFeedDescCateConfig qFSFeedDescCateConfig = (QFSFeedDescCateConfig) other;
        if (Float.compare(this.feedGuideThreshold, qFSFeedDescCateConfig.feedGuideThreshold) == 0 && Intrinsics.areEqual(this.subCateList, qFSFeedDescCateConfig.subCateList)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.feedGuideThreshold) * 31) + this.subCateList.hashCode();
    }

    @NotNull
    public String toString() {
        return "QFSFeedDescCateConfig(feedGuideThreshold=" + this.feedGuideThreshold + ", subCateList=" + this.subCateList + ")";
    }

    public QFSFeedDescCateConfig(float f16, @NotNull List<String> subCateList) {
        Intrinsics.checkNotNullParameter(subCateList, "subCateList");
        this.feedGuideThreshold = f16;
        this.subCateList = subCateList;
    }

    public /* synthetic */ QFSFeedDescCateConfig(float f16, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 68.0f : f16, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
