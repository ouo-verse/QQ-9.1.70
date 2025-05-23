package tencent.im.oidb.cmd0x91d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.label.comm.PersonalityTagComm$LabelInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x91d$LabelUpdateInfo extends MessageMicro<cmd0x91d$LabelUpdateInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"msg_label_info", "uint32_upload_photos"}, new Object[]{null, 0}, cmd0x91d$LabelUpdateInfo.class);
    public PersonalityTagComm$LabelInfo msg_label_info = new PersonalityTagComm$LabelInfo();
    public final PBUInt32Field uint32_upload_photos = PBField.initUInt32(0);
}
