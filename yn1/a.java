package yn1;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.quiprofile.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0002\u0007\fB\u0011\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lyn1/a;", "Landroid/text/style/CharacterStyle;", "Landroid/text/TextPaint;", "textPaint", "", "updateDrawState", "", "a", "I", "color", "<init>", "(I)V", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends CharacterStyle {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int color;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0002\u00a8\u0006\u0006"}, d2 = {"Lyn1/a$a;", "", "", "b", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: yn1.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int b() {
            MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
            Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
            return new c(sMobileQQ, null, 0, false, 14, null).getColor(R.color.qui_common_text_link);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lyn1/a$b;", "", "Lyn1/a;", "a", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "guildNumber", "b", "I", "d", "()I", "startIndex", "endIndex", "<init>", "(Ljava/lang/String;II)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: yn1.a$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class GuildJumpEntity {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String guildNumber;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int startIndex;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int endIndex;

        public GuildJumpEntity(@NotNull String guildNumber, int i3, int i16) {
            Intrinsics.checkNotNullParameter(guildNumber, "guildNumber");
            this.guildNumber = guildNumber;
            this.startIndex = i3;
            this.endIndex = i16;
        }

        @NotNull
        public final a a() {
            return new a(0, 1, null);
        }

        /* renamed from: b, reason: from getter */
        public final int getEndIndex() {
            return this.endIndex;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getGuildNumber() {
            return this.guildNumber;
        }

        /* renamed from: d, reason: from getter */
        public final int getStartIndex() {
            return this.startIndex;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildJumpEntity)) {
                return false;
            }
            GuildJumpEntity guildJumpEntity = (GuildJumpEntity) other;
            if (Intrinsics.areEqual(this.guildNumber, guildJumpEntity.guildNumber) && this.startIndex == guildJumpEntity.startIndex && this.endIndex == guildJumpEntity.endIndex) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.guildNumber.hashCode() * 31) + this.startIndex) * 31) + this.endIndex;
        }

        @NotNull
        public String toString() {
            return "GuildJumpEntity(guildNumber=" + this.guildNumber + ", startIndex=" + this.startIndex + ", endIndex=" + this.endIndex + ")";
        }
    }

    public a() {
        this(0, 1, null);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        textPaint.setColor(this.color);
        textPaint.setUnderlineText(true);
    }

    public /* synthetic */ a(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? INSTANCE.b() : i3);
    }

    public a(int i3) {
        this.color = i3;
    }
}
