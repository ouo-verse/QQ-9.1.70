package tencent.im.oidb.cmd0xebf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class oidb_cmd0xebf$NativeBookCollectRequestParams extends MessageMicro<oidb_cmd0xebf$NativeBookCollectRequestParams> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uin", "book_id", "op_type"}, new Object[]{0L, "", 0}, oidb_cmd0xebf$NativeBookCollectRequestParams.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField book_id = PBField.initString("");
    public final PBUInt32Field op_type = PBField.initUInt32(0);
}
