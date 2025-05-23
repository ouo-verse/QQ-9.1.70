package ty1;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.cy;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d {
    private static String a(AppInterface appInterface, String str, String str2, String str3) {
        QLog.e("Guild.sch.GuildScheduleUtil", 1, String.format("getFixedChannelIdFromName, jumpGuildId:%s, jumpChannelName:%s, defaultJumpChannelId:%s", str, str2, str3));
        List<cy> channelCategoryList = ((IGPSService) appInterface.getRuntimeService(IGPSService.class, "")).getChannelCategoryList(str);
        if (channelCategoryList == null) {
            return str3;
        }
        Iterator<cy> it = channelCategoryList.iterator();
        while (it.hasNext()) {
            List<IGProChannelInfo> channelList = it.next().getChannelList();
            if (channelList != null) {
                for (int i3 = 0; i3 < channelList.size(); i3++) {
                    IGProChannelInfo iGProChannelInfo = channelList.get(i3);
                    if (iGProChannelInfo != null && TextUtils.equals(str2, iGProChannelInfo.getChannelName())) {
                        QLog.i("Guild.sch.GuildScheduleUtil", 1, String.format("getFixedChannelIdFromName, getRealJumpChannelId:%s", iGProChannelInfo.getChannelUin()));
                        return iGProChannelInfo.getChannelUin();
                    }
                }
            }
        }
        return str3;
    }

    public static String b(AppInterface appInterface, GuildScheduleInfo guildScheduleInfo, String str) {
        GuildScheduleChannelInfo channelInfo = guildScheduleInfo.getChannelInfo();
        String valueOf = String.valueOf(channelInfo.getChannelId());
        if (!TextUtils.equals(valueOf, str)) {
            return valueOf;
        }
        return a(appInterface, String.valueOf(channelInfo.getGuildId()), channelInfo.getChannelName(), str);
    }
}
