package tencent.im.oidb;

import appoint.define.appoint_define$AppointInfo;
import appoint.define.appoint_define$PublisherInfo;
import appoint.define.appoint_define$StrangerInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class cmd0x7de$UserProfile extends MessageMicro<cmd0x7de$UserProfile> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"msg_publisher_info", "msg_appoints_info", "rpt_msg_vistor_info"}, new Object[]{null, null, null}, cmd0x7de$UserProfile.class);
    public appoint_define$PublisherInfo msg_publisher_info = new appoint_define$PublisherInfo();
    public appoint_define$AppointInfo msg_appoints_info = new appoint_define$AppointInfo();
    public final PBRepeatMessageField<appoint_define$StrangerInfo> rpt_msg_vistor_info = PBField.initRepeatMessage(appoint_define$StrangerInfo.class);
}
