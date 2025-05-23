package qzone;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$GetSpaceMainPageFeedsRsp extends MessageMicro<QZIntimateSpaceReader$GetSpaceMainPageFeedsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"ext", "feeds", "attach_info", PictureConst.KEY_HAS_MORE}, new Object[]{null, null, "", Boolean.FALSE}, QZIntimateSpaceReader$GetSpaceMainPageFeedsRsp.class);
    public QZoneBaseCommon$StCommonExt ext = new QZoneBaseCommon$StCommonExt();
    public final PBRepeatMessageField<QZIntimateSpaceReader$StClientFeed> feeds = PBField.initRepeatMessage(QZIntimateSpaceReader$StClientFeed.class);
    public final PBStringField attach_info = PBField.initString("");
    public final PBBoolField has_more = PBField.initBool(false);
}
