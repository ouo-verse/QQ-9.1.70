package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSac$GetSacBeatInfoReq extends MessageMicro<QQCircleSac$GetSacBeatInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"src", "uin"}, new Object[]{0L, 0L}, QQCircleSac$GetSacBeatInfoReq.class);
    public final PBUInt64Field src = PBField.initUInt64(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
}
