package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.thumbplayer.report.reportv1.TPReportParams;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class appauth_comm$ExtendGroupTuple extends MessageMicro<appauth_comm$ExtendGroupTuple> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"auth_group_type", "auth_pair"}, new Object[]{0, null}, appauth_comm$ExtendGroupTuple.class);
    public final PBUInt32Field auth_group_type = PBField.initUInt32(0);
    public appauth_comm$ExtendGroupPair auth_pair = new MessageMicro<appauth_comm$ExtendGroupPair>() { // from class: tencent.im.oidb.appauth_comm$ExtendGroupPair
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", TPReportParams.JSON_KEY_VAL}, new Object[]{"", ""}, appauth_comm$ExtendGroupPair.class);
        public final PBStringField key = PBField.initString("");
        public final PBStringField val = PBField.initString("");
    };
}
