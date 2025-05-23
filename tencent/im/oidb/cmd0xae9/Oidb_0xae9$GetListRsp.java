package tencent.im.oidb.cmd0xae9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xae9$GetListRsp extends MessageMicro<Oidb_0xae9$GetListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"doc_list", "next"}, new Object[]{null, 0}, Oidb_0xae9$GetListRsp.class);
    public final PBRepeatMessageField<group_online_docs$DocInfo> doc_list = PBField.initRepeatMessage(group_online_docs$DocInfo.class);
    public final PBUInt32Field next = PBField.initUInt32(0);
}
