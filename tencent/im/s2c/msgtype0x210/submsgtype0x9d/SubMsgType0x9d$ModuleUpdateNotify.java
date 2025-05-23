package tencent.im.s2c.msgtype0x210.submsgtype0x9d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qzone.networkedmodule.QzoneModuleConst;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x9d$ModuleUpdateNotify extends MessageMicro<SubMsgType0x9d$ModuleUpdateNotify> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"module_id", QzoneModuleConst.QZONE_MODULE_CONFIG_MODULE_VERSION, "module_state"}, new Object[]{0, 0, 0}, SubMsgType0x9d$ModuleUpdateNotify.class);
    public final PBUInt32Field module_id = PBField.initUInt32(0);
    public final PBUInt32Field module_version = PBField.initUInt32(0);
    public final PBUInt32Field module_state = PBField.initUInt32(0);
}
