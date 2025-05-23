package tencent.im.nearfield_date;

import appoint.define.appoint_define$AppointInfo;
import appoint.define.appoint_define$PublisherInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class nearby_date$UserProfile extends MessageMicro<nearby_date$UserProfile> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"msg_publisher_info", "msg_appoints_info", "rpt_uint64_uin"}, new Object[]{null, null, 0L}, nearby_date$UserProfile.class);
    public appoint_define$PublisherInfo msg_publisher_info = new appoint_define$PublisherInfo();
    public appoint_define$AppointInfo msg_appoints_info = new appoint_define$AppointInfo();
    public final PBRepeatField<Long> rpt_uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
