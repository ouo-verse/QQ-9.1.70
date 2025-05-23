package ut1;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.message.api.impl.GuildRoamMessageHandler;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.service.message.e;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.group_pro_proto.common.common$Msg;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public AppInterface f440015a;

    /* renamed from: b, reason: collision with root package name */
    e f440016b;

    /* renamed from: c, reason: collision with root package name */
    public GuildRoamMessageHandler f440017c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<common$Msg> f440018d = new ArrayList<>();

    public a(AppInterface appInterface, GuildRoamMessageHandler guildRoamMessageHandler) {
        this.f440015a = appInterface;
        this.f440017c = guildRoamMessageHandler;
        this.f440016b = (e) appInterface.getMsgCache();
    }

    private IGPSService a() {
        return (IGPSService) this.f440015a.getRuntimeService(IGPSService.class, "");
    }

    public boolean b(String str, long j3, long j16, Bundle bundle) {
        long M0 = this.f440016b.M0(str, 10014);
        long j17 = (j16 - j3) + 1;
        String guildIdOf = a().getGuildIdOf(str);
        if (TextUtils.isEmpty(guildIdOf)) {
            guildIdOf = bundle.getString("guild_id");
        }
        if (QLog.isColorLevel()) {
            QLog.d("BasePullRoamMsgLogic", 2, "--->>reqPullRoamMsg() channelId: " + str + " guildId: " + guildIdOf + " beginSeq: " + j3 + " endSeq: " + j16 + " delSeq: " + M0 + " pull num : " + j17 + " ThreadId:" + Thread.currentThread().getId() + " directMsgFlag: " + ((int) bundle.getByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG)));
        }
        if (j3 >= 0 && j16 > 0 && !TextUtils.isEmpty(guildIdOf) && !TextUtils.isEmpty(str)) {
            return c(guildIdOf, str, j3, j16, bundle);
        }
        return false;
    }

    public abstract boolean c(String str, String str2, long j3, long j16, Bundle bundle);
}
