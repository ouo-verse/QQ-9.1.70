package u73;

import com.google.gson.annotations.SerializedName;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aekit.plugin.core.AIInput;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u00148\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001f\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\fR\u0011\u0010#\u001a\u00020 8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010%\u001a\u00020 8F\u00a2\u0006\u0006\u001a\u0004\b$\u0010\"\u00a8\u0006&"}, d2 = {"Lu73/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "url", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "", "startTime", UserInfo.SEX_FEMALE, "getStartTime", "()F", "endTime", "getEndTime", "Lu73/c;", AIInput.KEY_FRAME, "Lu73/c;", "c", "()Lu73/c;", "Lu73/a;", "audio", "Lu73/a;", "a", "()Lu73/a;", "d", "path", "", "e", "()J", "startTimeUS", "b", "durationUS", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: u73.i, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class Sticker {

    @SerializedName("audio")
    @Nullable
    private final Audio audio;

    @SerializedName("endTime")
    private final float endTime;

    @SerializedName(AIInput.KEY_FRAME)
    @NotNull
    private final Frame frame;

    @SerializedName("startTime")
    private final float startTime;

    @SerializedName("url")
    @NotNull
    private final String url;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Audio getAudio() {
        return this.audio;
    }

    public final long b() {
        return (this.endTime - this.startTime) * 1000000;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final Frame getFrame() {
        return this.frame;
    }

    @NotNull
    public final String d() {
        return d.a(this.url);
    }

    public final long e() {
        return this.startTime * 1000000;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Sticker)) {
            return false;
        }
        Sticker sticker = (Sticker) other;
        if (Intrinsics.areEqual(this.url, sticker.url) && Float.compare(this.startTime, sticker.startTime) == 0 && Float.compare(this.endTime, sticker.endTime) == 0 && Intrinsics.areEqual(this.frame, sticker.frame) && Intrinsics.areEqual(this.audio, sticker.audio)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((this.url.hashCode() * 31) + Float.floatToIntBits(this.startTime)) * 31) + Float.floatToIntBits(this.endTime)) * 31) + this.frame.hashCode()) * 31;
        Audio audio = this.audio;
        if (audio == null) {
            hashCode = 0;
        } else {
            hashCode = audio.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "Sticker(url=" + this.url + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", frame=" + this.frame + ", audio=" + this.audio + ")";
    }
}
