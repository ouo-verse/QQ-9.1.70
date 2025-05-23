package tencent.sso.roam;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Roam$RoamQualifyRsp extends MessageMicro<Roam$RoamQualifyRsp> {
    public static final int HEAD_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"head"}, new Object[]{null}, Roam$RoamQualifyRsp.class);
    public Roam$RoamRspHead head = new MessageMicro<Roam$RoamRspHead>() { // from class: tencent.sso.roam.Roam$RoamRspHead
        public static final int MSG_FIELD_NUMBER = 2;
        public static final int RESULT_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"result", "msg"}, new Object[]{0, ""}, Roam$RoamRspHead.class);
        public final PBInt32Field result = PBField.initInt32(0);

        /* renamed from: msg, reason: collision with root package name */
        public final PBStringField f436069msg = PBField.initString("");
    };
}
