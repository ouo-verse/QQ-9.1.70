package xq1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeJoinInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalBanner;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final IGProGuildInfo f448393a;

    /* renamed from: b, reason: collision with root package name */
    private final IGProChannelInfo f448394b;

    /* renamed from: c, reason: collision with root package name */
    private final IGProGlobalBanner f448395c;

    /* renamed from: d, reason: collision with root package name */
    private final FacadeJoinInfo f448396d;

    /* renamed from: e, reason: collision with root package name */
    private final GuildAppReportSourceInfo f448397e;

    public d(@NonNull IGProGuildInfo iGProGuildInfo, @NonNull IGProChannelInfo iGProChannelInfo, @NonNull IGProGlobalBanner iGProGlobalBanner, @Nullable FacadeJoinInfo facadeJoinInfo, @Nullable GuildAppReportSourceInfo guildAppReportSourceInfo) {
        this.f448393a = iGProGuildInfo;
        this.f448394b = iGProChannelInfo;
        this.f448395c = iGProGlobalBanner;
        if (facadeJoinInfo == null) {
            FacadeJoinInfo facadeJoinInfo2 = new FacadeJoinInfo();
            this.f448396d = facadeJoinInfo2;
            facadeJoinInfo2.b(new JumpGuildParam.JoinInfoParam(iGProChannelInfo.getChannelUin(), "", "", ""));
        } else {
            this.f448396d = facadeJoinInfo;
        }
        this.f448397e = guildAppReportSourceInfo;
    }

    public String toString() {
        return "GuildAnnounceBannerModel{mGuildInfo=" + this.f448393a + ", mChannelInfo=" + this.f448394b + ", mGuildBanner=" + this.f448395c + '}';
    }
}
