package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;

/* loaded from: classes30.dex */
public final class VideoBriefIntro$VideoBriefIntroductionPage extends MessageMicro<VideoBriefIntro$VideoBriefIntroductionPage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{QAdVrReport.ElementID.AD_POSTER, "actor_info", "text"}, new Object[]{null, null, null}, VideoBriefIntro$VideoBriefIntroductionPage.class);
    public VideoBriefIntro$VideoBriefIntroductionPoster poster = new VideoBriefIntro$VideoBriefIntroductionPoster();
    public VideoBriefIntro$VideoBriefIntroductionActorList actor_info = new VideoBriefIntro$VideoBriefIntroductionActorList();
    public VideoBriefIntro$VideoBriefIntroductionText text = new VideoBriefIntro$VideoBriefIntroductionText();
}
