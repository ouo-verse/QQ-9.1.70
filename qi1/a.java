package qi1;

import android.view.View;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticonview.EmotionReportDtImpl;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.mobileqq.guild.emoj.b;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes13.dex */
public class a {
    private static int a(SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo) {
        if (systemAndEmojiEmoticonInfo.emotionType == 2) {
            return 2;
        }
        if (!SystemAndEmojiEmoticonInfo.isAniStickerEnable(systemAndEmojiEmoticonInfo.code, true)) {
            return 1;
        }
        return 3;
    }

    private static int b(String str) {
        IGProGuildInfo guildInfo;
        IGPSService iGPSService = (IGPSService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGPSService.class, "");
        IGProChannelInfo channelInfo = iGPSService.getChannelInfo(str);
        if (channelInfo == null || (guildInfo = iGPSService.getGuildInfo(channelInfo.getGuildId())) == null) {
            return 4;
        }
        return v.b(guildInfo.getUserType());
    }

    public static void c(View view, SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo) {
        ch.Y0(view, "em_aio_yellow_tab", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL);
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_aio_stickers_entry", 2);
        hashMap.put(EmotionReportDtImpl.AIO_YELLOW_STICKERS_ID, Integer.valueOf(QQSysAndEmojiResMgr.getInstance().getResImpl(systemAndEmojiEmoticonInfo.emotionType).getServerId(systemAndEmojiEmoticonInfo.code)));
        hashMap.put(EmotionDaTongReportUtil.EM_PARAMS_EMOJI_TAB_TYPE, Integer.valueOf(a(systemAndEmojiEmoticonInfo)));
        VideoReport.reportEvent("dt_clck", view, hashMap);
    }

    public static void d(View view, View view2, SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo, b bVar, int i3) {
        ch.Y0(view, "em_aio_menu_emoji_comment_more", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL);
        HashMap hashMap = new HashMap(1);
        hashMap.put("sgrp_sub_channel_id", bVar.f217872f);
        hashMap.put("sgrp_user_type", Integer.valueOf(b(bVar.f217872f)));
        hashMap.put("sgrp_channel_id", bVar.f217873g);
        hashMap.put("emoji_comment_more_source", Integer.valueOf(bVar.f217867a));
        VideoReport.setPageParams(view2, new PageParams(hashMap));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("emoji_id", Integer.valueOf(QQSysAndEmojiResMgr.getInstance().getResImpl(systemAndEmojiEmoticonInfo.emotionType).getServerId(systemAndEmojiEmoticonInfo.code)));
        hashMap2.put(EmotionDaTongReportUtil.EM_PARAMS_EMOJI_TAB_TYPE, Integer.valueOf(a(systemAndEmojiEmoticonInfo)));
        hashMap2.put("sgrp_emoji_tab", Integer.valueOf(i3));
        VideoReport.reportEvent("dt_clck", view, hashMap2);
    }

    public static void e(View view, SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo, int i3, String str) {
        ch.Y0(view, "em_aio_menu_emoji_comment", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL);
        HashMap hashMap = new HashMap();
        hashMap.put("emoji_location", Integer.valueOf(i3 + 1));
        hashMap.put("emoji_id", Integer.valueOf(QQSysAndEmojiResMgr.getInstance().getResImpl(systemAndEmojiEmoticonInfo.emotionType).getServerId(systemAndEmojiEmoticonInfo.code)));
        hashMap.put("sgrp_user_type", Integer.valueOf(b(str)));
        hashMap.put(QQHealthReportApiImpl.MSG_TYPE_KEY, Integer.valueOf(systemAndEmojiEmoticonInfo.emotionType));
        VideoReport.reportEvent("dt_clck", view, hashMap);
    }
}
