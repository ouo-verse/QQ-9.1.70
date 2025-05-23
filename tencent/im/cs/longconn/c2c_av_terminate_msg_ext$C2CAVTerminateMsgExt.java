package tencent.im.cs.longconn;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class c2c_av_terminate_msg_ext$C2CAVTerminateMsgExt extends MessageMicro<c2c_av_terminate_msg_ext$C2CAVTerminateMsgExt> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{AudienceReportConst.ROOM_ID, "reason", "logout_ts", "buss_flag", "has_switched"}, new Object[]{0L, 1, 0, 1, Boolean.FALSE}, c2c_av_terminate_msg_ext$C2CAVTerminateMsgExt.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBEnumField reason = PBField.initEnum(1);
    public final PBUInt32Field logout_ts = PBField.initUInt32(0);
    public final PBEnumField buss_flag = PBField.initEnum(1);
    public final PBBoolField has_switched = PBField.initBool(false);
}
