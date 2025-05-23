package wz1;

import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotCardRecommendRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInfo;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001BY\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\"\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0018j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0001`\u0019\u0012\u0006\u0010$\u001a\u00020\u001f\u00a2\u0006\u0004\b%\u0010&R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R3\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0018j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0001`\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010$\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lwz1/b;", "", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GProGuildRobotInfo;", "a", "Ljava/util/List;", "getResult", "()Ljava/util/List;", "result", "", "b", "I", "getMoreNum", "()I", "moreNum", "c", "getMaxShowIcon", "maxShowIcon", "", "d", "Ljava/lang/String;", "getRecommendTips", "()Ljava/lang/String;", "recommendTips", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "e", "Ljava/util/HashMap;", "getReportRobotData", "()Ljava/util/HashMap;", "reportRobotData", "Lcom/tencent/qqnt/kernel/nativeinterface/GProGuildRobotCardRecommendRsp;", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/GProGuildRobotCardRecommendRsp;", "getCardRecommendReply", "()Lcom/tencent/qqnt/kernel/nativeinterface/GProGuildRobotCardRecommendRsp;", "cardRecommendReply", "<init>", "(Ljava/util/List;IILjava/lang/String;Ljava/util/HashMap;Lcom/tencent/qqnt/kernel/nativeinterface/GProGuildRobotCardRecommendRsp;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<GProGuildRobotInfo> result;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int moreNum;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int maxShowIcon;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String recommendTips;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, Object> reportRobotData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GProGuildRobotCardRecommendRsp cardRecommendReply;

    public b(@NotNull List<GProGuildRobotInfo> result, int i3, int i16, @NotNull String recommendTips, @NotNull HashMap<String, Object> reportRobotData, @NotNull GProGuildRobotCardRecommendRsp cardRecommendReply) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(recommendTips, "recommendTips");
        Intrinsics.checkNotNullParameter(reportRobotData, "reportRobotData");
        Intrinsics.checkNotNullParameter(cardRecommendReply, "cardRecommendReply");
        this.result = result;
        this.moreNum = i3;
        this.maxShowIcon = i16;
        this.recommendTips = recommendTips;
        this.reportRobotData = reportRobotData;
        this.cardRecommendReply = cardRecommendReply;
    }
}
