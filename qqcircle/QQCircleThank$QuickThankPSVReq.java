package qqcircle;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QQCircleThank$QuickThankPSVReq extends MessageMicro<QQCircleThank$QuickThankPSVReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"start_time", PictureConst.KEY_CATEGORY_ID}, new Object[]{0L, 0}, QQCircleThank$QuickThankPSVReq.class);
    public final PBUInt64Field start_time = PBField.initUInt64(0);
    public final PBEnumField category_id = PBField.initEnum(0);
}
