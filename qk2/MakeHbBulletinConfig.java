package qk2;

import com.google.gson.annotations.SerializedName;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010\u00a8\u0006\u0019"}, d2 = {"Lqk2/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "id", "I", "d", "()I", "content", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "url", "e", "beginTime", "a", "endTime", "c", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qk2.g, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class MakeHbBulletinConfig {

    @SerializedName("begintime")
    @Nullable
    private final String beginTime;

    @SerializedName("content_text")
    @Nullable
    private final String content;

    @SerializedName(AEEditorConstants.VIDEO_CLIP_END_TIME)
    @Nullable
    private final String endTime;

    @SerializedName("bulletin_id")
    private final int id;

    @SerializedName("url")
    @Nullable
    private final String url;

    public MakeHbBulletinConfig() {
        this(0, null, null, null, null, 31, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getBeginTime() {
        return this.beginTime;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    /* renamed from: d, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MakeHbBulletinConfig)) {
            return false;
        }
        MakeHbBulletinConfig makeHbBulletinConfig = (MakeHbBulletinConfig) other;
        if (this.id == makeHbBulletinConfig.id && Intrinsics.areEqual(this.content, makeHbBulletinConfig.content) && Intrinsics.areEqual(this.url, makeHbBulletinConfig.url) && Intrinsics.areEqual(this.beginTime, makeHbBulletinConfig.beginTime) && Intrinsics.areEqual(this.endTime, makeHbBulletinConfig.endTime)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int i3 = this.id * 31;
        String str = this.content;
        int i16 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        String str2 = this.url;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i18 = (i17 + hashCode2) * 31;
        String str3 = this.beginTime;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i19 = (i18 + hashCode3) * 31;
        String str4 = this.endTime;
        if (str4 != null) {
            i16 = str4.hashCode();
        }
        return i19 + i16;
    }

    @NotNull
    public String toString() {
        return "MakeHbBulletinConfig(id=" + this.id + ", content=" + this.content + ", url=" + this.url + ", beginTime=" + this.beginTime + ", endTime=" + this.endTime + ")";
    }

    public MakeHbBulletinConfig(int i3, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.id = i3;
        this.content = str;
        this.url = str2;
        this.beginTime = str3;
        this.endTime = str4;
    }

    public /* synthetic */ MakeHbBulletinConfig(int i3, String str, String str2, String str3, String str4, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? null : str, (i16 & 4) != 0 ? null : str2, (i16 & 8) != 0 ? null : str3, (i16 & 16) == 0 ? str4 : null);
    }
}
