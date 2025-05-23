package tencent.im.group_pro_proto.cmd0x101b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.remote.ServiceConst;

/* loaded from: classes29.dex */
public final class cmd0x101b$AppPlayInfo extends MessageMicro<cmd0x101b$AppPlayInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"title", "file_id", ServiceConst.PARA_SESSION_ID}, new Object[]{"", "", ""}, cmd0x101b$AppPlayInfo.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField file_id = PBField.initString("");
    public final PBStringField session_id = PBField.initString("");
}
