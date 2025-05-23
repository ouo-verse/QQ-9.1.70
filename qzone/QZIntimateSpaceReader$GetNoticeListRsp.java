package qzone;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$GetNoticeListRsp extends MessageMicro<QZIntimateSpaceReader$GetNoticeListRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public QZoneBaseCommon$StCommonExt ext = new QZoneBaseCommon$StCommonExt();
    public final PBRepeatMessageField<QZIntimateSpaceReader$StNotice> notices = PBField.initRepeatMessage(QZIntimateSpaceReader$StNotice.class);
    public final PBStringField attach_info = PBField.initString("");
    public final PBBoolField has_more = PBField.initBool(false);
    public final PBBoolField has_notice_before = PBField.initBool(false);

    static {
        String[] strArr = {"ext", "notices", "attach_info", PictureConst.KEY_HAS_MORE, "has_notice_before"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, strArr, new Object[]{null, null, "", bool, bool}, QZIntimateSpaceReader$GetNoticeListRsp.class);
    }
}
