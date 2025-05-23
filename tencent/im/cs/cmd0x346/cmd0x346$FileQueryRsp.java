package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x346$FileQueryRsp extends MessageMicro<cmd0x346$FileQueryRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 162, 242}, new String[]{"int32_ret_code", "str_ret_msg", "msg_file_info"}, new Object[]{0, "", null}, cmd0x346$FileQueryRsp.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
    public cmd0x346$FileInfo msg_file_info = new cmd0x346$FileInfo();
}
