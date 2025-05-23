package wo1;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.home.subhome.GuildHomeSubFragmentBehavior;
import com.tencent.mobileqq.guild.home.views.header.handler.GuildHomeHeaderTitleJumpHandler;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Deprecated(message = "\u65e7\u7248\u672c\u9891\u9053\u9996\u9875\u540e\u7eed\u4f1a\u4e0b\u6389")
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001R\u001c\u0010\u0007\u001a\u00020\u00028&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006 "}, d2 = {"Lwo1/b;", "", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "c", "()Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "g", "(Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;)V", "facadeArgsData", "Lcom/tencent/mobileqq/app/QBaseActivity;", "getActivity", "()Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/guild/home/subhome/GuildHomeSubFragmentBehavior;", "e", "()Lcom/tencent/mobileqq/guild/home/subhome/GuildHomeSubFragmentBehavior;", "fragmentBehavior", "Lmp1/b;", "d", "()Lmp1/b;", "homeViewModel", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "a", "()Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "guildFacadeType", "Lcom/tencent/mobileqq/guild/home/views/header/handler/GuildHomeHeaderTitleJumpHandler;", "f", "()Lcom/tencent/mobileqq/guild/home/views/header/handler/GuildHomeHeaderTitleJumpHandler;", "guildTitleJumpHandler", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "b", "()Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface b {
    @NotNull
    GuildFacadeType a();

    @NotNull
    IPerformanceReportTask b();

    @NotNull
    /* renamed from: c */
    FacadeArgsData getFacadeArgsData();

    @NotNull
    /* renamed from: d */
    mp1.b getHomeViewModel();

    @NotNull
    /* renamed from: e */
    GuildHomeSubFragmentBehavior getFragmentBehavior();

    @NotNull
    GuildHomeHeaderTitleJumpHandler f();

    void g(@NotNull FacadeArgsData facadeArgsData);

    @NotNull
    QBaseActivity getActivity();
}
