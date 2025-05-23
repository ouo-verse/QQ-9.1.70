package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$DisplayCfg extends MessageMicro<QzoneActivityPB$DisplayCfg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"dump_key"}, new Object[]{""}, QzoneActivityPB$DisplayCfg.class);
    public final PBStringField dump_key = PBField.initString("");
}
