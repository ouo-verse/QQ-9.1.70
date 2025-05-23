package qj1;

import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextCardContent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&JN\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\f\u0012\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u000e0\f2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\u0018\u0010\u0013\u001a\u00060\u0001j\u0002`\u00122\n\u0010\u0011\u001a\u00060\u0001j\u0002`\u0010H&J\b\u0010\u0014\u001a\u00020\rH&J\b\u0010\u0016\u001a\u00020\u0015H&J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0002H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0002H\u0016J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0002H\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0002H\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u0002H&J\b\u0010\"\u001a\u00020!H&J\n\u0010$\u001a\u0004\u0018\u00010#H&\u00a8\u0006%"}, d2 = {"Lqj1/e;", "", "", "Lqj1/l;", "c", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "joinInfoParam", "", "hideUrlTypes", "emojiSize", "", "traceId", "Lkotlin/Pair;", "Landroid/text/SpannableStringBuilder;", "Lcom/tencent/mobileqq/guild/feed/displayable/TouchMovementMethod;", "y", "Lcom/tencent/mobileqq/guild/feed/displayable/LongFeedParseParam;", "param", "Lcom/tencent/mobileqq/guild/feed/displayable/LongFeedUIData;", BdhLogUtil.LogTag.Tag_Conn, "v", "", "k", "Lqj1/r;", "H", "Lqj1/q;", "b", "Lqj1/t;", tl.h.F, "Lqj1/u;", "getTroopList", "Lqj1/w;", "f", "Lqj1/a;", "l", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextCardContent;", "D", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface e {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Pair a(e eVar, JumpGuildParam.JoinInfoParam joinInfoParam, List list, int i3, String str, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 1) != 0) {
                    joinInfoParam = null;
                }
                if ((i16 & 2) != 0) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                if ((i16 & 4) != 0) {
                    i3 = 20;
                }
                if ((i16 & 8) != 0) {
                    str = "";
                }
                return eVar.y(joinInfoParam, list, i3, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMainTextContent");
        }

        @NotNull
        public static List<t> b(@NotNull e eVar) {
            List<t> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }

        @NotNull
        public static List<r> c(@NotNull e eVar) {
            List<r> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }

        @NotNull
        public static List<q> d(@NotNull e eVar) {
            List<q> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }

        @NotNull
        public static List<u> e(@NotNull e eVar) {
            List<u> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }

    @NotNull
    Object C(@NotNull Object param);

    @Nullable
    GProStRichTextCardContent D();

    @NotNull
    List<r> H();

    @NotNull
    List<q> b();

    @NotNull
    List<l> c();

    @NotNull
    List<w> f();

    @NotNull
    List<u> getTroopList();

    @NotNull
    List<t> h();

    boolean k();

    @NotNull
    qj1.a l();

    @NotNull
    SpannableStringBuilder v();

    @NotNull
    Pair<SpannableStringBuilder, Object> y(@Nullable JumpGuildParam.JoinInfoParam joinInfoParam, @NotNull List<Integer> hideUrlTypes, int emojiSize, @Nullable String traceId);
}
