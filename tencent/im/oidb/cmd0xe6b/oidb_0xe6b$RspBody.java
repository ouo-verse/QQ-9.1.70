package tencent.im.oidb.cmd0xe6b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe6b$RspBody extends MessageMicro<oidb_0xe6b$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 90}, new String[]{"uint64_uin", "msg_profile_info"}, new Object[]{0L, null}, oidb_0xe6b$RspBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public beancurdcube_profile_common$BeancurdcubeProfile msg_profile_info = new MessageMicro<beancurdcube_profile_common$BeancurdcubeProfile>() { // from class: tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common$BeancurdcubeProfile
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_beancurdcube_profile_info"}, new Object[]{null}, beancurdcube_profile_common$BeancurdcubeProfile.class);
        public final PBRepeatMessageField<beancurdcube_profile_common$BeancurdcubeProfileInfo> rpt_beancurdcube_profile_info = PBField.initRepeatMessage(beancurdcube_profile_common$BeancurdcubeProfileInfo.class);
    };
}
