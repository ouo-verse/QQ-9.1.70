package qqcircle;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRead$UserCircleSimpleInfo extends MessageMicro<QQCircleRead$UserCircleSimpleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"circleID", "name", WadlProxyConsts.KEY_JUMP_URL, "circleType"}, new Object[]{"", "", "", 0}, QQCircleRead$UserCircleSimpleInfo.class);
    public final PBStringField circleID = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField jumpUrl = PBField.initString("");
    public final PBInt32Field circleType = PBField.initInt32(0);
}
