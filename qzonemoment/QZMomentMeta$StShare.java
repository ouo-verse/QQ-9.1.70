package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentMeta$StShare extends MessageMicro<QZMomentMeta$StShare> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74}, new String[]{"title", "desc", "url", "author", QAdVrReport.ElementID.AD_POSTER, "cover", "shareCardInfo", "images", "feed_id"}, new Object[]{"", "", "", null, null, null, "", null, ""}, QZMomentMeta$StShare.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public QZMomentMeta$StUser author = new QZMomentMeta$StUser();
    public QZMomentMeta$StUser poster = new QZMomentMeta$StUser();
    public QZMomentMeta$StImage cover = new QZMomentMeta$StImage();
    public final PBStringField shareCardInfo = PBField.initString("");
    public final PBRepeatMessageField<QZMomentMeta$StImage> images = PBField.initRepeatMessage(QZMomentMeta$StImage.class);
    public final PBStringField feed_id = PBField.initString("");
}
