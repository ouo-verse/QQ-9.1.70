package qk2;

import com.google.gson.annotations.SerializedName;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u000eB)\u0012 \b\u0002\u0010\f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tj\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u0001`\u000b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R2\u0010\f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tj\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u0001`\u000b8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lqk2/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/ArrayList;", "Lqk2/f$a;", "Lkotlin/collections/ArrayList;", "recommendList", "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qk2.f, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class HbRecommendConfig {

    @SerializedName("recommends")
    @Nullable
    private final ArrayList<RecommendItem> recommendList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lqk2/f$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "beginTime", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "endTime", "b", "flag", "I", "c", "()I", "text", "d", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qk2.f$a, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class RecommendItem {

        @SerializedName("begintime")
        @Nullable
        private final String beginTime;

        @SerializedName(AEEditorConstants.VIDEO_CLIP_END_TIME)
        @Nullable
        private final String endTime;

        @SerializedName("flag")
        private final int flag;

        @SerializedName("text")
        @Nullable
        private final String text;

        public RecommendItem() {
            this(null, null, 0, null, 15, null);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getBeginTime() {
            return this.beginTime;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getEndTime() {
            return this.endTime;
        }

        /* renamed from: c, reason: from getter */
        public final int getFlag() {
            return this.flag;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RecommendItem)) {
                return false;
            }
            RecommendItem recommendItem = (RecommendItem) other;
            if (Intrinsics.areEqual(this.beginTime, recommendItem.beginTime) && Intrinsics.areEqual(this.endTime, recommendItem.endTime) && this.flag == recommendItem.flag && Intrinsics.areEqual(this.text, recommendItem.text)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            String str = this.beginTime;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.endTime;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (((i16 + hashCode2) * 31) + this.flag) * 31;
            String str3 = this.text;
            if (str3 != null) {
                i3 = str3.hashCode();
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            return "RecommendItem(beginTime=" + this.beginTime + ", endTime=" + this.endTime + ", flag=" + this.flag + ", text=" + this.text + ")";
        }

        public RecommendItem(@Nullable String str, @Nullable String str2, int i3, @Nullable String str3) {
            this.beginTime = str;
            this.endTime = str2;
            this.flag = i3;
            this.text = str3;
        }

        public /* synthetic */ RecommendItem(String str, String str2, int i3, String str3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? null : str, (i16 & 2) != 0 ? null : str2, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? null : str3);
        }
    }

    public HbRecommendConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Nullable
    public final ArrayList<RecommendItem> a() {
        return this.recommendList;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof HbRecommendConfig) && Intrinsics.areEqual(this.recommendList, ((HbRecommendConfig) other).recommendList)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        ArrayList<RecommendItem> arrayList = this.recommendList;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.hashCode();
    }

    @NotNull
    public String toString() {
        return "HbRecommendConfig(recommendList=" + this.recommendList + ")";
    }

    public HbRecommendConfig(@Nullable ArrayList<RecommendItem> arrayList) {
        this.recommendList = arrayList;
    }

    public /* synthetic */ HbRecommendConfig(ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : arrayList);
    }
}
