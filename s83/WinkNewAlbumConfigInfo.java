package s83;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.perf.process.config.g;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\b\u0016\b\u0086\b\u0018\u0000 =2\u00020\u0001:\u0001\tB\u0097\u0001\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0014\u0012\b\b\u0002\u0010\"\u001a\u00020\u0004\u0012\b\b\u0002\u0010$\u001a\u00020\u0004\u0012\b\b\u0002\u0010'\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00020(\u0012\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u00020\u00020(\u0012\b\b\u0002\u00104\u001a\u00020\u0002\u0012\u000e\b\u0002\u00106\u001a\b\u0012\u0004\u0012\u00020\u00020(\u0012\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020\u00020(\u0012\b\b\u0002\u0010:\u001a\u00020\u0014\u00a2\u0006\u0004\b;\u0010<J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001d\u001a\u0004\b\u0015\u0010\u001f\"\u0004\b#\u0010!R\"\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u001d\u001a\u0004\b\u0010\u0010\u001f\"\u0004\b&\u0010!R(\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R(\u00101\u001a\b\u0012\u0004\u0012\u00020\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010)\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R\"\u00104\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\n\u001a\u0004\b2\u0010\f\"\u0004\b3\u0010\u000eR(\u00106\u001a\b\u0012\u0004\u0012\u00020\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010)\u001a\u0004\b%\u0010+\"\u0004\b5\u0010-R(\u00108\u001a\b\u0012\u0004\u0012\u00020\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010)\u001a\u0004\b\u001c\u0010+\"\u0004\b7\u0010-R\"\u0010:\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0016\u001a\u0004\b\t\u0010\u0018\"\u0004\b9\u0010\u001a\u00a8\u0006>"}, d2 = {"Ls83/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "setStoryID", "(Ljava/lang/String;)V", "storyID", "b", h.F, "setStoryName", "storyName", "", "c", UserInfo.SEX_FEMALE, "l", "()F", "setThreshold", "(F)V", "threshold", "d", "I", "e", "()I", "setPriorityIndex", "(I)V", "priorityIndex", "setMinShowCount", "minShowCount", "f", "setMaxShowCount", "maxShowCount", "", "Ljava/util/List;", "k", "()Ljava/util/List;", "setTemplateIDList", "(Ljava/util/List;)V", "templateIDList", "j", "setTagNameList", "tagNameList", "i", "setStorySQL", "storySQL", "setRandomStoryNameList", "randomStoryNameList", "setPathFilter", "pathFilter", "setAestheticThreshold", "aestheticThreshold", "<init>", "(Ljava/lang/String;Ljava/lang/String;FIIILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;F)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: s83.a, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class WinkNewAlbumConfigInfo {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String storyID;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String storyName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private float threshold;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int priorityIndex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int minShowCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private int maxShowCount;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private List<String> templateIDList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private List<String> tagNameList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String storySQL;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private List<String> randomStoryNameList;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private List<String> pathFilter;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private float aestheticThreshold;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0003J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007\u00a8\u0006\u000b"}, d2 = {"Ls83/a$a;", "", "Lorg/json/JSONObject;", "Ls83/a;", "b", "", "jsonString", "", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: s83.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        private final WinkNewAlbumConfigInfo b(JSONObject jSONObject) {
            String optString = jSONObject.optString("story_id", "");
            Intrinsics.checkNotNullExpressionValue(optString, "optString(\"story_id\", \"\")");
            String optString2 = jSONObject.optString("story_name", "");
            Intrinsics.checkNotNullExpressionValue(optString2, "optString(\"story_name\", \"\")");
            float optDouble = (float) jSONObject.optDouble("threshold", 0.0d);
            int optInt = jSONObject.optInt("priority_index", 0);
            int optInt2 = jSONObject.optInt("min_show_count", 0);
            int optInt3 = jSONObject.optInt("max_show_count", 0);
            ArrayList<String> a16 = g.a(jSONObject, "template_id");
            ArrayList<String> a17 = g.a(jSONObject, "tag_name");
            String optString3 = jSONObject.optString("story_sql", "");
            Intrinsics.checkNotNullExpressionValue(optString3, "optString(\"story_sql\", \"\")");
            return new WinkNewAlbumConfigInfo(optString, optString2, optDouble, optInt, optInt2, optInt3, a16, a17, optString3, g.a(jSONObject, "story_name_list"), g.a(jSONObject, "story_path_filter"), (float) jSONObject.optDouble("aesthetic_threshold", -10.0d));
        }

        @JvmStatic
        @NotNull
        public final List<WinkNewAlbumConfigInfo> a(@NotNull String jsonString) {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = new JSONArray(jsonString);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jsonObject = jSONArray.getJSONObject(i3);
                Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                arrayList.add(b(jsonObject));
            }
            return arrayList;
        }

        Companion() {
        }
    }

    public WinkNewAlbumConfigInfo() {
        this(null, null, 0.0f, 0, 0, 0, null, null, null, null, null, 0.0f, 4095, null);
    }

    @JvmStatic
    @NotNull
    public static final List<WinkNewAlbumConfigInfo> m(@NotNull String str) {
        return INSTANCE.a(str);
    }

    /* renamed from: a, reason: from getter */
    public final float getAestheticThreshold() {
        return this.aestheticThreshold;
    }

    /* renamed from: b, reason: from getter */
    public final int getMaxShowCount() {
        return this.maxShowCount;
    }

    /* renamed from: c, reason: from getter */
    public final int getMinShowCount() {
        return this.minShowCount;
    }

    @NotNull
    public final List<String> d() {
        return this.pathFilter;
    }

    /* renamed from: e, reason: from getter */
    public final int getPriorityIndex() {
        return this.priorityIndex;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkNewAlbumConfigInfo)) {
            return false;
        }
        WinkNewAlbumConfigInfo winkNewAlbumConfigInfo = (WinkNewAlbumConfigInfo) other;
        if (Intrinsics.areEqual(this.storyID, winkNewAlbumConfigInfo.storyID) && Intrinsics.areEqual(this.storyName, winkNewAlbumConfigInfo.storyName) && Float.compare(this.threshold, winkNewAlbumConfigInfo.threshold) == 0 && this.priorityIndex == winkNewAlbumConfigInfo.priorityIndex && this.minShowCount == winkNewAlbumConfigInfo.minShowCount && this.maxShowCount == winkNewAlbumConfigInfo.maxShowCount && Intrinsics.areEqual(this.templateIDList, winkNewAlbumConfigInfo.templateIDList) && Intrinsics.areEqual(this.tagNameList, winkNewAlbumConfigInfo.tagNameList) && Intrinsics.areEqual(this.storySQL, winkNewAlbumConfigInfo.storySQL) && Intrinsics.areEqual(this.randomStoryNameList, winkNewAlbumConfigInfo.randomStoryNameList) && Intrinsics.areEqual(this.pathFilter, winkNewAlbumConfigInfo.pathFilter) && Float.compare(this.aestheticThreshold, winkNewAlbumConfigInfo.aestheticThreshold) == 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<String> f() {
        return this.randomStoryNameList;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getStoryID() {
        return this.storyID;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getStoryName() {
        return this.storyName;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.storyID.hashCode() * 31) + this.storyName.hashCode()) * 31) + Float.floatToIntBits(this.threshold)) * 31) + this.priorityIndex) * 31) + this.minShowCount) * 31) + this.maxShowCount) * 31) + this.templateIDList.hashCode()) * 31) + this.tagNameList.hashCode()) * 31) + this.storySQL.hashCode()) * 31) + this.randomStoryNameList.hashCode()) * 31) + this.pathFilter.hashCode()) * 31) + Float.floatToIntBits(this.aestheticThreshold);
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getStorySQL() {
        return this.storySQL;
    }

    @NotNull
    public final List<String> j() {
        return this.tagNameList;
    }

    @NotNull
    public final List<String> k() {
        return this.templateIDList;
    }

    /* renamed from: l, reason: from getter */
    public final float getThreshold() {
        return this.threshold;
    }

    @NotNull
    public String toString() {
        return "WinkNewAlbumConfigInfo(storyID=" + this.storyID + ", storyName=" + this.storyName + ", threshold=" + this.threshold + ", priorityIndex=" + this.priorityIndex + ", minShowCount=" + this.minShowCount + ", maxShowCount=" + this.maxShowCount + ", templateIDList=" + this.templateIDList + ", tagNameList=" + this.tagNameList + ", storySQL=" + this.storySQL + ", randomStoryNameList=" + this.randomStoryNameList + ", pathFilter=" + this.pathFilter + ", aestheticThreshold=" + this.aestheticThreshold + ")";
    }

    public WinkNewAlbumConfigInfo(@NotNull String storyID, @NotNull String storyName, float f16, int i3, int i16, int i17, @NotNull List<String> templateIDList, @NotNull List<String> tagNameList, @NotNull String storySQL, @NotNull List<String> randomStoryNameList, @NotNull List<String> pathFilter, float f17) {
        Intrinsics.checkNotNullParameter(storyID, "storyID");
        Intrinsics.checkNotNullParameter(storyName, "storyName");
        Intrinsics.checkNotNullParameter(templateIDList, "templateIDList");
        Intrinsics.checkNotNullParameter(tagNameList, "tagNameList");
        Intrinsics.checkNotNullParameter(storySQL, "storySQL");
        Intrinsics.checkNotNullParameter(randomStoryNameList, "randomStoryNameList");
        Intrinsics.checkNotNullParameter(pathFilter, "pathFilter");
        this.storyID = storyID;
        this.storyName = storyName;
        this.threshold = f16;
        this.priorityIndex = i3;
        this.minShowCount = i16;
        this.maxShowCount = i17;
        this.templateIDList = templateIDList;
        this.tagNameList = tagNameList;
        this.storySQL = storySQL;
        this.randomStoryNameList = randomStoryNameList;
        this.pathFilter = pathFilter;
        this.aestheticThreshold = f17;
    }

    public /* synthetic */ WinkNewAlbumConfigInfo(String str, String str2, float f16, int i3, int i16, int i17, List list, List list2, String str3, List list3, List list4, float f17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? "" : str, (i18 & 2) != 0 ? "" : str2, (i18 & 4) != 0 ? 0.0f : f16, (i18 & 8) != 0 ? 0 : i3, (i18 & 16) != 0 ? 0 : i16, (i18 & 32) == 0 ? i17 : 0, (i18 & 64) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i18 & 128) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i18 & 256) == 0 ? str3 : "", (i18 & 512) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list3, (i18 & 1024) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list4, (i18 & 2048) != 0 ? -10.0f : f17);
    }
}
