package tencent.im.oidb;

import appoint.define.appoint_define$AppointInfo;
import appoint.define.appoint_define$PublisherInfo;
import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7cd$AppointBrife extends MessageMicro<cmd0x7cd$AppointBrife> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_publisher_info", "msg_appoints_info"}, new Object[]{null, null}, cmd0x7cd$AppointBrife.class);
    public appoint_define$PublisherInfo msg_publisher_info = new appoint_define$PublisherInfo();
    public appoint_define$AppointInfo msg_appoints_info = new appoint_define$AppointInfo();
}
