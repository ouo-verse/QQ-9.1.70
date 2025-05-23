package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x346$UploadSuccReq extends MessageMicro<cmd0x346$UploadSuccReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 160, 242, 322}, new String[]{"uint64_sender_uin", "uint64_recver_uin", "bytes_uuid", "str_fileidcrc"}, new Object[]{0L, 0L, ByteStringMicro.EMPTY, ""}, cmd0x346$UploadSuccReq.class);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_recver_uin = PBField.initUInt64(0);
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_fileidcrc = PBField.initString("");
}
