package wk1;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProStCommonExt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&Ji\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062W\b\u0002\u0010\u0010\u001aQ\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bj\u0004\u0018\u0001`\u000fH&J\b\u0010\u0013\u001a\u00020\u0012H&\u00a8\u0006\u0014"}, d2 = {"Lwk1/f;", "", "", "feedId", "", "isRequesting", "Lwk1/b;", "args", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "result", "rsp", "", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/base/LikeCallBack;", "callback", "a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStCommonExt;", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface f {
    void a(@NotNull FeedReferRequestArgs args, @Nullable Function3<? super Integer, ? super FeedReferRequestArgs, Object, Unit> callback);

    @NotNull
    GProStCommonExt b();

    boolean isRequesting(@NotNull String feedId);
}
