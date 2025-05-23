package tencent.im.nearfield_discuss;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearfield_discuss$ReqGetList extends MessageMicro<nearfield_discuss$ReqGetList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"msg_head", "msg_lbs_info", "str_number", "uint32_session_id", "bytes_cookie"}, new Object[]{null, null, "", 0, ByteStringMicro.EMPTY}, nearfield_discuss$ReqGetList.class);
    public nearfield_discuss$BusiReqHead msg_head = new nearfield_discuss$BusiReqHead();
    public nearfield_discuss$LBSInfo msg_lbs_info = new nearfield_discuss$LBSInfo();
    public final PBStringField str_number = PBField.initString("");
    public final PBUInt32Field uint32_session_id = PBField.initUInt32(0);
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
}
