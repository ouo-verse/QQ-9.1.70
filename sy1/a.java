package sy1;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.share.GuildShareWrapper;
import com.tencent.mobileqq.guild.share.ShareInfoResult;
import com.tencent.mobileqq.guild.share.m;
import com.tencent.mobileqq.guild.share.shorturl.ShareServiceType;
import com.tencent.mobileqq.guild.share.t;
import com.tencent.mobileqq.guild.usecases.b;
import com.tencent.mobileqq.guild.util.aa;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.ShareJsPlugin;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;
import tencent.im.group_pro_proto.channel_share.ChannelShareRequest$ScheduleParam;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f434962a = Pattern.compile("http(?:s)?://qun.qq.com/qqweb/qunpro/[\\S]+");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: sy1.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public class C11259a implements t {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GuildScheduleInfo f434963a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f434964b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ IGProGuildInfo f434965c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f434966d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IGProChannelInfo f434967e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f434968f;

        C11259a(GuildScheduleInfo guildScheduleInfo, Activity activity, IGProGuildInfo iGProGuildInfo, boolean z16, IGProChannelInfo iGProChannelInfo, b bVar) {
            this.f434963a = guildScheduleInfo;
            this.f434964b = activity;
            this.f434965c = iGProGuildInfo;
            this.f434966d = z16;
            this.f434967e = iGProChannelInfo;
            this.f434968f = bVar;
        }

        @Override // com.tencent.mobileqq.guild.share.t
        public void a(ShareInfoResult shareInfoResult) {
            boolean z16;
            m mVar;
            ri1.a e16 = ri1.a.e(shareInfoResult.getResult(), shareInfoResult.getErrMsg(), shareInfoResult.getSecResult());
            if (TextUtils.isEmpty(shareInfoResult.getShareUrl()) && TextUtils.isEmpty(shareInfoResult.getShareInfo())) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (e16.d() && z16) {
                QLog.d("Guild.sch.GuildScheduleShareUtil", 1, "shareInfoResult = " + shareInfoResult);
                b.c cVar = new b.c(shareInfoResult.getShareUrl(), shareInfoResult.getShareInfo());
                cVar.f235321c = this.f434963a.getTitle();
                cVar.f235322d = a.d(this.f434964b, this.f434963a, this.f434965c);
                cVar.f235323e = shareInfoResult.getLongShareUrl();
                cVar.f235324f = String.valueOf(this.f434963a.getScheduleId());
                if (this.f434966d) {
                    mVar = new m(this.f434964b, this.f434965c, this.f434967e, GuildSharePageSource.FEED_LIST, "pindao_card", ShareServiceType.SCHEDULE);
                } else {
                    mVar = new m(this.f434964b, this.f434965c, this.f434967e, GuildSharePageSource.SCHEDULE_DETAIL);
                }
                mVar.v(1);
                mVar.w(cVar);
                b bVar = this.f434968f;
                if (bVar != null) {
                    bVar.a(mVar);
                }
                mVar.z();
                return;
            }
            QLog.e("Guild.sch.GuildScheduleShareUtil", 1, "onFetchGuildShareUrl,  shareInfoResult=", shareInfoResult);
            aa.b(ShareJsPlugin.ERRMSG_INVITE_REQUIRE);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface b {
        void a(@NonNull m mVar);
    }

    private static String b(long j3, String str) {
        return new SimpleDateFormat(str).format(new Date(j3));
    }

    private static String c(GuildScheduleInfo guildScheduleInfo) {
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        long startTimeMs = guildScheduleInfo.getStartTimeMs();
        long endTimeMs = guildScheduleInfo.getEndTimeMs();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(serverTimeMillis);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(startTimeMs);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTimeInMillis(endTimeMs);
        int i3 = calendar2.get(5);
        boolean z16 = true;
        int i16 = calendar.get(1);
        int i17 = calendar2.get(1);
        int i18 = calendar3.get(1);
        if (i17 == i16 && i18 == i16) {
            z16 = false;
        }
        StringBuilder sb5 = new StringBuilder();
        if (i3 == calendar.get(5)) {
            sb5.append("\u4eca\u5929");
            sb5.append(b(startTimeMs, DateUtil.DATE_FORMAT_HOUR));
            sb5.append(" - ");
        } else if (z16) {
            sb5.append(b(startTimeMs, "yyyy\u5e74MM\u6708dd\u65e5HH:mm"));
            sb5.append(" - ");
        } else {
            sb5.append(b(startTimeMs, "MM\u6708dd\u65e5HH:mm - "));
        }
        if (i3 == calendar3.get(5)) {
            sb5.append(b(endTimeMs, DateUtil.DATE_FORMAT_HOUR));
        } else if (z16) {
            sb5.append(b(endTimeMs, "yyyy\u5e74MM\u6708dd\u65e5HH:mm"));
        } else {
            sb5.append(b(endTimeMs, "MM\u6708dd\u65e5HH:mm"));
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(Context context, GuildScheduleInfo guildScheduleInfo, IGProGuildInfo iGProGuildInfo) {
        return String.format(Locale.getDefault(), context.getString(R.string.f155251h0), c(guildScheduleInfo), iGProGuildInfo.getGuildName());
    }

    public static void e(Activity activity, IGProGuildInfo iGProGuildInfo, IGProChannelInfo iGProChannelInfo, GuildScheduleInfo guildScheduleInfo, boolean z16, b bVar) {
        if (o.c("Guild.sch.GuildScheduleShareUtil")) {
            return;
        }
        ChannelShareRequest$ScheduleParam channelShareRequest$ScheduleParam = new ChannelShareRequest$ScheduleParam();
        channelShareRequest$ScheduleParam.f435938id.set(guildScheduleInfo.getScheduleId());
        GuildShareWrapper.e(iGProChannelInfo.getGuildId(), iGProChannelInfo.getChannelUin(), 1, channelShareRequest$ScheduleParam.toByteArray(), null, new C11259a(guildScheduleInfo, activity, iGProGuildInfo, z16, iGProChannelInfo, bVar));
    }
}
