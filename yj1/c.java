package yj1;

import androidx.annotation.UiThread;
import com.tencent.mobileqq.guild.feed.report.GuildFeedReportTable12003;
import com.tencent.mobileqq.guild.feed.report.GuildFeedReporter;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.qphone.base.util.QLog;
import ij1.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00052\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\f\u001a\u00020\n\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0017R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000bR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lyj1/c;", "Lyj1/f;", "Lij1/g;", "feed", "", "c", "blockData", "", com.tencent.luggage.wxa.c8.c.G, "a", "Lcom/tencent/mobileqq/guild/mainframe/GuildFeedReportSourceInfo;", "Lcom/tencent/mobileqq/guild/mainframe/GuildFeedReportSourceInfo;", "reportSourceInfo", "", "", "b", "Ljava/util/List;", "exposedList", "<init>", "(Lcom/tencent/mobileqq/guild/mainframe/GuildFeedReportSourceInfo;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFeedReportSourceInfo reportSourceInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> exposedList;

    public c(@NotNull GuildFeedReportSourceInfo reportSourceInfo) {
        Intrinsics.checkNotNullParameter(reportSourceInfo, "reportSourceInfo");
        this.reportSourceInfo = reportSourceInfo;
        this.exposedList = new ArrayList();
    }

    private final void c(g feed) {
        GuildFeedReportTable12003.b(new GuildFeedReportTable12003.a(com.tencent.mobileqq.guild.feed.report.f.b(feed.b(), this.reportSourceInfo.getReportInfoMap().get("extra_feeds_page_forum_type")).K("imp").J("success").Y(this.reportSourceInfo.getReportInfoMap().get("extra_feeds_page_id")).V(this.reportSourceInfo.getReportInfoMap().get("extra_feeds_page_forum_type")).g0(this.reportSourceInfo.getReportInfoMap().get("extra_feeds_pre_page_id")).f0(this.reportSourceInfo.getReportInfoMap().get("extra_feeds_pre_page_forum_type"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(c this$0, g blockData, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(blockData, "$blockData");
        this$0.c(blockData);
        QLog.d("GuildFeedSquareAutoReportManager", 4, "report expose pos:" + i3 + " ,feedId:" + blockData.b().idd);
    }

    @Override // yj1.f
    @UiThread
    public void a(@NotNull final g blockData, final int pos) {
        Intrinsics.checkNotNullParameter(blockData, "blockData");
        if (!this.exposedList.contains(blockData.b().idd)) {
            List<String> list = this.exposedList;
            String str = blockData.b().idd;
            Intrinsics.checkNotNullExpressionValue(str, "blockData.sourceData.idd");
            list.add(str);
            GuildFeedReporter.o().n().post(new Runnable() { // from class: yj1.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.d(c.this, blockData, pos);
                }
            });
        }
    }
}
