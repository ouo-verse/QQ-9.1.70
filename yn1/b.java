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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0001\u0007B\u0019\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR$\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\u0012\"\u0004\b\u0010\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lyn1/b;", "Landroid/text/style/CharacterStyle;", "Landroid/text/TextPaint;", "textPaint", "", "updateDrawState", "", "a", "J", "()J", "topicId", "", "b", "I", "color", "", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "topicName", "<init>", "(JI)V", "d", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b extends CharacterStyle {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long topicId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int color;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String topicName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0002\u00a8\u0006\u0006"}, d2 = {"Lyn1/b$a;", "", "", "b", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: yn1.b$a, reason: from kotlin metadata */
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

    public /* synthetic */ b(long j3, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, (i16 & 2) != 0 ? INSTANCE.b() : i3);
    }

    /* renamed from: a, reason: from getter */
    public final long getTopicId() {
        return this.topicId;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getTopicName() {
        return this.topicName;
    }

    public final void c(@Nullable String str) {
        this.topicName = str;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        textPaint.setColor(this.color);
    }

    public b(long j3, int i3) {
        this.topicId = j3;
        this.color = i3;
    }
}
