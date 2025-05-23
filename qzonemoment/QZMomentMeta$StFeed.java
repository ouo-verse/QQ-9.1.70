package qzonemoment;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentMeta$StFeed extends MessageMicro<QZMomentMeta$StFeed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 58, 66, 72, 82, 88}, new String[]{"id", QAdVrReport.ElementID.AD_POSTER, WadlProxyConsts.CREATE_TIME, "images", "content", "poiInfo", "commonExt", "likeInfo", "commentCount", "extInfo", "opMask"}, new Object[]{"", null, 0L, null, "", null, null, null, 0, null, 1}, QZMomentMeta$StFeed.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f430362id = PBField.initString("");
    public QZMomentMeta$StUser poster = new QZMomentMeta$StUser();
    public final PBUInt64Field createTime = PBField.initUInt64(0);
    public final PBRepeatMessageField<QZMomentMeta$StImage> images = PBField.initRepeatMessage(QZMomentMeta$StImage.class);
    public final PBStringField content = PBField.initString("");
    public QZMomentMeta$StPoiInfo poiInfo = new QZMomentMeta$StPoiInfo();
    public QZMomentCommon$StCommonExt commonExt = new QZMomentCommon$StCommonExt();
    public QZMomentMeta$StLike likeInfo = new QZMomentMeta$StLike();
    public final PBUInt32Field commentCount = PBField.initUInt32(0);
    public final PBRepeatMessageField<QZMomentCommon$Entry> extInfo = PBField.initRepeatMessage(QZMomentCommon$Entry.class);
    public final PBRepeatField<Integer> opMask = PBField.initRepeat(PBEnumField.__repeatHelper__);
}
