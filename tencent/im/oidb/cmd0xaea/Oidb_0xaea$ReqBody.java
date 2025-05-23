package tencent.im.oidb.cmd0xaea;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xaea$ReqBody extends MessageMicro<Oidb_0xaea$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 122}, new String[]{"delete_doc_req", "pskey"}, new Object[]{null, ByteStringMicro.EMPTY}, Oidb_0xaea$ReqBody.class);
    public Oidb_0xaea$DeleteDocReq delete_doc_req = new Oidb_0xaea$DeleteDocReq();
    public final PBBytesField pskey = PBField.initBytes(ByteStringMicro.EMPTY);
}
