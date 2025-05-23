package u73;

import com.google.gson.annotations.SerializedName;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aekit.plugin.core.AIInput;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0017\u0010\fR\u001a\u0010\u0018\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015R\u001a\u0010\u001f\u001a\u00020\u001e8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010$\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0011\u0010*\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u0011\u0010.\u001a\u00020+8F\u00a2\u0006\u0006\u001a\u0004\b,\u0010-R\u0011\u00100\u001a\u00020+8F\u00a2\u0006\u0006\u001a\u0004\b/\u0010-\u00a8\u00061"}, d2 = {"Lu73/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "text", "Ljava/lang/String;", tl.h.F, "()Ljava/lang/String;", "textColor", "j", "textBgColor", "i", "", "textBgAlpha", UserInfo.SEX_FEMALE, "getTextBgAlpha", "()F", "strokeColor", "f", "strokeWidth", "g", "startTime", "getStartTime", "endTime", "getEndTime", "Lu73/c;", AIInput.KEY_FRAME, "Lu73/c;", "d", "()Lu73/c;", "Lu73/a;", "audio", "Lu73/a;", "a", "()Lu73/a;", "b", "()I", "bgAlpha", "", "e", "()J", "startTimeUS", "c", "durationUS", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: u73.j, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class Text {

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

    @SerializedName("strokeColor")
    @Nullable
    private final String strokeColor;

    @SerializedName("strokeWidth")
    private final float strokeWidth;

    @SerializedName("text")
    @NotNull
    private final String text;

    @SerializedName("textBgAlpha")
    private final float textBgAlpha;

    @SerializedName("textBgColor")
    @Nullable
    private final String textBgColor;

    @SerializedName("textColor")
    @NotNull
    private final String textColor;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Audio getAudio() {
        return this.audio;
    }

    public final int b() {
        return (int) (this.textBgAlpha * 255);
    }

    public final long c() {
        return (this.endTime - this.startTime) * 1000000;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final Frame getFrame() {
        return this.frame;
    }

    public final long e() {
        return this.startTime * 1000000;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Text)) {
            return false;
        }
        Text text = (Text) other;
        if (Intrinsics.areEqual(this.text, text.text) && Intrinsics.areEqual(this.textColor, text.textColor) && Intrinsics.areEqual(this.textBgColor, text.textBgColor) && Float.compare(this.textBgAlpha, text.textBgAlpha) == 0 && Intrinsics.areEqual(this.strokeColor, text.strokeColor) && Float.compare(this.strokeWidth, text.strokeWidth) == 0 && Float.compare(this.startTime, text.startTime) == 0 && Float.compare(this.endTime, text.endTime) == 0 && Intrinsics.areEqual(this.frame, text.frame) && Intrinsics.areEqual(this.audio, text.audio)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final String getStrokeColor() {
        return this.strokeColor;
    }

    /* renamed from: g, reason: from getter */
    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = ((this.text.hashCode() * 31) + this.textColor.hashCode()) * 31;
        String str = this.textBgColor;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int floatToIntBits = (((hashCode3 + hashCode) * 31) + Float.floatToIntBits(this.textBgAlpha)) * 31;
        String str2 = this.strokeColor;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int floatToIntBits2 = (((((((((floatToIntBits + hashCode2) * 31) + Float.floatToIntBits(this.strokeWidth)) * 31) + Float.floatToIntBits(this.startTime)) * 31) + Float.floatToIntBits(this.endTime)) * 31) + this.frame.hashCode()) * 31;
        Audio audio = this.audio;
        if (audio != null) {
            i3 = audio.hashCode();
        }
        return floatToIntBits2 + i3;
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public final String getTextBgColor() {
        return this.textBgColor;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getTextColor() {
        return this.textColor;
    }

    @NotNull
    public String toString() {
        return "Text(text=" + this.text + ", textColor=" + this.textColor + ", textBgColor=" + this.textBgColor + ", textBgAlpha=" + this.textBgAlpha + ", strokeColor=" + this.strokeColor + ", strokeWidth=" + this.strokeWidth + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", frame=" + this.frame + ", audio=" + this.audio + ")";
    }
}
