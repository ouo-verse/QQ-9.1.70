package s83;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0002\b\n\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\tB%\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0013\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\"\u0010\u0019\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u000f\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Ls83/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "setStoryID", "(Ljava/lang/String;)V", "storyID", "b", "getPrompt", "setPrompt", "prompt", "", "c", "[F", "()[F", "setTextFeature", "([F)V", "textFeature", "<init>", "(Ljava/lang/String;Ljava/lang/String;[F)V", "d", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: s83.b, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class WinkNewAlbumFeatureConfigInfo {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String storyID;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String prompt;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private float[] textFeature;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007\u00a8\u0006\u000b"}, d2 = {"Ls83/b$a;", "", "Lorg/json/JSONObject;", "Ls83/b;", "b", "", "jsonString", "", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: s83.b$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final WinkNewAlbumFeatureConfigInfo b(JSONObject jSONObject) {
            String optString = jSONObject.optString("story_id", "");
            Intrinsics.checkNotNullExpressionValue(optString, "optString(\"story_id\", \"\")");
            String optString2 = jSONObject.optString("prompt", "");
            Intrinsics.checkNotNullExpressionValue(optString2, "optString(\"prompt\", \"\")");
            return new WinkNewAlbumFeatureConfigInfo(optString, optString2, fx4.b.d(jSONObject.optJSONArray("text_feature")));
        }

        @JvmStatic
        @NotNull
        public final List<WinkNewAlbumFeatureConfigInfo> a(@NotNull String jsonString) {
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

    public WinkNewAlbumFeatureConfigInfo() {
        this(null, null, null, 7, null);
    }

    @JvmStatic
    @NotNull
    public static final List<WinkNewAlbumFeatureConfigInfo> c(@NotNull String str) {
        return INSTANCE.a(str);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getStoryID() {
        return this.storyID;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final float[] getTextFeature() {
        return this.textFeature;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkNewAlbumFeatureConfigInfo)) {
            return false;
        }
        WinkNewAlbumFeatureConfigInfo winkNewAlbumFeatureConfigInfo = (WinkNewAlbumFeatureConfigInfo) other;
        if (Intrinsics.areEqual(this.storyID, winkNewAlbumFeatureConfigInfo.storyID) && Intrinsics.areEqual(this.prompt, winkNewAlbumFeatureConfigInfo.prompt) && Intrinsics.areEqual(this.textFeature, winkNewAlbumFeatureConfigInfo.textFeature)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.storyID.hashCode() * 31) + this.prompt.hashCode()) * 31) + Arrays.hashCode(this.textFeature);
    }

    @NotNull
    public String toString() {
        return "WinkNewAlbumFeatureConfigInfo(storyID=" + this.storyID + ", prompt=" + this.prompt + ", textFeature=" + Arrays.toString(this.textFeature) + ")";
    }

    public WinkNewAlbumFeatureConfigInfo(@NotNull String storyID, @NotNull String prompt, @NotNull float[] textFeature) {
        Intrinsics.checkNotNullParameter(storyID, "storyID");
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        Intrinsics.checkNotNullParameter(textFeature, "textFeature");
        this.storyID = storyID;
        this.prompt = prompt;
        this.textFeature = textFeature;
    }

    public /* synthetic */ WinkNewAlbumFeatureConfigInfo(String str, String str2, float[] fArr, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? new float[0] : fArr);
    }
}
