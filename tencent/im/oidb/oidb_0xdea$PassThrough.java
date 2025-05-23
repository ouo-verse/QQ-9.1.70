package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import common.config.service.QzoneConfig;

/* loaded from: classes29.dex */
public final class oidb_0xdea$PassThrough extends MessageMicro<oidb_0xdea$PassThrough> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "uint32_client_type"}, new Object[]{1, 0}, oidb_0xdea$PassThrough.class);
    public final PBEnumField entrance = PBField.initEnum(1);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
}
