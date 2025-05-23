package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleLightinteract$StGetUrgeStatusRsp extends MessageMicro<QQCircleLightinteract$StGetUrgeStatusRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"urgeStatus", "urgePosition"}, new Object[]{0, 0}, QQCircleLightinteract$StGetUrgeStatusRsp.class);
    public final PBInt32Field urgeStatus = PBField.initInt32(0);
    public final PBInt32Field urgePosition = PBField.initInt32(0);
}
