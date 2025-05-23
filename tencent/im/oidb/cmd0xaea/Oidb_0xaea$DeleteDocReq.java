package tencent.im.oidb.cmd0xaea;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xae9.online_docs$DocId;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xaea$DeleteDocReq extends MessageMicro<Oidb_0xaea$DeleteDocReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"group_code", "doc_id", "copy"}, new Object[]{0L, null, 0}, Oidb_0xaea$DeleteDocReq.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public online_docs$DocId doc_id = new online_docs$DocId();
    public final PBUInt32Field copy = PBField.initUInt32(0);
}
