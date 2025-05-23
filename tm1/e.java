package tm1;

import com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J+\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Ltm1/e;", "", "", "toolType", "Ltm1/b;", "b", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/translate/translator/i;", "transparentJsonTranslator", "", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/translate/translator/e;", "extendedTranslators", "Ltm1/a;", "a", "(ILcom/tencent/mobileqq/guild/feed/nativepublish/tool/translate/translator/i;[Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/translate/translator/e;)Ltm1/a;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f436596a = new e();

    e() {
    }

    @NotNull
    public final a a(int toolType, @NotNull i transparentJsonTranslator, @NotNull com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.e[] extendedTranslators) {
        Intrinsics.checkNotNullParameter(transparentJsonTranslator, "transparentJsonTranslator");
        Intrinsics.checkNotNullParameter(extendedTranslators, "extendedTranslators");
        if (toolType != 1) {
            if (toolType != 3) {
                return new d(transparentJsonTranslator, extendedTranslators);
            }
            return new c(transparentJsonTranslator, extendedTranslators);
        }
        return new d(transparentJsonTranslator, extendedTranslators);
    }

    @NotNull
    public final b b(int toolType) {
        if (toolType != 1) {
            if (toolType != 3) {
                return new d(new i(null, null, 3, null), new com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.e[0]);
            }
            return new c(new i(null, null, 3, null), new com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.e[0]);
        }
        return new d(new i(null, null, 3, null), new com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.e[0]);
    }
}
